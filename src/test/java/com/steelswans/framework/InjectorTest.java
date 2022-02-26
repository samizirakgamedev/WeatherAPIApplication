package com.steelswans.framework;

import com.steelswans.dto.*;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

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
    public void getJSONResponseContainsWeather() {
        ConnectionManager cm = new ConnectionManager("https://api.openweathermap.org/data/2.5/weather?q=",
                "bristol,gb", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        String apiDeatils = jsonObject.toString();
        MatcherAssert.assertThat(apiDeatils, CoreMatchers.containsString("weather"));
    }

    @Test
    public void getJSONResponseContainsClouds() {
        ConnectionManager cm = new ConnectionManager("https://api.openweathermap.org/data/2.5/weather?q=",
                "bristol,gb", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        String apiDeatils = jsonObject.toString();
        MatcherAssert.assertThat(apiDeatils, CoreMatchers.containsString("clouds"));
    }

    @Test
    public void getJSONResponseContainsCoord() {
        ConnectionManager cm = new ConnectionManager("https://api.openweathermap.org/data/2.5/weather?q=",
                "bristol,gb", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        String apiDeatils = jsonObject.toString();
        MatcherAssert.assertThat(apiDeatils, CoreMatchers.containsString("coord"));
    }

    @Test
    public void getJSONResponseContainsMain() {
        ConnectionManager cm = new ConnectionManager("https://api.openweathermap.org/data/2.5/weather?q=",
                "bristol,gb", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        String apiDeatils = jsonObject.toString();
        MatcherAssert.assertThat(apiDeatils, CoreMatchers.containsString("main"));
    }

    @Test
    public void getJSONResponseContainsSys() {
        ConnectionManager cm = new ConnectionManager("https://api.openweathermap.org/data/2.5/weather?q=",
                "bristol,gb", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        String apiDeatils = jsonObject.toString();
        MatcherAssert.assertThat(apiDeatils, CoreMatchers.containsString("sys"));
    }
    @Test
    public void getJSONResponseContainsWind() {
        ConnectionManager cm = new ConnectionManager("https://api.openweathermap.org/data/2.5/weather?q=",
                "bristol,gb", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        String apiDeatils = jsonObject.toString();
        MatcherAssert.assertThat(apiDeatils, CoreMatchers.containsString("wind"));
    }

    @Test
    public void getJSONResponseContainsSnow() {
        ConnectionManager cm = new ConnectionManager("https://api.openweathermap.org/data/2.5/weather?q=",
                "bristol,gb", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        String apiDeatils = jsonObject.toString();
        MatcherAssert.assertThat(apiDeatils, CoreMatchers.containsString("snow"));
    }

    @Test
    public void getJSONResponseContainsRain() {
        ConnectionManager cm = new ConnectionManager("https://api.openweathermap.org/data/2.5/weather?q=",
                "bristol,gb", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        String apiDeatils = jsonObject.toString();
        MatcherAssert.assertThat(apiDeatils, CoreMatchers.containsString("rain"));
    }

    @Test
    void getJSONResponseIsNotNullCheck() {
        ConnectionManager cm = new ConnectionManager("https://api.openweathermap.org/data/2.5/weather?q=",
                "bristol,gb", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        Assertions.assertNotNull(jsonObject);
    }

    @Test
    void injectIntoDTO() {
        ConnectionManager cm = new ConnectionManager("https://api.openweathermap.org/data/2.5/weather?q=",
                "bristol,gb", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        String apiDeatils = jsonObject.toString();
        MatcherAssert.assertThat(apiDeatils, CoreMatchers.containsString("weather"));

    }
}