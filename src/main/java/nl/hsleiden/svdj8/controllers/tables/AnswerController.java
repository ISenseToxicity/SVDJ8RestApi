package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.AnswerDAO;
import nl.hsleiden.svdj8.models.tables.Answer;
import nl.hsleiden.svdj8.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AnswerController {

    @Autowired
    public final AnswerDAO answerDAO;

    @Autowired
    public final AnswerRepository answerRepository;

    public AnswerController(AnswerDAO answerDAO, AnswerRepository answerRepository) {
        this.answerDAO = answerDAO;
        this.answerRepository = answerRepository;
    }

    @RequestMapping(value = "/answer/all", method = RequestMethod.GET)
    public ResponseEntity<List<Answer>> getAllAnswers() {
        return new ResponseEntity<>(answerDAO.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/answer/{id}", method = RequestMethod.GET)
    public ResponseEntity<Answer> getAnswer(@PathVariable final Long id) {
        return new ResponseEntity<>(answerDAO.getById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/answer/question/{id}", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Answer>> getAnswersByQuestionId(@PathVariable Long id){
        return new ResponseEntity<>(answerDAO.getByQuestionId(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/answer/{id}", method = RequestMethod.PUT)
    Answer editAnswer(@RequestBody Answer editAnswer, @PathVariable Long id) throws Exception {

        return answerRepository.findById(id)
                .map(answer -> {
                    answer.setAnswerText(editAnswer.getAnswerText());
                    answer.setQuestionID(editAnswer.getQuestionID());
                    answer.setCategoryID(editAnswer.getCategoryID());
                    return answerRepository.save(answer);
                })
                .orElseThrow(() -> new Exception(
                        "No answer found with id " + id + "\""));

    }

    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    Answer addAnswer(@RequestBody Answer newAnswer) {
        return answerRepository.save(newAnswer);
    }

    @DeleteMapping("/answer/{id}")
    void deleteAnswer(@PathVariable Long id) {
        answerRepository.deleteById(id);
    }
}
