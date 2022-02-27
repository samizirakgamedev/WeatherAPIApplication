package com.steelswans.framework;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.*;
import java.util.Objects;

class InjectorTest {
    private static JSONObject jsonObject;
    private static Injector injector;
    private static ConnectionManager cm;
    // Instantiating an instance of the ConnectionManager prior to every test.
    @BeforeAll
    static void setUp(){
        cm = new ConnectionManager("https://api.openweathermap.org/data/2.5/weather?q=",
                "bristol,gb", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
    }
    @Test
    @DisplayName("Given a valid API key, the JSON response contains the 'weather' section of the API")
    public void getJSONResponseContainsWeather() {
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        String apiDetails = jsonObject.toString();
        MatcherAssert.assertThat(apiDetails, CoreMatchers.containsString("weather"));
    }
    @Test
    @DisplayName("Given a valid API key, the JSON response contains the 'clouds' section of the API")
    public void getJSONResponseContainsClouds() {
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        String apiDetails = jsonObject.toString();
        MatcherAssert.assertThat(apiDetails, CoreMatchers.containsString("clouds"));
    }
    @Test
    @DisplayName("Given a valid API key, the JSON response contains the 'coord' section of the API")
    public void getJSONResponseContainsCoord() {
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        String apiDetails = jsonObject.toString();
        MatcherAssert.assertThat(apiDetails, CoreMatchers.containsString("coord"));
    }
    @Test
    @DisplayName("Given a valid API key, the JSON response contains the 'main' section of the API")
    public void getJSONResponseContainsMain() {
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        String apiDetails = jsonObject.toString();
        MatcherAssert.assertThat(apiDetails, CoreMatchers.containsString("main"));
    }
    @Test
    @DisplayName("Given a valid API key, the JSON response contains the 'sys' section of the API")
    public void getJSONResponseContainsSys() {
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        String apiDetails = jsonObject.toString();
        MatcherAssert.assertThat(apiDetails, CoreMatchers.containsString("sys"));
    }
    @Test
    @DisplayName("Given a valid API key, the JSON response contains the 'wind' section of the API")
    public void getJSONResponseContainsWind() {
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        String apiDetails = jsonObject.toString();
        MatcherAssert.assertThat(apiDetails, CoreMatchers.containsString("wind"));
    }
    @Test
    @DisplayName("Given a valid API key, the JSON response is not null")
    void getJSONResponseIsNotNullCheck() {
        injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.returnHttpResponse(cm.returnHttpRequest())));
        Assertions.assertNotNull(jsonObject);
    }
}