package nl.hsleiden.svdj8.daos.dto;

import nl.hsleiden.svdj8.models.tables.Answer;
import nl.hsleiden.svdj8.models.tables.Question;

import java.util.List;

public class QuestionDto {

    private Long questionId;
    private String questionText;
    private List<Answer> answers;

    private String extraInfoTile;
    private String extraInfoDescription;
    private String extraInfoVideoURL;

    public static QuestionDto from(Question question) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionText(question.getQuestionText());
        questionDto.setQuestionId(question.getQuestionID());
        questionDto.setExtraInfoDescription(question.getExtraInfoDescription());
        questionDto.setExtraInfoTile(question.getExtraInfoTile());
        questionDto.setExtraInfoVideoURL(question.getExtraInfoVideoURL());
        return questionDto;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public String getExtraInfoTile() {
        return extraInfoTile;
    }

    public void setExtraInfoTile(String extraInfoTile) {
        this.extraInfoTile = extraInfoTile;
    }

    public String getExtraInfoDescription() {
        return extraInfoDescription;
    }

    public void setExtraInfoDescription(String extraInfoDescription) {
        this.extraInfoDescription = extraInfoDescription;
    }

    public String getExtraInfoVideoURL() {
        return extraInfoVideoURL;
    }

    public void setExtraInfoVideoURL(String extraInfoVideoURL) {
        this.extraInfoVideoURL = extraInfoVideoURL;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}
