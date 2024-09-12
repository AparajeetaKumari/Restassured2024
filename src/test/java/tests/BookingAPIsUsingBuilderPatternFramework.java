package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;
import model.Booking;
import model.BookingDates;
import specs.ResponseSpec;
import utils.JsonUtils;

public class BookingAPIsUsingBuilderPatternFramework extends BaseTest {
	
	@Test
	public void createBooking() {

		BookingDates bookingdates = new BookingDates("2024-09-12","2024-09-17");
		Booking bookingRequest = Booking.builder()
				.firstname("Aiden").lastname("Kachhap").totalprice(2000).depositpaid(true).bookingdates(bookingdates).additionalneeds("Need non-veg meal").build();		
		Map<String,Object> headers = new HashMap();
		headers.put("content-Type", "application/json");
		Response res = sendRequest("Post", "/booking", bookingRequest,headers);
		res.then().spec(ResponseSpec.responseSpec());
		res.prettyPrint();
		System.out.println("Response code is "+ res.getStatusCode());
		
		String firstName = JsonUtils.getString(res, "booking.firstname");
		Assert.assertEquals(firstName, bookingRequest.getFirstname());
	}

}
