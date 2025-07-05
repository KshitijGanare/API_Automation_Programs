package PATCH_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TC_002_PATCH_Req_Explanation {

    RequestSpecification rspec;    // Interface iska object nahi banta
    Response res;                  // Interface
    ValidatableResponse vres;


    @Test
    @Description("Verify PATCH request")
    public void PATCH_Req_Explanation(){

        int booking_id = 479;
        String body = "{\n" +
                "    \"firstname\": \"Narendra\",\n" +
                "    \"lastname\": \"Gandhi\"\n" +
                "}";
        String token = "f29140a574aaf5e";


        rspec = RestAssured.given();
        rspec.baseUri("https://restful-booker.herokuapp.com");
        rspec.basePath("/booking/" + booking_id);
        rspec.body(body);
        rspec.cookie("token",token);
        rspec.contentType(ContentType.JSON);

        res = rspec.when().patch();

        vres = res.then().log().all().statusCode(200);


    }

}
