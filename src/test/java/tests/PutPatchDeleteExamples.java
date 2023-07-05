package tests;

import org.json.simple.JSONObject;

//import org.testng.Assert;
import org.testng.annotations.Test;

import groovy.util.logging.Log;

import static io.restassured.RestAssured.*;
//import io.restassured.response.Response;
//import static io.restassured.matcher.RestAssuredMatchers.*;

//import static org.hamcrest.Matcher.*;
//import static org.hamcrest.core.IsEqual.*;
//
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class PutPatchDeleteExamples {
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPUT() {
		
		baseURI = "https://reqres.in/api";
		basePath = "/users/2";
		
		JSONObject request = new JSONObject();
		request.put("name", "Yash");
		request.put("job", "Tester");
		System.out.println("\n\nPUT REQUEST: \n" + request);
		System.out.println("\nRESPONSE:");
		given().
			header("Content-Type","application/json").
			body(request.toJSONString()).
		when().
			put(basePath).
		then().
			statusCode(200).
			log().all();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPATCH() {
		
		baseURI = "https://reqres.in/api";
		basePath = "/users/2";
		
		JSONObject request = new JSONObject();
		request.put("name", "Yash");
		request.put("job", "Tester");
		System.out.println("\n\nPATCH REQUEST: \n" + request);
		System.out.println("\nRESPONSE:");
		given().
			header("Content-Type","application/json").
			body(request.toJSONString()).
		when().
			patch(basePath).
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void testDELETE() {
//		https://reqres.in/api/users/2
		baseURI = "https://reqres.in/api";
		basePath = "/users/2";	
		System.out.println("\n\nDELETE REQUEST:");
		given().
		when().
			delete("https://reqres.in/api/users/2").
		then().
			statusCode(204).
			log().all();
	}
}
