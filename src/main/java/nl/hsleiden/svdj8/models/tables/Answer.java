package nl.hsleiden.svdj8.models.tables;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "answer")
public class Answer {
    @ManyToOne
    private @Id @GeneratedValue Long answerID;
    private String answerText;
    private @ElementCollection Collection<Long> catogoryIds;

    public Answer(Long answerID, String answerText, ArrayList<Long> catogoryIds) {
        this.answerID = answerID;
        this.answerText = answerText;
        this.catogoryIds = catogoryIds;
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

    public Collection<Long> getcatogoryIds() {
        return catogoryIds;
    }

    public void setcatogoryIds(ArrayList<Long> catogoryIds
    ) {
        this.catogoryIds = catogoryIds;
    }
}
