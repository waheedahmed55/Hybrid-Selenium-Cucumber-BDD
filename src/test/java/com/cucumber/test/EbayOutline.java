package com.cucumber.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.pom.LoginController;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EbayOutline {
	WebDriver driver;

	@Given("^User is at the Home Page$")
	public void user_is_at_the_Home_Page() throws Throwable {
		Path currentRelativePath = Paths.get("");
		String pathToDriver = currentRelativePath.toAbsolutePath().toString() + File.separator + "DriverEXE"
				+ File.separator;
		System.setProperty("webdriver.gecko.driver", pathToDriver + "geckodriver.exe");
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		dc.setCapability("marionette", false);

		//driver = new FirefoxDriver(dc);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.ebay.com/");
		Thread.sleep(1000);
	}

	@Given("^Navigate to LogIn Page$")
	public void navigate_to_LogIn_Page() throws Throwable {
		driver.findElement(By.linkText("Sign in")).click();
	}

	@When("^User enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enter_and(String username, String pwd) throws Throwable {
		driver.findElement(LoginController.Username).clear();
		driver.findElement(LoginController.Username).sendKeys(username);
		driver.findElement(LoginController.Password).clear();
		driver.findElement(LoginController.Password).sendKeys(pwd);

	}

	@When("^Click on the LogIn button$")
	public void click_on_the_LogIn_button() throws Throwable {
		driver.findElement(LoginController.Signin).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Then("^login should be unsuccessful$")
	public void login_should_be_unsuccessful() throws Throwable {

		if (driver.findElement(LoginController.Signin).isDisplayed()) {
			System.out.println("Invalid Login");
			takeScreenshot();
		} else {
			System.out.println("Login Successfully");
		}
		driver.quit();
	}

	public void takeScreenshot() throws IOException {
		 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		    Date now = new Date();
		    String strDate = sdfDate.format(now);
		Path currentRelativePath = Paths.get("");
		String path = currentRelativePath.toAbsolutePath().toString() + File.separator + "FailedScreenShot"
				+ File.separator;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(path+"screenshot_"+strDate+".png"));

	}

}
