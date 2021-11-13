package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.QuestionDAO;
import nl.hsleiden.svdj8.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

            @Autowired
    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<QuestionDAO> addQuestion(@RequestBody final QuestionDAO questionDAO){

    }
}
