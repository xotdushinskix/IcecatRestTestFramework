package com.rest.icecat.helpers;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Created by nikita on 07.12.16.
 */
public class JSONworker {


    public String getJsonObject(HttpEntity entity, String keyName) throws IOException {
        JSONParser parser = new JSONParser();
        JSONObject json;
        String requiredValue = null;
        try {
            json = (JSONObject) parser.parse(EntityUtils.toString(entity, "UTF-8"));
            requiredValue = (String) json.get(keyName);
        } catch (ParseException e) {
            System.out.println("Cannot get value from json object");
        }
        return requiredValue;
    }




    public String getDataFromJson(String data, String keyName) {
        JSONParser parser = new JSONParser();
        JSONObject json;
        String requiredValue = null;
        try {
            json = (JSONObject) parser.parse(data);
            requiredValue = (String) json.get(keyName);
        } catch (ParseException e) {
            System.out.println("Cannot get value from json object");
        }
        return requiredValue;
    }

}
