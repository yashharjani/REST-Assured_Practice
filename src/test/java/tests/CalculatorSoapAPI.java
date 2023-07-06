package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import org.apache.commons.io.IOUtils;

public class CalculatorSoapAPI {
	
	@Test
	public void AddSoapAPI() throws IOException {
		
		System.out.println("\nThis is the ADD API response");
		
		File file = new File("./SoapRequest/Add.xml");
		
		if(file.exists())
			System.out.println("	>> File Exists");
		
		FileInputStream fileInputStream = new FileInputStream(file);
		
		String requestBody = IOUtils.toString(fileInputStream,"UTF-8");
		
		baseURI ="http://www.dneonline.com";
		
// Validate the XML response METHOD-1
		 given().
			header("Content-Type","text/xml").
			body(requestBody).
		when().
			post("/calculator.asmx").
		then().
			statusCode(200).
		and().
		 	body("//*:AddResult.text()",equalTo("5")).
		 	log().all();
		
// Validate the XML response METHOD-2
		Response response2 = given().
				header("Content-Type","text/xml").
				body(requestBody).
			when().
				post("/calculator.asmx");
		
		 int statusCode = response2.statusCode();
		 assertEquals(200, statusCode);
		 System.out.println("\n\nStatus code: " +statusCode);
		 String addResult = response2.xmlPath().
	                getString("Envelope.Body.AddResponse.AddResult");
		 System.out.println("AddResult: " + addResult);
		 assertEquals(String.valueOf(5), addResult);
	}
	
	@Test
	public void SubtractSoapAPI() throws IOException {
		
		System.out.println("\n\nThis is the SUBTRACT API response");
		
		File file = new File("./SoapRequest/Subtract.xml");
		
		if(file.exists())
			System.out.println("	>> File Exists");
		
		FileInputStream fileInputStream = new FileInputStream(file);
		
		String requestBody = IOUtils.toString(fileInputStream,"UTF-8");
		
		baseURI ="http://www.dneonline.com";
		
// Validate the XML response METHOD-1
		 given().
			header("Content-Type","text/xml").
			body(requestBody).
		when().
			post("/calculator.asmx").
		then().
			statusCode(200).
		and().
		 	body("//*:SubtractResult.text()",equalTo("8")).
		 	log().all();
		
// Validate the XML response METHOD-2
		 Response response = given().
				 	header("Content-Type","text/xml").
					body(requestBody).
				when().
					post("/calculator.asmx");
		 
		 String subtractResult = response.xmlPath().
	                getString("Envelope.Body.SubtractResponse.SubtractResult");
		 System.out.println("\n\nSubtractResult: " + subtractResult);
		 assertEquals(String.valueOf(8), subtractResult);
	}
	
}