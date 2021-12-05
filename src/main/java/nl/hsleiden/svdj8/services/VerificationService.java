package nl.hsleiden.svdj8.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Properties;
import java.util.Random;

@Service
public class VerificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    public String createVerificationCode() {
        String codeNumber = String.valueOf(new Random().nextInt(89999999) + 10000000);
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < codeNumber.length(); i++) {
            if (i == 4) {
                code.append(" ");
            }
            code.append(codeNumber.charAt(i));
        }
        return code.toString();
    }

    public void sendEmail(String email, String verificationCode) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("noreply@svdj.nl");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("Verificatie code SVDJ admin");
        simpleMailMessage.setText("Gebruik deze code om u identiteit te bevestigen voor de SVDJ admin portal \n" + verificationCode + "\n \n- SVDJ");
        javaMailSender = getJavaMailSender();
        javaMailSender.send(simpleMailMessage);
    }

    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        //TODO: change and env file
        mailSender.setUsername("groep8hsls@gmail.com");
        mailSender.setPassword("SVDJMAAare1t4drg156");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

}
