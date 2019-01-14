package com.epam.testautomation.cleartrip.utils;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.epam.testautomation.cleartrip.constant.Browser;
import com.epam.testautomation.cleartrip.constant.Driver;
import com.epam.testautomation.cleartrip.constant.Index;
import com.epam.testautomation.cleartrip.models.FlightType;

public class DriverUtil {
	
	private static final Logger LOGGER = Logger.getLogger(DriverUtil.class.getName());
	private static final String USER_DIR = System.getProperty(Index.System.USER_DIR);
	private String browser;
	private WebDriver driver;
	private JavascriptExecutor javaScriptExecutor;
	private TakesScreenshot takesScreenShot;
	private FlightType flightType;
	
	static {
		System.setProperty(Driver.CHROME_DRIVER, USER_DIR + "\\src\\main\\resources\\tools\\chromedriver.exe");
		System.setProperty(Driver.GECKO_DRIVER, USER_DIR + "\\src\\main\\resources\\tools\\geckodriver.exe");
		System.setProperty(Driver.IE_DRIVER, USER_DIR + "\\src\\main\\resources\\tools\\IEDriverServer.exe");
	}
	
	public DriverUtil(final String browser) {
		this.browser = browser;
		setDriver();
		setJavaScriptExecutor();
		setTakesScreenShot();
	}
	
	/**
	 * Set WebDriver as per the comands passed
	 */
	private void setDriver() {
		
		switch (this.browser) {
			case Browser.CHROME :
				driver = new ChromeDriver();
				LOGGER.info("Initiating ======================================== C H R O M E ================================================");
				break;
			
			case Browser.FIREFOX : 
				driver = new FirefoxDriver();
				LOGGER.info("Initiating ======================================== F I R E F O X =================================================");
				break;
			
			case Browser.IE : 
				driver = new InternetExplorerDriver();
				LOGGER.info("Initiating ======================================== I N T E R N E T   E X P L O R E R =============================================");
				break;
			
			default :
				LOGGER.info("No such browser found");
				System.exit(-1);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}

	public TakesScreenshot getTakesScreenShot() {
		return takesScreenShot;
	}

	private void setTakesScreenShot() {
		this.takesScreenShot = (TakesScreenshot) this.driver;
	}

	public JavascriptExecutor getJavaScriptExecutor() {
		return javaScriptExecutor;
	}

	private void setJavaScriptExecutor() {
		this.javaScriptExecutor = (JavascriptExecutor) this.driver;
	}

	public FlightType getFlightType() {
		return flightType;
	}

	public void setFlightType(FlightType flightType) {
		this.flightType = flightType;
	}

}
