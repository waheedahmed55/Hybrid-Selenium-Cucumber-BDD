#Author : Waheed Ahmed
Feature: Adding Item in Shopping Cart

  Background: 
    Given chrome only validation

  @chrome
  Scenario: Login with valid username and select item
    Given user is on Ebay homepage
    When user click on Sign in link
    Then user is logged in with valid username and password
    Then user is searching for watch
    Then user selected first watch
    Then user click on add to cart button
    Then user click on proceed checkout button
    Then Payment option getting display
