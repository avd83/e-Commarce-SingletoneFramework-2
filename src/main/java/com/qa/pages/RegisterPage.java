package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.base.PageDriver;

public class RegisterPage extends BaseTest {
	
	WebDriver driver;	
	public RegisterPage(){
		
		driver = PageDriver.getInstance().getDriver();
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy (xpath="//h1[text()='Register Account']")
	WebElement registerPageName;
	
	@FindBy (css="input[id=input-lastname]")
	WebElement laststName;
	
	@FindBy (css="input[id=input-firstname]")
	WebElement firstName;
	
	@FindBy (css="input[id=input-email]")
	WebElement email;
	
	@FindBy (css="input[id=input-telephone]")
	WebElement telephone;
	
	@FindBy (css="input[id=input-password]")
	WebElement password;
	
	@FindBy (css="input[id=input-confirm]")
	WebElement confirmPassword;
	
	@FindBy (css="input[name='agree']")
	WebElement privacyChkBox;
	
	@FindBy (css="input[value='Continue']")
	WebElement continueBtn;
	
	@FindBy (xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement validationMsg;
	
	@FindBy (xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement validationErrorMsg;
	
	public String getRegisterPageTitle() {		
		return driver.getTitle();
	}	
	
	public String getRegisaterPageName() {
		
		String regPageName = registerPageName.getText();		
		return regPageName;
	}
	
	public void getFillRegPageData() throws InterruptedException {
		firstName.sendKeys("abc");
		laststName.sendKeys("xyz");
		email.sendKeys("abc@gmail.com");
		telephone.sendKeys("987876787");
		password.sendKeys("123d");
		confirmPassword.sendKeys("123d");
		privacyChkBox.click();
		continueBtn.click();
		Thread.sleep(4000);
	}
	
	public String getValidationMsg(){
		
		String ValidationMssg = validationMsg.getText();
		return ValidationMssg;
	}
	
	public String getErrorValidationMssg() throws InterruptedException {
		Thread.sleep(5000);
		String validtionErrorMsg = validationErrorMsg.getText();
		return validtionErrorMsg;
		
	}
}
