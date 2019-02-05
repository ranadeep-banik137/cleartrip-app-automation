package com.epam.testautomation.cleartrip.constant;

public interface Index {
	
	interface System {
		
		String USER_DIR = "user.dir";
		
		String USER_NAME = "user.name";
	}
	
	interface JavascriptArgs {
		
		String SENDKEYS_BY_ID = "document.getElementById('%s').value='%s';";
		
		String CLICK_ELEMENT = "arguments[0].click();";
		
		String CLICK_BY_ID = "document.getElementById('%s').click();";
		
		String CHECK_BOX_SELECT_BY_ID = "document.getElementById('%s').checked=true;";
		
		String CHECK_BOX_DESELECT_BY_ID = "document.getElementById('%s').checked=false;";
		
		String CREATE_ALERT = "alert('%s');";
		
		String REFRESH_BROWSER_BY_HISTORY = "history.go(0)";
		
		String INNER_TEXT_ENTIRE_WEBPAGE = "return document.documentElement.innerText;";
		
		String GET_PAGE_TITLE = "return document.title;";
		
		String GET_PAGE_DOMAIN = "return document.domain;";
		
		String GET_PAGE_URL = "return document.URL;";
		
		String SCROLL_DOWN_BY_HEIGHT = "window.scrollBy(0,%s)";
		
		String SCROLL_INTO_VIEW = "arguments[0].scrollIntoView(true);";
		
		String CLICK_SUB_MENU_THROUGH_HOVER = "$('ul.menus.menu-secondary.sf-js-enabled.sub-menu li').hover()";
		
		String BROWSE = "window.location = '%s'";
	}
	
	interface CommandLineConstraints {
		
		String URL = "url";
		
		String TEST_XML = "execution-xml";
		
		String TEST_GROUP = "test-group";
		
	}
	
	interface Path {
		 
		String TEST_RESOURCES_PATH = "\\src\\test\\resources\\";
		
		String MAIN_RESOURCES_PATH = "\\src\\main\\resources\\";
		
		String TEST_JAVA_PATH = "\\src\\test\\java\\";
		
		String MAIN_JAVA_PATH = "\\src\\main\\java\\";
	}
	
	interface Folder {
		
		String DATA_PROVIDER = "dataprovider\\";
		
		String RUNNERS = "runners\\";
		
		String TOOLS = "tools\\";
		
		String SHOTS = "shots\\";
		
		String REPORTS = "reports\\";
	}
	
	interface FlatFile {
		
		String DEFAULT_PROPERTIES_FILE = "data.properties";
		
		String DEFAULT_EXCEL_FILE = "TestData.xlsx";
		
		String DEFAULT_RUNNER_XML_FILE = "runner.xml";
		
		String EXTENT_REPORT_FILENAME = "epam_cleartrip-run_html_report.html";
		
		String INFO_FILE = "info.properties";
		
		String EXTENT_CONFIG = "extent-config.xml";
	}
	
	interface Constants {
		
		String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";
		
		String ALL_SPECIAL_CHARACTER_REGEX_PATTERN = "[^\\dA-Za-z ]";
		
		String ALL_NON_NUMERIC_CHARACTERS = "[^\\d.]";
		
		String SPACE = " ";
	}

}
