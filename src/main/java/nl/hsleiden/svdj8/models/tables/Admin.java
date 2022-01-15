package nl.hsleiden.svdj8.models.tables;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private long adminID;

    private String name;
    private String password;

    public Admin() {
    }

    public Admin(long adminID, String name, String password) {
        this.adminID = adminID;
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getAdminID() {
        return this.adminID;
    }

    public void setAdminID(long adminID) {
        this.adminID = adminID;
    }
}
