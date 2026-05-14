package com.gedala.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.gedala.annotations.FrameWorkAnnotation;
import com.gedala.reports.ExtentLogger;
import com.gedala.requestbuilder.RequestBuilder;

import io.restassured.response.Response;

public class GetTest  {

	@FrameWorkAnnotation(author={"vijay","Gedala"},category= {"smoke","sanity"})
	@Test
	public void getEmployeeDetails() {
		Response response = RequestBuilder.buildRequestForGetCalls().get("/employees");

		ExtentLogger.logResponse(response.asPrettyString());

		Assertions.assertThat(response.getStatusCode()).isEqualTo(200);

		Assertions.assertThat(response.jsonPath().getList("$").size()).isPositive().isGreaterThan(100);

	}

	@FrameWorkAnnotation(author={"vijay","Gedala","userTest"},category= {"smoke","regression","sanity"})
	@Test
	public void getEmployeeDetail() {
		Response response = RequestBuilder.buildRequestForGetCalls().pathParam("id", 3).get("/employees/{id}");
	
		ExtentLogger.logResponse(response.asPrettyString());

		Assertions.assertThat(response.getStatusCode()).isEqualTo(200);

		Assertions.assertThat(response.jsonPath().getMap("$").size()).isPositive().isGreaterThan(2);

		Assertions.assertThat(response.jsonPath().getString("firstname")).isEqualTo("Anita").hasSizeBetween(1, 10);

	}

}
