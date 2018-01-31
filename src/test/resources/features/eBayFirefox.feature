#Author : Waheed Ahmed
Feature: Adding Items in Shopping Cart

  Background: 
    Given Firefox browser only validation

  @firefox
  Scenario: Add item in the cart
    Given I am on Ebay page
    When I clicked on Sign in link
    Then I logged in with valid username and password
    Then I searching for watch
    Then I selected first watch
    Then I clicked on add to cart button
    Then I clicked on proceed checkout button
    Then Payment option is getting display