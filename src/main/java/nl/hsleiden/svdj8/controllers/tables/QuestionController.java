package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.Dto.QuestionDto;
import nl.hsleiden.svdj8.models.tables.Question;
import nl.hsleiden.svdj8.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class QuestionController {
    @Autowired
    public final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

//    @GetMapping(value = "all")
//    public ResponseEntity<List<QuestionDto> getAllQuestions(){
//        List<Question> questions = questionService.getAllquestions();
//        return new ResponseEntity(QuestionDto.from(questions), HttpStatus.OK);
//    }
//    @PostMapping
//    public ResponseEntity<QuestionDto> addQuestion(@RequestBody final QuestionDto questionDto){
//        Question question = questionService.savequestion(Question.from(questionDto));
//        return new ResponseEntity<>(questionDto, HttpStatus.OK);
//    }
//    @GetMapping(value = "{id}")
//    public ResponseEntity<QuestionDto> getQuestion(@PathVariable final Long id){
//        Question question = questionService.getquestion(Question(id);
//        return new ResponseEntity(QuestionDto.from(question), HttpStatus.OK);
//    }
//    @DeleteMapping(value = "{id}")
//    public ResponseEntity<QuestionDto> deleteQuestion(@PathVariable final Long id){
//        Question question = questionService.deleteQuestion(id);
//        return new ResponseEntity(QuestionDto.from(question), HttpStatus.OK);
//    }
}
