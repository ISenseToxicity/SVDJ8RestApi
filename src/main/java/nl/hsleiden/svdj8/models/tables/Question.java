package nl.hsleiden.svdj8.models.tables;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collection;

@Entity
@Table(name = "question")
public class Question {
    @Id @GeneratedValue
    private Long questionID;
    private String questionText;
    @OneToMany(mappedBy="answerID")
    private Long answers;
    private String extraInfoTile;
    private String extraInfoDescription;
    private String extraInfoVideoURL;

    public Question(Long questionID, String questionText, Long answers, String extraInfoTile, String extraInfoDescription, String extraInfoVideoURL) {
        this.questionID = questionID;
        this.questionText = questionText;
        this.answers = answers;
        this.extraInfoTile = extraInfoTile;
        this.extraInfoDescription = extraInfoDescription;
        this.extraInfoVideoURL = extraInfoVideoURL;
    }

    public Question() {

    }



    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Long getAnswers() {
        return answers;
    }

    public void setAnswers (Long answers) {
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

    @Id
    public Long getQuestionID() {
        return questionID;
    }
}