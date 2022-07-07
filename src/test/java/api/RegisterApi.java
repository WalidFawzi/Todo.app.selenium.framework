package api;

import io.restassured.http.Cookies;
import io.restassured.response.Response;
import objects.User;
import utils.ConfigUtils;
import utils.UserUtils;

import static config.EndPoint.API_REGISTER_ENDPOINT;
import static io.restassured.RestAssured.given;

public class RegisterApi {
    private Cookies restAssuredCookies;
    private String accessToken;
    private String userId;
    private String firstName;

    public String getUserId() {
        return this.userId;
    }

    public String getFirstName() {
        return this.firstName;
    }


    public Cookies getRestAssuredCookies() {
        return this.restAssuredCookies;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    // Register method for making the API Request
    public void register (){

        User user =  UserUtils.generateRandomUser();

        Response response =
                given()
                    .baseUri(ConfigUtils.getInstance().getBaseUrl())
                    .header("Content-Type","application/json")
                    .body(user)
                    .log().all()
                .when()
                    .post(API_REGISTER_ENDPOINT)
                .then()
                     .log().all()
                     .extract().response();

        if(response.statusCode()!=201){
            throw  new RuntimeException("Something went wrong in the request");
        }

        restAssuredCookies = response.detailedCookies();
        accessToken = response.path("access-token");
        userId = response.path("userID");
        firstName = response.path("firstName");
    }
}
