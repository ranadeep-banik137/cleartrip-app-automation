package com.epam.testautomation.cleartrip.steps;

import cucumber.api.java.en.And;

public class CountrySelectionSteps extends BaseStep {
	
	@And("^Select country as \"([^\"]*)\"$")
	public void selectCountry(String country) {
		dashboard.changeCountry(country);
		screenshotUtil.captureScreenshotOfCurrentPage();
	}
	
}
