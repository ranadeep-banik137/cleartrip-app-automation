package com.epam.testautomation.cleartrip.contextconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.epam.testautomation.cleartrip.utils.DriverUtil;


@Configuration
@ComponentScan(basePackages = "com.epam.testautomation.cleartrip")
public class ContextConfigInitializer {
	
	private static String browser;
	
	static {
		browser = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
	}
	
	@Bean(name = "driverUtil")
	public DriverUtil getDriverUtil() {
		return new DriverUtil(browser);
	}
}
