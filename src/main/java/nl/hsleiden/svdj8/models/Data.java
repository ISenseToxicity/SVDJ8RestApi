package nl.hsleiden.svdj8.models;

import java.util.HashMap;

public class Data {
    private int userNr;
    private String duty;
    private HashMap<String,Object>givenVariables;
    private boolean isNewData;

//    Constructor

    public Data(int userNr, String duty, HashMap<String, Object> givenVariables, boolean isNewData) {
        this.userNr = userNr;
        this.duty = duty;
        this.givenVariables = givenVariables;
        this.isNewData = isNewData;
    }

//    Getters and Setters

    public int getUserNr() {
        return userNr;
    }

    public void setUserNr(int userNr) {
        this.userNr = userNr;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public HashMap<String, Object> getGivenVariables() {
        return givenVariables;
    }

    public void setGivenVariables(HashMap<String, Object> givenVariables) {
        this.givenVariables = givenVariables;
    }

    public boolean isNewData() {
        return isNewData;
    }

    public void setNewData(boolean newData) {
        isNewData = newData;
    }
}
