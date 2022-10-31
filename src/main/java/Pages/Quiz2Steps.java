package Pages;

import Data.Constants;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Quiz2Steps {
    @Step("Fill data")
    public String jsonBody(String username, String password) {
        return "{\n" +
                "  \"userName\": \"" + username + "\",\n" +
                "  \"password\": \"" + password + "\"\n" +
                "}";
    }

    @Step("Send request and get response")
    public Response sendRequest(String body) {
        return
                given()
                        .when()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(body)
                        .post(Constants.postUrl);
    }
}
