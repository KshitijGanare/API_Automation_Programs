package TestNg_Examples;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class APITesting_003_AssertJ {
    public static void main(String[] args) {

        RequestSpecification requestSpecification;
        ValidatableResponse validatableResponse;
        Response response;

        String token = "7ecea7b05ffaf13";
        String body = "{\n" +
                "    \"firstname\" : \"Gangadhar\",\n" +
                "    \"lastname\" : \"Four\",\n" +
                "    \"totalprice\" : 100000,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2025-01-01\",\n" +
                "        \"checkout\" : \"2025-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
//        requestSpecification.basePath("/booking/" + id);
        requestSpecification.cookie("token", token);
        requestSpecification.body(body).log().all();

        response = requestSpecification.when().post();

        validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);


    }

}
