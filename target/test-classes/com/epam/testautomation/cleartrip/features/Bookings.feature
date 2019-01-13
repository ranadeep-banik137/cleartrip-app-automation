@All
Feature: Book Flights from cleartrip.com website

  @Oneway
  Scenario: Book one way flight
    Given I will browse to cleartrip website
    And Login with valid credentials
    And Select country as "India"
    When I Click on one way radio button
    And Enter departure airport name and select the appropriate option
    And Enter arrival airport name and select the appropriate option
    And Select the departure date
    And Select the person counts
    And I start searching flights
    Then I get list of available flights
    And I choose the appropriate airline within my budget 5000
    And I finally close the browser here

  @Twoway
  Scenario: Book two way flight
    Given I will browse to cleartrip website
    And Login with valid credentials
    And Select country as "India"
    When I Click on two way radio button
    And Enter departure airport name and select the appropriate option
    And Enter arrival airport name and select the appropriate option
    And Select the departure date
    And Select the return date
    And Select the person counts
    And I start searching flights
    Then I get list of available flights
    And I choose the departure airline within my budget 5000
    And I choose the return airline within my budget 4500
    And I validate the booking and click book button
    And I finally close the browser here
