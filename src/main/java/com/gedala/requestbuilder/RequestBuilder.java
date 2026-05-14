package com.gedala.requestbuilder;

import static io.restassured.RestAssured.*;

import com.gedala.enums.ConfigProperties;
import com.gedala.utils.propertyUtils;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

/**
 * Utility class for building API request specifications.
 * <p>
 * Uses RestAssured to create reusable request setups for
 * GET and POST calls with common configurations like base URI
 * and content type.
 * </p>
 *
 * @author Vijay Gedala
 * @version 1.0
 */
public final class RequestBuilder {

	private RequestBuilder() {};

	public static RequestSpecification buildRequestForGetCalls() {

		return given().baseUri(propertyUtils.getValue(ConfigProperties.BASEURL)).log().all();

	}

	public static RequestSpecification buildRequestForPostCalls() {
		return buildRequestForGetCalls().contentType(ContentType.JSON);

	}

}
