package nl.hsleiden.svdj8.services;

import nl.hsleiden.svdj8.daos.QuestionDAO;
import nl.hsleiden.svdj8.exceptions.NoGrantFoundException;
import nl.hsleiden.svdj8.models.tables.Grant;
import nl.hsleiden.svdj8.models.tables.Question;
import nl.hsleiden.svdj8.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import javax.inject.Scope;
import java.util.List;

//@Scope("session")
@Component(value = "QuestionService")
public class QuestionService {

    @Autowired
    private QuestionDAO questionDAO;
    @Autowired
    private QuestionRepository questionRepository;
    private Question question = new Question();


    public void save() {
        questionDAO.save(question);
        question = new Question();
    }

    public List<Question> getAllquestions() {

        return questionDAO.getAll();
    }

    public int savequestion(Question question) {
        validate(QuestionService.this.question);
        return questionDAO.save(QuestionService.this.question);
    }


    private void validate(Question question) {
        // Dont know yet
    }

    public Question getquestion() {
        return question;
    }

    public Question deleteQuestion(Long id) {
        Question question = getQuestion(id);
        questionDAO.delete(QuestionService.this.question);
        return QuestionService.this.question;
    }

    public Question getQuestion(Long id) {
        return questionRepository.findById(id).orElseThrow(() ->
                new RuntimeException(new NoGrantFoundException(id)));
    }
}
