package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenericUtil {
	
	
	public static String getCurrentFormattedDate() {
		Date date = new Date();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy-HH_mm_ss");
		String formattedDate = dateFormat.format(date);
		return formattedDate;
		
		
	}

}
