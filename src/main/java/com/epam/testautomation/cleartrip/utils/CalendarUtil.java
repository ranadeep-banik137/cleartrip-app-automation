package com.epam.testautomation.cleartrip.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.testautomation.cleartrip.constant.Index;

@Component
public class CalendarUtil {
	
	private static final Logger LOGGER = Logger.getLogger(CalendarUtil.class.getName());
	private static final String SPACE = " ";
	private static final String DATE_SEPARATOR = "/";
	private WebDriver driver;
	private Map<Integer, String> monthMapper;
	private Map<Integer, String> dayMapper;
	
	@Autowired
	public CalendarUtil(DriverUtil driverUtil) {
		this.driver = driverUtil.getDriver();
		setMonthMapper();
		setDayMapper();
	}
	
	@SuppressWarnings("deprecation")
	public void selectDate(final String departureDate) {
		try {
			Date date = new SimpleDateFormat(Index.Constants.DEFAULT_DATE_FORMAT).parse(departureDate);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			boolean nextFlag;
			String requiredMonth = String.valueOf(monthMapper.get(calendar.get(Calendar.MONTH)));
			String requiredYear = String.valueOf(calendar.get(Calendar.YEAR));
			String requiredDate = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
			String requiredDay = String.valueOf(dayMapper.get(date.getDay()));
			List<WebElement> dates = null;
			do {
				WebElement firstMonthBlock = driver.findElement(By.xpath("//div[@class='monthBlock first']//span[@class='ui-datepicker-month']"));
				WebElement lastMonthBlock = driver.findElement(By.xpath("//div[@class='monthBlock last']//span[@class='ui-datepicker-month']"));
				WebElement firstYearBlock = driver.findElement(By.xpath("//div[@class='monthBlock first']//span[@class='ui-datepicker-year']"));
				WebElement lastYearBlock = driver.findElement(By.xpath("//div[@class='monthBlock last']//span[@class='ui-datepicker-year']"));
				if (firstMonthBlock.getText().equals(requiredMonth) && firstYearBlock.getText().equals(requiredYear)) {
					dates = driver.findElements(By.xpath("//div[@class='monthBlock first']//td[@data-handler='selectDay']"));
					nextFlag = false;
				} else if (lastMonthBlock.getText().equals(requiredMonth) && lastYearBlock.getText().equals(requiredYear)) {
					dates = driver.findElements(By.xpath("//div[@class='monthBlock last']//td[@data-handler='selectDay']"));
					nextFlag = false;
				} else {
					driver.findElement(By.xpath("//a[@class='nextMonth ']")).click();
					nextFlag = true;
				}
			} while (nextFlag);
			for (WebElement dateElement : dates) {
				if (dateElement.getText().equals(requiredDate)) {
					dateElement.click();
					LOGGER.info("Date Selected is : " + requiredDay + SPACE + requiredDate + DATE_SEPARATOR + requiredMonth + DATE_SEPARATOR + requiredYear);
					break;
				}
			}
		} catch (ParseException parseException) {
			LOGGER.info(parseException.getCause().getMessage());
		}
	}
	
	private void setMonthMapper() {
		monthMapper = new HashMap<>();
		monthMapper.put(0, "January");
		monthMapper.put(1, "February");
		monthMapper.put(2, "March");
		monthMapper.put(3, "April");
		monthMapper.put(4, "May");
		monthMapper.put(5, "June");
		monthMapper.put(6, "July");
		monthMapper.put(7, "August");
		monthMapper.put(8, "September");
		monthMapper.put(9, "October");
		monthMapper.put(10, "November");
		monthMapper.put(11, "December");
	}
	
	private void setDayMapper() {
		dayMapper = new HashMap<>();
		dayMapper.put(0, "Sunday");
		dayMapper.put(1, "Monday");
		dayMapper.put(2, "Tuesday");
		dayMapper.put(3, "Wednesday");
		dayMapper.put(4, "Thursday");
		dayMapper.put(5, "Friday");
		dayMapper.put(6, "Saturday");
	}

}
