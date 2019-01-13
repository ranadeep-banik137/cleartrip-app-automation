package com.epam.testautomation.cleartrip.initiators;

import com.epam.testautomation.cleartrip.constant.Index;

public class SystemProvider {
	
	public static String URL = System.getProperty(Index.CommandLineConstraints.URL) == null ? System.getenv(Index.CommandLineConstraints.URL) : System.getenv(Index.CommandLineConstraints.URL);

}
