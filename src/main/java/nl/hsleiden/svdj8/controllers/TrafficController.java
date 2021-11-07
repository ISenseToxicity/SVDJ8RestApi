package nl.hsleiden.svdj8.controllers;

import nl.hsleiden.svdj8.exceptions.NoSuchElementException;
import nl.hsleiden.svdj8.models.tables.Question;
import nl.hsleiden.svdj8.models.tables.TempQuestionListMaker;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class TrafficController {


    @RequestMapping(value = "/questionlist", method = RequestMethod.GET)
    public Object getQuestionList(){
        TempQuestionListMaker tempQuestionListMaker = new TempQuestionListMaker();
        return tempQuestionListMaker.makeList();
    }

    @RequestMapping(value = "/question/{id}")
    public Question getQuestion(@PathVariable int id){
        TempQuestionListMaker tempQuestionListMaker = new TempQuestionListMaker();
        ArrayList<Question> questions = new ArrayList<>(tempQuestionListMaker.makeList().getQuestions());
        if(questions.size() -1 < id)throw new NoSuchElementException("index out of bounds");
        return questions.get(id);
    }
}
