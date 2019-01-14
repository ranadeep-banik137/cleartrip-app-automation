package com.epam.testautomation.cleartrip.utils;

import java.util.List;
import java.util.stream.Collectors;

public class CommonUtils {
	
	/**
	 * Merges list objects into a string
	 * @param stringList
	 * @return
	 */
	public static String mergeString(List<String> stringList) {
		return stringList.stream().collect(Collectors.joining());
	}
	
	/**
	 * Mergers list objects into a string including a separator
	 * @param stringList
	 * @param separator
	 * @return
	 */
	public static String mergeString(List<String> stringList, final CharSequence separator) {
		return stringList.stream().collect(Collectors.joining(separator));
	}
	
}
