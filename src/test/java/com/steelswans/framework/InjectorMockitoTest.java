package com.steelswans.framework;

import com.steelswans.framework.dto.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.*;

public class InjectorMockitoTest {
    private static JSONParser parser;
    private static String response;
    private static JSONObject jsonObject;

    private static Clouds clouds;
    private static Coord coord;
    private static Main main;
    private static Sys sys;
    private static Weather weather;
    private static Wind wind;
    private static Snow snow;
    private static Rain rain;

    // Instantiating new instances of the DTO classes and assigning them to the appropriate variables.
    // Reading the test response from a file.
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
        parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("response.json"));
            response = obj.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ConnectionManager mockManager = Mockito.mock(ConnectionManager.class);
        Injector injector = new Injector();
        Mockito.when(mockManager.returnStringHttpResponse(mockManager.returnHttpRequest())).thenReturn(response);
        jsonObject =  injector.getJSONResponseBody(mockManager.returnStringHttpResponse(mockManager.returnHttpRequest()));
        injector.injectIntoDTO(jsonObject, clouds, coord, main, sys, weather, wind, snow, rain);
    }

    @Test
    @DisplayName("When getJSON response method is used, jsonObject should not be null")
    public void testGetJSONResponse(){
        Assertions.assertNotNull(jsonObject);
    }

    @Test
    @DisplayName("When injectIntoDTO method is used, the weather object should not be null")
    public void givenInjectIntoDTO_WeatherIsNotNull(){
        Assertions.assertNotNull(weather);
    }

    @Test
    @DisplayName("When injectIntoDTO method is used, the clouds object should not be null")
    public void givenInjectIntoDTO_CloudsIsNotNull(){
        Assertions.assertNotNull(clouds);
    }

    @Test
    @DisplayName("When injectIntoDTO method is used, the coord object should not be null")
    public void givenInjectIntoDTO_CoordIsNotNull(){
        Assertions.assertNotNull(coord);
    }

    @Test
    @DisplayName("When injectIntoDTO method is used, the main object should not be null")
    public void givenInjectIntoDTO_MainIsNotNull(){
        Assertions.assertNotNull(main);
    }

    @Test
    @DisplayName("When injectIntoDTO method is used, the sys object should not be null")
    public void givenInjectIntoDTO_SysIsNotNull(){
        Assertions.assertNotNull(sys);
    }

    @Test
    @DisplayName("When injectIntoDTO method is used, the wind object should not be null")
    public void givenInjectIntoDTO_WindIsNotNull(){
        Assertions.assertNotNull(wind);
    }

    @Test
    @DisplayName("When injectIntoDTO method is used, the snow object should not be null")
    public void givenInjectIntoDTO_SnowIsNotNull(){
        Assertions.assertNotNull(snow);
    }

    @Test
    @DisplayName("When injectIntoDTO method is used, the rain object should not be null")
    public void givenInjectIntoDTO_RainIsNotNull(){
        Assertions.assertNotNull(rain);
    }
}
