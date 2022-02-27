package com.steelswans.framework;

import com.steelswans.dto.*;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.*;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class InjectorTest {
    private static JSONObject jsonObject;
    private static Clouds clouds;
    private static Coord coord;
    private static Main main;
    private static Sys sys;
    private static Weather weather;
    private static Wind wind;
    private static Snow snow;
    private static Rain rain;
    private static Injector injector;
    private static ConnectionManager cm;

    @Test
    @DisplayName("Given a valid API key, the JSON response contains the 'weather' section of the API")
    public void getJSONResponseContainsWeather() {
        ConnectionManager cm = new ConnectionManager("https://api.openweathermap.org/data/2.5/weather?q=",
                "bristol,gb", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        String apiDeatils = jsonObject.toString();
        MatcherAssert.assertThat(apiDeatils, CoreMatchers.containsString("weather"));
    }

    @Test
    @DisplayName("Given a valid API key, the JSON response contains the 'clouds' section of the API")
    public void getJSONResponseContainsClouds() {
        ConnectionManager cm = new ConnectionManager("https://api.openweathermap.org/data/2.5/weather?q=",
                "bristol,gb", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        String apiDeatils = jsonObject.toString();
        MatcherAssert.assertThat(apiDeatils, CoreMatchers.containsString("clouds"));
    }

    @Test
    @DisplayName("Given a valid API key, the JSON response contains the 'coord' section of the API")
    public void getJSONResponseContainsCoord() {
        ConnectionManager cm = new ConnectionManager("https://api.openweathermap.org/data/2.5/weather?q=",
                "bristol,gb", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        String apiDeatils = jsonObject.toString();
        MatcherAssert.assertThat(apiDeatils, CoreMatchers.containsString("coord"));
    }

    @Test
    @DisplayName("Given a valid API key, the JSON response contains the 'main' section of the API")
    public void getJSONResponseContainsMain() {
        ConnectionManager cm = new ConnectionManager("https://api.openweathermap.org/data/2.5/weather?q=",
                "bristol,gb", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        String apiDeatils = jsonObject.toString();
        MatcherAssert.assertThat(apiDeatils, CoreMatchers.containsString("main"));
    }

    @Test
    @DisplayName("Given a valid API key, the JSON response contains the 'sys' section of the API")
    public void getJSONResponseContainsSys() {
        ConnectionManager cm = new ConnectionManager("https://api.openweathermap.org/data/2.5/weather?q=",
                "bristol,gb", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        String apiDeatils = jsonObject.toString();
        MatcherAssert.assertThat(apiDeatils, CoreMatchers.containsString("sys"));
    }
    @Test
    @DisplayName("Given a valid API key, the JSON response contains the 'wind' section of the API")
    public void getJSONResponseContainsWind() {
        ConnectionManager cm = new ConnectionManager("https://api.openweathermap.org/data/2.5/weather?q=",
                "bristol,gb", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        String apiDeatils = jsonObject.toString();
        MatcherAssert.assertThat(apiDeatils, CoreMatchers.containsString("wind"));
    }

    @Test
    @DisplayName("Given a valid API key, the JSON response is not null")
    void getJSONResponseIsNotNullCheck() {
        ConnectionManager cm = new ConnectionManager("https://api.openweathermap.org/data/2.5/weather?q=",
                "bristol,gb", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        Assertions.assertNotNull(jsonObject);
    }
}