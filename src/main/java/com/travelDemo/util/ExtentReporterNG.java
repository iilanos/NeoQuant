package com.travelDemo.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	 public static ExtentReports extent;
	
	
	public static  ExtentReports getReportObject() {
		//extendReoprter ExtentSparkReporter
		//getting the path for report generation
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Test");
		reporter.config().setDocumentTitle("Test Report");
		
		 extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sonali");
		
		return extent;
	}
	
	
	

}
