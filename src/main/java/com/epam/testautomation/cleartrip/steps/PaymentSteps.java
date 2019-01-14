package com.epam.testautomation.cleartrip.steps;

import com.epam.testautomation.cleartrip.constant.ExcelKeywords;

import cucumber.api.java.en.Then;

public class PaymentSteps extends BaseStep {
	
	@Then("^I finally close the browser here$")
	public void closeTheBrowser() {
		screenshotUtil.captureScreenshotWithFileName(this.getClass().getSimpleName());
		this.driver.close();
	}
	
	@Then("^I validated all the flight details on payment page$")
	public void validateAllTheFlightDetails() {
		paymentPage.validateFlightDetails(this.excelUtil.booleanConvert(ExcelKeywords.Sheet.ONE_WAY, ExcelKeywords.Headers.INCLUDE_INSURANCE, 1));
	}
	
	@Then("^I enter and validate traveller details$")
	public void enterAndValidateTravellerDetails() {
		paymentPage.validateDefaultTravellerDetails();
	}

}
