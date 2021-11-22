package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.ResultDAO;
import nl.hsleiden.svdj8.models.tables.Result;
import nl.hsleiden.svdj8.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResultController {

    @Autowired
    public final ResultDAO resultDAO;

    @Autowired
    public final ResultRepository resultRepository;

    public ResultController(ResultDAO resultDAO, ResultRepository resultRepository) {
        this.resultDAO = resultDAO;
        this.resultRepository = resultRepository;
    }

    @RequestMapping(value = "/result/all", method = RequestMethod.GET)
    public ResponseEntity<List<Result>> getAllResults() {
        return new ResponseEntity<>(resultDAO.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/result/{id}", method = RequestMethod.GET)
    public ResponseEntity<Result> getResult(@PathVariable final Long id) {
        return new ResponseEntity<>(resultDAO.getById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/result/{id}", method = RequestMethod.PUT)
    Result editResult(@RequestBody Result editResult, @PathVariable Long id) throws Exception {

        return resultRepository.findById(id)
                .map(result -> {
                    result.setTotalTime(editResult.getTotalTime());
                    result.setAmountQuestions(editResult.getAmountQuestions());
                    return resultRepository.save(result);
                })
                .orElseThrow(() -> new Exception(
                        "No result found with id " + id + "\""));
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    Result addResult(@RequestBody Result newResult) {
        return resultRepository.save(newResult);
    }

    @DeleteMapping("/result/{id}")
    void deleteResult(@PathVariable Long id) {
        resultRepository.deleteById(id);
    }

}
