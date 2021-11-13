package nl.hsleiden.svdj8.models.tables;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "result")
public class Result extends Persistence {


    private @Id @GeneratedValue Long resultID;
    private int amountQuestions;
    private Time totalTime;

    public Result(Long resultID, int amountQuestions, Time totalTime) {
        this.resultID = resultID;
        this.amountQuestions = amountQuestions;
        this.totalTime = totalTime;
    }

    public Result(){}

//Getter Setters
    public void setResultID(Long resultID) {
        this.resultID = resultID;
    }

    @Id
    @GeneratedValue
    public Long getResultID() {
        return resultID;
    }

    public int getAmountQuestions() {
        return amountQuestions;
    }

    public void setAmountQuestions(int amountQuestions) {
        this.amountQuestions = amountQuestions;
    }

    public Time getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Time totalTime) {
        this.totalTime = totalTime;
    }

    @ManyToOne(optional = false)
    private Grant grants;

    public Grant getGrants() {
        return grants;
    }

    public void setGrants(Grant grants) {
        this.grants = grants;
    }
}
