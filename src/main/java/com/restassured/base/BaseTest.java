package com.restassured.base;

import io.restassured.RestAssured;

public class BaseTest {
	
	public void insit() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8085;
		RestAssured.basePath = "/student";
	}
}
