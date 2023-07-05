package tests;

import org.json.simple.JSONObject;

//import org.json.simple.JSONObject;

//import org.testng.Assert;
import org.testng.annotations.Test;

//import groovy.util.logging.Log;

import static io.restassured.RestAssured.*;
//import io.restassured.response.Response;
//import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matcher.*;
import static org.hamcrest.core.IsEqual.*;

public class LocalAPITest {

	@Test
	public void get() {
		
		baseURI = "http://localhost:3000";
		given().get("/users").then().statusCode(200).log().all();
		
	}
	
	@SuppressWarnings("unchecked")
//	@Test
	public void post() {
		
		baseURI = "http://localhost:3000";
		JSONObject request = new JSONObject();
		request.put("firstName", "Harsha");
		request.put("lastName", "Harjani");
		request.put("subjectId", 2);
		
		given().
			header("Content-Type","application/json").
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			body("firstName",equalTo("Harsha"));
	}
	
	@SuppressWarnings("unchecked")
//	@Test
	public void put() {
		baseURI = "http://localhost:3000";
		JSONObject request = new JSONObject();
		request.put("firstName", "Harsha");
		request.put("lastName", "Harjani");
		request.put("subjectId", 1); //Updating the subjectId from 2 to 1
		
		given().
			header("Content-Type","application/json").
			body(request.toJSONString()).
		when().
			put("/users/3").
		then().
			statusCode(200).
			log().all();
	}
	
//	@Test
	public void delete() {
		baseURI = "http://localhost:3000";
		given().delete("/users/3").then().statusCode(200);
	}
}
