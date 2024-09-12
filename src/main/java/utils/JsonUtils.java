package utils;

import java.util.List;
import java.util.Map;

import io.restassured.response.Response;

public class JsonUtils {
	
	/*
	 * We can different types of responses
	 * String
	 * List
	 * boolean
	 * Integer
	 * Map<String,String>
	 * Map<String, Object?
	 * Object
	 * And many more
	 * 
	 * This util will help us to convert response to a specific type
	 * 
	 */
	
	public static String getString(Response resp, String jsonPath) {
		return resp.jsonPath().getString(jsonPath);
	
	}
	
	public static int getInteger(Response resp, String jsonPath) {
		return resp.jsonPath().getInt(jsonPath);
		
	}
	
	public static boolean getBoolean(Response resp, String jsonPath) {
		return resp.jsonPath().getBoolean(jsonPath);
		
	}
	
	public static <T> List<T> getList(Response resp, String jsonPath) {
		return resp.jsonPath().getList(jsonPath);
	}

	public static <K,V> Map<K,V> getMap(Response resp, String jsonPath) {
		return  resp.jsonPath().getMap(jsonPath);
		
	}
}
