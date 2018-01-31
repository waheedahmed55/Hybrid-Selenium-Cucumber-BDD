package com.cucumber.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.pom.LoginController;
import com.pom.SearchingController;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EbayIE {

	WebDriver driver;

	@Given("^IE browser only validation$")
	public void ie_browser_only_validation() throws Throwable {

		System.out.println("IE Browser Environmnet Created");
		System.out.println("________________________________________");
		Path currentRelativePath = Paths.get("");
		String pathToDriver = currentRelativePath.toAbsolutePath().toString() + File.separator + "DriverEXE"
				+ File.separator;
		System.setProperty("webdriver.ie.driver", pathToDriver + "IEDriverServer.exe");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		driver = new InternetExplorerDriver(dc);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("^user is on Ebay page$")
	public void user_is_on_Ebay_page() throws Throwable {
		driver.get("https://www.ebay.com/");
		Thread.sleep(1000);
	}

	@When("^I click on Sign in link$")
	public void i_click_on_Sign_in_link() throws Throwable {

		driver.findElement(By.linkText("Sign in")).click();
	}

	@Then("^I am logged in with valid username and password$")
	public void i_am_logged_in_with_valid_username_and_password() throws Throwable {
		driver.findElement(LoginController.Username).clear();
		driver.findElement(LoginController.Username).sendKeys("niravpanchal2047@gmail.com");
		driver.findElement(LoginController.Password).clear();
		driver.findElement(LoginController.Password).sendKeys("test@123");
		driver.findElement(LoginController.Signin).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Then("^I am searching for watch$")
	public void i_am_searching_for_watch() throws Throwable {
		driver.findElement(SearchingController.SearchingTextBox).clear();
		driver.findElement(SearchingController.SearchingTextBox).sendKeys("Watch");
		Thread.sleep(1000);
		driver.findElement(SearchingController.SearchingButton).click();
		Thread.sleep(5000);
	}

	@Then("^I am selected first watch$")
	public void i_am_selected_first_watch() throws Throwable {
		driver.navigate().to(
				"https://www.ebay.com/itm/Retro-Womens-Mens-Stainless-Steel-Watches-Compass-Quartz-Analog-Wrist-Watch/122725341611?hash=item1c930019ab:m:mdyGR5fCAFJP22cpwETKUMg");
		Thread.sleep(2000);
	}

	@Then("^I click on add to cart button$")
	public void i_click_on_add_to_cart_button() throws Throwable {
		driver.findElement(By.id("isCartBtn_btn")).click();
	}

	@Then("^I click on proceed checkout button$")
	public void i_click_on_proceed_checkout_button() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.id("ptcBtnBottom")).click();
	}

	@Then("^Payment option should display$")
	public void payment_option_should_display() throws Throwable {
		assertEquals(driver.findElement(By.cssSelector("span.PAYPAL.pmt-logo")).getText(), "");
	}

}
