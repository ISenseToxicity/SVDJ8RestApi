package nl.hsleiden.svdj8.models.temp;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Answer {
    private @Id @GeneratedValue Long answerID;
    private String answerText;
    private @ElementCollection ArrayList<String > categoryID;

    public Answer(Long answerID, String answerText, ArrayList<String> categoryID) {
        this.answerID = answerID;
        this.answerText = answerText;
        this.categoryID = categoryID;
    }

    public Answer() {

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

    public ArrayList<String> getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(ArrayList<String> categoryID) {
        this.categoryID = categoryID;
    }
}
