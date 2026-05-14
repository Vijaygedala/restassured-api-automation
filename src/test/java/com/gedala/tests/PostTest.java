package com.gedala.tests;

import java.lang.reflect.Method;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.gedala.annotations.FrameWorkAnnotation;
import com.gedala.constants.FrameWorkConstants;
import com.gedala.pojo.Employee;
import com.gedala.reports.ExtentLogger;
import com.gedala.requestbuilder.RequestBuilder;
import com.gedala.utils.ApiUtils;
import com.gedala.utils.RandomUtils;

import io.restassured.response.Response;

public class PostTest {

	@FrameWorkAnnotation(author={"vijay","Gedala","user3"},category= {"smoke","regression","sanity"})
	@Test
	public void postTests() {

		Employee employee = Employee.builder().setId(RandomUtils.getId()).setFirstname(RandomUtils.getFirstName())
				.setLastname(RandomUtils.getLastName()).build();

		Response response = RequestBuilder.buildRequestForPostCalls().body(employee).post("/employees/");

		ExtentLogger.logResponse(response.asPrettyString());
		Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
	}

	@FrameWorkAnnotation(author={"user3"},category= {"smoke","regression"})
	@Test
	public void postRequestUsingExternalFile(Method method) {
		String bodyResource = ApiUtils.readJsonAndGetAsString(FrameWorkConstants.getRequestJsonFolderPath()+"request.json")
				.replace("number",String.valueOf(RandomUtils.getId()))
				.replace("Fname", RandomUtils.getFirstName())
		        .replace("Lname", RandomUtils.getFirstName())
		        .replace("Email.com", RandomUtils.getEmail());
		
		Response response = RequestBuilder.buildRequestForPostCalls()
				.body(bodyResource)
				.post("/employees/");
		
		ExtentLogger.logResponse(response.asPrettyString());
		
		ApiUtils.storeStringAsJsonFile(FrameWorkConstants.getResponseJsonFolderPath()+method.getName()+"response.json",response);
		
		Assertions.assertThat(response.getStatusCode())
		.isEqualTo(201);
		
		
	}
	
}
