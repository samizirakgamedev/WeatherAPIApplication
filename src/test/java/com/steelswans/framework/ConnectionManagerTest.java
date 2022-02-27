package com.steelswans.framework;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpRequest;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionManagerTest {
    private static ConnectionManager cm;

    @Test
    void returnHttpRequest() {
    }

    @Test
    void returnStringHttpRequestClassTypeCheck() {
        ConnectionManager cm = new ConnectionManager("https://api.openweathermap.org/data/2.5/weather?q=",
                "bristol,gb", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
    }

    @Test
    void returnHttpResponse() {
    }

    @Test
    void returnStringHttpResponse() {
    }

    @Test
    void getConnectionResponse() {
    }

    @Test
    void getHeaders() {
    }
}