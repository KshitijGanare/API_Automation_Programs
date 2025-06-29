package PATCH_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TC_001_PATCH_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description("Verify PATCH request for restful booker API")
    @Test
    public void test_PUT_NonBDDStyle_UpdateBooking() {

        String id = "2592";
        String token = "971df13343c591f";

        String payload = "{\n" +
                "    \"firstname\": \"Partial\",\n" +
                "    \"lastname\": \"Update\",\n" +
                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + id);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(payload).log().all();


        response = r.when().log().all().patch();

        vr = response.then().log().all().statusCode(200);

    }
}
