package com.gedala.logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Provides centralized logging utilities for the automation framework.
 * <p>
 * This package integrates with <b>Log4j2</b> to produce consistent,
 * thread-aware log messages across the framework. It ensures that all logs
 * include the thread ID, making parallel execution easier to trace.
 * </p>
 * 
 * @author Vijay Gedala
 * @version 1.0
 * @since 1.0 
 */
public class FrameWorkLogger {
	private FrameWorkLogger() {
	}

	private static final Logger logger = LogManager.getLogger();

	private static String buildMessage(String message) {

		long threadId = Thread.currentThread().threadId();

		return "[Thread-" + threadId + "] " + message;
	}

	public static void info(String message) {
		logger.info(buildMessage(message));
	}

	public static void pass(String message) {
		logger.info(buildMessage("PASS : " + message));
	}

	public static void fail(String message) {
		logger.error(buildMessage("FAIL : " + message));
	}
	
	public static void skip(String message) {
		logger.warn(buildMessage("SKIP : " + message));
	}

}
