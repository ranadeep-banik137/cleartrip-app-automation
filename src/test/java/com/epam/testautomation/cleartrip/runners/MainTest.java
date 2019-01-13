package com.epam.testautomation.cleartrip.runners;

import java.util.Properties;

import com.epam.testautomation.cleartrip.utils.ExcelUtil;
import com.epam.testautomation.cleartrip.utils.PropertyUtil;

public class MainTest {
	
	public static void main(String[] args) {
		
		//// Test Property Utils
		
		System.out.println(".249.0".split(".").length);
		
		PropertyUtil prop = new PropertyUtil();
		prop.setProperties(new Properties());
		System.out.println(prop.fetchPropertyFile("D:\\Ranadeep's\\Projects\\cleartripapp-v1\\cleartripapp\\src\\test\\resources\\dataprovider\\data.properties").updatePropertyFile("abc", "Ranadeep").fetchValueWithKey("abc"));
		
		System.out.println(System.getProperties());
		
		ExcelUtil excel = new ExcelUtil();
		System.out.println(excel.readDefaultExcel().read("XwoWay", "Return Date", 2));
	}

}
