package com.travelDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.travelDemo.base.TestBase;

public class LoginPage extends TestBase {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//System.out.println("Driver is initialized");
	}
	
	@FindBy(name = "first_name")
	WebElement first_name;
	
	@FindBy(name = "last_name")
	WebElement last_name;
	
	@FindBy(name = "business_name")
	WebElement business_name;
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(id ="demo")
	WebElement submit;
	
	
	public void setFirstName(String firstName) {
		 first_name.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		last_name.sendKeys(lastName);
	}
	
	public void setbusinessName(String businessName) {
		business_name.sendKeys(businessName);
	}
	
	public void setemail(String email) {
		this.email.sendKeys(email);
	}
	public void clickOnSubmit()
	{
		submit.click();
	}

		
}
