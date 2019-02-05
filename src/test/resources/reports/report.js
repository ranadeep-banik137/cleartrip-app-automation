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
  "duration": 4565386562,
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
  "duration": 8480652220,
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
  "duration": 17861559957,
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
  "duration": 6244736993,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.clickOnOneWayRadioButton()"
});
formatter.result({
  "duration": 23215515,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.enterAndSelectDepartureAirportName()"
});
formatter.result({
  "duration": 2594804676,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.enterAndSelectArrivalAirportName()"
});
formatter.result({
  "duration": 2588310806,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.selectDepartureDate()"
});
formatter.result({
  "duration": 528976799,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.selectTheIndividualCounts()"
});
formatter.result({
  "duration": 489100510,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.clickOnSearchFlights()"
});
formatter.result({
  "duration": 712463481,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.viewListOfAvailableFlights()"
});
formatter.result({
  "duration": 16751351041,
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
  "duration": 9399484814,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.validateAllTheFlightDetails()"
});
formatter.result({
  "duration": 25951739706,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.enterAndValidateTravellerDetails()"
});
formatter.result({
  "duration": 21618164120,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.closeTheBrowser()"
});
formatter.result({
  "duration": 2626026738,
  "status": "passed"
});
formatter.after({
  "duration": 230705056,
  "status": "passed"
});
formatter.before({
  "duration": 3345674436,
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
  "duration": 9900536833,
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
  "duration": 17820410209,
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
  "duration": 7950179243,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.clickOnTwoWayRadioButton()"
});
formatter.result({
  "duration": 92535235,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.enterAndSelectDepartureAirportName()"
});
formatter.result({
  "duration": 3591254807,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.enterAndSelectArrivalAirportName()"
});
formatter.result({
  "duration": 2563578063,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.selectDepartureDate()"
});
formatter.result({
  "duration": 422386302,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.selectReturnDate()"
});
formatter.result({
  "duration": 385155348,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.selectTheIndividualCounts()"
});
formatter.result({
  "duration": 399877063,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.clickOnSearchFlights()"
});
formatter.result({
  "duration": 738859371,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.viewListOfAvailableFlights()"
});
formatter.result({
  "duration": 18680188973,
  "status": "passed"
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
  "duration": 1101623809,
  "status": "passed"
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
  "duration": 1288066156,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.validateTheBooking()"
});
formatter.result({
  "duration": 9845164854,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.validateAllTheFlightDetails()"
});
formatter.result({
  "duration": 21895468030,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.enterAndValidateTravellerDetails()"
});
formatter.result({
  "duration": 14028918345,
  "status": "passed"
});
formatter.match({
  "location": "CleartripAutomationSteps.closeTheBrowser()"
});
formatter.result({
  "duration": 2417675900,
  "status": "passed"
});
formatter.after({
  "duration": 201410106,
  "status": "passed"
});
});