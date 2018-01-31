$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/eBayFirefox.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author : Waheed Ahmed"
    }
  ],
  "line": 2,
  "name": "Adding Items in Shopping Cart",
  "description": "",
  "id": "adding-items-in-shopping-cart",
  "keyword": "Feature"
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
  "name": "Firefox browser only validation",
  "keyword": "Given "
});
formatter.match({
  "location": "EbayFireFox.Firefox_browser_oformatter.result({
  "formatter.result({
  "duration": 18229310269,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Add item in the cart",
  "description": "",
  "id": "adding-items-in-shopping-cart;add-item-in-the-cart",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@firefox"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I am on Ebay page",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I clicked on Sign in link",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I logged in with valid username and password",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "I searching for watch",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "I selected first watch",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "I clicked on add to cart button",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "I clicked on proceed checkout button",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "Payment option is getting display",
  "keyword": "Then "
});
formatter.match({
  "location": "EbayFireFox.i_am_on_Ebay_page()"
});
formatter.result({
  "duration": 4221174566,
  "status": "passed"
});
formatter.match({
  "location": "EbayFireFox.i_clicked_on_Sign_in_link()"
});
formatter.result({
  "duration": 2863791950,
  "status": "passed"
});
formatter.match({
  "location": "EbayFireFox.i_logged_in_with_valid_username_and_password()"
});
formatter.result({
  "duration": 5780931320,
  "status": "passed"
});
formatter.match({
  "location": "EbayFireFox.i_searching_for_watch()"
});
formatter.result({
  "duration": 34930510867,
  "status"formatter.result({
  "duration": 77568757858,
  "status": "passed"
});
formatter.match({
  "location": "EbayChrome.user_selected_first_watch()"
});
formatter.result({
  "duration": 41759548218,
  "status": "passed"
});
formatter.match({
  "location": "EbayChrome.user_click_on_add_to_cart_button()"
});
formatter.result({
  "duration": 5111117020,
  "status": "passed"
});
formatter.match({
  "location": "EbayChrome.user_click_on_proceed_checkout_button()"
});
formatter.result({
  "duration": 9630720569,
  "status": "passed"
});
formatter.match({
  "location": "EbayChrome.payment_option_getting_display()"
});
formatter.result({
  "duration": 3444385041,
  "status": "passed"
});
});gIn_button()"
});
formatter.result({
  "duration": 2463071170,
  "status": "passed"
});
formatter.match({
  "location": "EbayOutline.login_should_be_unsuccessful()"
});
formatter.result({
  "duration": 1812100685,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Login functionality for a eBay site.",
  "description": "",
  "id": "scenario-outline;login-functionality-for-a-ebay-site.;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "User is at the Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Navigate to LogIn Page",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "User enter \"testuser_2\" and \"Test@153\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Click on the LogIn button",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "login should be unsuccessful",
  "keyword": "Then "
});
formatter.match({
  "location": "EbayOutline.user_is_at_the_Home_Page()"
});
formatter.result({
  "duration": 16403405621,
  "status": "passed"
});
formatter.match({
  "location": "EbayOutline.navigate_to_LogIn_Page()"
});
formatter.result({
  "duration": 2180720919,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "testuser_2",
      "offset": 12
    },
    {
      "val": "Test@153",
      "offset": 29
    }
  ],
  "location": "EbayOutline.user_enter_and(String,String)"
});
formatter.result({
  "duration": 90910491,
  "status": "passed"
});
formatter.match({
  "location": "EbayOutline.click_on_the_LogIn_button()"
});
formatter.result({
  "duration": 2317702932,
  "status": "passed"
});
formatter.match({
  "location": "EbayOutline.login_should_be_unsuccessful()"
});
formatter.result({
  "duration": 762554963,
  "status": "passed"
});
});