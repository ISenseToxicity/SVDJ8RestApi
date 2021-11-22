package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.QuestionDAO;
import nl.hsleiden.svdj8.models.tables.Question;
import nl.hsleiden.svdj8.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    public final QuestionDAO questionDAO;

    @Autowired
    public final QuestionRepository questionRepository;

    public QuestionController(QuestionDAO questionDAO, QuestionRepository questionRepository) {
        this.questionDAO = questionDAO;
        this.questionRepository = questionRepository;
    }

    @RequestMapping(value = "/question/all", method = RequestMethod.GET)
    public ResponseEntity<List<Question>> getAllQuestions() {
      return new ResponseEntity<>(questionDAO.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/question/{id}", method = RequestMethod.GET)
    public ResponseEntity<Question> getQuestion(@PathVariable final Long id) {
       return new ResponseEntity<>(questionDAO.getById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/question/{id}", method = RequestMethod.PUT)
    Question editQuestion(@RequestBody Question editQuestion, @PathVariable Long id) throws Exception {

        return questionRepository.findById(id)
                .map(question -> {
                    question.setQuestionText(editQuestion.getQuestionText());
                    question.setExtraInfoTile(editQuestion.getExtraInfoTile());
                    question.setExtraInfoDescription(editQuestion.getExtraInfoDescription());
                    question.setExtraInfoVideoURL(editQuestion.getExtraInfoVideoURL());
                    return questionRepository.save(question);
                })
                .orElseThrow(() -> new Exception(
                        "No question found with id " + id + "\""));
    }

    @RequestMapping(value = "/question", method = RequestMethod.POST)
    Question addQuestion(@RequestBody Question newQuestion) {
        return questionRepository.save(newQuestion);
    }

    @DeleteMapping("/question/{id}")
    void deleteQuestion(@PathVariable Long id) {
        questionRepository.deleteById(id);
    }

}
