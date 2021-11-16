package nl.hsleiden.svdj8.controllers;

import nl.hsleiden.svdj8.models.Data;
import nl.hsleiden.svdj8.services.AuthenticatingService;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ApiController {

    private static ApiController apiController;

    public static ApiController getInstance() {
        if(apiController == null) {
            apiController = new ApiController();
        }
        return apiController;
    }

    public void deconstructData(String json) {
        DataController dataController = DataController.getInstance();
        StatementController statementController = StatementController.getInstance();

        Map<String, Object> deconstructedData = dataController.deconstructOldData(json);
        Data data = dataController.setData(deconstructedData);
        checkStatement(data);
    }

    private void checkStatement(Data data) {
        StatementController statementController = StatementController.getInstance();
        char statement = data.getDuty();
        switch (statement) {
            case 'C':
                statementController.getCreateStatement(data);
                break;
            case 'R':
                statementController.getReadDataStatement(data);
                break;
            case 'U':
                statementController.getUpdateStatement(data);
                break;
            case 'D':
                statementController.getDeleteStatement(data);
                break;
        }
    }

    private boolean checkAuthentication(Data data) {
        String token = data.getToken();
//        return authenticatingService.isAdmin(token);
        return false;
    }


    public Data returnDataStatement(Data oldData) {
        return null;
    }

    public void getConstructedNewData(Data newData) {

    }

    public void chooseTable() {

    }

    public Data makeSubsidieStatement(Data oldData) {
        return null;
    }

    public Data allQuestionsStatement(Data oldData) {
        return null;
    }

    public Data createRouteStatement(Data oldData) {
        return null;
    }

    public Data addAnswerStatement(Data oldData) {
        return null;
    }

    public String returnQueryAnswer(Data newData) {
        return null; //JSON
    }

    public Data questionStatement() {
        return null;
    }

    public Data subsidieStatement() {
        return null;
    }

    private Data answerToQuestionStatement() {
        return null;
    }

    public Data categoryStatement() {
        return null;
    }

    public Data setTheme(Data oldData) {
        return null;
    }

}
