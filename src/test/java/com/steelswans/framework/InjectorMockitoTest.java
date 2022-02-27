package com.steelswans.framework;

import com.steelswans.dto.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.*;
import java.util.Objects;
import static org.mockito.ArgumentMatchers.any;

public class InjectorMockitoTest {
    private static JSONObject testJSONObject;
    private static String response;

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
        clouds = new Clouds();
        coord = new Coord();
        main = new Main();
        sys = new Sys();
        weather = new Weather();
        wind = new Wind();
        snow = new Snow();
        rain = new Rain();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("testJSONObject.json"));
            testJSONObject = (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Object obj = parser.parse(new FileReader("response.json"));
            response = obj.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("When inject into DTO method is used, the weather object should not be null")
    public void testInjectIntoDTO(){
        ConnectionManager mockManager = Mockito.mock(ConnectionManager.class);
        Injector injector = new Injector();
        Mockito.when(mockManager.returnStringHttpResponse(mockManager.returnHttpRequest())).thenReturn(response);
        JSONObject jsonObject =  injector.getJSONResponseBody(mockManager.returnStringHttpResponse(mockManager.returnHttpRequest()));
        injector.injectIntoDTO(jsonObject, clouds, coord, main, sys, weather, wind, snow, rain);
        Assertions.assertNotNull(weather);

    }

    @Test
    @DisplayName("When getJSON response method is used, jsonObject should not be null")
    public void testGetJSONResponse(){
        ConnectionManager mockManager = Mockito.mock(ConnectionManager.class);
        Injector injector = new Injector();
        Mockito.when(mockManager.returnStringHttpResponse(mockManager.returnHttpRequest())).thenReturn(response);
        JSONObject jsonObject =  injector.getJSONResponseBody(mockManager.returnStringHttpResponse(mockManager.returnHttpRequest()));
        Assertions.assertNotNull(jsonObject);
    }
}
