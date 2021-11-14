package nl.hsleiden.svdj8.models.tables;

import nl.hsleiden.svdj8.daos.Dto.GivenAnswerDto;

import javax.persistence.*;

@Entity
@Table(name = "given_answer")
public class GivenAnswer {
    @Id
    @GeneratedValue
    @Column(name = "given_answer_id")
    private Long givenAnswerId;
    private int elapsedSeconds;
    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "route_id")
    private Route routeId;
    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private Question questionId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_id", referencedColumnName = "answer_id", insertable = true, updatable = true)
    private Answer answerId;

    public GivenAnswer(Long givenAnswerId, int elapsedSeconds, Question questionId, Answer answerId) {
        this.givenAnswerId = givenAnswerId;
        this.elapsedSeconds = elapsedSeconds;
        this.questionId = questionId;
        this.answerId = answerId;
    }

    public GivenAnswer() {
    }

    public static GivenAnswer from(GivenAnswerDto givenAnswerDto) {
        GivenAnswer givenAnswer = new GivenAnswer();
        givenAnswer.setGivenAnswerId(givenAnswerDto.getGivenAnswerId());
        return givenAnswer;
    }

    public Long getGivenAnswerId() {
        return givenAnswerId;
    }

    public void setGivenAnswerId(Long givenAnswerId) {
        this.givenAnswerId = givenAnswerId;
    }

    public int getElapsedSeconds() {
        return elapsedSeconds;
    }

    public void setElapsedSeconds(int elapsedSeconds) {
        this.elapsedSeconds = elapsedSeconds;
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

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }
}
