package nl.hsleiden.svdj8.repository;

import nl.hsleiden.svdj8.models.tables.Answer;
import nl.hsleiden.svdj8.models.tables.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository  extends CrudRepository<Question, Long> {
    List<Question> findByAnswers(Answer answers);
   }
