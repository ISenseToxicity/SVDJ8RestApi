package nl.hsleiden.svdj8.models.tables;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long answerID;

    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "question_id")
    private Long questionID;

    @Column(name = "category_id")
    private Long categoryID;

//    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Question.class)
//    @JoinColumn(name = "question_id", nullable = false, referencedColumnName = "question_id")
//    private Question question;

    public Answer(Long answerID, String answerText) {
        this.answerID = answerID;
        this.answerText = answerText;
    }

    public Answer() {

    }

    public Long getAnswerID() {
        return answerID;
    }

    public void setAnswerID(Long answerID) {
        this.answerID = answerID;
    }

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }

    public Long getCategoryID() { return categoryID; }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

}
