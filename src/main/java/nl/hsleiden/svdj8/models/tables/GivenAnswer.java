package nl.hsleiden.svdj8.models.tables;

import javax.persistence.*;

@Entity
public class GivenAnswer{
    private @Id @GeneratedValue Long givenAnswerID;
    private int elapsedSeconds;
    private String questionID;
    private String answerID;

    public GivenAnswer(Long givenAnswerID, int elapsedSeconds, String questionID, String answerID) {
        this.givenAnswerID = givenAnswerID;
        this.elapsedSeconds = elapsedSeconds;
        this.questionID = questionID;
        this.answerID = answerID;
    }

    public GivenAnswer() {

    }

    @Id
    @GeneratedValue
    public Long getGivenAnswerID() {
        return givenAnswerID;
    }

    public void setGivenAnswerID(Long givenAnswerID) {
        this.givenAnswerID = givenAnswerID;
    }

    public int getElapsedSeconds() {
        return elapsedSeconds;
    }

    public void setElapsedSeconds(int elapsedSeconds) {
        this.elapsedSeconds = elapsedSeconds;
    }

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getAnswerID() {
        return answerID;
    }

    public void setAnswerID(String answerID) {
        this.answerID = answerID;
    }

}
