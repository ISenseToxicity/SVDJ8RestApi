package nl.hsleiden.svdj8.models.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {

    private @Id @GeneratedValue Long catogoryID;
    private String name;
    private String description;

    public Category(Long catogoryID, String name, String description) {
        this.catogoryID = catogoryID;
        this.name = name;
        this.description = description;
    }

    public Category() {
    }

//    Setters and Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCatogoryID(Long catogoryID) {
        this.catogoryID = catogoryID;
    }

    @Id
    @GeneratedValue
    public Long getCatogoryID() {
        return catogoryID;
    }
}
