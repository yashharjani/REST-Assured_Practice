package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;

public class TestExamples {
	
	@Test
	public void test_1() {
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getBody().asString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test
	public void test_2() {
		baseURI = "https://reqres.in/api";
		basePath = "/users?page=2";
		given().
			get(basePath).
		then().
			statusCode(200).
			log().all();
	}
}
