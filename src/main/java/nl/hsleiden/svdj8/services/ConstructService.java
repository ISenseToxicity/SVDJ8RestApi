package nl.hsleiden.svdj8.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.util.Map;

public class ConstructService {

    public String constructNewJson(Map<String, Object> map) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

}
