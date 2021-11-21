package nl.hsleiden.svdj8.models.tables;

import nl.hsleiden.svdj8.daos.dto.RouteDto;

import javax.persistence.*;
import java.util.*;
import java.util.List;

@Entity
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "route_id")
    private Long routeId;

    @Column(name = "total_time")
    private int totalTime;

    @OneToOne(targetEntity = Result.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "result_id", referencedColumnName = "result_id")
    private Result result;

    public static Route from(RouteDto routeDto) {
        Route route = new Route();
        route.setRouteId(routeDto.getRouteId());
        route.setTotalTime(routeDto.getTotalTime());
//        route.setResultId(routeDto.getResultId());
        return route;
    }

    public Route(int totalTime, Result resultId) {
        this.totalTime = totalTime;
    }

    public Route() {

    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public Result getResult() {
        return result;
    }

//    public void setResult(Result result) {
//        this.result = result;
//    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }
}
