package tests;

import org.json.simple.JSONObject;

//import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
//import io.restassured.response.Response;
//import static io.restassured.matcher.RestAssuredMatchers.*;

//import static org.hamcrest.Matcher.*;
import static org.hamcrest.core.IsEqual.*;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class GetAndPostExamples {
	
//	@Test
	public void testGET() {
		baseURI = "https://reqres.in/api";
		basePath = "/users?page=2";
		given().get(basePath).then().statusCode(200).body("data[4].first_name",equalTo("George"));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	private void testPOST() {
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "Yash");
//		map.put("job", "AutomationTester");
		
//		System.out.println(map); //This will not print or send the same syntax as of JSON request body. 
		//And to solve this, we use JSONObject class.
//		JSONObject request = new JSONObject(map);
		
		JSONObject request = new JSONObject();
		request.put("name", "Yash");
		request.put("job", "AutomationTester");
		System.out.println(request);
		System.out.println(request.toJSONString());		
		
		baseURI = "https://reqres.in/api";
		basePath = "/users";
		
		given().
			header("Content-Type","application/json").
			body(request.toJSONString()).
		when().
			post(basePath).
		then().
			statusCode(201);
		
	}
}
