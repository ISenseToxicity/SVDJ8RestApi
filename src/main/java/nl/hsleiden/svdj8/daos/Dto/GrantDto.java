package nl.hsleiden.svdj8.daos.Dto;

import nl.hsleiden.svdj8.models.tables.Grant;

public class GrantDto {
    private Long id;
    private String name;

    public static GrantDto from(Grant grant){
        GrantDto grantDto = new GrantDto();
        grantDto.setName(grant.getName());
        grantDto.setId(grant.getGrantID());
        return grantDto;
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
