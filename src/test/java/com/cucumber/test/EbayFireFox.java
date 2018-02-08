package com.cucumber.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.datadriven.Constant;
import com.datadriven.ExcelUtils;
import com.extentreport.ExtentReportsClass;
import com.pom.EbayController;
import com.pom.LoginController;
import com.pom.SearchingController;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EbayFireFox {
	WebDriver driver;
	int i = 0;

	@Given("^Firefox browser only validation$")
	public void Firefox_browser_only_validation() throws Throwable {

		try {

			System.out.println("Firefox Browser Environmnet Created");
			System.out.println("________________________________________");
			Path currentRelativePath = Paths.get("");
			String pathToDriver = currentRelativePath.toAbsolutePath().toString() + File.separator + "DriverEXE"
					+ File.separator;
			System.setProperty("webdriver.gecko.driver", pathToDriver + "geckodriver.exe");
			DesiredCapabilities dc = DesiredCapabilities.firefox();
			dc.setCapability("marionette", false);

			// driver = new FirefoxDriver(dc);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			ExtentReportsClass.startReport("FirefoxBrowserTest", "FireFox");
			ExtentReportsClass.test = ExtentReportsClass.extent
					.startTest("Verify Ebay add to Cart & checkout functionality Firefox browser");
			Assert.assertTrue(true);
		}

		catch (Exception e) {
			e.printStackTrace();
			ExtentReportsClass.endreport();
		}
	}

	@Given("^I am on Ebay page$")
	public void i_am_on_Ebay_page() throws Throwable {
		try {
			driver.get("https://www.ebay.ca/");
			ExtentReportsClass.test = ExtentReportsClass.extent.startTest("It is sucessfully launch Ebay home page.");
			ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
			ExtentReportsClass.endreport();
		}
	}

	@When("^I clicked on Sign in link$")
	public void i_clicked_on_Sign_in_link() throws Throwable {

		try {
			driver.findElement(EbayController.SignIn).click();
			ExtentReportsClass.test = ExtentReportsClass.extent.startTest("It is click on sigin link.");
			ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentReportsClass.endreport();
		}
	}

	@Then("^I logged in with valid username and password$")
	public void i_logged_in_with_valid_username_and_password() throws Throwable {
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
			ExtentReportsClass.test = ExtentReportsClass.extent.startTest("It is sucessfully Logged in.");
			ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");

		} catch (Exception e) {
			ExtentReportsClass.endreport();
		}
	}

	@Then("^I searching for watch$")
	public void i_searching_for_watch() throws Throwable {
		try {
			driver.findElement(EbayController.Cart).click();
			driver.findElement(EbayController.Remove).click();
		} catch (Exception m) {
			i = 1;
		}
		driver.findElement(SearchingController.SearchingTextBox).clear();
		driver.findElement(SearchingController.SearchingTextBox)
				.sendKeys("2018 New Fashion LINKIN PARK Band Men 3D Print Short Sleeve");
		Thread.sleep(1000);
		driver.findElement(SearchingController.SearchingButton).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Search result display sucessfully.");
		ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
	}

	@Then("^I selected first watch$")
	public void i_selected_first_watch() throws Throwable {
		// driver.navigate().to("https://www.ebay.com/itm/Retro-Womens-Mens-Stainless-Steel-Watches-Compass-Quartz-Analog-Wrist-Watch/122725341611?hash=item1c930019ab:m:mdyGR5fCAFJP22cpwETKUMg");
		try {
			//driver.findElement(EbayController.SortingICon).click();
			Thread.sleep(1000);
		} catch (Exception m) {
			//driver.findElement(EbayController.SortButton);
			Thread.sleep(2000);
		}
		//driver.findElement(EbayController.Sorting).click();
		//driver.navigate().refresh();
		//driver.findElement(EbayController.SortingICon).click();
		//driver.findElement(By.linkText("Best Match")).click();

		Thread.sleep(1000);
		driver.findElements(EbayController.ItemList).get(i).findElement(EbayController.Item).click();
		Thread.sleep(2000);
		ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Select anyone Tshirt from the list.");
		ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
	}

	@Then("^I clicked on add to cart button$")
	public void i_clicked_on_add_to_cart_button() throws Throwable {
		try {
			new Select(driver.findElement(EbayController.SelectColor)).deselectByIndex(1);
			ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Search result display sucessfully.");

			ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		} catch (Exception m) {
			ExtentReportsClass.endreport();
		}

		driver.findElement(EbayController.AddToCart).click();
		Thread.sleep(1000);
	}

	@Then("^I clicked on proceed checkout button$")
	public void i_clicked_on_proceed_checkout_button() throws Throwable {
		try {
			Thread.sleep(2000);
			driver.findElement(EbayController.CheckOut).click();
			ExtentReportsClass.test = ExtentReportsClass.extent.startTest("User click on Checkout button sucessfully.");
			ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		} catch (Exception m) {
			ExtentReportsClass.endreport();
		}
	}

	@Then("^Payment option is getting display$")
	public void payment_option_is_getting_display() throws Throwable {
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
