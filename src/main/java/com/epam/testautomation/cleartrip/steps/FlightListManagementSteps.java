package com.epam.testautomation.cleartrip.steps;

import com.epam.testautomation.cleartrip.constant.ExcelKeywords;

import cucumber.api.java.en.Then;

public class FlightListManagementSteps extends BaseStep {
	
	@Then("^I get list of available flights$")
	public void viewListOfAvailableFlights() {
		flightList.scrollAndLogAllFlightSearchList();
	}

	@Then("^I choose the appropriate airline within my budget (\\d+)$")
	public void chooseFlightWithinBudget(int range) {
		flightList.selectDepartureFlightAsPerFlightNameAndRange(factory.getFlightType(), excelUtil.read(ExcelKeywords.Sheet.ONE_WAY, ExcelKeywords.Headers.AIRLINE_NAME, 1), range);
	}
	
	@Then("^I choose the departure airline within my budget (\\d+)$")
	public void chooseDepartureFlightWithinBudget(int range) {
		flightList.selectDepartureFlightAsPerFlightNameAndRange(factory.getFlightType(), excelUtil.read(ExcelKeywords.Sheet.TWO_WAY, ExcelKeywords.Headers.DEPARTURE_AIRLINE_NAME, 1), range);
	}
	
	@Then("^I choose the return airline within my budget (\\d+)$")
	public void chooseReturnFlightWithinBudget(int range) {
		flightList.selectReturnFlightAsPerFlightNameAndRange(excelUtil.read(ExcelKeywords.Sheet.TWO_WAY, ExcelKeywords.Headers.RETURN_AIRLINE_NAME, 1), range);
	}

	@Then("^I validate the booking and click book button$")
	public void validateTheBooking() {
		flightList.roundTripBookingConfirmation();
	}

	/*@Then("^I finally close the browser here$")
	public void closeTheBrowser() {
		//TODO
	}*/
}
