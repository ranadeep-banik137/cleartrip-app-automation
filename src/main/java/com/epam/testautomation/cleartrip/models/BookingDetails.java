package com.epam.testautomation.cleartrip.models;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BookingDetails {

	private double departurePrice;
	private double returnPrice;
	private List<String> departureFlightList;
	private List<String> returnFlightList;
	
	public double getDeparturePrice() {
		return departurePrice;
	}
	public void setDeparturePrice(double departurePrice) {
		this.departurePrice = departurePrice;
	}
	public double getReturnPrice() {
		return returnPrice;
	}
	public void setReturnPrice(double returnPrice) {
		this.returnPrice = returnPrice;
	}
	public List<String> getDepartureFlightList() {
		return departureFlightList;
	}
	public void setDepartureFlightList(List<String> departureFlightList) {
		this.departureFlightList = departureFlightList;
	}
	public List<String> getReturnFlightList() {
		return returnFlightList;
	}
	public void setReturnFlightList(List<String> returnFlightList) {
		this.returnFlightList = returnFlightList;
	}
}
