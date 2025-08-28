package Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssured_TestNG_Assertions {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;


    @Test
    public void test_POST() {

        String payload_POST = "{\n" +
                "    \"firstname\" : \"Kshitij\",\n" +
                "    \"lastname\" : \"Ganare\",\n" +
                "    \"totalprice\" : 10000,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_POST).log().all();

        Response response = requestSpecification.when().post();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();

        // Rest Assured.
        validatableResponse.statusCode(200);        // This is restassured inbuilt assertion


        // USING TESTNG ASSERTION
        bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");

        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstname, "Kshitij");
        Assert.assertEquals(lastname, "Ganare");

    }

}

/*
Logic: Extract first data from response using inbuilt function


*/