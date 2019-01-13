package com.epam.testautomation.cleartrip.steps;

import cucumber.api.java.en.Then;

public class PaymentSteps extends BaseStep {
	
	@Then("^I finally close the browser here$")
	public void closeTheBrowser() {
		paymentPage.validateFlightDetails();
		paymentPage.validateDefaultTravellerDetails();
	}

}
