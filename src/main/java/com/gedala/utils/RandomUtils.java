package com.gedala.utils;

/**
 * Utility class for generating random test data.
 * <p>
 * Acts as a business layer over FakerUtils, providing commonly used data.
 * </p>
 *
 * <p>
 * This separation ensures that any changes in the underlying data generation
 * library do not impact test code directly.
 * </p>
 *
 * @author Vijay Gedala
 * @version 1.0
 */
public final class RandomUtils {
	private RandomUtils() {};

	// Business layer to handle business level changes
	public static int getId() {
		return FakerUtils.getNumber(100, 1000);

	}

	public static String getFirstName() {
		return FakerUtils.getFirstName().toLowerCase();
	}

	public static String getLastName() {
		return FakerUtils.getLasttName().toLowerCase();
	}

	public static String getEmail() {
		return FakerUtils.getEmail();
	}

}
