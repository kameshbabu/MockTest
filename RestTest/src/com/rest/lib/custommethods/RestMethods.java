package com.rest.lib.custommethods;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.rest.igtest.resources.ResourcesGET;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

/**
 * RestMethods class contains of all Rest request/responses using Rest-Assured tool,
 *
 * @version 1.0.1-Beta
 * 
 * @author kamesh babu
 */

public class RestMethods {
	private static final Logger log = LogManager.getLogger(RestMethods.class);
	
	/**
	 * getMockTest() returns response mock details for test purpose.
	 * 
	 * @param authType Enum param of authorization type parameter basic or OAuth2.
	 */
	public static Response getMockTest() {
		log.info("getMockTest");
		Response response = 
			RestAssured.
			given()
	            .log().all()
	            .expect().defaultParser(Parser.JSON).
	        when()
	            .get(ResourcesGET.mockTest_GET()).
	        then()
	        	.log().all().
	        extract()
	          	.response();
		
		return response;
	}
}