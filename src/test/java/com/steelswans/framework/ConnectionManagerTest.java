package com.steelswans.framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpRequest;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionManagerTest {
    private static ConnectionManager cm;
    @BeforeAll
    static void setUp(){
        cm = new ConnectionManager("https://api.openweathermap.org/data/2.5/weather?q=",
                "bristol,gb", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
    }

    @Test
    void returnHttpRequest() {
        var actualRequest = cm.returnHttpRequest();
        assertNotNull(actualRequest);
    }

    @Test
    void returnStringHttpRequestClassTypeCheck() {
        var actualRequest = cm.returnStringHttpRequest();
        assertNotNull(actualRequest);
    }

    @Test
    void returnHttpResponse() {
        var actualResponse = cm.returnHttpResponse(cm.returnHttpRequest());

        var expectedBaseUrl = "https://api.openweathermap.org/data/2.5/weather?q=";
        var expectedCity = "bristol,gb";
        var expectedAPIKey = APIKeyFileReader.readAPIKeyFile("apikey.txt");

        assertTrue(actualResponse.toString().contains(expectedBaseUrl));
        assertTrue(actualResponse.toString().contains(expectedCity));
        assert expectedAPIKey != null;
        assertTrue(actualResponse.toString().contains(expectedAPIKey));
    }

    @Test
    void returnStringHttpResponse() {
        var actualResponse = cm.returnHttpResponse(cm.returnHttpRequest());

        var expectedBaseUrl = "https://api.openweathermap.org/data/2.5/weather?q=";
        var expectedCity = "bristol,gb";
        var expectedAPIKey = APIKeyFileReader.readAPIKeyFile("apikey.txt");

        assertTrue(actualResponse.toString().contains(expectedBaseUrl));
        assertTrue(actualResponse.toString().contains(expectedCity));
        assert expectedAPIKey != null;
        assertTrue(actualResponse.toString().contains(expectedAPIKey));
    }

    @Test
    void getConnectionResponse() {
    }

    @Test
    void getHeaders() {
    }
}