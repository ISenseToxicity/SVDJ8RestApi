package nl.hsleiden.svdj8.models.tables;

import javax.persistence.*;

@Entity
@Table(name = "grant")
public class Grant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grant_id")
    private Long grantID;

    private String name;
    private String description;

    @Column(name = "begin_date")
    private String beginDate;

    @Column(name = "end_date")
    private String endDate;
    @Column(name = "advise_url")
    private String adviseURL;

    public Grant(Long grantID, String name, String description, String beginDate, String endDate, String adviseURL) {
        this.grantID = grantID;
        this.name = name;
        this.description = description;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.adviseURL = adviseURL;
    }

    public Grant() {
    }


    public void setGrantID(Long grantID) {
        this.grantID = grantID;
    }

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

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAdviseURL() {
        return adviseURL;
    }

    public void setAdviseURL(String adviseURL) {
        this.adviseURL = adviseURL;
    }
}
