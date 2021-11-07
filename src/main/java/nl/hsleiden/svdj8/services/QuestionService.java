package nl.hsleiden.svdj8.services;

import nl.hsleiden.svdj8.daos.QuestionDAO;
import nl.hsleiden.svdj8.models.tables.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import javax.inject.Scope;
import java.util.Collection;

//@Scope("session")
@Component(value = "QuestionService")
public class QuestionService {

    @Autowired
    private QuestionDAO questionDAO;
    private Question question = new Question();


    public void save() {
        questionDAO.save(question);
        question = new Question();
    }

    public Collection<Question> getAllquestion() {
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

}
