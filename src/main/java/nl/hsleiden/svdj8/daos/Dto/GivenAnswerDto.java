package nl.hsleiden.svdj8.daos.Dto;

import nl.hsleiden.svdj8.models.tables.Answer;
import nl.hsleiden.svdj8.models.tables.GivenAnswer;
import nl.hsleiden.svdj8.models.tables.Question;
import nl.hsleiden.svdj8.models.tables.Route;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class GivenAnswerDto {

    private Long givenAnswerId;
    private int elapsedSeconds;
    private Route routeId;
    private Question questionId;
    private Answer answerId;

    public static GivenAnswerDto from(GivenAnswer givenAnswer) {
        GivenAnswerDto givenAnswerDto = new GivenAnswerDto();
        givenAnswerDto.setAnswerId(givenAnswer.getAnswerId());
        givenAnswerDto.setGivenAnswerId(givenAnswer.getGivenAnswerId());
        givenAnswerDto.setRouteId(givenAnswer.getRouteId());
        givenAnswerDto.setElapsedSeconds(givenAnswer.getElapsedSeconds());
        givenAnswerDto.setQuestionId(givenAnswer.getQuestionId());
        return givenAnswerDto;
    }


    public int getElapsedSeconds() {
        return elapsedSeconds;
    }

    public void setElapsedSeconds(int elapsedSeconds) {
        this.elapsedSeconds = elapsedSeconds;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public Question getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
    }

    public Answer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Answer answerId) {
        this.answerId = answerId;
    }

    public Long getGivenAnswerId() {
        return this.givenAnswerId;
    }

    public void setGivenAnswerId(Long givenAnswerId) {
        this.givenAnswerId = givenAnswerId;
    }
}
