package pojo_Programs_Master.Post_Request_Examples;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo_Programs_Master.pojo_classes.request.Booking;
import pojo_Programs_Master.pojo_classes.request.BookingDates;
import pojo_Programs_Master.pojo_classes.response.BookingResponse;

import static org.hamcrest.Matchers.equalTo;

public class EX_01_PostPrograms {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Description("Verify all the posted field values get posted correctly")
    @Test
    public void verifyFieldValues(){

        // Payload
        Booking booking = new Booking();
        booking.setFirstname("Mike");
        booking.setLastname("Dustin");
        booking.setTotalprice(9999);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Geyser");

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2025-08-27");
        bookingDates.setCheckout("2025-08-29");

        booking.setBookingdates(bookingDates);

        System.out.println(booking+"xxxxxx\n");

        Gson gson = new Gson();
        String bookingJson = gson.toJson(booking);   // <-- JSON string payload    // Serialize
        System.out.println("REQUEST JSON:\n" + bookingJson);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(bookingJson);     // Sent json into payload

        response = requestSpecification.when().post();


        // Deserialization
        String responseJson = response.asString(); // JSON response → converted to String
        System.out.println("RESPONSE JSON:\n" + responseJson);

        BookingResponse bookingResponse = gson.fromJson(responseJson, BookingResponse.class);
        // String → mapped to Java object (gson.fromJson(responseJson, BookingResponse.class)), gson uses setter method to set values in BookingResponse class

        // After deserialization
        if (bookingResponse.getBookingid() != null) {
            System.out.println("bookingid is numeric: " + bookingResponse.getBookingid());
        } else {
            System.out.println("bookingid is not set or not numeric.");
        }

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


        // 7) Assertions (Response vs Request)

        Booking respBooking = bookingResponse.getBooking();

        validatableResponse.body("booking.firstname", equalTo(respBooking.getFirstname()));

        Assert.assertEquals(bookingResponse.getBooking().getFirstname(), booking.getFirstname());
        Assert.assertEquals(respBooking.getLastname(), booking.getLastname());
        Assert.assertEquals(respBooking.getTotalprice(), booking.getTotalprice());
        Assert.assertEquals(respBooking.getDepositpaid(), booking.getDepositpaid());
        Assert.assertEquals(respBooking.getAdditionalneeds(), booking.getAdditionalneeds());

        Assert.assertEquals(respBooking.getBookingdates().getCheckin(), booking.getBookingdates().getCheckin());
        Assert.assertEquals(respBooking.getBookingdates().getCheckout(), booking.getBookingdates().getCheckout());


    }

}

/*

booking --> initialized pojo class (java object)

/ Converting into Json   [ Serialization ]
  Gson gson = new Gson();
  String bookingJson = gson.toJson(booking);   // <-- JSON string payload  // Serialize java object - json
  System.out.println("REQUEST JSON:\n" + bookingJson);

/ Sent into payload
  requestSpecification.body(bookingJson);     // Sent json into payload

--- Response recieved

/ Deserialization
  String responseJson = response.asString(); // JSON response → String
  BookingResponse bookingResponse = gson.fromJson(responseJson, BookingResponse.class); // String --> Java object / Deserialize
   //// gson mapped data into BookingResponse class using setter method internally

  Booking respBooking = bookingResponse.getBooking(); // extracted Booking object from BookingResponse and stored it in Booking object

bookingResponse ==> Contains response data
booking ==> Contains request data

/// Validating them with Assert
Assert.assertEquals(respBooking.actual, booking.repected);




 */




