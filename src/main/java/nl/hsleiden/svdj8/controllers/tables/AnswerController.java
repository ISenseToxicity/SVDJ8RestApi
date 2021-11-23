package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.AnswerDAO;
import nl.hsleiden.svdj8.models.tables.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswerController {

    @Autowired
    public final AnswerDAO answerDAO;

    public AnswerController(AnswerDAO answerDAO) {
        this.answerDAO = answerDAO;
    }

    @GetMapping(value = "/answer/all")
    public List<Answer> getAllAnswers() {
        return answerDAO.getAll();
    }

    @GetMapping(value = "/answer/{id}")
    public Answer getAnswer(@PathVariable final Long id) {
        return answerDAO.getById(id);
    }

    @GetMapping(value = "/answer/question/{id}")
    public List<Answer> getAnswersByQuestionId(@PathVariable Long id){
        return answerDAO.getByQuestionId(id);
    }

    @PutMapping(value = "/answer/{id}")
    public Answer editAnswer(@RequestBody Answer editAnswer, @PathVariable Long id) throws Exception {

        return answerDAO.getByIdOptional(id)
                .map(answer -> {
                    answer.setAnswerText(editAnswer.getAnswerText());
                    answer.setQuestionID(editAnswer.getQuestionID());
                    answer.setCategoryID(editAnswer.getCategoryID());
                    return answerDAO.addAnswer(answer);
                })
                .orElseThrow(() -> new Exception(
                        "No answer found with id " + id + "\""));
    }

    @PostMapping(value = "/answer")
    public Answer addAnswer(@RequestBody Answer newAnswer) {
        return answerDAO.addAnswer(newAnswer);
    }

    @DeleteMapping("/answer/{id}")
    public void deleteAnswer(@PathVariable Long id) {
        answerDAO.deleteByAnswerId(id);
    }
}
