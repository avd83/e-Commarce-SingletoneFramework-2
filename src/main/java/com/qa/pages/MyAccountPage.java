package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.base.PageDriver;

public class MyAccountPage extends BaseTest {
	
	WebDriver driver;
	
	public MyAccountPage() {
		
		driver= PageDriver.getInstance().getDriver();
		PageFactory.initElements(driver, this);
	}
	
	
	

}
