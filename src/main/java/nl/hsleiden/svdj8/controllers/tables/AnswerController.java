package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.AnswerDAO;
import nl.hsleiden.svdj8.models.tables.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/answer", method = RequestMethod.GET)
public class AnswerController {

    @Autowired
    public final AnswerDAO answerDAO;

    public AnswerController(AnswerDAO answerDAO) {
        this.answerDAO = answerDAO;
    }

//    @PostMapping
//    public ResponseEntity<AnswerDto> addAnswer(@RequestBody final AnswerDto answerDto) {
//        Answer answer = answerService.addAnswer(Answer.from(answerDto));
//        return new ResponseEntity<>(answerDto, HttpStatus.OK);
//    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Answer>> getAllAnswers() {
        return new ResponseEntity<>(answerDAO.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Answer> getAnswer(@PathVariable final Long id) {
        return new ResponseEntity<>(answerDAO.getById(id), HttpStatus.OK);
    }

//    @DeleteMapping(value = "{id}")
//    public ResponseEntity<AnswerDto> deleteAnswer(@PathVariable final Long id) {
//        Answer answer = answerService.deleteAnswer(id);
//        return new ResponseEntity<>(AnswerDto.from(answer), HttpStatus.OK);
//    }
}
