package nl.hsleiden.svdj8.services;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.hibernate.internal.util.collections.ArrayHelper.toList;

public class DeconstructService {

    public Map<String, Object> deconstructJson(JSONObject json) {
        Map<String, Object> map = new HashMap<>();

        if(json != JSONObject.NULL) {
            map = toMap(json);
        }
        return map;
    }

    private Map<String, Object> toMap(JSONObject json) {
        Map<String, Object> map = new HashMap<String, Object>();

        Iterator<String> keysItr = json.keys();
        while(keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = json.get(key);

            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }

}
