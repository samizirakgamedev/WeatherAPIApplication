package com.steelswans.framework.userstories;

import com.steelswans.framework.APIKeyFileReader;
import com.steelswans.framework.ConnectionManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConnectionManagerStepdefs {

    private static ConnectionManager cm;
    private HttpRequest request;
    private HttpResponse response;
    private String requestString;
    private String responseString;
    private String baseUrl;
    private String city;
    private String apikey;
    private String constructedUrl;

    @Given("I have a {string}, a {string} and a api Key")
    public void iHaveAnBaseurlAndCity(String baseUrl, String city) {
        this.baseUrl = baseUrl;
        this.city = city;
        this.apikey = APIKeyFileReader.readAPIKeyFile("invalidapikey.txt");
    }

    @When("I call getConnection")
    public void iCallGetConnection() {
        cm = new ConnectionManager(baseUrl, city, apikey);
    }

    @Then("the result should be {string}")
    public void theResultShouldBeResult(String result) {
        Assertions.assertEquals(result, cm.constructedUrl);
    }

    @When("I call makeStringHttpRequest")
    public void iCallMakeStringHttpRequest() {
        requestString = cm.returnStringHttpRequest();
    }

    @Then("I received a request status")
    public void iReceivedAValidRequestStatus() {
        Assertions.assertEquals("https://api.openweathermap.org/data/2.5/weather?q=London&appid=111111111dddddddd GET", requestString);
    }


    @Given("I have a valid HTTP request")
    public void iHaveAValidHTTPRequest() {
        request = cm.returnHttpRequest();
    }

    @When("I call getStringHttpResponse")
    public void iCallGetStringHttpResponse() {
        responseString = cm.returnStringHttpResponse(request);
    }

    @Then("I received a response")
    public void iReceivedAValidResponse() {
        Assertions.assertEquals("{\"cod\":401, \"message\": \"Invalid API key. Please see http://openweathermap.org/faq#error401 for more info.\"}", responseString);
    }


    @Given("I have a {string}, a {string} and a {string}")
    public void iHaveABaseURLACityAndAAPIKey(String baseUrl, String city, String apikey) {
        this.baseUrl = baseUrl;
        this.city = city.replace(' ', '+');
        this.apikey = APIKeyFileReader.readAPIKeyFile(apikey);
    }

    @When("I call makeHttpRequest")
    public void iCallMakeHttpRequest() {
        this.constructedUrl = this.baseUrl + this.city + "&appid=" + this.apikey;
        request = cm.returnHttpRequest();
    }

    @When("I call getHttpResponse")
    public void iCallGetHttpResponse() {
        if (this.city.equals("Manila")) {
            for (int i = 0; i < 60; i++) {
                ConnectionManager cmerror = new ConnectionManager(baseUrl, city, apikey);
                HttpRequest request = cmerror.returnHttpRequest();
                response = cmerror.returnHttpResponse(request);
            }
        } else {
            response = cm.returnHttpResponse(request);
        }

    }

    @Then("I get {int}")
    public void iGetADifferentHTTPStatusResponse(int status) {
        Assertions.assertEquals(status, response.statusCode());
    }
}
