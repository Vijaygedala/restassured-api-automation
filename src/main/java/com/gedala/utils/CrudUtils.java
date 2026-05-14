package com.gedala.utils;

import com.gedala.requestbuilder.RequestBuilder;

import io.restassured.response.Response;

public class CrudUtils {

	public static Response createUser(String endPoint,Object payload) {
		return RequestBuilder.buildRequestForPostCalls()
				.body(payload)
				.post(endPoint);
	}

	public static Response updateUser(String endPoint,String id, Object payload) {
		return RequestBuilder.buildRequestForPostCalls()
				.body(payload)
				.put(endPoint + id);
	}

	public static Response deleteUser(String endPoint,String id) {
		return RequestBuilder.buildRequestForGetCalls()
				.delete(endPoint + id);

	}
	
	public static Response getUserDetails(String endPoint) {
		return RequestBuilder.buildRequestForGetCalls()
				.get(endPoint);
	}
	
	
}