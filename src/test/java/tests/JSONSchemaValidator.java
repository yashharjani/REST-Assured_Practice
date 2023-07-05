package tests;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.core.IsEqual.*;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JSONSchemaValidator {
	
	@Test
	public void testGET() {
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
			statusCode(200).log().all();
	}
}
