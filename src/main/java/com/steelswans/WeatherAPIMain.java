package com.steelswans;

import com.steelswans.framework.*;
import com.steelswans.framework.APIKeyFileReader;
import com.steelswans.framework.ConnectionManager;
import com.steelswans.framework.Injector;
import com.steelswans.framework.dto.*;
import org.json.simple.JSONObject;

import java.util.Objects;

public class WeatherAPIMain {
    private static ConnectionManager cm;
    private static Injector injector;

    private static JSONObject jsonObject;

    public static void main(String[] args) {
        // Handles sending the HTTP Request and getting the HTTP Response
        cm = new ConnectionManager("https://api.openweathermap.org/data/2.5/weather?q=",
                "London", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));

        // DTO classes for storing data from the response.
        Clouds clouds = new Clouds();
        Coord coord = new Coord();
        Main main = new Main();
        Sys sys = new Sys();
        Weather weather = new Weather();
        Wind wind = new Wind();
        Snow snow = new Snow();
        Rain rain = new Rain();

        // Injecting the data into the DTO classes from the response.
        injector.injectIntoDTO(jsonObject, clouds, coord, main, sys, weather, wind, snow, rain);

        // Output to the console.
        // Confirms the framework is sending a request and getting a response from the Open Weather API.
        System.out.println("Request Made To Open Weather API:");
        System.out.println(cm.returnHttpRequest());
        System.out.println("=================================================");
        System.out.println("Response Received From Open Weather API:");
        System.out.println(jsonObject);
        System.out.println("=================================================");
        if (jsonObject != null)
            System.out.println(">> Framework Functioning Correctly <<");
    }
}
