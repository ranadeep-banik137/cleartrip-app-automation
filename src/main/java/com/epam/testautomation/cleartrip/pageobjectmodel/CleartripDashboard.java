package com.epam.testautomation.cleartrip.pageobjectmodel;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import com.epam.testautomation.cleartrip.constant.ExcelKeywords;
import com.epam.testautomation.cleartrip.constant.Index;
import com.epam.testautomation.cleartrip.models.ForceWait;
import com.epam.testautomation.cleartrip.utils.CalendarUtil;
import com.epam.testautomation.cleartrip.utils.DriverUtil;
import com.epam.testautomation.cleartrip.utils.ExcelUtil;




@Component
public class CleartripDashboard {

	private static final Logger LOGGER = Logger.getLogger(CleartripDashboard.class.getName());
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor jsx;
	@Autowired
	private CalendarUtil calendarUtil;
	@Autowired
	private ExcelUtil excelUtil;
	
	@Autowired
	public CleartripDashboard(DriverUtil driverUtil) {
		this.driver = driverUtil.getDriver();
		this.jsx = (JavascriptExecutor) this.driver;
		org.openqa.selenium.support.PageFactory.initElements(this.driver, this);
		this.wait = new WebDriverWait(this.driver, 30);
	}
	
	@FindBy (xpath = "//li[contains(@class,'userAccountMenuContainer')]")
	public WebElement loginMenuContainer;
	
	@FindBy (css = "li.signInBlock")
	public WebElement signInBlock;
	
	@FindBy(xpath = "//input[@type = 'submit' and @title = 'Sign In']")
	public WebElement signInButton;
	
	@FindBy (xpath = "//body[@class='Signin modal']")
	public WebElement loginContextBox;
	
	@FindBy (id = "email")
	private WebElement userNameInput;
	
	@FindBy (id = "password")
	private WebElement passwordInput;
	
	@FindBy (id = "persistent_login")
	private WebElement rememberMeCheckbox;
	
	@FindBy (id = "signInButton")
	private WebElement signinButton;
	
	@FindBy (id = "userAccountLink")
	private WebElement userAccountLink;
	
	@FindBy (xpath = "//a[contains(@class,'countryLink')]")
	private WebElement changeCountryLink;
	
	@FindBy (xpath = "//span[@class='currentCountry']")
	private WebElement currentCountryInForm;
	
	@FindBy (id = "countryForm")
	private WebElement countryForm;
	
	@FindBy (xpath = "//*[@id = 'countryForm']//a")
	private List<WebElement> countryList;
	
	@FindBy (id = "OneWay")
	private WebElement oneWayRadioButton;
	
	@FindBy (id = "RoundTrip")
	private WebElement roundTripRadioButton;
	
	@FindBy (id = "MultiCity")
	private WebElement multiCityRadioButton;
	
	@FindBy (id = "FromTag")
	private WebElement fromTag;
	
	@FindBy (id = "ToTag")
	private WebElement toTag;
	
	@FindBy (xpath = "//ul[@class = 'autoComplete' and contains(@id,'ui-id') and contains(@style,'display: block')]//li//a")
	private List<WebElement> airportSuggestionList;
	
	@FindBy (id = "DepartDate")
	private WebElement departDateSelector;
	
	@FindBy (id = "ReturnDate")
	private WebElement returnDateSelector;
	
	@FindBy (id = "SearchBtn")
	private WebElement searchButton;
	
	@FindBy (id = "ui-datepicker-div")
	private WebElement fullCalenderLocator;
	
	@FindBy (id = "Adults")
	private WebElement adultsSelector;
	
	@FindBy (id = "Infants")
	private WebElement infantsSelector;
	
	@FindBy (id = "Childrens")
	private WebElement childrenSelector;
	
	/**
	 * clicks sign-in button at the upper right corner of the dashboard page for login purpose
	 */
	public void clickSignInButton() {
		loginMenuContainer.click();
		this.wait.until(ExpectedConditions.visibilityOf(signInBlock));
		signInButton.click();
		driver.switchTo().frame("modal_window");
		Assert.assertTrue(loginContextBox.isDisplayed());
	}
	
	/**
	 * Login credentials to be entered using username & password
	 * @param userName
	 * @param password
	 */
	public void enterCredentials(final String userName, final String password) {
		ForceWait.pause(3);
		this.wait.until(ExpectedConditions.elementToBeClickable(userNameInput));
		if (userName != null && password != null) {
			userNameInput.sendKeys(userName);
			passwordInput.sendKeys(password);
			if (!rememberMeCheckbox.isEnabled()) {
				rememberMeCheckbox.click();
			}
			signinButton.click();
			wait.until(ExpectedConditions.visibilityOf(userAccountLink));
			Assert.assertEquals(userAccountLink.getText(), userName);
		} else {
			throw new NullPointerException("UserName & Password provided is null");
		}
	}
	
	/**
	 * Directs to sign-in box after clicking sign-in button
	 * @param userName
	 * @param password
	 */
	public void enterLoginCredentialsAfterClickingOnSiginButton(final String userName, final String password) {
		if (loginMenuContainer.getText().contains("Your trips")) {
		clickSignInButton();
		enterCredentials(userName, password);
		}
	}
	
	/**
	 * Change country on the dashboard of cleartrip app
	 * @param country
	 */
	public void changeCountry(final String country) {
		changeCountryLink.click();
		wait.until(ExpectedConditions.visibilityOf(countryForm));
		for (WebElement countryLocator : countryList) {
			if (countryLocator.getText().contains(country))
				countryLocator.click();
				break;
		}
	}
	
	/**
	 * click on one-way button at of cleartrip dashboard
	 */
	public void clickOnOneWayRadioButton() {
		if (!oneWayRadioButton.isEnabled()) {
			oneWayRadioButton.click();
		}
	}
	
	/**
	 * click on two-way button at of cleartrip dashboard
	 */
	public void clickOnRoundTripRadioButton() {
		roundTripRadioButton.click();
		if (!roundTripRadioButton.isEnabled()) {
			roundTripRadioButton.click();
		}
	}
	
	/**
	 * click on multi-city button at of cleartrip dashboard
	 */
	public void clickOnMultiCityRadioButton() {
		if (!multiCityRadioButton.isEnabled()) {
			multiCityRadioButton.click();
		}
	}
	
	/**
	 * Select airport from the airport suggestion drop down
	 * @param departureAirportName
	 */
	public void selectAirportFromSuggetionList(final String departureAirportName) {
		wait.until(ExpectedConditions.visibilityOfAllElements(airportSuggestionList));
		for (WebElement airportSuggestion : airportSuggestionList) {
			jsx.executeScript(Index.JavascriptArgs.SCROLL_INTO_VIEW, airportSuggestion);
			if (airportSuggestion.getText().contains(departureAirportName))
				airportSuggestion.click();
		}
	}
	
	/**
	 * Enter departure airport name at the from tag text box
	 * @param departureAirportName
	 */
	public void enterDepatureAirportName(final String departureAirportName) {
		fromTag.clear();
		fromTag.click();
		fromTag.sendKeys(departureAirportName);
		selectAirportFromSuggetionList(departureAirportName);
	}
	
	/**
	 * enter arrival airport name at the 'To' tagged text box
	 * @param arrivalAirportName
	 */
	public void enterArrivalAirportName(final String arrivalAirportName) {
		toTag.clear();
		toTag.click();
		toTag.sendKeys(arrivalAirportName);
		selectAirportFromSuggetionList(arrivalAirportName);
	}
	
	/**
	 * Enter travel starting date
	 * @param date
	 */
	public void enterTravelDate(final String date) {
		departDateSelector.click();
		this.wait.until(ExpectedConditions.visibilityOf(fullCalenderLocator));
		this.calendarUtil.selectDate(date);
	}
	
	/**
	 * Enter retrun date for round trip
	 * @param date
	 */
	public void enterReturnDate(final String date) {
		returnDateSelector.click();
		this.wait.until(ExpectedConditions.visibilityOf(fullCalenderLocator));
		this.calendarUtil.selectDate(date);
	}
	
	/**
	 * Click search flights button at the dashboard
	 */
	public void clickSearchFlights() {
		searchButton.click();
		LOGGER.info("Searching for flights........");
	}
	
	/**
	 * Enter no of infants, children, adults.
	 * Data to be fetched from the excel data sheet. (By default)
	 */
	public void enterNoOfPerson() {
		String noOfAdults = String.valueOf(excelUtil.readDefaultExcel().readInt(ExcelKeywords.Sheet.TWO_WAY, ExcelKeywords.Headers.ADULTS_COUNT, 1));
		String noOfInfants = String.valueOf(excelUtil.readDefaultExcel().readInt(ExcelKeywords.Sheet.TWO_WAY, ExcelKeywords.Headers.INFANT_COUNT, 1));
		String noOfChildren = String.valueOf(excelUtil.readDefaultExcel().readInt(ExcelKeywords.Sheet.TWO_WAY, ExcelKeywords.Headers.CHILDREN_COUNT, 1));
		adultsSelector.click();
		new Select(adultsSelector).selectByVisibleText(noOfAdults);
		LOGGER.info(noOfAdults + "Adults");
		infantsSelector.click();
		new Select(infantsSelector).selectByVisibleText(noOfInfants);
		LOGGER.info(noOfInfants + "Infants");
		childrenSelector.click();
		new Select(childrenSelector).selectByVisibleText(noOfChildren);
		LOGGER.info(noOfChildren + "Children");
	}

}
