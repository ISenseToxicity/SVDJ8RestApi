package nl.hsleiden.svdj8.models.tables;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Route {
    private int totalTime;
    @OneToMany
    private ArrayList<GivenAnswer> givenAnswerList;
    private String resultID;
    private @Id @GeneratedValue Long routeID;

    public Route(int totalTime, String resultID) {
        this.totalTime = totalTime;
        this.resultID = resultID;
        givenAnswerList = new ArrayList<>();
    }

    public Route() {

    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public ArrayList<GivenAnswer> getGivenAnswerList() {
        return givenAnswerList;
    }

    public void setGivenAnswerList(ArrayList<GivenAnswer> givenAnswerList) {
        this.givenAnswerList = givenAnswerList;
    }

    public String getResultID() {
        return resultID;
    }

    public void setResultID(String resultID) {
        this.resultID = resultID;
    }

    public void addGivenAnswer(GivenAnswer givenAnswer) {
        givenAnswerList.add(givenAnswer);
    }

    public void removeLastGivenAnswer() {
        givenAnswerList.remove(givenAnswerList.size()-1);
    }

    public void setRouteID(Long routeID) {
        this.routeID = routeID;
    }

    @Id
    @GeneratedValue
    public Long getRouteID() {
        return routeID;
    }
}
