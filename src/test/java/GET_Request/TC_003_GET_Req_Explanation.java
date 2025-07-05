package GET_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TC_003_GET_Req_Explanation {

    RequestSpecification rspec;    // Interface iska object nahi banta
    Response res;                  // Interface
    ValidatableResponse vres;      // Interface


    @Test
    @Description("Verify the GET request with Indian pincode")
    public void test_GET_Positive(){
        int pincode = 110001;

        rspec = RestAssured.given();  // return RequestSpecification object
        rspec.baseUri("https://api.zippopotam.us/");
        rspec.basePath("/IN/" + pincode);

        res = rspec.get();

        vres = res.then().log().all().statusCode(200);

    }

}


/*
      Step 1
/ RestAssured class me given() hai jo RequestSpecification object ko return karta hai via this
/ fir rspec ko obj assign ho gaya RequestSpecification ka
  fir RequestSpecification ke methods use karenge

      Step 2
/ Use Response object,
  Response variable me rspec.method() lagana bas     [ 1 line step ]
  fir isme response interface ka object aa jayega

      Step 3
/ Use Validatable response,
   variable me


 */
