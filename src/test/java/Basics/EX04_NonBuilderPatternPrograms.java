package Basics;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class EX04_NonBuilderPatternPrograms {


    @Description("Verify the GET request positive")
    @Test
    public void test_Non_BDD_GET(){
        RequestSpecification reqsp;
        Response resp;
        ValidatableResponse valresp;

        reqsp = RestAssured.given();
        reqsp.baseUri("https://restful-booker.herokuapp.com/");
        reqsp.basePath("booking");

        resp = reqsp.when().log().all().get();

        valresp = resp.then().log().all().statusCode(200);

    }
}
