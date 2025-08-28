package payload_management.gson;


import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import payload_management.ai_03.Booking;
import payload_management.ai_03.Bookingdates;

import static org.assertj.core.api.Assertions.*;

import static org.assertj.core.api.Assertions.*;

public class Restassured_Gson {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;

    @Test
    public void test_Create_Booking_Positive() {

        // Step 1: Set all booking values, class values
        Booking booking = new Booking();
        booking.setFirstname("Virat");
        booking.setLastname("Kohli");
        booking.setTotalprice(99999);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Dinner");

        // Step 2: Set all booking dates, or subclass values
        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");

        // Step 3: Set subclass value into mainclass
        booking.setBookingdates(bookingdates);

                                        //  PAYLOAD IS SET /////

        System.out.println(booking);   // It will print java object reference


        // Step 4: Java Object -> JSON
        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);

        System.out.println(jsonStringBooking);


        // Step 5:
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonStringBooking).log().all(); // add here json string

        Response response = requestSpecification.when().post();
        String jsonResponseString = response.asString(); // Convert Json response to string and store it in variable

        System.out.println("XXX"+jsonResponseString);

        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


        // Case 1: extract(): Direct Extraction
        String firstname = response.then().extract().path("booking.firstname");
        Assert.assertEquals(firstname, "Virat");




    }

}

/*
- Postman se response uthaya nd usse BookingResponse class banaya
- Fir response ko map kiya is BookingResponse class se and ek variable me store kiya BookingResponse class type ke
- ab isme saari keys aa gayi and isse kuch bhi key nikal sakte and verify kar sakte directly
-


*/