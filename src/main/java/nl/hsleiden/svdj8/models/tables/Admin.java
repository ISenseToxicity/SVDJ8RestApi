package nl.hsleiden.svdj8.models.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
    private @Id @GeneratedValue Long adminID;
    private String name;
    private String password; //???????????TODO: CHECK DIT NA

    public Admin(){}

    public Admin(Long adminID, String name, String password) {
        this.adminID = adminID;
        this.name = name;
        this.password = password;
    }

    // SETTERS AND GETTERS


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdminID(Long adminID) {
        this.adminID = adminID;
    }

    @Id
    @GeneratedValue
    public Long getAdminID() {
        return adminID;
    }
}
