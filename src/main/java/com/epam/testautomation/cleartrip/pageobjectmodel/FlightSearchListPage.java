package com.epam.testautomation.cleartrip.pageobjectmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import com.epam.testautomation.cleartrip.constant.Index;
import com.epam.testautomation.cleartrip.models.BookingDetails;
import com.epam.testautomation.cleartrip.models.FlightType;
import com.epam.testautomation.cleartrip.models.FlightWay;
import com.epam.testautomation.cleartrip.models.ForceWait;
import com.epam.testautomation.cleartrip.utils.DriverUtil;


@Component
public class FlightSearchListPage {
	
	private static final Logger LOGGER = Logger.getLogger(FlightSearchListPage.class.getName());
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor jsx;
	@Autowired
	private BookingDetails bookingDetails;
	
	@Autowired
	public FlightSearchListPage(DriverUtil driverUtil) {
		this.driver = driverUtil.getDriver();
		this.jsx = driverUtil.getJavaScriptExecutor();
		org.openqa.selenium.support.PageFactory.initElements(this.driver, this);
		this.wait = new WebDriverWait(this.driver, 30);
	}
	
	@FindBy (xpath = "//ul[@class='listView flights']/li")
	private List<WebElement> flightSearchList;
	
	@FindBy (xpath = "//section[@style='display:none']//following-sibling::form[@id='flightForm']//div[contains(@data-fromto,'_')  and @data-leg='2']//ul[@class='listView flights']//li")
	private List<WebElement> twoWayReturnFlightSearchList;
	
	@FindBy (xpath = "//section[@style='display:none']//following-sibling::form[@id='flightForm']//div[contains(@data-fromto,'_')  and @data-leg='1']//ul[@class='listView flights']//li")
	private List<WebElement> twoWayDepartureFlightSearchList;
	
	@FindBy (css = "div.row.roundTripHead[style='display: block;']")
	private WebElement roundTripConfirmHeader;
	
	private By flightMarkers = By.xpath("//div[contains(@class,'legInfo')]");
	private By totalAmount = By.xpath("//h2[@class='totalAmount']");
	private By bookConfirm = By.cssSelector("button.booking.fRight");
	
	/**
	 * Scroll to view and log all the available flights list
	 */
	public void scrollAndLogAllFlightSearchList() {
		ForceWait.pause(15);
		wait.until(ExpectedConditions.visibilityOfAllElements(flightSearchList));
		Assert.assertTrue(flightSearchList.size() > 1);
		flightSearchList.forEach(flight -> {this.jsx.executeScript(Index.JavascriptArgs.SCROLL_INTO_VIEW, flight); LOGGER.info(flight.getText());});
	}
	
	/**
	 * Method for booking one-way flight from the available flight list as per the parameters provided
	 * @param flightList
	 * @param airlineName
	 * @param range
	 */
	private void bookForOneWayFlight(final List<WebElement> flightList, final String airlineName, final int range) {
		String vendorLocator = "th.vendor.count1";
		String priceLocator = "BaggageBundlingTemplate";
		List<WebElement> filteredFlightList = flightList.stream().filter(flight -> flight.findElement(By.cssSelector(vendorLocator)).getText().equals(airlineName) && Integer.parseInt(flight.findElement(By.id(priceLocator)).getText().replaceAll(Index.Constants.ALL_NON_NUMERIC_CHARACTERS, StringUtils.EMPTY).replaceAll(Index.Constants.ALL_SPECIAL_CHARACTER_REGEX_PATTERN, StringUtils.EMPTY)) <= range)
		.collect(Collectors.toList());
		WebElement flight = filteredFlightList.get(new Random().nextInt(filteredFlightList.size()));
		List<String> bookedAirlineList = new ArrayList<>();
		List<WebElement> allConnectedAirlineNames =	flight.findElements(By.cssSelector(vendorLocator));
		allConnectedAirlineNames.forEach(airline -> {
			bookedAirlineList.add(airline.getText());
		});
		String ticketPrice = flight.findElement(By.id(priceLocator)).getText().replaceAll(Index.Constants.ALL_NON_NUMERIC_CHARACTERS, StringUtils.EMPTY).replaceAll(Index.Constants.ALL_SPECIAL_CHARACTER_REGEX_PATTERN, StringUtils.EMPTY);
		this.bookingDetails.setDepartureFlightList(bookedAirlineList);
		this.bookingDetails.setDeparturePrice(Double .parseDouble(ticketPrice));
		WebElement bookButton = flight.findElement(By.className("booking"));
		wait.until(ExpectedConditions.elementToBeClickable(bookButton));
		jsx.executeScript(Index.JavascriptArgs.SCROLL_INTO_VIEW, bookButton);
		jsx.executeScript(Index.JavascriptArgs.CLICK_ELEMENT, bookButton);
		LOGGER.info("Booked " + bookedAirlineList + " airline. Price : Rs " + ticketPrice);
	}
	
	/**
	 * Method for booking round trip flight from the available flight list as per the parameters provided
	 * @param flightWay
	 * @param airlineName
	 * @param range
	 */
	private void bookForTwoWayFlight(final FlightWay flightWay, final String airlineName, final int range) {
		List<String> airlineText = new ArrayList<>();
		Double airlinePrice;
		String vendorLocator = "td.vendor";
		String priceLocator = "th.price";
		String connectingFlightSegments = "tbody[class*=segment]";
		List <WebElement> flightList = flightWay.equals(FlightWay.DEPARTURE) ? twoWayDepartureFlightSearchList : twoWayReturnFlightSearchList;
		flightList = flightList.stream().filter(
			flight -> flight.findElement(By.cssSelector(vendorLocator)).getText().contains(airlineName) && Integer.parseInt(flight.findElement(By.cssSelector(priceLocator)).getText().replaceAll(Index.Constants.ALL_NON_NUMERIC_CHARACTERS, StringUtils.EMPTY).replaceAll(Index.Constants.ALL_SPECIAL_CHARACTER_REGEX_PATTERN, StringUtils.EMPTY)) <= range
		).collect(Collectors.toList());
		WebElement element = flightList.get(new Random().nextInt(flightList.size()));
		List<WebElement> allConnectingFlightDetails = element.findElements(By.cssSelector(connectingFlightSegments));
		if (flightWay.equals(FlightWay.DEPARTURE)) {
			for (WebElement airline : allConnectingFlightDetails) {
				airlineText.add(airline.findElement(By.cssSelector(vendorLocator)).getText());
			}
			airlinePrice = Double.parseDouble(element.findElement(By.cssSelector(priceLocator)).getText().replaceAll(Index.Constants.ALL_NON_NUMERIC_CHARACTERS, StringUtils.EMPTY).replaceAll(Index.Constants.ALL_SPECIAL_CHARACTER_REGEX_PATTERN, StringUtils.EMPTY));
			this.bookingDetails.setDepartureFlightList(airlineText);
			this.bookingDetails.setDeparturePrice(airlinePrice);
		} else {
			for (WebElement airline : allConnectingFlightDetails) {
				airlineText.add(airline.findElement(By.cssSelector(vendorLocator)).getText());
			}
			airlinePrice = Double.parseDouble(element.findElement(By.cssSelector(priceLocator)).getText().replaceAll(Index.Constants.ALL_NON_NUMERIC_CHARACTERS, StringUtils.EMPTY).replaceAll(Index.Constants.ALL_SPECIAL_CHARACTER_REGEX_PATTERN, StringUtils.EMPTY));
			this.bookingDetails.setReturnFlightList(airlineText);
			this.bookingDetails.setReturnPrice(airlinePrice);
		}
		WebElement radioButton = element.findElement(By.tagName("input"));
		wait.until(ExpectedConditions.elementToBeClickable(radioButton));
		jsx.executeScript(Index.JavascriptArgs.CLICK_ELEMENT, radioButton);
		LOGGER.log(Level.INFO, "Booked " + airlineText + " airline. Price : " + airlinePrice);
	}
	
	/**
	 * Book departure flights as per the parameters provided
	 * applicable for both one-way and two way flights
	 * @param flightType
	 * @param airlineName
	 * @param range
	 */
	public void selectDepartureFlightAsPerFlightNameAndRange(final FlightType flightType, final String airlineName, final int range) {
		switch (flightType) {
		case ONE_WAY : {
			bookForOneWayFlight(flightSearchList, airlineName, range);
			break;
		}
		case TWO_WAY : {
			bookForTwoWayFlight(FlightWay.DEPARTURE, airlineName, range);
			break;
		}
		default : 
			break;
		}
		
	}
	
	/**
	 * Book return flights from the available flight list as per the parameters provided
	 * Only applicable for two way round trip
	 * @param airlineName
	 * @param range
	 */
	public void selectReturnFlightAsPerFlightNameAndRange(final String airlineName, final int range) {
		bookForTwoWayFlight(FlightWay.ARRIVAL, airlineName, range);
		LOGGER.info("Two way trip Booking done");
	}
	
	/**
	 * Method is to validate the flight details after choosing two way flights 
	 * This method should be called right before confirming booking the two way flights
	 * Works as booking method on 'Flight list' page
	 */
	public void roundTripBookingConfirmation() {
		this.wait.until(ExpectedConditions.visibilityOf(roundTripConfirmHeader));
		List<WebElement> flightDetails = roundTripConfirmHeader.findElements(flightMarkers);
		WebElement totalPriceLocator = driver.switchTo().activeElement().findElement(totalAmount); 
		WebElement bookButton = roundTripConfirmHeader.findElement(bookConfirm);
		int index = 0;
		for (WebElement flightDetail : flightDetails) {
			WebElement flight = flightDetail.findElement(By.tagName("strong"));
			Assert.assertTrue(index == 0 ? this.bookingDetails.getDepartureFlightList().get(0).contains(flight.getText()) : this.bookingDetails.getReturnFlightList().get(0).contains(flight.getText()));
			index ++;
		}
		Assert.assertEquals(Double.parseDouble(totalPriceLocator.getText().replaceAll(Index.Constants.ALL_NON_NUMERIC_CHARACTERS, StringUtils.EMPTY).replaceAll(Index.Constants.ALL_SPECIAL_CHARACTER_REGEX_PATTERN, StringUtils.EMPTY)), this.bookingDetails.getDeparturePrice() + this.bookingDetails.getReturnPrice(), "Price does not match");
		bookButton.click();
		LOGGER.info("Booked " + this.bookingDetails.getDepartureFlightList() + " Airline for departure & " + this.bookingDetails.getReturnFlightList() + " Airline for return. /n Total price for booking : Rs:" + (this.bookingDetails.getDeparturePrice() + this.bookingDetails.getReturnPrice()));
	}

}
