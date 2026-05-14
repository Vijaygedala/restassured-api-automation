package com.gedala.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class dateUtility {
	private dateUtility() {
	}

	public static String getCurrentDateTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-m-ss");
		return LocalDateTime.now().format(formatter);
	}

}
