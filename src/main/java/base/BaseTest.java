package base;

import java.util.Map;

import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import specs.RequestSpec;
import static io.restassured.RestAssured.*;

public class BaseTest {
	static RequestSpecification requestSpec;

	@BeforeClass
	public void setup() {
		System.out.println("********** Running Setp ************");
		requestSpec = RequestSpec.spec();
	}
	
	
	public static Response sendRequest(String method,
							String endpoint,
							Object body,
							Map<String,Object> headers,
							Map<String,Object> query,
							String token) {
		
		RequestSpecification req= given().spec(requestSpec);
		
		if(headers!=null) {
			req.headers(headers);
		}
		
		if(query!=null) {
			req.queryParams(query);
		}
		
		if(body!=null) {
			req.body(body);
		}
		
		if(token!=null) {
			req.auth().preemptive().oauth2(token);
		}
		
		switch(method.toUpperCase()) {
		case "GET":return req.when().get(endpoint);
				   
		case "POST":return req.when().post(endpoint);
					
		case "PUT": return req.when().put(endpoint);
					
		case "PATCH": return req.when().patch(endpoint);
						
		case "DELETE": return req.when().delete(endpoint);
		          
		 default: throw new IllegalArgumentException("Please use valid rest methods");
		}
		
		
	}
	
	public Response sendRequest(String method,
			String endpoint,
			Object body) {
		
		return sendRequest(method, endpoint, body, null, null,null);
	
	}
	
	public Response sendRequest(String method,
			String endpoint,
			Object payload,Map<String,Object> headers) {
		
		return sendRequest(method, endpoint, payload, headers, null,null);
	
	}
	
	public Response sendRequest(String method,
			String endpoint,
			Object body,Map<String,Object> headers,
			Map<String,Object> query) {
		
		return sendRequest(method, endpoint, body, headers, query,null);
	
	}
	
	public Response sendDeleteRequest(String method,
			String endpoint,Map<String,Object> headers) {
		
		return sendRequest(method, endpoint, null, headers, null,null);
	}
	
	public Response sendPartialUpdateRequest(String method,
			String endpoint,Object body,Map<String,Object> headers) {
		
		return sendRequest(method, endpoint, body, headers, null,null);
	}
	
	
}
