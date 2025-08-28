package Master;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class EX02_NonBDDProgram_POSTRequest {

    @Description("Verify the POST request by sending correct Data")
    @Test
    public void test_Non_BDD_GET() {

        RequestSpecification reqsp;
        Response resp;
        ValidatableResponse valresp;

        String bodyPayload = "{\n" +
                "    \"firstname\" : \"Ricky\",\n" +
                "    \"lastname\" : \"One\",\n" +
                "    \"totalprice\" : 100000,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2025-01-01\",\n" +
                "        \"checkout\" : \"2025-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        reqsp = RestAssured.given();
        reqsp.baseUri("https://restful-booker.herokuapp.com");
        reqsp.basePath("/booking");
        reqsp.contentType(ContentType.JSON);
        reqsp.body(bodyPayload);

        resp = reqsp.when().log().all().post();

        valresp = resp.then().statusCode(200);

        // By hamcrest matcher
        valresp.body("booking.firstname",equalTo("Ricky"));

        // By Assert
        String firstname = resp.jsonPath().get("booking.firstname");
        Assert.assertTrue(firstname.equals("Ricky"));

    }

}
