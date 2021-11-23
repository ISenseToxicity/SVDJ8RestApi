package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.GivenAnswerDAO;
import nl.hsleiden.svdj8.models.tables.GivenAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GivenAnswerController {

    @Autowired
    private GivenAnswerDAO givenAnswerDAO;

    public GivenAnswerController(GivenAnswerDAO givenAnswerDAO) {
        this.givenAnswerDAO = givenAnswerDAO;
    }

    @GetMapping(value = "/givenanswer/all")
    public List<GivenAnswer> getAllGivenAnswers() {
        return givenAnswerDAO.getAll();
    }

    @GetMapping(value = "givenanswer/{id}")
    public GivenAnswer getGivenAnswer(@PathVariable final Long id) {
        return givenAnswerDAO.getById(id);
    }

    @PutMapping(value = "/givenanswer/{id}")
    public GivenAnswer editGivenAnswer(@RequestBody GivenAnswer editGivenAnswer, @PathVariable Long id) throws Exception {

        return givenAnswerDAO.getByIdOptional(id)
                .map(givenAnswer -> {
                    givenAnswer.setElapsedSeconds(editGivenAnswer.getElapsedSeconds());

                    return givenAnswerDAO.addGivenAnswer(givenAnswer);
                })
                .orElseThrow(() -> new Exception(
                        "No answer found with id " + id + "\""));

    }

    @PostMapping(value = "/givenanswer")
    public GivenAnswer addGivenAnswer(@RequestBody GivenAnswer newGivenAnswer) {
        return givenAnswerDAO.addGivenAnswer(newGivenAnswer);
    }

    @DeleteMapping("/givenanswer/{id}")
    public void deleteGivenAnswer(@PathVariable Long id) {
       givenAnswerDAO.deleteGivenAnswer(id);
    }
}
