package nl.hsleiden.svdj8.models.tables;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Grant {
    private @Id @GeneratedValue Long grantID;
    private String nameGrant;
    private String description;
    private @ElementCollection ArrayList<String> Keywords;

    public Grant(Long grantID, String nameGrant, String description, ArrayList<String> keywords) {
        this.grantID = grantID;
        this.nameGrant = nameGrant;
        this.description = description;
        Keywords = keywords;
    }
    public Grant(){}

    /*Setters Getters*/
    public void setGrantID(Long grantID) {
        this.grantID = grantID;
    }

    @Id
    @GeneratedValue
    public Long getGrantID() {
        return grantID;
    }

    public String getNameGrant() {
        return nameGrant;
    }

    public void setNameGrant(String nameGrant) {
        this.nameGrant = nameGrant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getKeywords() {
        return Keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        Keywords = keywords;
    }
}
