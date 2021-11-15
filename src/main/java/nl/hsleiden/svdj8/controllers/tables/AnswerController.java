package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.Dto.AnswerDto;
import nl.hsleiden.svdj8.models.tables.Answer;
import nl.hsleiden.svdj8.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/answer", method = RequestMethod.GET)
public class AnswerController {

    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {

        this.answerService = answerService;
    }

    @PostMapping
    public ResponseEntity<AnswerDto> addAnswer(@RequestBody final AnswerDto answerDto) {
        Answer answer = answerService.addAnswer(Answer.from(answerDto));
        return new ResponseEntity<>(answerDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AnswerDto> getItem(@PathVariable final Long id) {
        Answer answer = answerService.getAnswer(id);
        return new ResponseEntity<>(AnswerDto.from(answer), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<AnswerDto> deleteAnswer(@PathVariable final Long id) {
        Answer answer = answerService.deleteAnswer(id);
        return new ResponseEntity<>(AnswerDto.from(answer), HttpStatus.OK);
    }
}
