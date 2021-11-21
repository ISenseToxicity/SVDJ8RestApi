package nl.hsleiden.svdj8.daos.dto;

import nl.hsleiden.svdj8.models.tables.Answer;
import nl.hsleiden.svdj8.models.tables.Question;

public class AnswerDto {

    private Long answerID;
    private Long questionID;
    private String answerText;

    public static AnswerDto from(Answer answer) {
        AnswerDto answerDto = new AnswerDto();
        answerDto.setAnswerText(answer.getAnswerText());
        answerDto.setQuestionID(answer.getQuestionID());
        answerDto.setAnswerID(answer.getAnswerID());
        return answerDto;
    }

    public Long getAnswerID() {
        return answerID;
    }

    public void setAnswerID(Long answerID) {
        this.answerID = answerID;
    }

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

}
