package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.base.PageDriver;


public class HomePage extends BaseTest {
	
	WebDriver driver;
	
	public HomePage(){
		
		driver = PageDriver.getInstance().getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//a[text()='Qafox.com']")
	WebElement logoName;
	
	@FindBy (css = "span[class='caret']")
	WebElement myAccountLink;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement registerLink;
	
	@FindBy(xpath="//li//ul//li//a[text()='Login']")
	WebElement loginLink;
	
	public String getHomePageTitle() {		
		String homePageTitle = driver.getTitle();
		return homePageTitle;
	}
	
	public String getLogoName() {		
		String logo = logoName.getText();
		return logo;
	}
	public RegisterPage getClickMyAccountLink() throws InterruptedException {
		myAccountLink.click();
		Thread.sleep(2000);
		registerLink.click();
		return new RegisterPage();
	}
	
	public LoginPage getClickLoginLink() throws InterruptedException {
		myAccountLink.click();
		Thread.sleep(2000);
		loginLink.click();
		return new LoginPage();
		
	}
	
}
