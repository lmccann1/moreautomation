package com.qa.teatesting.teatesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkout {
	@FindBy(id = "wsb-button-00000000-0000-0000-0000-000451959280")
	private WebElement CheckButton;
	
	public void clickCheckout(WebDriver driver) {
		
		CheckButton.click();
		//MenuButton.click();

	}

}
