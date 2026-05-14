package com.gedala.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.testng.internal.PropertyUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.gedala.constants.FrameWorkConstants;
import com.gedala.enums.ConfigProperties;
import com.gedala.utils.propertyUtils;

public final class ExtentReport {

	private ExtentReport() {
	};

	private static ExtentReports extent;
	private static ExtentTest test;

	public static void initReports() {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameWorkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Extent Report");
			spark.config().setReportName("CurrentUser");
		}

	}

	public static void teardownReports() {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
		Extentmanager.unloadExtentReport();
		if (propertyUtils.getValue(ConfigProperties.OPENEXTENTREPORTAUTOMATICALLYAFTEREXECUTIONCOMPLETES)
				.equalsIgnoreCase("yes")) {
			try {
				Desktop.getDesktop().browse(new File(FrameWorkConstants.getExtentReportFilePath()).toURI());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void createtest(String name) {
		test = extent.createTest(name);
		Extentmanager.setExtent(test);
	}

	public static void addAuthors(String[] authors) {
		for (String author : authors) {
			Extentmanager.getTest().assignAuthor(author);
		}

	}

	public static void addCategory(String[] categories) {
		for (String category : categories) {
			Extentmanager.getTest().assignCategory(category);
		}

	}

}
