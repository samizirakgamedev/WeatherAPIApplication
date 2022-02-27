package com.steelswans.dto;

import com.steelswans.framework.APIKeyFileReader;
import com.steelswans.framework.ConnectionManager;
import com.steelswans.framework.Injector;
import org.junit.jupiter.api.*;
import org.json.simple.JSONObject;

import java.util.Objects;

public class CityTests {
    private static JSONObject jsonObject, jsonObject2;
    private static Clouds clouds;
    private static Coord coord;
    private static Main main;
    private static Sys sys;
    private static Weather weather;
    private static Wind wind;
    private static Snow snow;
    private static Rain rain;

    @BeforeAll
    public static void setUp(){
        ConnectionManager cm = new ConnectionManager("https://api.openweathermap.org/data/2.5/weather?q=",
                "bristol,gb", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        Injector injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        clouds = new Clouds();
        coord = new Coord();
        main = new Main();
        sys = new Sys();
        weather = new Weather();
        wind = new Wind();
        snow = new Snow();
        rain = new Rain();
        injector.injectIntoDTO(jsonObject, clouds, coord, main, sys, weather, wind, snow, rain);
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
}