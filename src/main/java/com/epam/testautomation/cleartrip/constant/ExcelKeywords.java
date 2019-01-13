package com.epam.testautomation.cleartrip.constant;

public interface ExcelKeywords {

	interface Sheet {
		
		String ONE_WAY = "OneWay";
		
		String TWO_WAY = "TwoWay";
	}
	
	interface Headers {
		
		String COUNTRY = "Country Location";
		
		String DEPARTURE_AIRPORT = "Departure Airport";
		
		String ARRIVAL_AIRPORT = "Arrival Airport";
		
		String DEPARTURE_DATE = "Departure Date";
		
		String RETURN_DATE = "Return Date";
		
		String AIRLINE_NAME = "Airline Name";
		
		String DEPARTURE_AIRLINE_NAME = "Departure Airport Name";
		
		String RETURN_AIRLINE_NAME = "Return Airline Name";
		
		String STARTING_PRICE_RANGE = "Starting Range";
		
		String MAX_PRICE_RANGE = "Maximum Range";
		
		String AVERAGE_PRICE_RANGE = "Average Range";
		
		String ADULTS_COUNT = "No Of Adults";
		
		String CHILDREN_COUNT = "No Of Children";
		
		String INFANT_COUNT = "No Of Infants";
		
		String TRAVELLER_FORMATTER = "Traveller%s";
		
		String MOBILE_NUMBER = "Mobile Number";
	}
}
