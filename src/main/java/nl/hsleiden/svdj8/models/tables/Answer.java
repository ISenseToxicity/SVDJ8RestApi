package nl.hsleiden.svdj8.models.tables;

import nl.hsleiden.svdj8.daos.Dto.AnswerDto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "answer_id")
    private Long answerID;
    private String answerText;
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question questionId;
    @ManyToMany
    @JoinColumn(name = "keyword", referencedColumnName = "keyword_id")
    private List<Keyword> keywords;

    public Answer(Long answerID, String answerText, List<Keyword> keywords) {
        this.answerID = answerID;
        this.answerText = answerText;
        this.keywords = keywords;
    }

    public Answer() {

    }

    public static Answer from(AnswerDto answerDto) {
        Answer answer = new Answer();
        answer.setAnswerID(answerDto.getAnswerID());
        answer.setAnswerText(answerDto.getAnswerText());
        answer.setkeywords(answerDto.getKeywords());
        answer.setQuestionId(answerDto.getQuestion_id());
        return answer;
    }

    //    Getters Setters
    public Long getAnswerID() {
        return answerID;
    }

    public void setAnswerID(Long answerID) {
        this.answerID = answerID;
    }

    public Question getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Question questionID) {
        this.questionId = questionID;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
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

    public void setkeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }
}
