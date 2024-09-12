package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpec {
	
	public static ResponseSpecification responseSpec() {
		ResponseSpecification res = new ResponseSpecBuilder().
				expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		return res;
	}

}
