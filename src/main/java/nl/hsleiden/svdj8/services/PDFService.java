package nl.hsleiden.svdj8.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import nl.hsleiden.svdj8.models.tables.GivenAnswer;
import nl.hsleiden.svdj8.models.tables.Route;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

public class PDFService {

    public static ByteArrayOutputStream createPDF(Route route) {
        VelocityEngine velocityEngine = new VelocityEngine();

        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class",
                ClasspathResourceLoader.class.getName());
        velocityEngine.init();
        Template template = velocityEngine.getTemplate("templates/SummaryTemplatePDF.vm");

        VelocityContext context = new VelocityContext();
        String grantName = route.getResult().getGrant().getName();
        context.put("grantTitle", grantName);
        context.put("grantPeriod", route.getResult().getGrant().getPeriod());
        context.put("grantDescription", route.getResult().getGrant().getDescription());

        grantName = grantName.replace(' ', '-');
        String url = "https://www.svdj.nl/regeling/" + grantName;
        context.put("moreInfoLink", url);

        String questionList = returnHTMLQuestionList(route);
        context.put("submittedAnswers", questionList);

        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        return generatePDF(writer.toString());
    }

    private static String returnHTMLQuestionList(Route route) {
        ArrayList<GivenAnswer> givenAnswers = new ArrayList<>();
        StringBuilder response = new StringBuilder();
        for (GivenAnswer givenAnswer : givenAnswers) {
            response.append("<div class=\"questionAnswerbox\"><b class=\"question\">").append(givenAnswer.getQuestion()
                    .getQuestionText()).append("</b>").append("<p class=\"answer\">").append(givenAnswer.getAnswer()
                    .getAnswerText()).append("</p></div>");
        }
        return response.toString();
    }

    private static ByteArrayOutputStream generatePDF(String html) {
        try {
            PdfWriter pdfWriter = null;
            Document document = new Document();
            document.addAuthor("SVDJ-SubsidieWijzer");
            document.addTitle("Samenvatting van jouw antwoorden met de subsidiewijzer");
            document.setPageSize(PageSize.LETTER);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, baos);

            document.open();

            XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
            xmlWorkerHelper.getDefaultCssResolver(true);
            xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(html));

            document.close();
            return baos;

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
