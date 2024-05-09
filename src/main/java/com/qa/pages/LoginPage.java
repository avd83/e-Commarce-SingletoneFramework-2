package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.base.PageDriver;

public class LoginPage extends BaseTest{
	
	WebDriver driver;
	
	public LoginPage(){
		
		driver = PageDriver.getInstance().getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css="input[id=input-email]")
	WebElement emailId;	

	@FindBy (css="input[id=input-password]")
	WebElement password;
	
	@FindBy (css="input[value=Login]")
	WebElement loginBtn;
	
	//@FindBy (xpath="//div[@class='alert alert-danger alert-dismissible']")
	//WebElement inValidLoginErrorMsg;
	
	public String getLoginPageTitle() {
		
		return driver.getTitle();
	}
	
	public MyAccountPage getValidLogin() {
		emailId.sendKeys(prop.getProperty("validUser"));
		password.sendKeys(prop.getProperty("validPassword"));
		loginBtn.click();	
		return new MyAccountPage();
	}
	
	public void getInValidLogin() {
		emailId.sendKeys(prop.getProperty("inValidUser"));
		password.sendKeys(prop.getProperty("inValidPassword"));
		loginBtn.click();	
	}	
}
