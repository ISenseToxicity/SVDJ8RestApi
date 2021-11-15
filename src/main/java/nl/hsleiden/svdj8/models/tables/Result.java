package nl.hsleiden.svdj8.models.tables;

import nl.hsleiden.svdj8.daos.Dto.ResultDto;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "result")
public class Result extends Persistence {

    @Id
    @GeneratedValue
    @Column(name = "result_id")
    private Long resultID;
    private int amountQuestions;
    private Time totalTime;
    @ManyToOne(targetEntity = Grant.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Grant grant;

    public Result(Long resultID, int amountQuestions, Time totalTime, Grant grant) {
        this.resultID = resultID;
        this.amountQuestions = amountQuestions;
        this.totalTime = totalTime;
        this.grant = grant;
    }

    public Result() {

    }

    public static Result from(ResultDto resultDto) {
        Result result = new Result();
        result.setResultID(resultDto.getResultID());
        result.setAmountQuestions(resultDto.getAmountQuestions());
        result.setTotalTime(resultDto.getTotalTime());
        result.setTotalTime(resultDto.getTotalTime());

        return result;
    }

    //Getter Setters
    public void setResultID(Long resultID) {
        this.resultID = resultID;
    }

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

    public Grant getGrant() {
        return grant;
    }

    public void setGrant(Grant grant) {
        this.grant = grant;
    }
}
