package AllureReport_Programs;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.Scanner;

public class AllureReportProgram {

    Scanner scan = new Scanner(System.in);

    @Test
    @Description("TC#1 - Verify that the Indian Valid Pincode gives 200 Ok")
    public void indiaPincode() {
        String pincode = "110002";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);

    }

    @Test
    @Description("TC#2 - Verify that the US Valid Pincode gives 200 Ok")
    public void usPincode() {
        String pincode = "99950";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("US/" + pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);

    }


    @Test
    @Description("TC#3 - Verify that the Invalid Pincode gives 404 Error")
    public void negativePincode() {
        String pincode = "-99950";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(404);

    }


    @Test
    @Description("TC#4 - Verify that the Invalid Pincode gives 404 Error")
    public void specialCharacterPincode() {
        String pincode = "@#$%^&*";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("country/" + pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(404);

    }


    @Test
    @Description("TC#5 - Verify that the Valid Pincode gives 404 Error")
    public void nullPincode() {
        String pincode = null;
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("US/" + pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(404);

    }

    @Test
    @Description("This is all zero pincode")
    public void allZeroPincode() {
        int pincode = 00000;

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("us/" + pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(404);


    }

}
