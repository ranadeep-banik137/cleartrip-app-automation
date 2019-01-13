package com.epam.testautomation.cleartrip.utils;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.testautomation.cleartrip.constant.Index;

@Component
public class ScreenshotUtil {
	
	private static final Logger LOGGER = Logger.getLogger(ScreenshotUtil.class.getName());
	private static final String FILE_CAPTURE_LOCATION = System.getProperty(Index.System.USER_DIR) + Index.Path.TEST_RESOURCES_PATH + Index.Folder.SHOTS;
	private static final String JPG_EXTENSION = ".jpg";
	private static final String SEPARATOR = "\\";
	private TakesScreenshot takesScreenshot;
	private WebDriver driver;
	
	@Autowired
	public ScreenshotUtil(DriverUtil driverUtil) {
		this.driver = driverUtil.getDriver();
		this.takesScreenshot = driverUtil.getTakesScreenShot();
	}
	
	public void captureScreenshotOfCurrentPage() {
		File screenshotFile = this.takesScreenshot.getScreenshotAs(OutputType.FILE);
		File outputFile = new File(FILE_CAPTURE_LOCATION + SEPARATOR + this.driver.getTitle() + SEPARATOR + RandomStringUtils.randomAlphanumeric(18).toUpperCase() + JPG_EXTENSION);
		try {
			FileUtils.copyFile(screenshotFile, outputFile);
		} catch (IOException ioException) {
			LOGGER.info(ioException.getCause().getMessage());
		}
	}
	
	public void captureScreenshotWithFileName(final String fileName) {
		File screenshotFile = this.takesScreenshot.getScreenshotAs(OutputType.FILE);
		File outputFile = new File(FILE_CAPTURE_LOCATION + SEPARATOR + this.driver.getTitle() + SEPARATOR + fileName + JPG_EXTENSION);
		try {
			FileUtils.copyFile(screenshotFile, outputFile);
		} catch (IOException ioException) {
			LOGGER.info(ioException.getCause().getMessage());
		}
	}

}
