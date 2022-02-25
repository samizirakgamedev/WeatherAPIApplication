package com.steelswans;

import org.json.simple.JSONObject;

import java.net.http.HttpResponse;
import java.util.Objects;

public class WeatherAPIMain {
    private static JSONObject jsonObject;

    public static void main(String[] args) {
        ConnectionManager cm = ConnectionManager.getConnection("https://api.openweathermap.org/data/2.5/weather?q=",
                "London", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        jsonObject = Injector.getJSONResponse(Objects.requireNonNull(cm.getHttpResponse(cm.makeHttpRequest())));
        Injector.injectIntoDTO(jsonObject);
    }
}
