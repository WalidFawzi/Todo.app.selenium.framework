package api;

import io.restassured.http.Cookies;
import io.restassured.response.Response;
import objects.User;
import utils.UserUtils;

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

    public void register (){

        User user =  UserUtils.generateRandomUser();

        Response response =
                given()
                    .baseUri("https://qacart-todo.herokuapp.com/")
                    .header("Content-Type","application/json")
                    .body(user)
                    .log().all()
                .when()
                    .post("/api/v1/users/register")
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
