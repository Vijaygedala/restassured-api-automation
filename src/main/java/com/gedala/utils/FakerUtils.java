package com.gedala.utils;

import com.github.javafaker.Faker;
/**
 * Wrapper class for the Java Faker library.
 * <p>
 * Handles all interactions with the Faker library to generate random data.
 * </p>
 *
 * <p>
 * Isolating third-party library usage here improves maintainability
 * and makes it easier to update or replace the library in future.
 * </p>
 *
 * @author Vijay Gedala
 * @version 1.0
 */
public final class FakerUtils {

	private FakerUtils() {};

	static Faker faker = new Faker();

	 static int getNumber(int startValue, int endValue) {
		return faker.number().numberBetween(startValue, endValue);
	}
	
	 static String getFirstName() {
		return faker.name().firstName();
	}
	
	 static String getLasttName() {
		return faker.name().lastName();
	}
	 
	 static String getEmail() {
		 return faker.internet().emailAddress();
	 }

}
