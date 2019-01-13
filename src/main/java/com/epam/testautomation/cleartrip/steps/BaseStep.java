package com.epam.testautomation.cleartrip.steps;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.epam.testautomation.cleartrip.initiators.ContextInitiator;
import com.epam.testautomation.cleartrip.initiators.TestFactory;
import com.epam.testautomation.cleartrip.pageobjectmodel.CleartripDashboard;
import com.epam.testautomation.cleartrip.pageobjectmodel.FlightSearchListPage;
import com.epam.testautomation.cleartrip.pageobjectmodel.PaymentPage;
import com.epam.testautomation.cleartrip.utils.ExcelUtil;
import com.epam.testautomation.cleartrip.utils.ScreenshotUtil;

public class BaseStep {
	
	protected static TestFactory factory = ContextInitiator.initiateContext().getFactory();
	CleartripDashboard dashboard;
	FlightSearchListPage flightList;
	PaymentPage paymentPage;
	WebDriver driver;
	Properties properties;
	ScreenshotUtil screenshotUtil;
	ExcelUtil excelUtil;
	
	
	BaseStep() {
		dashboard = factory.getCleartripDashboard();
		flightList = factory.getFlightSearchListPage();
		paymentPage = factory.getPaymentPage();
		driver = factory.getDriver();
		properties = factory.getPropertyUtil().fetchDefaultPropertiesFile();
		screenshotUtil = factory.getScreenshotUtil();
		excelUtil = factory.getExcelUtil().readDefaultExcel();
	}

}
