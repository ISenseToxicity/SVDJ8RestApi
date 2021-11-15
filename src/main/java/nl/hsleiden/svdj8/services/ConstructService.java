package nl.hsleiden.svdj8.services;

import org.json.JSONObject;

import java.util.Map;

public class ConstructService {

    public JSONObject constructNewJson(Map<String, Object> newData) {
        return new JSONObject(newData);
    }

}
