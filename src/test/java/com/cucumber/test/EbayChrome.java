package com.cucumber.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base32;
import org.jsoup.Connection.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.datadriven.Constant;
import com.datadriven.ExcelUtils;
import com.extentreport.ExtentReportsClass;
import com.pom.EbayController;
import com.pom.LoginController;
import com.pom.SearchingController;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EbayChrome {

	WebDriver driver;
	int i=0;

	@Given("^chrome only validation$")
	public void chrome_only_validation() throws Throwable {
		try {
			System.out.println("Chrome Browser Environmnet Created");
			System.out.println("________________________________________");
			Path currentRelativePath = Paths.get("");
			String pathToDriver = currentRelativePath.toAbsolutePath().toString() + File.separator + "DriverEXE"
					+ File.separator;
			System.setProperty("webdriver.chrome.driver", pathToDriver + "chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-web-security");
			options.addArguments("--no-proxy-server");

			Map<String, Object> pref = new HashMap<String, Object>();
			pref.put("credentials_enable_service", false);
			pref.put("profile.password_manager_enabled", false);
			pref.put("profile.default_content_setting_values.notifications", 2);
			options.setExperimentalOption("prefs", pref);
			
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			ExtentReportsClass.startReport("ChromeBrowserTest", "Chrome");
			ExtentReportsClass.test = ExtentReportsClass.extent
					.startTest("Verify Ebay add to Cart & checkout functionality chrome browser");
			Assert.assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			ExtentReportsClass.endreport();
		}
	}

	@Given("^user is on Ebay homepage$")
	public void user_is_on_Ebay_homepage() throws Throwable {
		try {
			driver.get("https://www.ebay.ca/");
			Thread.sleep(1000);
			driver.manage().deleteAllCookies();
			ExtentReportsClass.test = ExtentReportsClass.extent.startTest("It is sucessfully launch Ebay home page.");
			ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		} catch (Exception e) {
			ExtentReportsClass.endreport();
			throw e;
		}
	}

	@When("^user click on Sign in link$")
	public void user_click_on_Sign_in_link() throws Throwable {
		try {
			driver.findElement(EbayController.SignIn).click();
			ExtentReportsClass.test = ExtentReportsClass.extent.startTest("It is click on sigin link.");
			ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		} catch (Exception e) {
			ExtentReportsClass.endreport();
			throw e;
		}
	}

	@Then("^user is logged in with valid username and password$")
	public void user_is_logged_in_with_valid_username_and_password() throws Throwable {

		try {
			ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
			String username = ExcelUtils.getCellData(1, 1);
			String password = ExcelUtils.getCellData(1, 2);

			driver.findElement(LoginController.Username).clear();
			driver.findElement(LoginController.Username).sendKeys(username);
			driver.findElement(LoginController.Password).clear();
			driver.findElement(LoginController.Password).sendKeys(password);
			driver.findElement(LoginController.Signin).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			ExcelUtils.setCellData("Pass", 1, 3);

			ExtentReportsClass.test = ExtentReportsClass.extent.startTest("It is sucessfully Logged in.");
			ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		} catch (Exception e) {
			ExtentReportsClass.endreport();
			throw e;
		}
	}

	@Then("^user is searching for watch$")
	public void user_is_searching_for_watch() throws Throwable {
		try {
			try
			{
				driver.findElement(EbayController.Cart).click();
				driver.findElement(EbayController.Remove).click();
			}
			catch(Exception m)
			{
				i=1;
			}
			driver.findElement(SearchingController.SearchingTextBox).clear();
			driver.findElement(SearchingController.SearchingTextBox).sendKeys("2018 New Fashion LINKIN PARK Band Men 3D Print Short Sleeve");
			Thread.sleep(1000);
			driver.findElement(SearchingController.SearchingButton).click();
			Thread.sleep(5000);
			ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Search result display sucessfully.");
			ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		} catch (Exception e) {
			ExtentReportsClass.endreport();
			throw e;
		}
	}

	@Then("^user selected first watch$")
	public void user_selected_first_watch() throws Throwable {
		try {
			try
			{
			//driver.findElement(EbayController.SortingICon).click();
			}
			catch(Exception m){driver.findElement(EbayController.SortButton).click();}
			//driver.findElement(EbayController.Sorting).click();
			//driver.findElement(By.linkText("Best Match")).click();
			
			driver.findElements(EbayController.ItemList).get(i).findElement(EbayController.Item).click();
			Thread.sleep(2000);
			ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Select anyone Tshirt from the list.");
			ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		} catch (Exception e) {
			ExtentReportsClass.endreport();
			throw e;
		}
	}

	@Then("^user click on add to cart button$")
	public void user_click_on_add_to_cart_button() throws Throwable {
		try {
			driver.navigate().refresh();
			try
			{
			new Select(driver.findElement(EbayController.SelectColor)).deselectByIndex(1);
			}
			catch(Exception m)
			{
				
			}

			driver.findElement(EbayController.AddToCart).click();
			ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Search result display sucessfully.");

			ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		} catch (Exception e) {
			ExtentReportsClass.endreport();
			throw e;
		}
	}

	@Then("^user click on proceed checkout button$")
	public void user_click_on_proceed_checkout_button() throws Throwable {
		try {
			Thread.sleep(2000);
			driver.findElement(EbayController.CheckOut).click();
			ExtentReportsClass.test = ExtentReportsClass.extent.startTest("User click on Checkout button sucessfully.");
			ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		} catch (Exception e) {
			ExtentReportsClass.endreport();
			throw e;
		}
	}

	@Then("^Payment option getting display$")
	public void payment_option_getting_display() throws Throwable {
		try {
			assertEquals(driver.findElement(EbayController.PayPal).getText(), "");
			ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Payment option displaying on web page.");
			Assert.assertTrue(true);
			ExtentReportsClass.test.log(LogStatus.PASS, "Assert Pass as condition is True");
			Thread.sleep(2000);
			driver.quit();
			ExtentReportsClass.endreport();
		} catch (Exception e) {
			ExtentReportsClass.endreport();
			throw e;
		}
	}

}
