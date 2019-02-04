$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Bookings.feature");
formatter.feature({
  "line": 2,
  "name": "Book Flights from cleartrip.com website",
  "description": "",
  "id": "book-flights-from-cleartrip.com-website",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@All"
    }
  ]
});
formatter.before({
  "duration": 52429486750,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I will browse to cleartrip website",
  "keyword": "Given "
});
formatter.match({
  "location": "CleartripAutomationSteps.navigateToCleartripWebSite()"
});
formatter.result({
  "duration": 80631346930,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Book one way flight",
  "description": "",
  "id": "book-flights-from-cleartrip.com-website;book-one-way-flight",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@Oneway"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "Login with valid credentials",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Select country as \"India\"",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I Click on one way radio button",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "Enter departure airport name and select the appropriate option",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Enter arrival airport name and select the appropriate option",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Select the departure date",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Select the person counts",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I start searching flights",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I get list of available flights",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "I choose the appropriate airline within my budget 5000",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I validated all the flight details on payment page",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "I enter and validate traveller details",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "I finally close the browser here",
  "keyword": "And "
});
formatter.match({
  "location": "CleartripAutomationSteps.loginWithValidCredentials()"
});
formatter.result({
  "duration": 33402180095,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "India",
      "offset": 19
    }
  ],
  "location": "CleartripAutomationSteps.selectCountry(String)"
});
formatter.result({
  "duration": 9316703012,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.clickOnOneWayRadioButton()"
});
formatter.result({
  "duration": 32630173,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.enterAndSelectDepartureAirportName()"
});
formatter.result({
  "duration": 4522801270,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.enterAndSelectArrivalAirportName()"
});
formatter.result({
  "duration": 1901955455,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.selectDepartureDate()"
});
formatter.result({
  "duration": 727968970,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.selectTheIndividualCounts()"
});
formatter.result({
  "duration": 1262034234,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.clickOnSearchFlights()"
});
formatter.result({
  "duration": 1730974408,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.viewListOfAvailableFlights()"
});
formatter.result({
  "duration": 31055009257,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5000",
      "offset": 50
    }
  ],
  "location": "CleartripAutomationSteps.chooseFlightWithinBudget(int)"
});
formatter.result({
  "duration": 27613781071,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"class name\",\"selector\":\"booking\"}\n  (Session info: chrome\u003d71.0.3578.98)\n  (Driver info: chromedriver\u003d2.42.591088 (7b2b2dca23cca0862f674758c9a3933e685c27d5),platform\u003dWindows NT 10.0.17134 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 20.01 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LAPTOP-Q981VJ79\u0027, ip: \u0027192.168.1.5\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_181\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{mobileEmulationEnabled\u003dfalse, hasTouchScreen\u003dfalse, platform\u003dXP, acceptSslCerts\u003dfalse, goog:chromeOptions\u003d{debuggerAddress\u003dlocalhost:52448}, acceptInsecureCerts\u003dfalse, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, setWindowRect\u003dtrue, unexpectedAlertBehaviour\u003d, applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.42.591088 (7b2b2dca23cca0862f674758c9a3933e685c27d5), userDataDir\u003dC:\\Users\\DEEPJO~1\\AppData\\Local\\Temp\\scoped_dir14532_12989}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, version\u003d71.0.3578.98, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, locationContextEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 049cfbd7044307d9426e1d3cca3db88e\n*** Element info: {Using\u003dclass name, value\u003dbooking}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:327)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.findElement(RemoteWebElement.java:198)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.findElementByClassName(RemoteWebElement.java:272)\r\n\tat org.openqa.selenium.By$ByClassName.findElement(By.java:391)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.findElement(RemoteWebElement.java:194)\r\n\tat com.epam.testautomation.cleartrip.pageobjectmodel.FlightSearchListPage.bookForOneWayFlight(FlightSearchListPage.java:94)\r\n\tat com.epam.testautomation.cleartrip.pageobjectmodel.FlightSearchListPage.selectDepartureFlightAsPerFlightNameAndRange(FlightSearchListPage.java:150)\r\n\tat com.epam.testautomation.cleartrip.steps.CleartripAutomationSteps.chooseFlightWithinBudget(CleartripAutomationSteps.java:124)\r\n\tat ✽.And I choose the appropriate airline within my budget 5000(Bookings.feature:18)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "CleartripAutomationSteps.validateAllTheFlightDetails()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CleartripAutomationSteps.enterAndValidateTravellerDetails()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CleartripAutomationSteps.closeTheBrowser()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 5454819646,
  "status": "passed"
});
formatter.before({
  "duration": 9626461172,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I will browse to cleartrip website",
  "keyword": "Given "
});
formatter.match({
  "location": "CleartripAutomationSteps.navigateToCleartripWebSite()"
});
formatter.result({
  "duration": 12827425354,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Book two way flight",
  "description": "",
  "id": "book-flights-from-cleartrip.com-website;book-two-way-flight",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 23,
      "name": "@Twoway"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "Login with valid credentials",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "Select country as \"India\"",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "I Click on two way radio button",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "Enter departure airport name and select the appropriate option",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "Enter arrival airport name and select the appropriate option",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "Select the departure date",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "Select the return date",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "Select the person counts",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "I start searching flights",
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "I get list of available flights",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "I choose the departure airline within my budget 5000",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "I choose the return airline within my budget 4500",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "I validate the booking and click book button",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "I validated all the flight details on payment page",
  "keyword": "And "
});
formatter.step({
  "line": 39,
  "name": "I enter and validate traveller details",
  "keyword": "And "
});
formatter.step({
  "line": 40,
  "name": "I finally close the browser here",
  "keyword": "And "
});
formatter.match({
  "location": "CleartripAutomationSteps.loginWithValidCredentials()"
});
formatter.result({
  "duration": 22963456869,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "India",
      "offset": 19
    }
  ],
  "location": "CleartripAutomationSteps.selectCountry(String)"
});
formatter.result({
  "duration": 10086998576,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.clickOnTwoWayRadioButton()"
});
formatter.result({
  "duration": 168179555,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.enterAndSelectDepartureAirportName()"
});
formatter.result({
  "duration": 4744385389,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.enterAndSelectArrivalAirportName()"
});
formatter.result({
  "duration": 4204484606,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.selectDepartureDate()"
});
formatter.result({
  "duration": 829754099,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.selectReturnDate()"
});
formatter.result({
  "duration": 776941748,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.selectTheIndividualCounts()"
});
formatter.result({
  "duration": 1198378582,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.clickOnSearchFlights()"
});
formatter.result({
  "duration": 1509403943,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.viewListOfAvailableFlights()"
});
formatter.result({
  "duration": 27458589671,
  "error_message": "org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document\n  (Session info: chrome\u003d71.0.3578.98)\n  (Driver info: chromedriver\u003d2.42.591088 (7b2b2dca23cca0862f674758c9a3933e685c27d5),platform\u003dWindows NT 10.0.17134 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 1.39 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/stale_element_reference.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LAPTOP-Q981VJ79\u0027, ip: \u0027192.168.1.5\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_181\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{mobileEmulationEnabled\u003dfalse, hasTouchScreen\u003dfalse, platform\u003dXP, acceptSslCerts\u003dfalse, goog:chromeOptions\u003d{debuggerAddress\u003dlocalhost:55265}, acceptInsecureCerts\u003dfalse, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, setWindowRect\u003dtrue, unexpectedAlertBehaviour\u003d, applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.42.591088 (7b2b2dca23cca0862f674758c9a3933e685c27d5), userDataDir\u003dC:\\Users\\DEEPJO~1\\AppData\\Local\\Temp\\scoped_dir7688_1957}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, version\u003d71.0.3578.98, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, locationContextEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 7e2414c66f45073583247abf74025966\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.executeScript(RemoteWebDriver.java:577)\r\n\tat com.epam.testautomation.cleartrip.pageobjectmodel.FlightSearchListPage.lambda$scrollAndLogAllFlightSearchList$0(FlightSearchListPage.java:71)\r\n\tat java.util.ArrayList.forEach(Unknown Source)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementListHandler.invoke(LocatingElementListHandler.java:39)\r\n\tat com.sun.proxy.$Proxy30.forEach(Unknown Source)\r\n\tat com.epam.testautomation.cleartrip.pageobjectmodel.FlightSearchListPage.scrollAndLogAllFlightSearchList(FlightSearchListPage.java:71)\r\n\tat com.epam.testautomation.cleartrip.steps.CleartripAutomationSteps.viewListOfAvailableFlights(CleartripAutomationSteps.java:119)\r\n\tat ✽.Then I get list of available flights(Bookings.feature:34)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "5000",
      "offset": 48
    }
  ],
  "location": "CleartripAutomationSteps.chooseDepartureFlightWithinBudget(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "4500",
      "offset": 45
    }
  ],
  "location": "CleartripAutomationSteps.chooseReturnFlightWithinBudget(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CleartripAutomationSteps.validateTheBooking()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CleartripAutomationSteps.validateAllTheFlightDetails()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CleartripAutomationSteps.enterAndValidateTravellerDetails()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CleartripAutomationSteps.closeTheBrowser()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 3908220626,
  "status": "passed"
});
