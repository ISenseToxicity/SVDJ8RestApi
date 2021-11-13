package nl.hsleiden.svdj8.models.tables;

import javax.persistence.*;
import java.util.*;
import java.util.List;

@Entity
@Table(name = "route")
public class Route {
    @Id @GeneratedValue
    @Column(name = "route_id")
    private  Long routeID;
    private int totalTime;
    @OneToMany(targetEntity=Answer.class,mappedBy = "route", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<GivenAnswer> givenAnswerList;
    @ManyToOne
    @JoinColumn(name = "result_id", referencedColumnName = "result_id")
    private Result resultID;

    public Route(int totalTime, Result resultID) {
        this.totalTime = totalTime;
        this.resultID = resultID;
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

    public Result getResultID() {
        return resultID;
    }

    public void setResultID(Result resultID) {
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
