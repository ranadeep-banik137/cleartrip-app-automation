package com.epam.testautomation.cleartrip.runners;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src/test/java/com/epam/testautomation/cleartrip/features", glue ={"com.epam.testautomation.cleartrip.steps"},  monochrome = true, plugin = {"pretty"}, tags = {"@All"})
public class LoginTestNgRunner {
	
	
	TestNGCucumberRunner runner = new TestNGCucumberRunner(this.getClass());
	
	@BeforeMethod
	public void setup() {
		//LoginContextConfig.getConfigContext();
	}
	
	@Test(dataProvider = "features")
	public void generateTest(CucumberFeatureWrapper features) {
		this.runner.runCucumber(features.getCucumberFeature());
	}
	
	@DataProvider(name = "features")
	public Object[][] getProviders() {
		return this.runner.provideFeatures();
	}
	
	@AfterMethod
	public void finish() {
		this.runner.finish();
	}

}
