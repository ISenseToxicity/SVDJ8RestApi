package nl.hsleiden.svdj8.models.tables;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "answer")
public class Answer {
    @Id @GeneratedValue
    @Column(name = "answer_id")
    private Long answerID;
    private String answerText;
    @ManyToOne
    @JoinColumn(name="question_id", nullable=false)
    private Question question_id;
    @ManyToMany
    @JoinColumn(name = "keyword", referencedColumnName = "keyword_id")
    private List<Keyword> keywords;

    @OneToMany(mappedBy = "answerId", orphanRemoval = true)
    private List<GivenAnswer> givenAnswers;

    public Answer(Long answerID, String answerText, List<Keyword> keywords) {
        this.answerID = answerID;
        this.answerText = answerText;
        this.keywords = keywords;
    }

    public Answer() {

    }
//    Getters Setters

    public Question getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Question questionID) {
        this.question_id = questionID;
    }

    public List<Keyword> getCatogoryIds() {
        return keywords;
    }

    public void setCatogoryIds(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public Long getAnswerID() {
        return answerID;
    }

    public void setAnswerID(Long answerID) {
        this.answerID = answerID;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public List<Keyword> getkeywords() {
        return keywords;
    }

    public void setkeywords(List<Keyword> keywords
    ) {
        this.keywords = keywords;
    }

    @ManyToOne(optional = false)
    private Question question;

    public List<GivenAnswer> getGivenAnswers() {
        return givenAnswers;
    }

    public void setGivenAnswers(List<GivenAnswer> givenAnswers) {
        this.givenAnswers = givenAnswers;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
