package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.QuestionDAO;
import nl.hsleiden.svdj8.daos.dto.QuestionDto;
import nl.hsleiden.svdj8.models.tables.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/question")
public class QuestionController {

    @Autowired
    public final QuestionDAO questionDAO;

    public QuestionController(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Question>> getAllQuestions() {
      return new ResponseEntity<>(questionDAO.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<QuestionDto> addQuestion(@RequestBody final QuestionDto questionDto) {
//        Question question = questionService.savequestion(Question.from(questionDto));
//        questionService.savequestion(Question.from(questionDto));
        return new ResponseEntity<>(questionDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Question> getQuestion(@PathVariable final Long id) {
       return new ResponseEntity<>(questionDAO.getById(id), HttpStatus.OK);
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<QuestionDto> deleteQuestion(@PathVariable final Long id) {
//        Question question = questionService.deleteQuestion(id);
//        return new ResponseEntity<>(QuestionDto.from(question), HttpStatus.OK);
//    }
}
