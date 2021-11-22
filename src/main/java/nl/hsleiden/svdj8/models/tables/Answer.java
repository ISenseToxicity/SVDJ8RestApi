package nl.hsleiden.svdj8.models.tables;

import nl.hsleiden.svdj8.daos.dto.AnswerDto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "answer_id")
    private Long answerID;

    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "question_id")
    private Long questionID;

//    @ManyToOne
//    @JoinColumn(name = "question_id", nullable = false, referencedColumnName = "question_id")
//    private Question question;

    public Answer(Long answerID, String answerText) {
        this.answerID = answerID;
        this.answerText = answerText;
    }

    public Answer() {

    }

    public static Answer from(AnswerDto answerDto) {
        Answer answer = new Answer();
        answer.setAnswerID(answerDto.getAnswerID());
        answer.setAnswerText(answerDto.getAnswerText());
//        answer.setQuestion(answerDto.getQuestion());
        return answer;
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

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

}
