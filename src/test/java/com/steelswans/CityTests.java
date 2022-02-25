package com.steelswans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.util.Objects;

public class CityTests {
    private static WeatherItem WeatherItem;
    private static JSONObject jsonObject, jsonObject2;
    private static FileWriter file;

    @BeforeAll
    public static void setUp(){
        ConnectionManager cm = ConnectionManager.getConnection("https://api.openweathermap.org/data/2.5/weather?q=",
                "bristol,gb", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        Injector injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.getHttpResponse(cm.makeHttpRequest())));
        injector.injectIntoDTO(jsonObject);
        System.out.println(jsonObject.toString());
    }
    @Test
    @DisplayName("Check the correct city is returned even if it's not capital letter")
    public void cityTest(){
        Assertions.assertEquals("Bristol", jsonObject.get("name"));
    }

    @Test
    @DisplayName("Check if correct city id is returned")
    public void cityIdCheck(){
        Assertions.assertEquals((long) 2654675, jsonObject.get("id"));
    }

    @Test
    @DisplayName("Check if the correct timezone for Bristol, UK is returned")
    public void checkTimezone(){
        Assertions.assertEquals((long) 0, jsonObject.get("timezone"));
    }

    @Test
    @DisplayName("Check if the correct country for Bristol, UK is returned")
    public void checkCountry(){
        JSONObject getSys = (JSONObject) jsonObject.get("sys");
        Assertions.assertEquals("GB", getSys.get("country"));
    }

    @Test
    @DisplayName("Check if the correct latitude for Bristol, UK is returned")
    public void checkLatitude(){
        JSONObject getCoord = (JSONObject) jsonObject.get("coord");
        Assertions.assertEquals(51.4552, getCoord.get("lat"));
    }

    @Test
    @DisplayName("Check if the correct longitude for Bristol, UK is returned")
    public void checkLongitude(){
        JSONObject getCoord = (JSONObject) jsonObject.get("coord");
        Assertions.assertEquals(-2.5967, getCoord.get("lon"));
    }

    @Test
    @DisplayName("Check invalid input response")//doesn't work
    public void checkInvalidInput(){
        ConnectionManager cm2 = ConnectionManager.getConnection("https://api.openweathermap.org/data/2.5/weather?q=", "", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        Injector injector2 = new Injector();
        jsonObject2 = injector2.getJSONResponse(Objects.requireNonNull(cm2.getHttpResponse(cm2.makeHttpRequest())));
        injector2.injectIntoDTO(jsonObject2);
        //System.out.println(jsonObject2);
        //System.out.println(jsonObject2.get("cod"));
    }

}
