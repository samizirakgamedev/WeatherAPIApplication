package com.steelswans.framework.userstories;

import com.steelswans.dto.*;
import com.steelswans.framework.APIKeyFileReader;
import com.steelswans.framework.ConnectionManager;
import com.steelswans.framework.Injector;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;

import java.io.FileReader;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Objects;

public class InjectorStepdefs {

    private static ConnectionManager cm;
    private static JSONObject jsonObject;
    private static Injector injectorHTTP = new Injector();
    private static Injector injectorJsonResponse = new Injector();
    private static HttpResponse response;
    private static JSONObject jsonObjectParse;
    private Clouds clouds = new Clouds();
    private Coord coord = new Coord();
    private Main main = new Main();
    private Sys sys = new Sys();
    private Weather weather = new Weather();
    private Wind wind = new Wind();
    private Snow snow = new Snow();
    private Rain rain = new Rain();

    @Given("I have a valid HTTP response")
    public void iHaveAValidHTTPResponse() {
        cm = ConnectionManager.getConnection("https://api.openweathermap.org/data/2.5/weather?q=",
                "London", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
    }

    @When("I call getJSONResponse")
    public void iCallGetJSONResponse() {
        response = Objects.requireNonNull(cm.getHttpResponse(cm.makeHttpRequest()));
    }

    @Then("I get a valid json Object")
    public void iGetAValidJsonObject() {
        jsonObject = injectorHTTP.getJSONResponse(response);
    }


    @Given("I have valid injector")
    public void iHaveValidInjector() {
        Assertions.assertNotNull(injectorJsonResponse);
    }

    @And("I have valid JSON response object")
    public void iHaveValidJSONResponseObject() {
        JSONParser parser = new JSONParser();
        try {
            jsonObjectParse = (JSONObject) parser.parse(new FileReader("response.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    @And("I have a new valid Clouds, Coord, Main, Sys, Weather, Win, Snow, Rain instances")
    public void iHaveAValidCloudsCoordMainSysWeatherWinSnowRainInstances() {
        Assertions.assertNotNull(clouds);
        Assertions.assertNotNull(coord);
        Assertions.assertNotNull(main);
        Assertions.assertNotNull(sys);
        Assertions.assertNotNull(weather);
        Assertions.assertNotNull(wind);
        Assertions.assertNotNull(snow);
        Assertions.assertNotNull(rain);
    }

    @When("I call injectIntoDTO")
    public void iCallInjectIntoDTO() {
        injectorJsonResponse.injectIntoDTO(jsonObjectParse, clouds, coord, main, sys, weather, wind, snow, rain);
    }

    @Then("All values from the JSON response object are assigned to their classes")
    public void allValuesFromTheJSONResponseObjectAreAssignedToTheirClases() {
        Assertions.assertEquals(75, clouds.getAll());

        Assertions.assertEquals(-0.1257, coord.getLon());
        Assertions.assertEquals(51.5085, coord.getLat());

        Assertions.assertEquals(0, rain.getRain1h());
        Assertions.assertEquals(0, rain.getRain3h());

        Assertions.assertEquals(0, snow.getSnow1h());
        Assertions.assertEquals(0, snow.getSnow3h());

        Assertions.assertEquals(2019646, sys.getId());
        Assertions.assertEquals(2, sys.getType());
        Assertions.assertEquals("GB", sys.getCountry());
        Assertions.assertEquals(1645772087, sys.getSunrise());
        Assertions.assertEquals(1645810365, sys.getSunset());

        Assertions.assertEquals( 290, wind.getDeg());
        Assertions.assertEquals( 7.2, wind.getSpeed());

        Assertions.assertEquals(1645794949, weather.getDt());
        Assertions.assertEquals(0, weather.getTimezone());
        Assertions.assertEquals("London", weather.getName());
        Assertions.assertEquals(200, weather.getCod());
        Assertions.assertEquals(10000, weather.getVisibility());
        Assertions.assertEquals("stations", weather.getBase());
        Assertions.assertEquals(2643743, weather.getId());

        Assertions.assertEquals(281.89, main.getFeelsLike());
        Assertions.assertEquals(0, main.getGrnd_level());
        Assertions.assertEquals(54, main.getHumidity());
        Assertions.assertEquals(1028, main.getPressure());
        Assertions.assertEquals(283.4, main.getTemp());
        Assertions.assertEquals(0, main.getSea_level());
        Assertions.assertEquals(285.03, main.getTempMax());
        Assertions.assertEquals(282.09, main.getTempMin());
    }
}