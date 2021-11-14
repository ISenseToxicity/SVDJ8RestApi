package nl.hsleiden.svdj8.repository;

import nl.hsleiden.svdj8.models.tables.Answer;
import nl.hsleiden.svdj8.models.tables.Keyword;
import nl.hsleiden.svdj8.models.tables.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
    List<Answer> findByQuestion_id(Question question_id);
    List<Answer> findByKeywords(Keyword keywords);
}
