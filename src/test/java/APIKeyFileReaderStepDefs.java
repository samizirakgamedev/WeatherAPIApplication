import com.steelswans.APIKeyFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class APIKeyFileReaderStepDefs {
    private String filePath;
    private static String APIKFR;


    @Given("I have a file path of type {string}")
    public void iHaveAFilePathOfTypeString(String filePath) {
        this.filePath = filePath;
    }

    @When("I call readAPIKeyFile method in APIKeyFileReader")
    public void iCallReadAPIKeyFileMethodInAPIKeyFileReader() {
        APIKFR = APIKeyFileReader.readAPIKeyFile(filePath);
    }

    @Then("readAPIKeyFile return the API Key as a String type value")
    public void readAPIKeyfileReturnTheAPIKeyAsAStringTypeValue() {
        Assertions.assertEquals(APIKFR, APIKeyFileReader.readAPIKeyFile("apikey.txt"));
    }
}
