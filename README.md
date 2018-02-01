# Hybrid Selenium-Cucumber BDD Automation Framework 

The purpose of the project is to display BDD framework for digital web application using combination of leading edge tools like Selenium & Cucumber

## Tools & Technologies

* Automation Tools : Selenium Web Driver (3.8.1 Version) & Cucumber
* Project Setup : Apache maven (3.5.2 Version)
* Data driven Testing Framework : Apache POI & Scenario Outline
* Object Repository Design Pattern : Page Object Model
* Test Execution Report:  Extent API Report & TestNG
* Test Execution Mode:  Parallel 
* Browser Compatibility: Cross Browser Execution
* Screenshot:  Take screen shot API to cover the flow and caputer invalid screenshots
* Implicit and explicit wait
* Mouse action and handling browser Popup
* Assertions : Hard & Soft

## Project Structure
* com.datadriven

This package has test data methods and class. So don’t need to do anything on this package.
It has two class which are as below:

Constant.java :-
   * It will use to set some constant value like UserName, Password, Path of Excel file which is used to read username and password for Login.

ExcelUtils.java :-
   * It is one type of template class. It has methods which manipulate Excel to Read and Write
  
* com.extentreport
This package has extent report class which is used as template. So you just have to called those methods which are you want to use. (For Ex: Log, Pass, Failed, Info etc.) By these methods you can create extent report and add information about your test cases that it has been passed or failed.


```java
   ExtentReportsClass.test = ExtentReportsClass.extent.startTest("It is sucessfully launch Ebay home page.");
   ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
```

* com.pom
This package has object repository of UI elements.  It is used when your element has changed then you have to change in this repository instead of change everywhere where you used it. So it is used for reduce Data Redundancy, improve Maintenance. So whenever you are going to create new automation case you need to create object repository for the same.
In this there are three classes which are as below:-

LoginController.java :-
	* It has repository of UI elements which are going to use in login.

SearchingController.java:-
	* It has repository of UI elements which are going to use in Searching.

EbayController.java:-
	* It has repository of UI elements which are going to use in Ebay Site.
	
For Ex of UserName TestBox Element:-
```java
	public static By Username =By.id("userid");
```
* com.cucumber.runner
This package has class which run the feature files according to the test cases. In this package we can calling the feature files. Runner extension should be common for all the java files as we are using in pom.xml to include for running parallel.
Runner class call the cucumber feature file by adding @CucumberOptions annotation (which is used to configuration for feature file).



