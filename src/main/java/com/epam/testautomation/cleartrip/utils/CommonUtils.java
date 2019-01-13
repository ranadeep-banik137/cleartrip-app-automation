package com.epam.testautomation.cleartrip.utils;

import java.util.List;
import java.util.stream.Collectors;

public class CommonUtils {
	
	public static String mergeString(List<String> stringList) {
		return stringList.stream().collect(Collectors.joining());
	}
	
	public static String mergeString(List<String> stringList, final CharSequence separator) {
		return stringList.stream().collect(Collectors.joining(separator));
	}

}
