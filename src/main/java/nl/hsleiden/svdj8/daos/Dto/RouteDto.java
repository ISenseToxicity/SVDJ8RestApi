package nl.hsleiden.svdj8.daos.Dto;

import nl.hsleiden.svdj8.models.tables.GivenAnswer;
import nl.hsleiden.svdj8.models.tables.Route;
import nl.hsleiden.svdj8.models.tables.Result;

import javax.persistence.*;
import java.util.List;

public class RouteDto {
    private Long routeId;
    private int totalTime;
    private Result resultId;
    private List<GivenAnswer> givenAnswerList;

    public static RouteDto from(Route route){
        RouteDto routeDto = new RouteDto();
        routeDto.setRouteId(route.getRouteId());
        routeDto.setTotalTime(route.getTotalTime());
        routeDto.setResultId(route.getResultId());
        routeDto.setGivenAnswerList(route.getGivenAnswerList());
        return routeDto;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public Result getResultId() {
        return resultId;
    }

    public void setResultId(Result resultId) {
        this.resultId = resultId;
    }

    public List<GivenAnswer> getGivenAnswerList() {
        return givenAnswerList;
    }

    public void setGivenAnswerList(List<GivenAnswer> givenAnswerList) {
        this.givenAnswerList = givenAnswerList;
    }
}
