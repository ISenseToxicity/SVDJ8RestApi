package nl.hsleiden.svdj8.daos.Dto;

import nl.hsleiden.svdj8.models.tables.Answer;
import nl.hsleiden.svdj8.models.tables.Keyword;
import nl.hsleiden.svdj8.models.tables.Question;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

public class AnswerDto {

    private Long answerID;
    private Question question_id;
    private String answerText;
    private List<Keyword> keywords;

    public static AnswerDto from(Answer answer){
        AnswerDto answerDto = new AnswerDto();
        answerDto.setAnswerText(answer.getAnswerText());
        answerDto.setKeywords(answer.getkeywords());
        answerDto.setQuestion_id(answer.getQuestion_id());
        answerDto.setAnswerID(answer.getAnswerID());
        return answerDto;
    }

    public Long getAnswerID() {
        return answerID;
    }

    public void setAnswerID(Long answerID) {
        this.answerID = answerID;
    }

    public Question getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Question question_id) {
        this.question_id = question_id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }
}
