package com.epam.testautomation.cleartrip.steps;

import com.epam.testautomation.cleartrip.constant.PropertyKeywords;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class LoginSteps extends BaseStep {
	
	@Given("^I will browse to cleartrip website$")
	public void navigateToCleartripWebSite() {
		factory.launchUrl(properties.getProperty(PropertyKeywords.URL));
	}
	
	@And("^Login with valid credentials$")
	public void loginWithValidCredentials() {
		String userName = properties.getProperty(PropertyKeywords.USER_NAME);
		String password = properties.getProperty(PropertyKeywords.PASSWORD);
		dashboard.enterLoginCredentialsAfterClickingOnSiginButton(userName, password);
		screenshotUtil.captureScreenshotWithFileName(this.getClass().getSimpleName());
	}
}
