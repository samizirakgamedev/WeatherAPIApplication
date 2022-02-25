package com.steelswans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


public class ConnectionManagerMockitoTest {
    @Mock
    private static String mockUrl;
    private static String mockCity;
    private static String mockApiKey;
    @Mock
    private static ConnectionManager mock;
    String fakeApiKey = "12345";

    @BeforeEach
    public void setUp(){
        mockUrl = "https://api.openweathermap.org/data/2.5/weather?q=";
        mockCity = "Leicester";
        mockApiKey = APIKeyFileReader.readAPIKeyFile("apikey.txt");
        mock = ConnectionManager.getConnection(mockUrl, mockCity, fakeApiKey);
    }

    @Test
    public void testConnectionManagerInstance(){
//        Assertions.assertNotNull(mock);
        String fakeApiKey = "12345";
        ConnectionManager fake = Mockito.mock(mock.getClass());
        Mockito.when(fake.constructedUrl).thenReturn("https://api.openweathermap.org/data/2.5/weather?q=Leicester&appid=12345");
        Assertions.assertEquals("https://api.openweathermap.org/data/2.5/weather?q=Leicester&appid=12345",
                fake.constructedUrl);
    }

    @Test
    public void testMakeHttpRequest(){
        Assertions.assertNotNull(mock.makeHttpRequest());
    }

    @Test
    public void testGetHttpResponse(){
        Assertions.assertNotNull(mock.getHttpResponse(mock.makeHttpRequest()));
    }
}
