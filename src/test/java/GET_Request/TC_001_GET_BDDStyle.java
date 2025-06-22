package GET_Request;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TC_001_GET_BDDStyle {

    @Test
    public void test_BDD_GET() {
        String pincode = "560016";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().log().all().get()   // Gives request headers
                .then().log().all().statusCode(200); // Gives response headers and body
    }
}