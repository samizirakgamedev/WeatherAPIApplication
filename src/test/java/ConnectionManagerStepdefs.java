
import com.steelswans.APIKeyFileReader;
import com.steelswans.ConnectionManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.net.http.HttpRequest;


public class ConnectionManagerStepdefs {

    private static ConnectionManager cm;
    private HttpRequest request;
    private String baseUrl;
    private String city;

    @Given("I have a {string}, a {string} and a api Key")
    public void iAnAAndA(String baseUrl, String city) {
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

    @Given("I have a valid connetion")
    public void iHaveAValidConnetion() {
        cm = ConnectionManager.getConnection(baseUrl, city, APIKeyFileReader.readAPIKeyFile("validAPIkey.txt"));
    }

    @When("I call makeHttpRequest\\()")
    public void iCallMakeHttpRequest() {
        request = cm.makeHttpRequest();
    }

    @Then("I received a valid request status")
    public void iReceivedAValidRequestStatus() {
//        Assertions.assertInstanceOf();
    }

    @Given("I have a valid HTTP request")
    public void iHaveAValidHTTPRequest() {
    }

    @When("I call getHttpResponse\\()")
    public void iCallGetHttpResponse() {
    }

    @Then("I received a valid response")
    public void iReceivedAValidResponse() {
    }
}
