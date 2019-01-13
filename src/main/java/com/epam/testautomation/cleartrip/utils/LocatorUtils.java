package com.epam.testautomation.cleartrip.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocatorUtils {

	private WebDriver driver;
	
	@Autowired
	public LocatorUtils(DriverUtil driverUtil) {
		this.driver = driverUtil.getDriver();
	}
	
	public WebElement mergeLocators(final WebElement parentPath, final By childLocator) {
		return parentPath.findElement(childLocator);
	}
	
	public WebElement mergeLocators(final String xpath, final By childLocator) {
		return this.driver.findElement(By.xpath(xpath)).findElement(childLocator);
	}
	
	public List<WebElement> mergeLocatorsInList(final WebElement parentPath, final By childLocator) {
		return parentPath.findElements(childLocator);
	}
	
	public List<WebElement> mergeLocatorsInList(final String xpath, final By childLocator) {
		return this.driver.findElement(By.xpath(xpath)).findElements(childLocator);
	}
	
	public By getByXpathLocator(final String xpath) {
		return By.xpath(xpath);
	}
	
	public WebElement getWebelementByXpath(final String xpath) {
		return this.driver.findElement(getByXpathLocator(xpath));
	}
	
	public By getByCssSelectorLocator(final String cssSelector) {
		return By.cssSelector(cssSelector);
	}
	
	public WebElement getWebelementByCssSelector(final String cssSelector) {
		return this.driver.findElement(getByCssSelectorLocator(cssSelector));
	}
	
	public By getByClassNameLocator(final String className) {
		return By.className(className);
	}
	
	public WebElement getWebelementByClassName(final String className) {
		return this.driver.findElement(getByClassNameLocator(className));
	}
	
	public By getByNameLocator(final String name) {
		return By.name(name);
	}
	
	public WebElement getWebelementByName(final String name) {
		return this.driver.findElement(getByNameLocator(name));
	}
	
	public By getByIdLocator(final String id) {
		return By.id(id);
	}
	
	public WebElement getWebelementById(final String id) {
		return this.driver.findElement(getByIdLocator(id));
	}
	
	public By getByLinkText(final String linkText) {
		return By.linkText(linkText);
	}
	
	public WebElement getWebelementByLinkText(final String linkText) {
		return this.driver.findElement(getByLinkText(linkText));
	}
	
	public By getByPartialLinkText(final String partialLinkText) {
		return By.partialLinkText(partialLinkText);
	}
	
	public WebElement getWebelementByPartialLinkText(final String partialLinkText) {
		return this.driver.findElement(getByPartialLinkText(partialLinkText));
	}
	
	public By getByTagName(final String name) {
		return By.tagName(name);
	}
	
	public WebElement getWebelementByTagName(final String name) {
		return this.driver.findElement(getByTagName(name));
	}
	
}
