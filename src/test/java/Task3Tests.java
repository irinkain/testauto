import Data.Constants;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Task3Tests {
    @Test
    public void getResponseStatus(){
        Response response =
                given()
                        .when()
                        .get(Constants.apiUrl);
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.jsonPath().getString("books[-1].isbn"),Constants.lastIsbn);
        Assert.assertEquals(response.jsonPath().getString("books[0].pages"),"234");
        Assert.assertEquals(response.jsonPath().getString("books[1].pages"),"254");
    }
}
