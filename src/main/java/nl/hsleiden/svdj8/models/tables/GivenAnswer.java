package nl.hsleiden.svdj8.models.tables;

import nl.hsleiden.svdj8.daos.dto.GivenAnswerDto;

import javax.persistence.*;

@Entity
@Table(name = "given_answer")
public class GivenAnswer {
    @Id
    @GeneratedValue
    @Column(name = "given_answer_id")
    private Long givenAnswerId;

    @Column(name = "elapsed_seconds")
    private int elapsedSeconds;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Route.class)
    @JoinColumn(name = "route_id", referencedColumnName = "route_id")
    private Route route;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Question.class)
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private Question question;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Answer.class)
    @JoinColumn(name = "answer_id", referencedColumnName = "answer_id")
    private Answer answer;

    public GivenAnswer(Long givenAnswerId, int elapsedSeconds, Answer answerId) {
        this.givenAnswerId = givenAnswerId;
        this.elapsedSeconds = elapsedSeconds;
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

}
