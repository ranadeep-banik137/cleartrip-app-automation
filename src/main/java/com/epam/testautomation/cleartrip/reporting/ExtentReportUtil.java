package com.epam.testautomation.cleartrip.reporting;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;

import com.epam.testautomation.cleartrip.constant.Index;
import com.epam.testautomation.cleartrip.utils.PropertyUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportUtil {
	
	PropertyUtil propertyUtil;
	ExtentReports extent;
	ExtentTest logger;
	
	public ExtentReportUtil() {
		propertyUtil = new PropertyUtil();
		propertyUtil.setProperties(new Properties());
	}
	
	@BeforeTest
	public void genarateReportFile() {
		extent = new ExtentReports(System.getProperty(Index.System.USER_DIR) + Index.Path.TEST_RESOURCES_PATH + Index.Folder.REPORTS + Index.FlatFile.EXTENT_REPORT_FILENAME, true);
		Map<String, String> systemInfoMapper = new HashMap<>();
		propertyUtil.fetchPropertyFile(System.getProperty(Index.System.USER_DIR) + Index.Path.MAIN_RESOURCES_PATH + Index.FlatFile.INFO_FILE).fetchAll().forEach((key, value) -> {
			systemInfoMapper.put(key, String.valueOf(value));
		});
		extent.addSystemInfo(systemInfoMapper);
		extent.assignProject("Cleartrip Automation");
		extent.loadConfig(new File(System.getProperty(Index.System.USER_DIR) + Index.Path.MAIN_RESOURCES_PATH + Index.Folder.TOOLS + Index.FlatFile.EXTENT_CONFIG));
	}
	
	public void result(ITestResult result) {
		logger = extent.startTest(result.getTestName());
		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, result.getMethod().getMethodName(), "Method : "+ result.getMethod().getMethodName() + " Passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, result.getMethod().getMethodName(), "Method : "+ result.getMethod().getMethodName() + " Failed");
		} else {
			logger.log(LogStatus.SKIP, result.getMethod().getMethodName(), "Method : "+ result.getMethod().getMethodName() + " Skipped");
		}
		logger.log(LogStatus.INFO, result.getMethod().getMethodName(), logger.addScreenCapture(System.getProperty(Index.System.USER_DIR) + Index.Path.TEST_RESOURCES_PATH + Index.Folder.SHOTS + "PaymentSteps.jpg"));
		logger.log(LogStatus.INFO, result.getMethod().getMethodName(), logger.addScreenCapture(System.getProperty(Index.System.USER_DIR) + Index.Path.TEST_RESOURCES_PATH + Index.Folder.SHOTS + "ChooseFlightSteps.jpg"));
		logger.log(LogStatus.INFO, result.getMethod().getMethodName(), logger.addScreenCapture(System.getProperty(Index.System.USER_DIR) + Index.Path.TEST_RESOURCES_PATH + Index.Folder.SHOTS + "CountrySelectionSteps.jpg"));
		logger.log(LogStatus.INFO, result.getMethod().getMethodName(), logger.addScreenCapture(System.getProperty(Index.System.USER_DIR) + Index.Path.TEST_RESOURCES_PATH + Index.Folder.SHOTS + "LoginSteps.jpg"));
		extent.endTest(logger);
		extent.flush();
		extent.close();
	}

}
