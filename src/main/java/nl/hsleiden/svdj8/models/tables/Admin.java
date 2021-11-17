package nl.hsleiden.svdj8.models.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
    private @Id
    @GeneratedValue
    Long adminID;
    private String email;
    private String password;

    public Admin() {
    }

    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // SETTERS AND GETTERS


    public String getEmail() {
        return email;
    }

    public void setEmail(String name) {
        this.email = name;
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

    public Long getAdminID() {
        return adminID;
    }
}
