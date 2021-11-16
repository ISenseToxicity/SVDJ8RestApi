package nl.hsleiden.svdj8.controllers;

import nl.hsleiden.svdj8.models.Data;
import nl.hsleiden.svdj8.services.ConstructService;
import nl.hsleiden.svdj8.services.DeconstructService;

import java.util.ArrayList;
import java.util.Map;

public class DataController {

    DeconstructService deconstructService;
    ConstructService constructService;

    public Data convertToNewData(Data oldData) {
        return null;
    }

    public Map<String, Object> deconstructOldData(String json) {
        return deconstructService.deconstructJson(json);
    }

    public Data reconstructOldData(Data oldData) {
        return null;
    }

    private void isNewData(Boolean isNewData) {

    }

    private void setDutyToDone(String done) {

    }

    public ArrayList<Data> getAllData() {
        return null;
    }

    public Data getData() {
        return null;
    }

    public Data setData(Map<String, Object> data) {
        return null;
    }


}
