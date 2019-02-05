package com.epam.testautomation.cleartrip.listeners;

import java.util.List;
import java.util.stream.Collectors;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.log4testng.Logger;

public class MethodInterceptorListener implements IMethodInterceptor {
	
	private static final Logger LOGGER = Logger.getLogger(MethodInterceptorListener.class);
	
	{
		LOGGER.info(this.getClass() + " Listener invoked");
	}

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		return methods.stream().filter(method -> method.getMethod().getEnabled() && method.getMethod().isTest() && method.getMethod().getMethodName().toLowerCase().contains("test")).collect(Collectors.toList());
	}

}
