package com.epam.testautomation.cleartrip.initiators;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.testautomation.cleartrip.models.BookingDetails;
import com.epam.testautomation.cleartrip.models.FlightType;
import com.epam.testautomation.cleartrip.pageobjectmodel.CleartripDashboard;
import com.epam.testautomation.cleartrip.pageobjectmodel.FlightSearchListPage;
import com.epam.testautomation.cleartrip.pageobjectmodel.PaymentPage;
import com.epam.testautomation.cleartrip.utils.DriverUtil;
import com.epam.testautomation.cleartrip.utils.ExcelUtil;
import com.epam.testautomation.cleartrip.utils.PropertyUtil;
import com.epam.testautomation.cleartrip.utils.ScreenshotUtil;

@Component(value = "factory")
public class TestFactory {
	
	@Autowired
	private CleartripDashboard cleartripDashboard;
	@Autowired
	private DriverUtil driverUtil;
	@Autowired
	private PropertyUtil propertyUtil;
	@Autowired
	private ScreenshotUtil screenshotUtil;
	@Autowired
	private FlightSearchListPage flightSearchListPage;
	@Autowired
	private PaymentPage paymentPage;
	private FlightType flightType;
	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private ExcelUtil excelUtil;

	public CleartripDashboard getCleartripDashboard() {
		return cleartripDashboard;
	}

	public void setCleartripDashboard(CleartripDashboard cleartripDashboard) {
		this.cleartripDashboard = cleartripDashboard;
	}

	public DriverUtil getDriverUtil() {
		return driverUtil;
	}

	public void setDriverUtil(DriverUtil driverUtil) {
		this.driverUtil = driverUtil;
	}
	
	public void launchUrl(final String url) {
		this.driverUtil.getDriver().navigate().to(url);
	}
	
	public WebDriver getDriver() {
		return this.driverUtil.getDriver();
	}

	public PropertyUtil getPropertyUtil() {
		return propertyUtil;
	}

	public void setPropertyUtil(PropertyUtil propertyUtil) {
		this.propertyUtil = propertyUtil;
	}

	public FlightSearchListPage getFlightSearchListPage() {
		return flightSearchListPage;
	}

	public void setFlightSearchListPage(FlightSearchListPage flightSearchListPage) {
		this.flightSearchListPage = flightSearchListPage;
	}
	
	public ScreenshotUtil getScreenshotUtil() {
		return screenshotUtil;
	}

	public void setScreenshotUtil(ScreenshotUtil screenshotUtil) {
		this.screenshotUtil = screenshotUtil;
	}

	public FlightType getFlightType() {
		return flightType;
	}

	public void setFlightType(FlightType flightType) {
		this.flightType = flightType;
	}

	public BookingDetails getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(BookingDetails bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	public ExcelUtil getExcelUtil() {
		return excelUtil;
	}

	public void setExcelUtil(ExcelUtil excelUtil) {
		this.excelUtil = excelUtil;
	}

	public PaymentPage getPaymentPage() {
		return paymentPage;
	}

	public void setPaymentPage(PaymentPage paymentPage) {
		this.paymentPage = paymentPage;
	}

}
