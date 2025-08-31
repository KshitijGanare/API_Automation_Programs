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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class EX_02_PostPrograms {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Description("Verify datatype of all the posted values")
    @Test
    public void verifyfield_Datatypes(){

        Booking booking = new Booking();
        booking.setFirstname("Vijay");
        booking.setLastname("Chauhan");
        booking.setDepositpaid(true);
        booking.setTotalprice(900);
        booking.setAdditionalneeds("Breakfast");

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2025-08-27");
        bookingdates.setCheckout("2025-08-30");
        booking.setBookingdates(bookingdates);

        requestSpecification = RestAssured.given();
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);

        // Serialize
        Gson gson = new Gson();
        String bookingJson = gson.toJson(booking);

        requestSpecification.body(bookingJson);

        response = requestSpecification.log().all().when().post();

        String responseJson = response.asString();
        BookingResponse bookingResponse = gson.fromJson(responseJson, BookingResponse.class);

        validatableResponse = response.then().log().all();

        Booking responseBooking = bookingResponse.getBooking();

        Assert.assertTrue(responseBooking.getFirstname() instanceof String, "Firstname should be String");
        Assert.assertTrue(responseBooking.getLastname() instanceof String, "Firstname should be String");
        Assert.assertNotNull(responseBooking.getTotalprice());
        Assert.assertNotNull(bookingResponse.getBookingid());

    }
}
