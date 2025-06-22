package GET_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TC_002_GET_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description("Verify the GET request positive")
    @Test
    public void test_Non_BDD_GET() {
        String pincode = "110002";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(200);
    }

    @Description("Verify the GET request with negative value -1")
    @Test
    public void test_NonBDD_Get_Negative(){

        String pincode = "-1";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(200);

    }
}
