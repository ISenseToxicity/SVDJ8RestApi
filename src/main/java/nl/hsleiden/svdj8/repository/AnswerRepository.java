package nl.hsleiden.svdj8.repository;

import nl.hsleiden.svdj8.models.tables.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
}
