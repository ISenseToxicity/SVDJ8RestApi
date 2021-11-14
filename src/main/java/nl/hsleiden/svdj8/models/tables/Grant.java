package nl.hsleiden.svdj8.models.tables;

import nl.hsleiden.svdj8.daos.Dto.GrantDto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "grant")
public class Grant {
    @Id @GeneratedValue
    @Column(name = "grant_id")
    private  Long grantID;
    private String name;
    private String description;
    @ManyToMany
    @JoinTable(name = "grant_and_keyword",
            joinColumns = @JoinColumn(name = "grant_id", referencedColumnName = "grant_id"))
    private List<Keyword> keywords;

    public Grant(Long grantID, String name, String description, Result result, List<Keyword> keywords) {
        this.grantID = grantID;
        this.name = name;
        this.description = description;
        this.keywords = keywords;
    }
    public Grant(){}

    public static Grant from(GrantDto grantDto){
        Grant grant = new Grant();
        grant.setGrantID(grantDto.getId());
        return grant;
    }

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

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

}
