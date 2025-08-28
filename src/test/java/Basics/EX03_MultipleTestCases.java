package Basics;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class EX03_MultipleTestCases {
    public static void main(String[] args) {

        String pincode = "110002";
        RestAssured
                .given()
                  .baseUri("https://api.zippopotam.us")
                  .basePath("/IN/"+ pincode)
                .when()
                  .get()
                .then()
                .log().all().statusCode(200);


        pincode = "0";
          RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+ pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);


          pincode = "abcd";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+ pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);

        // Jab class run karenge toh saare hi chalenge

    }
}
