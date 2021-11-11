package nl.hsleiden.svdj8.models.tables;

import javax.persistence.*;

@Entity
@Table(name = "keyword")
public class Keyword {
    @Id
    @GeneratedValue
    private Long keywordID;
    private String restriction;

    public Keyword(Long keywordID, String restriction) {
        this.keywordID = keywordID;
        this.restriction = restriction;
    }

    public Keyword() {
    }

//    Setters and Getters


    public Long getKeywordID() {
        return keywordID;
    }

    public void setKeywordID(Long keywordID) {
        this.keywordID = keywordID;
    }

    public String getRestriction() {
        return restriction;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }

    @ManyToOne(optional = false)
    private Grant grant;

    public Grant getGrant() {
        return grant;
    }

    public void setGrant(Grant grant) {
        this.grant = grant;
    }
}
