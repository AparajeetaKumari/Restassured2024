package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;


import base.BaseTest;
import io.restassured.response.Response;
import model.Booking;
import model.BookingDates;
import specs.ResponseSpec;
import utils.DataProviders;
import utils.JsonUtils;

public class BookingAPIsUsingFramework extends BaseTest {
	
	 int bookingId;
	 Booking bookingRequest;
	@Test(priority = 1)
	public void createBooking() {
		
		BookingDates bookingdates = new BookingDates("2024-09-12","2024-09-17");
	     bookingRequest = new Booking("Aparajeeta","Biswas",1000,true,bookingdates,"Need tea and coffee");
				
		Map<String,Object> headers = new HashMap();
		headers.put("content-Type", "application/json");
		Response res = sendRequest("Post", "/booking", bookingRequest,headers);
		res.then().spec(ResponseSpec.responseSpec());
		res.prettyPrint();
		System.out.println("Response code is "+ res.getStatusCode());
		
		String firstName = JsonUtils.getString(res, "booking.firstname");
		Assert.assertEquals(firstName, bookingRequest.getFirstname());
		
		bookingId = JsonUtils.getInteger(res, "bookingid");
		System.out.println("Booking id is::"+bookingId);
	}
	
	@Test(priority = 2,dataProvider = "UpdateBooking",dataProviderClass = DataProviders.class)
	public void updateBooking(String firstName,String lastName) {
		Map<String, Object> headerMap = new HashMap<String, Object>();
		
		headerMap.put("content-Type", "application/json");
		headerMap.put("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=");
		headerMap.put("Accept" ,"application/json");
		System.out.println("First and last name ::"+firstName + " "+lastName);
		bookingRequest.setFirstname(firstName);
		bookingRequest.setLastname(lastName);
		Response res = sendPartialUpdateRequest("put","/booking/"+bookingId,bookingRequest,headerMap);
		System.out.println("Patch response is ::"+res.prettyPrint());
	}
	
	
	@Test(priority = 3)
	public void deleteBooking() {
		Map<String, Object> headerMap = new HashMap<String, Object>();
		
		headerMap.put("content-Type", "application/json");
		headerMap.put("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=");
		Response res = sendDeleteRequest("delete", "/booking/"+bookingId,headerMap);
		
		Assert.assertEquals(201, res.getStatusCode());
		
	}

}
