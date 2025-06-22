package Basics;

import io.restassured.RestAssured;

import java.util.Scanner;

public class Ex01_BasicApiProgram {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter postal code: ");
        int postalCode = scan.nextInt();

        RestAssured
                .given()
                  .baseUri("https://api.zippopotam.us/")
                  .basePath("IN/" + postalCode)
                .when()
                  .get()
                .then()
                .log().all().statusCode(300);
    }
}
