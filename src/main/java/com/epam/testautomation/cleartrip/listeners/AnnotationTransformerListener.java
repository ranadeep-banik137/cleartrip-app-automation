package com.epam.testautomation.cleartrip.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import com.epam.testautomation.cleartrip.constant.Index;

public class AnnotationTransformerListener implements IAnnotationTransformer {
	
	private String group = System.getProperty(Index.CommandLineConstraints.TEST_GROUP, "default");
	
	@SuppressWarnings("rawtypes")
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(TestRetryListener.class);
		if (isGroupAvailable(annotation.getGroups())) {
			annotation.setEnabled(Boolean.TRUE);
		}
		
	}
	
	private boolean isGroupAvailable(final String[] groups) {
		boolean flag = false;
		for (String grp : groups) {
			if (grp.equals(group)) {
				flag = true;
				break;
			}
		}
		return flag;
	} 

}
