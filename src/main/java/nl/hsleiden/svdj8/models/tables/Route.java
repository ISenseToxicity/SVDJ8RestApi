package nl.hsleiden.svdj8.models.tables;

import javax.persistence.*;
import java.util.Collection;
import java.util.Iterator;

@Entity
public class Route {
    private int totalTime;
    @OneToMany
    private Collection<GivenAnswer> givenAnswerList;
    private String resultID;
    private @Id @GeneratedValue Long routeID;

    public Route(int totalTime, String resultID) {
        this.totalTime = totalTime;
        this.resultID = resultID;
        givenAnswerList = new Collection<GivenAnswer>() {
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

    public Collection<GivenAnswer> getGivenAnswerList() {
        return givenAnswerList;
    }

    public void setGivenAnswerList(Collection<GivenAnswer> givenAnswerList) {
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
