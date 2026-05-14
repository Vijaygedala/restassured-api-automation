package com.gedala.reports;

import com.aventstack.extentreports.ExtentTest;

public final class Extentmanager {
	private Extentmanager() {
	};

	private static ThreadLocal<ExtentTest> extest = new ThreadLocal<>();

	public static ExtentTest getTest() {
		return extest.get();
	}

	public static void setExtent(ExtentTest test) {
		extest.set(test);
	}

	public static void unloadExtentReport() {
		extest.remove();

	}

}
