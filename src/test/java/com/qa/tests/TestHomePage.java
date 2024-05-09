package com.qa.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.base.PageDriver;
import com.qa.pages.HomePage;

public class TestHomePage extends BaseTest {
	
	WebDriver driver;
	HomePage homePage;
	
	public void Initialization() {
		
		driver=PageDriver.getInstance().getDriver();
		homePage = new HomePage();		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() throws InterruptedException {
		Initialization();
		Thread.sleep(2000);
		String homePageTitle = homePage.getHomePageTitle();
		System.out.println("The title of the Home page is :"+ homePageTitle);
		Assert.assertEquals(homePageTitle, "Your Store");
	}
	
	@Test(priority=2)
	public void verifyHomePageLogo() throws InterruptedException {		
		Initialization();
		Thread.sleep(2000);
		String logo = homePage.getLogoName();
		System.out.println("The logo of the Home page is :"+ logo);
		Assert.assertEquals(logo, "Qafox.com");
	}
	
	@Test(priority=3)
	public void verifyMyAccountLink() throws InterruptedException {
		Initialization();
		Thread.sleep(2000);
		homePage.getClickMyAccountLink();
	}
}
