package com.travelDemo.testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.travelDemo.base.TestBase;
import com.travelDemo.pageObjects.LoginPage;
import com.travelDemo.util.XLUtils;

public class TC_LoginTest_001 extends TestBase{
	@BeforeMethod
	public void initialize() throws IOException
	{
		 initializeDriver();
		 System.out.println("Driver is initialized");
	}
	
	@Test(dataProvider ="LoginData")
	public void loginTest(String fname,String lname, String bname, String email) throws InterruptedException {
		System.out.println("Inside login data");
		
		LoginPage lp = new LoginPage(driver);
		System.out.println(fname);
		lp.setFirstName(fname);
		System.out.println("LASTNAME"+lname);
		lp.setLastName(lname);
		lp.setbusinessName(bname);
		lp.setemail(email);
		
		//Thread.sleep(15000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("demo"))));
		
		lp.clickOnSubmit();
		
		
		if(isAlertPresent() == true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			System.out.println("Registration failed");
		}
		else
		{
			Assert.assertTrue(true);
			System.out.println("REgistration success");
		}
		
	}
	public boolean isAlertPresent() throws InterruptedException //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}	
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\com\\travelDemo\\testData\\LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "loginData");
		int columnnum = XLUtils.getCellCount(path, "loginData", 1);
		
		String logindata[][]=new String[rownum][columnnum];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<columnnum;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"loginData", i,j);//1 0
			}
				
		}
	return logindata;
	}
	@AfterMethod
	public void teardown() throws IOException
	{
		 driver.close();
		 System.out.println("Driver is closed");
	}
	
		
	}
	


