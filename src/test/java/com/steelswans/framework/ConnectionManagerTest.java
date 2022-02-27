package com.steelswans.framework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionManagerTest {
    private static ConnectionManager cm;
    // Instantiating an instance of the ConnectionManager prior to every test.
    @BeforeAll
    static void setUp(){
        cm = new ConnectionManager("https://api.openweathermap.org/data/2.5/weather?q=",
                "bristol,gb", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
    }
    @Test
    @DisplayName("Given we make a HTTP Request it returns a HTTP Request as a HTTPRequest that isn't null")
    void returnHttpRequest() {
        var actualRequest = cm.returnHttpRequest();
        assertNotNull(actualRequest);
    }
    @Test
    @DisplayName("Given we make a HTTP Request it returns a HTTP Request as a String that isn't null")
    void returnStringHttpRequest() {
        var actualRequest = cm.returnStringHttpRequest();
        assertNotNull(actualRequest);
    }
    @Test
    @DisplayName("Given we request a HTTP Response it returns a HTTPResponse<String> that contains the URL of our request")
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
    @DisplayName("Given we request a HTTP Response it returns a String that contains the URL of our request")
    void returnStringHttpResponse() {
        var actualResponse = cm.returnStringHttpResponse(cm.returnHttpRequest());

        assertTrue(actualResponse.toLowerCase().contains("bristol"));
        assertTrue(actualResponse.toLowerCase().contains("weather"));
        assertTrue(actualResponse.toLowerCase().contains("description"));
    }
}