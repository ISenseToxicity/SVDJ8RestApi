package nl.hsleiden.svdj8.controllers;

import nl.hsleiden.svdj8.exceptions.NoSuchElementException;
import nl.hsleiden.svdj8.models.ReturnModel;
import nl.hsleiden.svdj8.models.temp.Question;
import nl.hsleiden.svdj8.models.temp.TempQuestionListMaker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class TrafficController {

    @GetMapping(value = "/questionlist")
    public Object getQuestionList(){
        TempQuestionListMaker tempQuestionListMaker = new TempQuestionListMaker();
        ReturnModel returnModel = new ReturnModel();
        returnModel.setHttpStatus("200");
        returnModel.setReturnObject(tempQuestionListMaker.makeList());
        return returnModel;
    }

    @GetMapping(value = "/question/{id}")
    public Question getQuestion(@PathVariable int id){
        TempQuestionListMaker tempQuestionListMaker = new TempQuestionListMaker();
        ArrayList<Question> questions = tempQuestionListMaker.makeList().getQuestions();
        if(questions.size() -1 < id)  throw new NoSuchElementException("index out of bounds");
        return questions.get(id);
    }
}
