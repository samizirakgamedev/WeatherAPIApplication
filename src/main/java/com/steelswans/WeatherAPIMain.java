package com.steelswans;

import org.json.simple.JSONObject;

import java.net.http.HttpResponse;

public class WeatherAPIMain {
    private static JSONObject jsonObject;


    public static void main(String[] args) {
        ConnectionManager cm = ConnectionManager.getConnection("api.openweathermap.org/data/2.5/weather?q=",
                "London", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        System.out.println(cm.constructedUrl);
        jsonObject = Injector.getJSONResponse(cm.getHttpResponse(cm.makeHttpRequest()));

    }
}
