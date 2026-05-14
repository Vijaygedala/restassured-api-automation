package com.gedala.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.gedala.annotations.FrameWorkAnnotation;
import com.gedala.pojo.Employee;
import com.gedala.reports.ExtentLogger;
import com.gedala.utils.CrudUtils;
import com.gedala.utils.RandomUtils;

import io.restassured.response.Response;

public class CrudTest  {
	
	@FrameWorkAnnotation(author={"vijay","Gedala","user3"},category= {"smoke","regression","sanity"})
	@Test
	public void UserService() {

		// create
		Employee employee = Employee.builder()
				.setId(RandomUtils.getId())
				.setFirstname(RandomUtils.getFirstName())
				.setLastname(RandomUtils.getLastName())
				.setEmail(RandomUtils.getEmail()).build();
		
		ExtentLogger.logPojo( employee);

		ExtentLogger.info("Creating a new  user");
		Response postCallresponse = CrudUtils.createUser("/employees/",employee);
		ExtentLogger.logResponse(postCallresponse.asPrettyString());
		Assertions.assertThat(postCallresponse.getStatusCode()).isEqualTo(201);
		
		String id = postCallresponse.jsonPath().getString("id");

		//Update
		ExtentLogger.info("Updating an existing user");
		Employee updateEmployee = Employee.builder()
				.setId(RandomUtils.getId())
				.setFirstname(RandomUtils.getFirstName())
				.setLastname(RandomUtils.getLastName())
				.setEmail(RandomUtils.getEmail()).build();
		
		//Delete
		Response putCallResponse = CrudUtils.updateUser("/employees/",id,updateEmployee);
		ExtentLogger.logResponse(putCallResponse.asPrettyString());
		Assertions.assertThat(putCallResponse.getStatusCode()).isEqualTo(200);
		
		Assertions.assertThat(putCallResponse.jsonPath().getString("firstname")).isNotEqualToIgnoringCase(postCallresponse.jsonPath().getString("firstname"));
		
		ExtentLogger.info("Deleting the created user");
		Response deleteCallResponse = CrudUtils.deleteUser("/employees/",id);
		Assertions.assertThat(deleteCallResponse.getStatusCode()).isEqualTo(200);
		
		ExtentLogger.info("Validating the created user is not present in the Api after deleting ");
		Response getCallResponse = CrudUtils.getUserDetails("/employees/");
		Assertions.assertThat( getCallResponse.jsonPath().getList("id")) .doesNotContain(id);
		
	}

}
