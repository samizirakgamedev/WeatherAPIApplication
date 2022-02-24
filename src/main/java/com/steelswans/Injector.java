package com.steelswans;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.net.http.HttpResponse;

public class Injector {
    private static JSONParser jsonParser;
    private static JSONObject jsonObject;

    public static JSONObject getJSONResponse(HttpResponse<String> response) {
        try{
            String responseBody = response.body();
            jsonParser = new JSONParser();
            jsonObject = (JSONObject) jsonParser.parse(responseBody);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
