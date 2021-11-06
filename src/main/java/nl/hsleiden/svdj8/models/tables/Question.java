package nl.hsleiden.svdj8.models.tables;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Question {
    private @Id @GeneratedValue Long questionID;
    private String questionText;
    @OneToMany
    private ArrayList<Answer> answers;
    private String extraInfoTile;
    private String extraInfoDescription;
    private String extraInfoVideoURL;

    public Question(Long questionID, String questionText, ArrayList<Answer> answers, String extraInfoTile, String extraInfoDescription, String extraInfoVideoURL) {
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

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
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