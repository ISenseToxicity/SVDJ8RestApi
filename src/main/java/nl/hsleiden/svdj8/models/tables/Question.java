package nl.hsleiden.svdj8.models.tables;

import nl.hsleiden.svdj8.daos.Dto.QuestionDto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {
    @Id @GeneratedValue
    @Column(name = "question_id")
    private Long questionID;
    @Column(name = "question_text")
    private String questionText;
    @OneToMany(targetEntity=Answer.class, mappedBy = "question_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Answer> answers;

    private String extraInfoTile;
    private String extraInfoDescription;
    private String extraInfoVideoURL;

    public Question(Long questionID, String questionText, List<Answer> answers, String extraInfoTile, String extraInfoDescription, String extraInfoVideoURL) {
        this.questionID = questionID;
        this.questionText = questionText;
        this.answers = answers;
        this.extraInfoTile = extraInfoTile;
        this.extraInfoDescription = extraInfoDescription;
        this.extraInfoVideoURL = extraInfoVideoURL;
    }

    public Question() {

    }

    public static Question from(QuestionDto questionDto){
        Question question = new Question();
        question.setQuestionID(questionDto.getQuestionId());
        question.setQuestionText(questionDto.getQuestionText());
        question.setAnswers(questionDto.getAnswers());
        question.setExtraInfoDescription(questionDto.getExtraInfoDescription());
        question.setExtraInfoVideoURL(questionDto.getExtraInfoVideoURL());
        question.setExtraInfoTile(questionDto.getExtraInfoTile());

        return question;
    }


    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers (List<Answer> answers) {
        this.answers = answers;
    }

    public String getExtraInfoTile() {
        return extraInfoTile;
    }

    public void setExtraInfoTile(String extraInfoTile) {
        this.extraInfoTile = extraInfoTile;
    }

    public String getExtraInfoDescription() {
        return extraInfoDescription;
    }

    public void setExtraInfoDescription(String extraInfoDescription) {
        this.extraInfoDescription = extraInfoDescription;
    }

    public String getExtraInfoVideoURL() {
        return extraInfoVideoURL;
    }

    public void setExtraInfoVideoURL(String extraInfoVideoURL) {
        this.extraInfoVideoURL = extraInfoVideoURL;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }

    public Long getQuestionID() {
        return questionID;
    }
}