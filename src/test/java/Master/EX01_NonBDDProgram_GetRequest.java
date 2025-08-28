package Master;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class EX01_NonBDDProgram_GetRequest {

    @Description("Verify the GET request positive")
    @Test
    public void test_Non_BDD_GET(){
        RequestSpecification reqsp;  // Declares a variable for RequestSpecification interface
        Response resp; // Declares a variable for the HTTP response
        ValidatableResponse valresp; // Declares a variable for the validatable response

        reqsp = RestAssured.given(); // Initializes the request specification, given() returns RequestSpecification object
        reqsp.baseUri("https://restful-booker.herokuapp.com/"); // Sets the base URI for the request
        reqsp.basePath("booking"); // Sets the base path for the request

        resp = reqsp.when().log().all().get(); // Sends a GET request, logs all details, and stores the response

        valresp = resp.then().log().all().statusCode(200); // Validates the response status code is 200 and logs all details

    }

}
