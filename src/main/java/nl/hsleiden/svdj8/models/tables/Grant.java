package nl.hsleiden.svdj8.models.tables;

import javax.persistence.*;

@Entity
@Table(name = "grant")
public class Grant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grant_id")
    private long grantID;

    private String name;
    private String description;

    public Grant(long grantID, String name, String description) {
        this.grantID = grantID;
        this.name = name;
        this.description = description;
    }

    public Grant() {
    }


    public void setGrantID(long grantID) {
        this.grantID = grantID;
    }

    public long getGrantID() {
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

}
