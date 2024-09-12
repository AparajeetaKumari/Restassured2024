package specs;

import config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
	
	public static RequestSpecification spec() {
		return new RequestSpecBuilder()
		.setBaseUri(ConfigReader.readConfigs("baseURL"))
		.setContentType(ContentType.JSON).build();
	}

}
