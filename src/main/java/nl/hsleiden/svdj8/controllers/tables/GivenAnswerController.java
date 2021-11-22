package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.GivenAnswerDAO;
import nl.hsleiden.svdj8.models.tables.GivenAnswer;
import nl.hsleiden.svdj8.repository.GivenAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GivenAnswerController {

    @Autowired
    public final GivenAnswerDAO givenAnswerDAO;

    @Autowired
    public final GivenAnswerRepository givenAnswerRepository;

    public GivenAnswerController(GivenAnswerDAO givenAnswerDAO, GivenAnswerRepository givenAnswerRepository) {
        this.givenAnswerDAO = givenAnswerDAO;
        this.givenAnswerRepository = givenAnswerRepository;
    }

    @GetMapping(value = "/givenanswer/all")
    public ResponseEntity<List<GivenAnswer>> getAllGivenAnswers() {
        return new ResponseEntity<>(givenAnswerDAO.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "givenanswer/{id}", method = RequestMethod.GET)
    public ResponseEntity<GivenAnswer> getGivenAnswer(@PathVariable final Long id) {
        return new ResponseEntity<>(givenAnswerDAO.getById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/givenanswer/{id}", method = RequestMethod.PUT)
    GivenAnswer editGivenAnswer(@RequestBody GivenAnswer editGivenAnswer, @PathVariable Long id) throws Exception {

//        "question_id"	integer NOT NULL,
//                "elapsed_seconds"	integer,
//                "answer_id"	integer NOT NULL,
//                "route_id"	integer,
        return givenAnswerRepository.findById(id)
                .map(givenAnswer -> {
//                    givenAnswer.setQuestion_id(editGivenAnswer.getQuestion_id());
                    givenAnswer.setElapsedSeconds(editGivenAnswer.getElapsedSeconds());

                    return givenAnswerRepository.save(givenAnswer);
                })
                .orElseThrow(() -> new Exception(
                        "No answer found with id " + id + "\""));

    }

    @RequestMapping(value = "/givenanswer", method = RequestMethod.POST)
    GivenAnswer addGivenAnswer(@RequestBody GivenAnswer newGivenAnswer) {
        return givenAnswerRepository.save(newGivenAnswer);
    }

    @DeleteMapping("/givenanswer/{id}")
    void deleteGivenAnswer(@PathVariable Long id) {
        givenAnswerRepository.deleteById(id);
    }

}
