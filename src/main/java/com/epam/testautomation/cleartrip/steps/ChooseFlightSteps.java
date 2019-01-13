package com.epam.testautomation.cleartrip.steps;

import com.epam.testautomation.cleartrip.constant.ExcelKeywords;
import com.epam.testautomation.cleartrip.models.FlightType;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class ChooseFlightSteps extends BaseStep {
	
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
	}
	

}
