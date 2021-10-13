package nl.hsleiden.svdj8.controllers;

import nl.hsleiden.svdj8.models.temp.TempQuestionListMaker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TrafficController {


    @RequestMapping(value = "/questionlist", method = RequestMethod.GET)
    public Object getQuestionList(){
        TempQuestionListMaker tempQuestionListMaker = new TempQuestionListMaker();
        return tempQuestionListMaker.makeList();
    }
}
