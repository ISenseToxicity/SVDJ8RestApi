package nl.hsleiden.svdj8.controllers;

import nl.hsleiden.svdj8.models.Data;

import java.util.Map;

public class ApiController {

    private void checkAuthentication(Data data) {

    }

    public void deconstructData(String json) {
        DataController dataController = new DataController();
        StatementController statementController = new StatementController();
        Map<String, Object> deconstructedData = dataController.deconstructOldData(json);
        Data data = dataController.setData(deconstructedData);
        Boolean user = true; //TODO: authenticate value isAdmin(); boolean
        if(user) {
            statementController.getReadDataStatement(data);
        }else {
            statementController.getCreateStatement(data);
        }
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
