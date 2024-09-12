package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class BookingAPIs {
	

	
	//calling test method without base class setup
	@Test
	public void createBooking() {
		RestAssured.baseURI="https://restful-booker.herokuapp.com/booking";
		Response res = given().header("content-Type", "application/json").
		body("{\n"
				+ "    \"firstname\" : \"Jim\",\n"
				+ "    \"lastname\" : \"Brown\",\n"
				+ "    \"totalprice\" : 111,\n"
				+ "    \"depositpaid\" : true,\n"
				+ "    \"bookingdates\" : {\n"
				+ "        \"checkin\" : \"2018-01-01\",\n"
				+ "        \"checkout\" : \"2019-01-01\"\n"
				+ "    },\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\n"
				+ "}").post();
		
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(), 200);
		
		
	}
	
	
}
