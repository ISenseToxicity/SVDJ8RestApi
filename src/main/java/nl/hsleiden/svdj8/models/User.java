package nl.hsleiden.svdj8.models;

public class User {
    private long id;
    private String origin;
    private String type;

    public User(long id, String origin, String type) {
    this.id = id;
    this.origin = origin;
    this.type = type;
    }

    public User() {
        
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setId(long userId) {
        this.id = userId;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
