package com.travelDemo.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.travelDemo.util.TestUtil;

public class TestBase {
		
		public WebDriver driver;
		public Properties prop;
		
		public TestBase() {
			prop = new Properties();
			FileInputStream fis;
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\travelDemo\\config\\config.properties");
				prop.load(fis);
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		public void initializeDriver() throws IOException
		{
			
			
			String browserName = prop.getProperty("browser");
			System.out.println("Initializing the driver");
			if(browserName.contains("chrome")) 
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(browserName.contains("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
			
			driver.get(prop.getProperty("url"));
			
		}
		
		public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException 
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
			FileUtils.copyFile(source, new File(destinationFile));
			return destinationFile;
			
		}
			
		
		
		



}
