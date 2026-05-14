package com.gedala.reports;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gedala.logger.FrameWorkLogger;

/**
 * Utility class for logging test information in the framework.
 * <p>
 * Integrates with ExtentReports and FrameWorkLogger to log
 * PASS, FAIL, INFO messages and formatted JSON responses.
 * </p>
 *
 * @author Vijay Gedala
 * @version 1.0
 */

public final class ExtentLogger {

	private ExtentLogger() {};

	public static void pass(String message) {
		Extentmanager.getTest().pass(message);
		FrameWorkLogger.pass(message);
	}
	
	public static void fail(String message) {
		Extentmanager.getTest().fail(message);
		FrameWorkLogger.fail(message);
	}
	
	public static void info(String message) {
		Extentmanager.getTest().info(message);
		FrameWorkLogger.info(message);
	}
	
	public static void skip(String message) {
		Extentmanager.getTest().skip(message);
		FrameWorkLogger.skip(message);
	}

	public static void logResponse(String message) {
		Extentmanager.getTest().pass(MarkupHelper.createCodeBlock(message,CodeLanguage.JSON));
		FrameWorkLogger.info(message);
	}
	
	public static void logPojo(Object obj) {
	    try {
	        ObjectMapper mapper = new ObjectMapper();
	        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
	        Extentmanager.getTest().info("The Passed POJO data is below :");
	        Extentmanager.getTest().pass(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
	        FrameWorkLogger.info("The passed Pojo data: "+json);

	    } catch (Exception e) {
	    	Extentmanager.getTest().fail("Failed to convert POJO to JSON: " + e.getMessage());
	    }
	}
}
