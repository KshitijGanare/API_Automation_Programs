package PUT_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TC_001_PUT_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description("Verify PUT request for restful booker API")
    @Test
    public void test_PUT_NonBDDStyle_UpdateBooking() {

        String id = "2592";
        String token = "691fd9596bef709";

        String payload = "{\n" +
                "    \"firstname\": \"Gangadhar\",\n" +
                "    \"lastname\": \"Update\",\n" +
                "    \"totalprice\": 9999,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2025-06-22\",\n" +
                "        \"checkout\": \"2025-06-22\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + id);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(payload).log().all();


        response = r.when().log().all().put();

        vr = response.then().log().all().statusCode(200);

    }
}
