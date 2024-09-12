package utils;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "UpdateBooking")
	public Object[][] updateBooking(){
		return new Object[][] {
			{"Benhur","Kachhap"}
		};
	}

}
