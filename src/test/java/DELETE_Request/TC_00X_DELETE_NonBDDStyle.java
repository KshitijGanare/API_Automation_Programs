package DELETE_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TC_00X_DELETE_NonBDDStyle {


    RequestSpecification request;
    Response response;
    ValidatableResponse validate;

    @Description("verify DELETE request")
    @Test
    public void test_DELETE_NonBDDStyle_UpdateBooking(){

        String bookingId = "1";
        String token = "8eec8a403663b35";

        request = RestAssured.given();
        request.baseUri("https://restful-booker.herokuapp.com");
        request.basePath("/booking/"+bookingId);
//        request.contentType(ContentType.JSON);
        request.cookie("token",token);

        response = request.when().log().all().delete();

        validate = response.then().log().all().statusCode(200);


    }

}
