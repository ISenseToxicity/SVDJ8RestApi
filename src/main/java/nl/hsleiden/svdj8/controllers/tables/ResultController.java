package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.GrantDAO;
import nl.hsleiden.svdj8.daos.ResultDAO;
import nl.hsleiden.svdj8.models.tables.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ResultController {

    @Autowired
    public final ResultDAO resultDAO;

    @Autowired
    public final GrantDAO grantDAO;


    public ResultController(ResultDAO resultDAO, GrantDAO grantDAO) {
        this.resultDAO = resultDAO;
        this.grantDAO = grantDAO;
    }

    @GetMapping(value = "/result/all")
    public List<Result> getAllResults() {
        return resultDAO.getAll();
    }

    @GetMapping(value = "/result/{id}")
    public Result getResult(@PathVariable final Long id) {
        return resultDAO.getById(id);
    }

    @PutMapping(value = "/result/{id}")
    public Result editResult(@RequestBody Result editResult, @PathVariable Long id) throws Exception {
        Result returnResult = resultDAO.getByIdOptional(id)
                .map(result -> {
                    result.setTotalTime(editResult.getTotalTime());
                    result.setAmountQuestions(editResult.getAmountQuestions());
                    result.setGrant(editResult.getGrant());
                    return resultDAO.addQuestion(result);
                })
                .orElseThrow(() -> new Exception(
                        "No result found with id " + id + "\""));
        returnResult.setGrant(grantDAO.getById(returnResult.getGrant().getGrantID()));
        return returnResult;
    }

    @PostMapping(value = "/result")
    public Result addResult(@RequestBody Result newResult) {
        return resultDAO.addQuestion(newResult);
    }

    @DeleteMapping("/result/{id}")
    public void deleteResult(@PathVariable Long id) {
        resultDAO.deleteQuestion(id);
    }
}
