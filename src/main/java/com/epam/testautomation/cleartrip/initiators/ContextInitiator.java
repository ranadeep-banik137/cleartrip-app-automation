package com.epam.testautomation.cleartrip.initiators;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epam.testautomation.cleartrip.contextconfig.LoginContextConfig;

public class ContextInitiator {
	
	private static final Logger LOGGER = Logger.getLogger(ContextInitiator.class.getName());
	private ApplicationContext context;
	
	private TestFactory factory;
	
	private ContextInitiator() {
		context = new AnnotationConfigApplicationContext(LoginContextConfig.class);
		LOGGER.info("Context created with the config class as : \"com.epam.testautomation.cleartrip.contextconfig.LoginContextConfig.class\"");
	}

	public static ContextInitiator initiateContext() {
		return new ContextInitiator();
	}
	
	public ApplicationContext getContext() {
		return context;
	}
	
	public TestFactory getFactory() {
		this.factory = (TestFactory) this.context.getBean("factory");
		return this.factory;
	}

	public void setFactory(TestFactory factory) {
		this.factory = factory;
	}

}
