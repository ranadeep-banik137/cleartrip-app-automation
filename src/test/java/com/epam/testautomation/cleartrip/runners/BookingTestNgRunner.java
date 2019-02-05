package com.epam.testautomation.cleartrip.runners;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.epam.testautomation.cleartrip.listeners.BasicTestFilterListener;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src/test/java/com/epam/testautomation/cleartrip/features", glue ={"com.epam.testautomation.cleartrip.steps"},  monochrome = true, plugin = {"pretty", "html:src/test/resources/reports"}, tags = {"@All"})
@Listeners({ BasicTestFilterListener.class})
public class BookingTestNgRunner {
	
	private Logger LOGGER = Logger.getLogger(BookingTestNgRunner.class.getName());
	TestNGCucumberRunner runner = new TestNGCucumberRunner(this.getClass());
	
	@BeforeMethod
	public void setup() {
		LOGGER.log(Level.INFO, "Initiating TestNG runner for automation of cleartrip application.");
	}
	
	@Test(dataProvider = "features", groups = {"default"})
	public void generateTest(CucumberFeatureWrapper features) {
		LOGGER.info("Running cucumber feature file at classname : " + features.getCucumberFeature().getClass().getSimpleName());
		this.runner.runCucumber(features.getCucumberFeature());
	}
	
	@DataProvider(name = "features", parallel = true)
	public Object[][] getProviders() {
		return this.runner.provideFeatures();
	}
	
	@AfterMethod
	public void finish(ITestResult result) {
		LOGGER.info("Feature runner accomplished");
		this.runner.finish();
	}

}
