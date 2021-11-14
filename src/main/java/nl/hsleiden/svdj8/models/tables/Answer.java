package nl.hsleiden.svdj8.models.tables;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "answer")
public class Answer {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "answer_id")
    private Long answerID;
    private String answerText;
    @ManyToOne
    @JoinColumn(name="question_id", nullable=false)
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

    public List<Keyword> getCatogoryIds() {
        return keywords;
    }

    public void setCatogoryIds(List<Keyword> keywords) {
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
