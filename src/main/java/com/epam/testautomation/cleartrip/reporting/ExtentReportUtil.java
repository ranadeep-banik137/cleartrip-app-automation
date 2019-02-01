package com.epam.testautomation.cleartrip.reporting;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.ITestResult;

import com.epam.testautomation.cleartrip.constant.Index;
import com.epam.testautomation.cleartrip.utils.PropertyUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportUtil {
	
	PropertyUtil propertyUtil;
	private ExtentReports extent;
	private ExtentTest logger;
	
	public ExtentReportUtil() {
		propertyUtil = new PropertyUtil();
		propertyUtil.setProperties(new Properties());
	}
	
	public ExtentReportUtil genarateReportFile() {
		extent = new ExtentReports(System.getProperty(Index.System.USER_DIR) + Index.Path.TEST_RESOURCES_PATH + Index.Folder.REPORTS + Index.FlatFile.EXTENT_REPORT_FILENAME, true);
		Map<String, String> systemInfoMapper = new HashMap<>();
		propertyUtil.fetchPropertyFile(System.getProperty(Index.System.USER_DIR) + Index.Path.MAIN_RESOURCES_PATH + Index.FlatFile.INFO_FILE).fetchAll().forEach((key, value) -> {
			systemInfoMapper.put(key, String.valueOf(value));
		});
		extent.addSystemInfo(systemInfoMapper);
		extent.assignProject("Cleartrip Automation");
		extent.loadConfig(new File(System.getProperty(Index.System.USER_DIR) + Index.Path.MAIN_RESOURCES_PATH + Index.Folder.TOOLS + Index.FlatFile.EXTENT_CONFIG));
		return this;
	}
	
	public void result(ITestResult result) {
		logger = extent.startTest(result.getTestName());
		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, result.getMethod().getMethodName(), "Method : "+ result.getMethod().getMethodName() + " Passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, result.getMethod().getMethodName(), logger.addScreenCapture(System.getProperty(Index.System.USER_DIR) + Index.Path.TEST_RESOURCES_PATH + Index.Folder.SHOTS + "FAILED.jpg"));
			logger.log(LogStatus.FAIL, result.getMethod().getMethodName(), "Method : "+ result.getMethod().getMethodName() + " Failed");
		} else {
			logger.log(LogStatus.SKIP, result.getMethod().getMethodName(), "Method : "+ result.getMethod().getMethodName() + " Skipped");
		}
		extent.endTest(logger);
		flushAndClose();
	}
	
	public void flushAndClose() {
		extent.flush();
		extent.close();
	}
	
	public void generateTestsWithName(final String scenario) {
		logger = extent.startTest(scenario);
	}
	
	public void logAsPerTestStatus(int status, final String scenario) {
		if (status == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, scenario, "Method : "+ scenario + " Passed");
		} else if (status == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, scenario, logger.addScreenCapture(System.getProperty(Index.System.USER_DIR) + Index.Path.TEST_RESOURCES_PATH + Index.Folder.SHOTS + "FAILED.jpg"));
			logger.log(LogStatus.FAIL, scenario, "Method : "+ scenario + " Failed");
		} else {
			logger.log(LogStatus.SKIP, scenario, "Method : "+ scenario + " Skipped");
		}
	}
	
	public void terminate(int status, final String scenario) {
		logAsPerTestStatus(status, scenario);
		extent.endTest(logger);
		flushAndClose();
	}
	
	public ExtentReports getExtentReportInstance() {
		return this.extent;
	}

}
