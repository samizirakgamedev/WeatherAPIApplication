package com.steelswans.framework;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.*;
import java.util.Objects;
import static org.mockito.ArgumentMatchers.any;

public class InjectorMockitoTest {
    private static JSONObject testJSONObject;
    @BeforeAll
    public static void setUp(){
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("testJSONObject.json"));
            testJSONObject = (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void testGetJSONResponse(){
//        String mockUrl = "https://api.openweathermap.org/data/2.5/weather?q=";
//        String mockCity = "London";
//        String mockApiKey = APIKeyFileReader.readAPIKeyFile("apikey.txt");
//        ConnectionManager cm = ConnectionManager.getConnection(mockUrl, mockCity, mockApiKey);
//
//        Injector injector = Mockito.mock(Injector.class);
//        JSONObject expected = testJSONObject;
//        Mockito.when(injector.getJSONResponse(any())).thenReturn(testJSONObject);
//        JSONObject actual =  injector.getJSONResponse(Objects.requireNonNull(cm.getHttpResponse(cm.makeHttpRequest())));
//
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void test(){
//        ConnectionManager mockManager = Mockito.mock(ConnectionManager.class);
//        Mockito.when(mockManager.getConnection(any(), any(), any())).thenReturn(mockManager);
//        Mockito.when(mockManager.makeStringHttpRequest()).thenReturn("");
//    }
}
