package nl.hsleiden.svdj8.daos.Dto;

import nl.hsleiden.svdj8.models.tables.Grant;
import nl.hsleiden.svdj8.models.tables.Keyword;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

public class GrantDto {
    private Long id;
    private String name;
    private String description;
    private List<Keyword> keywords;

    public static GrantDto from(Grant grant) {
        GrantDto grantDto = new GrantDto();
        grantDto.setName(grant.getName());
        grantDto.setId(grant.getGrantID());
        grantDto.setDescription(grant.getDescription());
        grantDto.setKeywords(grant.getKeywords());
        return grantDto;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
