package nl.hsleiden.svdj8.repository;

import nl.hsleiden.svdj8.models.tables.Answer;
import nl.hsleiden.svdj8.models.tables.GivenAnswer;
import nl.hsleiden.svdj8.models.tables.Question;
import nl.hsleiden.svdj8.models.tables.Route;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GivenAnswerRepository extends CrudRepository<GivenAnswer, Long> {
    @Query("select g from GivenAnswer g where g.answerId = ?1")
    List<GivenAnswer> q(Answer answerId);
    List<GivenAnswer> findByQuestionId(Question questionId);
    List<GivenAnswer> findByRouteId(Route routeId);
    List<GivenAnswer> findByAnswerId(Answer answerId);
}
