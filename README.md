[![SeleniumHQ](http://www.seleniumhq.org/images/big-logo.png)](http://www.seleniumhq.org/)  <img align="right" width="350" height="150" src="Image/cucumber.png">
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
* com.datadriven:-

This package has test data methods and class. So don’t need to do anything on this package.
It has two class which are as below:

Constant.java :-
   * It will use to set some constant value like UserName, Password, Path of Excel file which is used to read username and password for Login.

ExcelUtils.java :-
   * It is one type of template class. It has methods which manipulate Excel to Read and Write
  
* com.extentreport :-
This package has extent report class which is used as template. So you just have to called those methods which are you want to use. (For Ex: Log, Pass, Failed, Info etc.) By these methods you can create extent report and add information about your test cases that it has been passed or failed.


```java
   ExtentReportsClass.test = ExtentReportsClass.extent.startTest("It is sucessfully launch Ebay home page.");
   ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
```

* com.pom :-
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
* com.cucumber.runner:-
This package has class which run the feature files according to the test cases. In this package we can calling the feature files. Runner extension should be common for all the java files as we are using in pom.xml to include for running parallel.
Runner class call the cucumber feature file by adding @CucumberOptions annotation (which is used to configuration for feature file).

* com.cucumber.test:-
This package is very important. We can write all the automation code in this package according steps definition file. So we have to create class file according test cases name.
A StepDefinition file according to feature file. It has methods as steps in feature file, in that we have to write code for implementation.

* Features:-
In this package you can create all the feature files which has step to be followed in Automation Script.

* ExtentReport:-
ExtentReport folder has extent-report.config file which contains all configuration.
It has a target folder which contains extent report in form of html. It is used as a report to see information about test cases which are passes/failed.

* FailedScreenShot:-
Scenario Outline is used in this project for checking the Login by giving multiple username and password. It is a simple feature file just need to use Scenario Outline instead of Scenario.
In this case, if login failed then we capture the screen short and save in this folder `FailedScreenShot`

* TestData:-
TestData Folder has a excel file which is used to take user name and password for login.

* Pom.xml:-
Pom.xml file is very important. It will include all dependencies and download automatically in its repository. So we don’t need to add external jar files to project. Once you completed all the above steps then you have to run the pom.xml file. It will runs all the test cases paralleled. Don’t need to do any change in this file.
You just check your jdk 1.8 version and change in pom.xml which is showed in below screen shot.
For example here is 1.8.101 and if you have 1.8.501 then change it and then run the file.

# How to Setup & Run the project:-
We are using maven build so it has pom.xml files. This file has all the configuration of the project. We can all the libraries in that xml file. Following are the steps to run the project.

* Import project :- First you have to import your project in eclipse IDE. Select project setup path for build.
* Open eclipse > go to file > click on import link
* Project Path :-You have to select proper project path. Project path should be your project location where .setting and pom file were exist. Import existing maven project and click on next button.
* Select the root directory the project is and Click Finish
* Run pom.xml File:- You have to run pom.xml file as maven test.







