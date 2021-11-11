package nl.hsleiden.svdj8.models.tables;

import javax.persistence.*;

@Entity
@Table(name = "grant_and_keyword")
public class GrantAndKeyword {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "grand_key_id", nullable = false)
    private Long grandKeyID;

    public Long getGrandKeyID() {
        return grandKeyID;
    }

    public void setGrandKeyID(Long grandKeyID) {
        this.grandKeyID = grandKeyID;
    }
}
