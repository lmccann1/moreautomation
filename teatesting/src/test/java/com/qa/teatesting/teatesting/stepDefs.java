package com.qa.teatesting.teatesting;
import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefs {
 WebDriver driver;
	//static String URL1;
	static String URL1;
	static String URL2;
	public ExtentReports report;
	public ExtentTest test;
	
	@Before
	public void setup(){
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\AutomationReports\\TeaTest.html", true); 
		test = report.startTest("TeaTesting"); 
		test.log(LogStatus.INFO, "Started");
		
		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Given("^the correct web address$")
	public void the_correct_web_address()  {
	    // Write code here that turns the phrase above into concrete actions
		test.log(LogStatus.INFO, "Correct Web Address");
		driver.get("http://www.practiceselenium.com/welcome.html");
		//assertTrue(!Constants.URL1==driver.getCurrentUrl());
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page()  {
	    // Write code here that turns the phrase above into concrete actions
		test.log(LogStatus.INFO, "Nav to Menu");
		MenuPage page = PageFactory.initElements(driver, MenuPage.class);
		page.clickMenu(driver);		
		
		//String text = x.getText();
	}
	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products()  {
		if(Constants.URL1==driver.getCurrentUrl()){
			test.log(LogStatus.PASS, "Browse");
		}
		else{
			test.log(LogStatus.FAIL, "not able to Browse");
		}
		
	    // Write code here that turns the phrase above into concrete actions
		//driver.get("http://www.practiceselenium.com/menu.html");
		//URL1 = driver.getCurrentUrl();
		
		assertTrue(!Constants.URL1.equals(driver.getCurrentUrl()));
		
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button(){
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://www.practiceselenium.com/menu.html");
		checkout page = PageFactory.initElements(driver, checkout.class);
		//WebElement x = driver.findElement(By.id("wsb-button-00000000-0000-0000-0000-000451959280"));
		//Actions act = new Actions (driver);
		//act.moveToElement(x).click().perform();
		page.clickCheckout(driver);
		test.log(LogStatus.INFO, "checkout");
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() {
	    // Write code here that turns the phrase above into concrete actions
	//	URL2 = driver.getCurrentUrl();
		
		if(Constants.URL2==driver.getCurrentUrl()){
		test.log(LogStatus.PASS, "taken to checkout");
		}
		else{
		test.log(LogStatus.FAIL, "not taken to checkout");
		}
	
		assertTrue(!Constants.URL2.equals(driver.getCurrentUrl()));

	}
	@After
	public void teardown(){
		driver.quit();
		report.endTest(test);		
		report.flush();
		
	}

	

}
