package POST_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TC_001_POST_NonBDDStyle {

    RequestSpecification rs;
    Response response;
    ValidatableResponse vr;

    @Description("Verify POST request Non BDD Style")
    @Test
    public void test_POST_NonBDDStyle_Create_Token() {

        String payload = "{\n" +
                "  \"username\": \"admin\",\n" +
                "  \"password\": \"password123\"\n" +
                "}";

        // Step 1: Preparing Request
        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/auth");
        rs.contentType(ContentType.JSON);
        rs.body(payload).log().all();


        // Step 2: Making HTTP request
        response = rs.when().log().all().post();


        // Step 3: Verification Part
        vr = response.then().log().all().statusCode(200);

    }

}
