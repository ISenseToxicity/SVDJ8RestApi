package nl.hsleiden.svdj8.models;

public class User {
    private int id;
    private String origin;

    public User(int id, String origin) {
    this.id = id;
    this.origin = origin;
    }

    public int getId() {
        return id;
    }

    public String getOrigin() {
        return origin;
    }
}
