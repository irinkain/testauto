import Data.Constants;
import Steps.Quiz2Steps;
import io.restassured.response.Response;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Quiz2Tests {
    Quiz2Steps steps = new Quiz2Steps();

    @Test(priority = 1)
    public void emptyPassword(){
        Response response = steps.sendRequest(steps.jsonBody("irina",""));
        Assert.assertEquals(response.statusCode(),400);
        Assert.assertEquals(response.jsonPath().getString("message"),Constants.message);
    }

    @Test(priority = 2)
    public void emptyUsername(){
        Response response = steps.sendRequest(steps.jsonBody("","123"));
        Assert.assertEquals(response.statusCode(),400);
        Assert.assertEquals(response.jsonPath().getString("message"),Constants.message);
    }

    @Test(priority = 3)
    public void correctBoth(){
        String randomUsername = RandomStringUtils.randomAlphabetic(7);
        Response response = steps.sendRequest(steps.jsonBody(randomUsername,Constants.correctPassword));
        Assert.assertEquals(response.statusCode(),201);
        Assert.assertNotNull(response.jsonPath().getString(Constants.userIdResponse));
        Assert.assertEquals(response.jsonPath().getString("username"),randomUsername);
    }
}
