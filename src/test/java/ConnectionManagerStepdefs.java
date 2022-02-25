
import com.steelswans.ConnectionManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class ConnectionManagerStepdefs {

    private static ConnectionManager cm;
    private String baseUrl;
    private String city;
    private String apiKey;

    @Given("I have a {string}, a {string} and a {string}")
    public void iAnAAndA(String baseUrl, String city, String APIkey) {
        this.baseUrl = baseUrl;
        this.city = city;
        this.apiKey = APIkey;
    }

    @When("I call getConnection")
    public void iCallGetConnection() {
        cm = ConnectionManager.getConnection(baseUrl, city, apiKey);
    }

    @Then("the result should be <result>")
    public void theResultShouldBeResult() {
        Assertions.assertEquals(cm.constructedUrl, "https://api.openweathermap.org/data/2.5/weather?q=London&appid=c9aac92dbdefed0aa8e5e6d7a8c852cd");
    }
}
