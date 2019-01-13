package com.epam.testautomation.cleartrip.models;

import java.util.logging.Level;
import java.util.logging.Logger;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;

public interface ForceWait {
	
	Logger LOGGER = Logger.getLogger(ForceWait.class.getName());
	
	public static void pause(final int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException interruptedException) {
			LOGGER.log(Level.WARNING, "Interrupted!", interruptedException);
		    Thread.currentThread().interrupt();

		}
	}

}
