package nl.hsleiden.svdj8.models.tables;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "grant")
public class Grant {

    private @Id @GeneratedValue Long grantID;
    private String name;
    private String description;
    @Column(columnDefinition = "result")
    @OneToMany(mappedBy = "grant")
    private Result result;
    @OneToMany(mappedBy = "grant")
    private ArrayList<Keyword> keywords;


    public Grant(Long grantID, String name, String description, Result result, ArrayList<Keyword> keywords) {
        this.grantID = grantID;
        this.name = name;
        this.description = description;
        this.result = result;
        this.keywords = keywords;
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

    public String getName() {
        return name;
    }

    public void setName(String nameGrant) {
        this.name = nameGrant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public  ArrayList<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords( ArrayList<Keyword> keywords) {
        this.keywords = keywords;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
