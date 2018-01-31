Feature: Scenario Outline

Scenario Outline: Login functionality for a eBay site.
	Given User is at the Home Page
	And Navigate to LogIn Page
	When User enter "<username>" and "<password>"
	And Click on the LogIn button
	Then login should be unsuccessful
Examples:
| username   | password |
| testuser_1 | Test@123 |
| testuser_2 | Test@153 |