package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.GivenAnswerDAO;
import nl.hsleiden.svdj8.models.tables.GivenAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/givenanswer")
public class GivenAnswerController {

    @Autowired
    public final GivenAnswerDAO givenAnswerDAO;

    public GivenAnswerController(GivenAnswerDAO givenAnswerDAO) {
        this.givenAnswerDAO = givenAnswerDAO;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<GivenAnswer>> getAllGivenAnswers() {
        return new ResponseEntity<>(givenAnswerDAO.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<GivenAnswer> getGivenAnswer(@PathVariable final Long id) {
        return new ResponseEntity<>(givenAnswerDAO.getById(id), HttpStatus.OK);
    }

}
