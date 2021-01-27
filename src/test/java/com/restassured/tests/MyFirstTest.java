package com.restassured.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.restassured.base.BaseTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class MyFirstTest extends BaseTest {
	
	//@Disabled is used to disable the test execution for the annotated test 
	//@Disabled
	@DisplayName("Getting all the students from the DB")
	@Test
	public void  getAllStudentNamesFromDB() {
		
		// 3 ways we can write code for API Testing
		//1st Way
		RequestSpecification requestSpecification = RestAssured.given();
		Response response = requestSpecification.get("/list");
		response.prettyPrint();
		response.getStatusCode();
		response.statusCode();
		ValidatableResponse validatableResponse = response.then();	
		validatableResponse.statusCode(200);
		
		//2nd Way
//		RestAssured.given().
//		when().get("/list").
//		then().
//		statusCode(200);
	
		
		//3rd Way
//		RestAssured.given().
//		expect().
//		statusCode(200).
//		when().
//		get("/list");
		
		//After doing static import of RestAssured
//			given().
//			when().
//			get("/list").
//			then().
//			statusCode(403);
		
	}
	
	@Disabled
	@DisplayName("Get a single student from CS branch")
	@Test
	public void getSingleStudentFromCS() {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("programme","Computer Science");
		params.put("limit", 1);
		
		//1st way
		Response response = 
				given().
				queryParam("programme","Computer Science").
				queryParam("limit", 1).
				when().
				get("/list");
		response.prettyPrint();
		
//		//2nd way
				given().
				queryParams("programme","Computer Science","limit", 1).
				when().
				get("/list");
		response.prettyPrint();
		
		//3rd way
		given().
		queryParams(params).
		when().
		get("/list");
		response.prettyPrint();
		
	}
	
	@Disabled
	@DisplayName("Get any student by passing path param")
	@Test
	public void getAnyStudentDetails() {
		
		Response response = 
				given().
				pathParams("id",1).
				when().
				get("/{id}");
		response.prettyPrint();
	}

}
