package nl.hsleiden.svdj8.models.tables;

import javax.persistence.*;

@Entity
@Table(name = "given_answer")
public class GivenAnswer{
    @Id @GeneratedValue
    @Column(name = "given_answer_id")
    private Long givenAnswerId;
    private int elapsedSeconds;
    @ManyToOne
    private Route routeId;
    @OneToOne
    @JoinColumn(name = "question_id",referencedColumnName = "question_id")
    private Question questionId;
    @OneToOne
    @JoinColumn(name = "answer_id",referencedColumnName = "answer_id", insertable = true, updatable = true)
    private Answer answerId;

    public GivenAnswer(Long givenAnswerId, int elapsedSeconds, Question questionId, Answer answerId) {
        this.givenAnswerId = givenAnswerId;
        this.elapsedSeconds = elapsedSeconds;
        this.questionId = questionId;
        this.answerId = answerId;
    }

    public GivenAnswer() {

    }

    @Id
    @GeneratedValue
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

}
