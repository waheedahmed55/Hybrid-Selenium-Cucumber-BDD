#Author : Waheed Ahmed
Feature: Adding Items in Shopping Cart

  Background: 
    Given IE browser only validation

  @iebrowser
  Scenario: Add item in the cart
    Given user is on Ebay page
    When I click on Sign in link
    Then I am logged in with valid username and password
    Then I am searching for watch
    Then I am selected first watch
    Then I click on add to cart button
    Then I click on proceed checkout button
    Then Payment option should display