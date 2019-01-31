# Cleartrip App Automation V2.0.01

|Project Title | Version | Creator |
|---------|--------|------------|
| [Cleartrip Flight Booking Automation Demo](https://github.com/ranadeep-banik137/cleartrip-app-automation) | 2.0.01 | [Ranadeep Banik](https://github.com/ranadeep-banik137) |


# Project Details : 
	
	A complete project designed with maven build tool with all the required specifications/dependencies has been built at the runtime (For dependencies refer : pom.xml).
	

## Tools/Libraries used : 

+ TestNG : For test build & run. runner.xml is the testNG xml runner file where the test classes & method has been specified.
+ Cucumber : Behavorial tetsing approach through cucumber where all the steps are measured as per the feature files.
+ Spring : Framework utilisation has been designed to be as a singleton pattern for which Spring Autowiring approach has been followed.
+ Java features : All JAVA 8 features (Lambda expression, functional interface, default interface method,  Java stream API implementation, method references, etc ) has been practised in this framework. 
+ Apache POI : Runtime testData/data has been populated with dedicated headers in default excel sheet. Also the platform has been designed in such a way to utilize (excel/property/config) datas from any location.
+ Selenium Webdriver : Selenium version 2.53.0 has been used for automation
+ Screenshot Tool : All page behavior has been captured with TakesScreenShot Selenium java library. 
	
		Location of Screenshots : src/test/resources/shots/..

# Test Details :

## Test behaviors such as : 

+ One-Way Flight Booking : 
	
		One time flight booking from departure airport location to destination airport, comprising the validations done on the fight names, flight price, flight dynamic fare increment, flight insurance charges.
	
+ Two-Way (Includes Return) Flight Booking : 

		Two bookings comprising the departure from one date along with the return flight together. All the validations same as one-way flight i.e mentioned above has been included	

# Test Run Properties : 

+ We have to pass the testNG execution runner file through maven command. By default there is a [runner.xml](https://github.com/ranadeep-banik137/cleartrip-app-automation/blob/master/src/test/resources/runners/runner.xml) file included in [src/test/resources/runners](https://github.com/ranadeep-banik137/cleartrip-app-automation/blob/master/src/test/resources/runners) location.
	
		Example : mvn clean test -Dexecution-xml=runner
	
+ We have to pass the browser name through maven command. By default in [ConfigContext](https://github.com/ranadeep-banik137/cleartrip-app-automation/tree/master/src/main/java/com/epam/testautomation/cleartrip/ContextConfigInitializer.java) file if no browser name is specified, it would assume 'CHROME' as default browser.
	
		Example : mvn clean test -Dbrowser=firefox
	
+ Application url can be passed through environment variables as URL, though by default, in the default data.properties file the default url has been mentioned.
	
		Example : Assign KEY as 'URL' 
				 Value as 'https://www.cleartrip.com'
	
## Broswers applicable : 

| Browser | Maven Command Keyword |
|--------|-------------------|
| CHROME | chrome |
| FIREFOX | firefox |
| INTERNET EXPLORER | ie |

	NB : All the browser drivers has been placed itself inside the project in 'src/main/resources/tools/..' location. All left out browser implementation is in progress. Or the implementation can be done in BroswerUtils.java file itself.	

# Important Links : 

+ [System-drivers](https://github.com/ranadeep-banik137/cleartrip-app-automation/tree/master/src/main/resources/tools)
+ [Feature-files](https://github.com/ranadeep-banik137/cleartrip-app-automation/tree/master/src/test/java/com/epam/testautomation/cleartrip/features)
+ [Test-data-location](https://github.com/ranadeep-banik137/cleartrip-app-automation/blob/master/src/test/resources/dataprovider)
+ [Default-properties-file](https://github.com/ranadeep-banik137/cleartrip-app-automation/blob/master/src/test/resources/dataprovider/data.properties)
+ [Default-excel-data-sheet](https://github.com/ranadeep-banik137/cleartrip-app-automation/blob/master/src/test/resources/dataprovider/TestData.xlsx)
+ [Runner-files-path](https://github.com/ranadeep-banik137/cleartrip-app-automation/blob/master/src/test/resources/runners)
+ [Runtime-screenshots](https://github.com/ranadeep-banik137/cleartrip-app-automation/blob/master/src/test/resources/shots)