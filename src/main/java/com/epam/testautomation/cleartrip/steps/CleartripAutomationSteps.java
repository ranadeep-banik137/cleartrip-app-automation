package com.epam.testautomation.cleartrip.steps;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.SessionNotFoundException;

import com.epam.testautomation.cleartrip.constant.ExcelKeywords;
import com.epam.testautomation.cleartrip.constant.PropertyKeywords;
import com.epam.testautomation.cleartrip.initiators.ContextInitiator;
import com.epam.testautomation.cleartrip.initiators.TestFactory;
import com.epam.testautomation.cleartrip.models.FlightType;
import com.epam.testautomation.cleartrip.pageobjectmodel.CleartripDashboard;
import com.epam.testautomation.cleartrip.pageobjectmodel.FlightSearchListPage;
import com.epam.testautomation.cleartrip.pageobjectmodel.PaymentPage;
import com.epam.testautomation.cleartrip.utils.CommonUtils;
import com.epam.testautomation.cleartrip.utils.ExcelUtil;
import com.epam.testautomation.cleartrip.utils.PropertyUtil;
import com.epam.testautomation.cleartrip.utils.ScreenshotUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SuppressWarnings("deprecation")
public class CleartripAutomationSteps {
	
	private static final Logger LOGGER = Logger.getLogger(CleartripAutomationSteps.class.getName());
	TestFactory factory;
	CleartripDashboard dashboard;
	FlightSearchListPage flightList;
	PaymentPage paymentPage;
	WebDriver driver;
	PropertyUtil propertyUtil;
	ScreenshotUtil screenshotUtil;
	ExcelUtil excelUtil;
	
	@Before
	public void initialSetup(Scenario scenario) {
		LOGGER.log(Level.INFO, "Running Scenario : " + scenario.getName());
		factory = ContextInitiator.initiateContext().getFactory();
		dashboard = factory.getCleartripDashboard();
		flightList = factory.getFlightSearchListPage();
		paymentPage = factory.getPaymentPage();
		driver = factory.getDriver();
		propertyUtil = factory.getPropertyUtil();
		screenshotUtil = factory.getScreenshotUtil();
		excelUtil = factory.getExcelUtil().readDefaultExcel();
	}
	
	@Given("^I will browse to cleartrip website$")
	public void navigateToCleartripWebSite() {
		factory.launchUrl(String.valueOf(propertyUtil.fetchValueFromDefaultPropertiesFile(PropertyKeywords.URL)));
	}
	
	@And("^Login with valid credentials$")
	public void loginWithValidCredentials() {
		String userName = propertyUtil.fetchDecodedValue(PropertyKeywords.USER_NAME);
		String password = propertyUtil.fetchDecodedValue(PropertyKeywords.PASSWORD);
		dashboard.enterLoginCredentialsAfterClickingOnSiginButton(userName, password);
		screenshotUtil.captureScreenshotWithFileName(this.getClass().getSimpleName());
	}
	
	@And("^Select country as \"([^\"]*)\"$")
	public void selectCountry(String country) {
		dashboard.changeCountry(country);
		screenshotUtil.captureScreenshotWithFileName(this.getClass().getSimpleName());
	}
	
	@When("^I Click on one way radio button$")
	public void clickOnOneWayRadioButton() {
		dashboard.clickOnOneWayRadioButton();
		factory.setFlightType(FlightType.ONE_WAY);
	}
	
	@When("^I Click on two way radio button$")
	public void clickOnTwoWayRadioButton() {
		dashboard.clickOnRoundTripRadioButton();
		factory.setFlightType(FlightType.TWO_WAY);
	}
	
	@And("^Enter departure airport name and select the appropriate option$")
	public void enterAndSelectDepartureAirportName() {
		dashboard.enterDepatureAirportName(excelUtil.read(ExcelKeywords.Sheet.ONE_WAY, ExcelKeywords.Headers.DEPARTURE_AIRPORT, 1));
	}
	
	@And("^Enter arrival airport name and select the appropriate option$")
	public void enterAndSelectArrivalAirportName() {
		dashboard.enterArrivalAirportName(excelUtil.read(ExcelKeywords.Sheet.ONE_WAY, ExcelKeywords.Headers.ARRIVAL_AIRPORT, 1));
	}
	
	@And("^Select the departure date$")
	public void selectDepartureDate() {
		dashboard.enterTravelDate(excelUtil.read(ExcelKeywords.Sheet.ONE_WAY, ExcelKeywords.Headers.DEPARTURE_DATE, 1));
	}
	
	@And("^Select the return date$")
	public void selectReturnDate() {
		dashboard.enterReturnDate(excelUtil.read(ExcelKeywords.Sheet.TWO_WAY, ExcelKeywords.Headers.RETURN_DATE, 1));
	}
	
	@And("^Select the person counts$")
	public void selectTheIndividualCounts() {
		dashboard.enterNoOfPerson();
	}
	
	@And("^I start searching flights$")
	public void clickOnSearchFlights() {
		dashboard.clickSearchFlights();
		screenshotUtil.captureScreenshotWithFileName(this.getClass().getSimpleName());
	}
	
	@Then("^I get list of available flights$")
	public void viewListOfAvailableFlights() {
		flightList.scrollAndLogAllFlightSearchList();
	}

	@Then("^I choose the appropriate airline within my budget (\\d+)$")
	public void chooseFlightWithinBudget(int range) {
		flightList.selectDepartureFlightAsPerFlightNameAndRange(factory.getFlightType(), excelUtil.read(ExcelKeywords.Sheet.ONE_WAY, ExcelKeywords.Headers.AIRLINE_NAME, 1), range);
		screenshotUtil.captureScreenshotWithFileName("one-way-booking");
	}
	
	@Then("^I choose the departure airline within my budget (\\d+)$")
	public void chooseDepartureFlightWithinBudget(int range) {
		flightList.selectDepartureFlightAsPerFlightNameAndRange(factory.getFlightType(), excelUtil.read(ExcelKeywords.Sheet.TWO_WAY, ExcelKeywords.Headers.DEPARTURE_AIRLINE_NAME, 1), range);
		screenshotUtil.captureScreenshotWithFileName("departure-booking");
	}
	
	@Then("^I choose the return airline within my budget (\\d+)$")
	public void chooseReturnFlightWithinBudget(int range) {
		flightList.selectReturnFlightAsPerFlightNameAndRange(excelUtil.read(ExcelKeywords.Sheet.TWO_WAY, ExcelKeywords.Headers.RETURN_AIRLINE_NAME, 1), range);
		screenshotUtil.captureScreenshotWithFileName("return-booking");
	}

	@Then("^I validate the booking and click book button$")
	public void validateTheBooking() {
		flightList.roundTripBookingConfirmation();
	}
	
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
	
	@After
	public void end() {
		String windowHandle = null;
		try {
			windowHandle = driver.getWindowHandle();
		} catch(SessionNotFoundException session) {
			windowHandle = null;
			LOGGER.info("No sessions found");
		}
		if(!CommonUtils.isNullOrEmpty(windowHandle)) {
			screenshotUtil.captureScreenshotWithFileName("FAILED");
			driver.quit();
		}
	}

}
