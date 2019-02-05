package com.epam.testautomation.cleartrip.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

public class TestRetryListener implements IRetryAnalyzer {
	
	private static final Logger LOGGER = Logger.getLogger(TestRetryListener.class);
	private static final int RETRY_COUNT = 2;
	private int initialCount = 0;

	@Override
	public boolean retry(ITestResult result) {
		boolean flag = false;
		if (isTestFailed(result) && initialCount < TestRetryListener.RETRY_COUNT) {
			initialCount ++;
			flag = true;
			LOGGER.info("Retrying test method " + result.getName());
		}
		return flag;
	}
	
	private boolean isTestFailed(ITestResult result) {
		boolean flag = false;
		if (result.getStatus() == ITestResult.FAILURE) {
			flag = true;
		}
		return flag;
	}

}
