//TODO: Delete

package nl.hsleiden.svdj8.models.tables;

import javax.persistence.*;

@Entity
@Table(name = "advice")
public class Advice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "advice_id")
    private long adviceID;

    private String name;
    private String description;

    public Advice(long adviceID, String name, String description) {
        this.adviceID = adviceID;
        this.name = name;
        this.description = description;
    }

    public Advice() {
    }

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

    public void setAdviceID(long adviceID) {
        this.adviceID = adviceID;
    }

    public long getAdviceID() {
        return adviceID;
    }
}
