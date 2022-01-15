package nl.hsleiden.svdj8.models.tables;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name = "answer_id")
    private long answerID;

    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "question_id")
    private long parentQuestionID;


    @OneToOne(targetEntity = Question.class)
    @JoinColumn(name = "next_question_id", referencedColumnName = "question_id")
    private long next_question_id;

    public Answer(java.lang.Long answerID, String answerText) {
        this.answerID = answerID;
        this.answerText = answerText;
    }

    public Answer() {

    }

    public java.lang.Long getAnswerID() {
        return answerID;
    }

    public void setAnswerID(java.lang.Long answerID) {
        this.answerID = answerID;
    }

    public java.lang.Long getParentQuestionID() {
        return parentQuestionID;
    }

    public void setParentQuestionID(java.lang.Long parentLongID) {
        this.parentQuestionID = parentLongID;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public long getNextQuestion() {
        return next_question_id;
    }

    public void setNextQuestion(long nextQuestion) {
        this.next_question_id = nextQuestion;
    }
}
