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
  "duration": 4944517658,
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
  "duration": 18917909855,
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
  "duration": 17938109689,
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
  "duration": 8382093017,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.clickOnOneWayRadioButton()"
});
formatter.result({
  "duration": 27442931,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.enterAndSelectDepartureAirportName()"
});
formatter.result({
  "duration": 2640318942,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.enterAndSelectArrivalAirportName()"
});
formatter.result({
  "duration": 1700755457,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.selectDepartureDate()"
});
formatter.result({
  "duration": 496839394,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.selectTheIndividualCounts()"
});
formatter.result({
  "duration": 486245254,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.clickOnSearchFlights()"
});
formatter.result({
  "duration": 759321463,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.viewListOfAvailableFlights()"
});
formatter.result({
  "duration": 16990729666,
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
  "duration": 12007572200,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.validateAllTheFlightDetails()"
});
formatter.result({
  "duration": 26170102710,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.enterAndValidateTravellerDetails()"
});
formatter.result({
  "duration": 6626989299,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.closeTheBrowser()"
});
formatter.result({
  "duration": 2681272424,
  "status": "passed"
});
formatter.after({
  "duration": 198226602,
  "status": "passed"
});
formatter.before({
  "duration": 3626547557,
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
  "duration": 6208352261,
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
  "duration": 18648564706,
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
  "duration": 8179322413,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.clickOnTwoWayRadioButton()"
});
formatter.result({
  "duration": 89413455,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.enterAndSelectDepartureAirportName()"
});
formatter.result({
  "duration": 2618578272,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.enterAndSelectArrivalAirportName()"
});
formatter.result({
  "duration": 2674845398,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.selectDepartureDate()"
});
formatter.result({
  "duration": 493303463,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.selectReturnDate()"
});
formatter.result({
  "duration": 498585599,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.selectTheIndividualCounts()"
});
formatter.result({
  "duration": 432958255,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.clickOnSearchFlights()"
});
formatter.result({
  "duration": 851190244,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.viewListOfAvailableFlights()"
});
formatter.result({
  "duration": 19342138790,
  "error_message": "org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document\n  (Session info: chrome\u003d71.0.3578.98)\n  (Driver info: chromedriver\u003d2.42.591088 (7b2b2dca23cca0862f674758c9a3933e685c27d5),platform\u003dWindows NT 10.0.16299 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 72 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/stale_element_reference.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027EPINPUNW0043\u0027, ip: \u002710.22.94.69\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_181\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{mobileEmulationEnabled\u003dfalse, hasTouchScreen\u003dfalse, platform\u003dXP, acceptSslCerts\u003dfalse, goog:chromeOptions\u003d{debuggerAddress\u003dlocalhost:53604}, acceptInsecureCerts\u003dfalse, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, setWindowRect\u003dtrue, unexpectedAlertBehaviour\u003d, applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.42.591088 (7b2b2dca23cca0862f674758c9a3933e685c27d5), userDataDir\u003dC:\\Users\\RANADE~1\\AppData\\Local\\Temp\\scoped_dir3008_6271}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, version\u003d71.0.3578.98, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, locationContextEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: bdc67cea15cf166b090aa489730a5653\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:327)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.isDisplayed(RemoteWebElement.java:368)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$9.apply(ExpectedConditions.java:261)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$9.apply(ExpectedConditions.java:257)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:238)\r\n\tat com.epam.testautomation.cleartrip.pageobjectmodel.FlightSearchListPage.scrollAndLogAllFlightSearchList(FlightSearchListPage.java:69)\r\n\tat com.epam.testautomation.cleartrip.steps.CleartripAutomationSteps.viewListOfAvailableFlights(CleartripAutomationSteps.java:119)\r\n\tat ✽.Then I get list of available flights(Bookings.feature:34)\r\n",
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
  "duration": 1371971910,
  "status": "passed"
});
