package nl.hsleiden.svdj8.repository;

import nl.hsleiden.svdj8.models.tables.GivenAnswer;
import nl.hsleiden.svdj8.models.tables.Result;
import nl.hsleiden.svdj8.models.tables.Route;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RouteRepository extends CrudRepository<Route, Long> {
    List<Route> findByResultID(Result resultID);
    List<Route> findByGivenAnswerList(GivenAnswer givenAnswerList);
}
