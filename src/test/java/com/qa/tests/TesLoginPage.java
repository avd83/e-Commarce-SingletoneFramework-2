package com.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.base.BaseTest;
import com.qa.base.PageDriver;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.RegisterPage;

public class TesLoginPage extends BaseTest {

	WebDriver driver;
	HomePage homePage;
	RegisterPage regPage;
	LoginPage loginPage;

	public void Initialization() {

		driver = PageDriver.getInstance().getDriver();
		homePage = new HomePage();
		regPage = new RegisterPage();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitle() throws InterruptedException {
		Initialization();
		homePage.getClickLoginLink();
		String loginPageTitle = loginPage.getLoginPageTitle();
		System.out.println("The login page title is : " + loginPageTitle);
		Assert.assertEquals(loginPageTitle, "Account Login");		
	}
	
	@Test(priority=2)
	public void verifyValidLogin() throws InterruptedException {
		
		Initialization();
		homePage.getClickLoginLink();
		Thread.sleep(3000);
		loginPage.getValidLogin();
		Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void verifyInvalidLogin() throws InterruptedException {
		
		Initialization();
		homePage.getClickLoginLink();
		Thread.sleep(3000);
		loginPage.getInValidLogin();
		Thread.sleep(3000);
		String inValidErrorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		System.out.println("The invalid login validation message is : " + inValidErrorMessage);
		Assert.assertEquals(inValidErrorMessage,"Warning: No match for E-Mail Address and/or Password.");
	}	

}
