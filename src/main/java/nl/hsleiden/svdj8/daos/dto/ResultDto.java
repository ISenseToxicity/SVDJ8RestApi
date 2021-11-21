package nl.hsleiden.svdj8.daos.dto;

import nl.hsleiden.svdj8.models.tables.Result;

import java.sql.Time;

public class ResultDto {
    private Long resultID;
    private int amountQuestions;
    private Time totalTime;

    public static ResultDto from(Result result) {
        ResultDto resultDto = new ResultDto();
        resultDto.setResultID(result.getResultID());
        resultDto.setAmountQuestions(result.getAmountQuestions());
        resultDto.setTotalTime(result.getTotalTime());
        return resultDto;
    }

    public Long getResultID() {
        return resultID;
    }

    public void setResultID(Long resultID) {
        this.resultID = resultID;
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
}
