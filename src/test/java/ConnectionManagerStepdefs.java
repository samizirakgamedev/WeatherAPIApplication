
import com.steelswans.APIKeyFileReader;
import com.steelswans.ConnectionManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConnectionManagerStepdefs {

    private static ConnectionManager cm;
    private HttpRequest request;
    private HttpResponse<String> response;
    private String baseUrl;
    private String city;

    @Given("I have a {string}, a {string} and a api Key")
    public void iHaveAnBaseurlAndCity(String baseUrl, String city) {
        this.baseUrl = baseUrl;
        this.city = city;
    }

    @When("I call getConnection")
    public void iCallGetConnection() {
        cm = ConnectionManager.getConnection(baseUrl, city, APIKeyFileReader.readAPIKeyFile("apikey.txt"));
    }

    @Then("the result should be {string}")
    public void theResultShouldBeResult(String result) {
        Assertions.assertEquals(cm.constructedUrl, result);
    }

    @Given("I have a valid connection")
    public void iHaveAValidConnetion() {
        cm = ConnectionManager.getConnection(baseUrl, city, APIKeyFileReader.readAPIKeyFile("apikey.txt"));
    }

    @When("I call makeHttpRequest\\()")
    public void iCallMakeHttpRequest() {
        request = cm.makeHttpRequest();
    }

    @Then("I received a valid request status")
    public void iReceivedAValidRequestStatus() {
        Assertions.assertEquals(request.toString(), "https://api.openweathermap.org/data/2.5/weather?q=London&appid=111111111dddddddd GET");
    }

    @Given("I have a valid HTTP request")
    public void iHaveAValidHTTPRequest() {
        request = cm.makeHttpRequest();
    }

    @When("I call getHttpResponse\\()")
    public void iCallGetHttpResponse() {
        response = cm.getHttpResponse(request);
    }

    @Then("I received a response")
    public void iReceivedAValidResponse() {
        Assertions.assertEquals(response.toString(), "(GET https://api.openweathermap.org/data/2.5/weather?q=London&appid=111111111dddddddd) 401");
    }
}
