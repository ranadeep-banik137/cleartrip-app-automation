package com.epam.testautomation.cleartrip.pageobjectmodel;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import com.epam.testautomation.cleartrip.constant.Index;
import com.epam.testautomation.cleartrip.constant.PropertyKeywords;
import com.epam.testautomation.cleartrip.models.BookingDetails;
import com.epam.testautomation.cleartrip.models.ForceWait;
import com.epam.testautomation.cleartrip.utils.CommonUtils;
import com.epam.testautomation.cleartrip.utils.DriverUtil;
import com.epam.testautomation.cleartrip.utils.PropertyUtil;


@Component
public class PaymentPage {
	
	private static final Logger LOGGER = Logger.getLogger(PaymentPage.class.getName());
	private WebDriver driver;
	private WebDriverWait wait;
	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private PropertyUtil propertyUtil;
	private double insuranceAmount;
	
	@Autowired
	public PaymentPage(DriverUtil driverUtil) {
		this.driver = driverUtil.getDriver();
		PageFactory.initElements(this.driver, this);
		this.wait = new WebDriverWait(this.driver, 30);
		this.insuranceAmount = 0;
	}
	
	@FindBy (xpath = "//div[@class='openBlock']")
	private WebElement activeFlightDetailsBlock;
	
	@FindBy (xpath = "//form[@id='travellerDetails']")
	private WebElement activeTravellerDetailsBlock;
	
	@FindBy (css = "div[id=paymentOpen]")
	private WebElement activePaymentBox;
	
	@FindBy (xpath = "//input[@name='insurance']//following-sibling::small")
	private WebElement insuranceAmountDetails;
	
	@FindBy (xpath = "//ul[@id='travellerSuggestBoxList']/li")
	private List<WebElement> suggestionBoxTravellerList;
	
	@FindBy (css = "section.seatSell.priceChangeUpTemplate")
	private List<WebElement> priceChangeUpTemplate;
	
	private By continueWithPriceChangeButton = By.id("priceChangeUpBtn");
	private By totalFareLocator = By.cssSelector("strong.totalFare");
	
	private By airlineNames = By.cssSelector("div.airlineName");
	
	private By titleSelector = By.cssSelector("select[id*=AdultTitle]");
	
	private By firstNameBlock = By.cssSelector("input[id*=AdultFname]");
	
	private By lastNameBlock = By.cssSelector("input[id*=AdultLname]");
	
	private By mobileNumber = By.cssSelector("input[id=mobileNumber]");
	
	private By continueButton = By.cssSelector("input.booking");
	
	private By insuranceCheckBoxInput = By.cssSelector("input#insurance_box");
	
	private By insuranceConfirmCheckBox = By.cssSelector("input#insurance_confirm");
	
	private By increasedTotalFare = By.cssSelector("span#priceChangeIncreasedFare");
	
	
	/**
	 * Validate flight names and price on the payment page also checks whether insurance to be provided
	 */
	public void validateFlightDetails(final boolean checkInsurance) {
		this.wait.until(ExpectedConditions.visibilityOf(activeFlightDetailsBlock));
		handleFareChangePopup();
		List<WebElement> depFlights = activeFlightDetailsBlock.findElements(By.cssSelector("div.itinerary.clearFix.onwBlock"));
		List<WebElement> retFlights = activeFlightDetailsBlock.findElements(By.cssSelector("div.itinerary.clearFix.retBlock"));
		int index = 0;
		for (WebElement depatureFlight : depFlights) {
			WebElement flightNameLocator = depatureFlight.findElement(airlineNames);
			String flightName = CommonUtils.mergeString(Arrays.asList(flightNameLocator.getText().split("\n")), " ");
			Assert.assertTrue(flightName.contains(this.bookingDetails.getDepartureFlightList().get(index)), "Departure flight names did not match" + flightName + this.bookingDetails.getDepartureFlightList().get(index));
			index ++;
		}
		if (retFlights.size() > 0) {
			index = 0;
			for (WebElement returnFlight : retFlights) {
				WebElement flightNameLocator = returnFlight.findElement(airlineNames);
				String flightName = CommonUtils.mergeString(Arrays.asList(flightNameLocator.getText().split("\n")), " ");
				Assert.assertTrue(flightName.contains(this.bookingDetails.getReturnFlightList().get(index)), "Return flight names did not match" + flightName + this.bookingDetails.getReturnFlightList().get(index));
				index ++;
			}
		}
		if (checkInsurance) {
			includeInsuranceAmount();
		} else {
			unCheckInsurance();
		}
		WebElement totalFare = activeFlightDetailsBlock.findElement(totalFareLocator);
		Assert.assertEquals(Double.parseDouble(totalFare.getText().replaceAll(Index.Constants.ALL_NON_NUMERIC_CHARACTERS, StringUtils.EMPTY).replaceAll(Index.Constants.ALL_SPECIAL_CHARACTER_REGEX_PATTERN, StringUtils.EMPTY)), this.bookingDetails.getDeparturePrice() + this.bookingDetails.getReturnPrice() + insuranceAmount, "Price does not match");
		activeFlightDetailsBlock.findElement(continueButton).click();
		LOGGER.log(Level.INFO, "Flight details in payment page verified successfully");
	}
	
	/**
	 * Checks whether the insurance check box is checked or not
	 * @return
	 */
	public boolean isInsuranceChecked() {
		return activeFlightDetailsBlock.findElement(insuranceCheckBoxInput).isSelected();
	}
	
	/**
	 * Check whether insurance box is displayed or not
	 * @return
	 */
	public boolean isInsuranceBoxDisplayed() {
		List<WebElement> insuranceCheckBox = activeFlightDetailsBlock.findElements(insuranceCheckBoxInput);
		return insuranceCheckBox.size() > 0 ? true : false;
	}
	
	/**
	 * Perform un-tick on the insurance check box
	 */
	public void unCheckInsurance() {
		if (isInsuranceBoxDisplayed()) {
			WebElement insuranceCheckBox = activeFlightDetailsBlock.findElement(insuranceCheckBoxInput);
			if (isInsuranceChecked()) {
				insuranceCheckBox.click();
				ForceWait.pause(5);
			}
		}
	}
	
	/**
	 * Ticks the insurance check box and also include the insurance charges
	 */
	public void includeInsuranceAmount() {
		if (isInsuranceBoxDisplayed()) {
			if (isInsuranceChecked()) {
				this.insuranceAmount = Double.parseDouble(insuranceAmountDetails.getText().replace(" per passenger (Hide benefits)", StringUtils.EMPTY).replace("Rs. ", StringUtils.EMPTY));
				WebElement insuranceConfirm = activeFlightDetailsBlock.findElement(insuranceConfirmCheckBox);
				if (!insuranceConfirm.isSelected()) {
					insuranceConfirm.click();
				}
			}
		} else {
			LOGGER.log(Level.INFO, "Insurance box is not displayed. hence cannot include insurance amouont");
		}
	}
	
	/**
	 * Enter traveller details
	 * @param travellers
	 * @param mobileNum
	 */
	public void enterTravellerDetails(final List<String> travellers, final String mobileNum) {
		List<WebElement> titleSelect = activeTravellerDetailsBlock.findElements(titleSelector);
		List<WebElement> firstNameBlockLocator = activeTravellerDetailsBlock.findElements(firstNameBlock);
		List<WebElement> lastNameBlockLocator = activeTravellerDetailsBlock.findElements(lastNameBlock);
		WebElement mobileNumberBlockLocator = activeTravellerDetailsBlock.findElement(mobileNumber);
		int index = 0;
		for (String traveller : travellers) {
			WebElement titleIndex = titleSelect.get(index);
			WebElement firstNameLoc = firstNameBlockLocator.get(index);
			WebElement lastNameLoc = lastNameBlockLocator.get(index);
			titleIndex.click();
			new Select(titleIndex).selectByVisibleText(traveller.split(Index.Constants.SPACE)[0].replaceAll(Index.Constants.ALL_SPECIAL_CHARACTER_REGEX_PATTERN, StringUtils.EMPTY));
			firstNameLoc.clear();
			firstNameLoc.sendKeys(traveller.split(Index.Constants.SPACE)[1]);
			lastNameLoc.clear();
			lastNameLoc.sendKeys(traveller.split(Index.Constants.SPACE)[2]);
			index ++;
		}
		mobileNumberBlockLocator.clear();
		mobileNumberBlockLocator.sendKeys(mobileNum);
	}
	
	/**
	 * Validate default traveller details available at the traveller suggestion box
	 */
	public void validateDefaultTravellerDetails() {
		String suggestedName;
		String attributeValue = "value";
		this.wait.until(ExpectedConditions.visibilityOf(activeTravellerDetailsBlock));
		WebElement titleSelect = activeTravellerDetailsBlock.findElement(titleSelector);
		WebElement firstNameBlockLocator = activeTravellerDetailsBlock.findElement(firstNameBlock);
		WebElement lastNameBlockLocator = activeTravellerDetailsBlock.findElement(lastNameBlock);
		if (!suggestionBoxTravellerList.isEmpty()) {
			suggestedName = suggestionBoxTravellerList.get(0).getText();
			suggestionBoxTravellerList.get(0).click();
		} else {
			suggestedName = propertyUtil.fetchDefaultPropertiesFile().getProperty(PropertyKeywords.NAME);
			enterTravellerDetails(Arrays.asList(new String[] {suggestedName}), propertyUtil.fetchDefaultPropertiesFile().getProperty(PropertyKeywords.MOBILE_NUM));
		}
		Assert.assertEquals(titleSelect.getAttribute(attributeValue), suggestedName.split(Index.Constants.SPACE)[0].replaceAll(Index.Constants.ALL_SPECIAL_CHARACTER_REGEX_PATTERN, StringUtils.EMPTY));
		Assert.assertEquals(firstNameBlockLocator.getAttribute(attributeValue), suggestedName.split(Index.Constants.SPACE)[1].replaceAll(Index.Constants.ALL_SPECIAL_CHARACTER_REGEX_PATTERN, StringUtils.EMPTY));
		Assert.assertEquals(lastNameBlockLocator.getAttribute(attributeValue), suggestedName.split(Index.Constants.SPACE)[2].replaceAll(Index.Constants.ALL_SPECIAL_CHARACTER_REGEX_PATTERN, StringUtils.EMPTY));
		Assert.assertNotNull(activeTravellerDetailsBlock.findElement(mobileNumber).getAttribute(attributeValue));
		activeTravellerDetailsBlock.findElement(continueButton).click();
		wait.until(ExpectedConditions.visibilityOf(activePaymentBox));
		LOGGER.log(Level.INFO, "Traveller " + suggestedName + " has booked the flight");
	}
	
	/**
	 * Handle instant fare change popup and include the charges
	 */
	public void handleFareChangePopup() {
		if (priceChangeUpTemplate.size() > 0) {
			if (priceChangeUpTemplate.get(0).isDisplayed()) {
				double fare = Double.parseDouble(priceChangeUpTemplate.get(0).findElement(increasedTotalFare).getText().replaceAll(Index.Constants.ALL_NON_NUMERIC_CHARACTERS, StringUtils.EMPTY).replaceAll(Index.Constants.ALL_SPECIAL_CHARACTER_REGEX_PATTERN, StringUtils.EMPTY));
				this.bookingDetails.setDeparturePrice(fare);
				this.bookingDetails.setReturnPrice(0);
				priceChangeUpTemplate.get(0).findElement(continueWithPriceChangeButton).click();
			}
		}
	}

}
