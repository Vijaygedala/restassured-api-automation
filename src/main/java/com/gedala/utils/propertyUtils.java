package com.gedala.utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.gedala.constants.FrameWorkConstants;
import com.gedala.enums.ConfigProperties;

public final class propertyUtils {

	private propertyUtils() {};


	private static Properties properties = new Properties();
	private static Map<String, String> MAP = new HashMap<>();

	static {
		try (FileInputStream inputStream = new FileInputStream(FrameWorkConstants.getPropertyFilePath())) {
			properties.load(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		properties.entrySet().forEach(e -> MAP.put(String.valueOf(e.getKey()), String.valueOf(e.getValue())));
	}

	public static String getValue(ConfigProperties key) {
		return MAP.get(key.name().toLowerCase());
	}
}
