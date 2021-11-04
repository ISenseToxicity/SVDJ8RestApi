package nl.hsleiden.svdj8.controllers;

import nl.hsleiden.svdj8.daos.ApplicationDAO;
import nl.hsleiden.svdj8.models.Statement;

import nl.hsleiden.svdj8.models.temp.Data;

public class StatementController {
    private static StatementController statementController;
    ApplicationDAO dao = ApplicationDAO.getInstance();

    Statement statements = new Statement();

    public static StatementController getInstance(){
        if(statementController == null){
            statementController = new StatementController();
        }
        return statementController;
    }


    public boolean getCreateStatement(Data data) {
        String statementCreate = "INSERT INTO" + data.getGivenVariables().get("class")
                + "VARIABLES(" + data.getGivenVariables().get("columns") + ")";
        if (data.getGivenVariables().get("where") != null) {
            statementCreate += "WHERE" + data.getGivenVariables().get("where");
        }
        statements.setCreateStatement(new StringBuilder(statementCreate));
        return dao.sendQuery(statementCreate);
    }

    public boolean getUpdateStatement(Data data) {
        String statementUpdate = "UPDATE FROM" + data.getGivenVariables().get("class")
                + "WHERE" + data.getGivenVariables().get("where");

        statements.setCreateStatement(new StringBuilder(statementUpdate));
        return dao.sendQuery(statementUpdate);
    }

    public boolean getDeleteStatement(Data data) {
        String statementUpdate = "DELETE" + data.getGivenVariables().get("class")
                + "VARIABLES(" + data.getGivenVariables().get("columns") + ")"
                + "WHERE" + data.getGivenVariables().get("where");

        statements.setCreateStatement(new StringBuilder(statementUpdate));
        return dao.sendQuery(statementUpdate);
    }

    public boolean getReadDataStatement(Data data) {
        String statementGet = "SELECT" + data.getGivenVariables().get("columns")
                + "FROM" + data.getGivenVariables().get("class");
        if (data.getGivenVariables().get("where") != null) {
            statementGet += "WHERE" + data.getGivenVariables().get("where");
        }
        return dao.sendQuery(statementGet);
    }

}
