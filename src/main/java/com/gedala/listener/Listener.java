package com.gedala.listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.gedala.annotations.FrameWorkAnnotation;
import com.gedala.reports.ExtentLogger;
import com.gedala.reports.ExtentReport;

public class Listener implements ITestListener, ISuiteListener {
	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initReports();
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.teardownReports();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createtest(result.getMethod().getMethodName());

		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameWorkAnnotation.class).author());

		ExtentReport.addCategory(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameWorkAnnotation.class).category());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + " is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName() + " is failed");
		ExtentLogger.fail(result.getThrowable().toString().split("Build info")[0].trim());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " is Skipped");
	}


}
