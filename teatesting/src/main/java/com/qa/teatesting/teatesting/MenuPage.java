package com.qa.teatesting.teatesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
public class MenuPage {
	@FindBy(id = "wsb-nav-00000000-0000-0000-0000-000450914915")
	private WebElement MenuButton;
	
	public void clickMenu(WebDriver driver) {
	//	WebElement x = driver.findElement(By.id("wsb-nav-00000000-0000-0000-0000-000450914915"));
		//Actions act = new Actions (driver);
		//act.moveToElement(x).click().perform();
		MenuButton.click();
		
		
	

	}

}
