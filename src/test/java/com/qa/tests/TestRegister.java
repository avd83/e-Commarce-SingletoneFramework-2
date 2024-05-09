package com.qa.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.base.PageDriver;
import com.qa.pages.HomePage;
import com.qa.pages.RegisterPage;

public class TestRegister extends BaseTest {

	WebDriver driver;
	HomePage homePage;
	RegisterPage regPage;
	
	public void Initialization() {
		
		driver=PageDriver.getInstance().getDriver();
		homePage = new HomePage();
		regPage = new RegisterPage();
	}
	
	@Test(priority=1)
	public void verifyRegisterPageTitle() throws InterruptedException {
		
		Initialization();
		homePage.getClickMyAccountLink();
		Thread.sleep(2000);
		String regPageTitle = regPage.getRegisterPageTitle();
		System.out.println("The Register page title is : " + regPageTitle);
		Assert.assertEquals(regPageTitle, "Register Account");
	}
	
	@Test(priority=2)
	public void verifyRegisterPageName() throws InterruptedException {
		
		Initialization();
		homePage.getClickMyAccountLink();
		Thread.sleep(2000);
		String regPageName = regPage.getRegisaterPageName();
		System.out.println("The Register page name is : " + regPageName);
		Assert.assertEquals(regPageName, "Register Account");
	}
	
	@Test(priority=3)
	public void verifyCreateRegisterUser() throws InterruptedException {
		
		Initialization();
		homePage.getClickMyAccountLink();
		Thread.sleep(2000);
		regPage.getFillRegPageData();
		Thread.sleep(2000);		
		String validtionErrorMssg = regPage.getErrorValidationMssg();		
		System.out.println(validtionErrorMssg);		
		Assert.assertEquals(validtionErrorMssg,"Warning: E-Mail Address is already registered!");
		
		String validationMessage = regPage.getValidationMsg();
		System.out.println(validationMessage);		
		Assert.assertEquals(validationMessage,"Your Account Has Been Created!");
	}
	
}

