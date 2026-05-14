package com.gedala.constants;

import com.gedala.enums.ConfigProperties;
import com.gedala.utils.dateUtility;
import com.gedala.utils.propertyUtils;

import lombok.Getter;

public class FrameWorkConstants {
	
	// ================================
	   //Framework File Paths
	// ================================
	private static @Getter String requestJsonFolderPath=System.getProperty("user.dir")+"/src/test/resources/jsons/";
	private static @Getter String responseJsonFolderPath=System.getProperty("user.dir")+"/output/";
	private static @Getter String propertyFilePath=System.getProperty("user.dir")+"/src/test/resources/config.properties";
	
	
	
	
	// ================================
	  //Extent Report Configuration
	// ================================
	private static final String EXTENTREPORTSFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
	private static String extentReportFilePath = "";
	
	public static String getExtentReportFilePath() {
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = getExtentReporterFolderPath();
		}
		return extentReportFilePath;
	}

	public static String getExtentReporterFolderPath() {

		if (propertyUtils.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")) {
			return EXTENTREPORTSFOLDERPATH + dateUtility.getCurrentDateTime() + "index.html";
		} else {
			return EXTENTREPORTSFOLDERPATH + "index.html";
		}
	}

}
