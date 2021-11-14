package nl.hsleiden.svdj8.models.tables;

import nl.hsleiden.svdj8.daos.Dto.RouteDto;

import javax.persistence.*;
import java.util.*;
import java.util.List;

@Entity
@Table(name = "route")
public class Route {
    @Id @GeneratedValue
    @Column(name = "route_id")
    private  Long routeId;
    private int totalTime;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "result_id", referencedColumnName = "result_id")
    private Result resultId;
    @OneToMany(targetEntity = GivenAnswer.class,
            mappedBy = "routeId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<GivenAnswer> givenAnswerList;

    public static Route from(RouteDto routeDto){
        Route route = new Route();
        route.setRouteId(routeDto.getRouteId());
        route.setTotalTime(routeDto.getTotalTime());
        route.setGivenAnswerList(routeDto.getGivenAnswerList());
        route.setResultId(routeDto.getResultId());
        return route;
    }

    public Route(int totalTime, Result resultId) {
        this.totalTime = totalTime;
        this.resultId = resultId;
        this.givenAnswerList = new List<GivenAnswer>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<GivenAnswer> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(GivenAnswer givenAnswer) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends GivenAnswer> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends GivenAnswer> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public GivenAnswer get(int index) {
                return null;
            }

            @Override
            public GivenAnswer set(int index, GivenAnswer element) {
                return null;
            }

            @Override
            public void add(int index, GivenAnswer element) {

            }

            @Override
            public GivenAnswer remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<GivenAnswer> listIterator() {
                return null;
            }

            @Override
            public ListIterator<GivenAnswer> listIterator(int index) {
                return null;
            }

            @Override
            public List<GivenAnswer> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
    }
    public Route() {

    }

//    Setters And Getters
    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public List<GivenAnswer> getGivenAnswerList() {
        return givenAnswerList;
    }

    public void setGivenAnswerList(List<GivenAnswer> givenAnswerList) {
        this.givenAnswerList = givenAnswerList;
    }

    public Result getResultId() {
        return resultId;
    }

    public void setResultId(Result resultID) {
        this.resultId = resultID;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }
}
