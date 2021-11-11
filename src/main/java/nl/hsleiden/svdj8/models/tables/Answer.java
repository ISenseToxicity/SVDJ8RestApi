package nl.hsleiden.svdj8.models.tables;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {
    private @Id @GeneratedValue Long answerID;
//    @ManyToOne
//    @JoinColumn(name="questionID", nullable=false)
    private Long questionID;
//    @Column(nullable=false)
    private String answerText;
//    @Column(nullable=false)
    private Long catogoryIds;
//        private @ElementCollection Collection<Long> answers;

    public Answer(Long answerID, String answerText, Long catogoryIds) {
        this.answerID = answerID;
        this.answerText = answerText;
        this.catogoryIds = catogoryIds;
    }

    public Answer() {

    }
//    Getters Setters

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }

    public Long getCatogoryIds() {
        return catogoryIds;
    }

    public void setCatogoryIds(Long catogoryIds) {
        this.catogoryIds = catogoryIds;
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

    public Long getcatogoryIds() {
        return catogoryIds;
    }

    public void setcatogoryIds(Long catogoryIds
    ) {
        this.catogoryIds = catogoryIds;
    }
}
