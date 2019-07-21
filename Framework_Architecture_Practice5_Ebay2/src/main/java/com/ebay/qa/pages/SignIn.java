package com.ebay.qa.pages;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ebay.qa.util.TestUtil;

import junit.framework.Assert;

public class SignIn extends TestUtil{
	
	/*Test teh follwing Test Scenerios:
	1. Correct Email and Password
	2. Correct Email and wrong password 
	3. Wrong Email and Correct password
	4. Wrong Email and Wrong Password 
	5. Leave Both columns blank 
	6. Leave Email Column Blank 
	7. Leave Password Column Blank
	8. Enter invalid characters in the email field 
	*/
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extents;
	
	
	@BeforeSuite
	public static void ExtentReport()
	{
		htmlReporter = new ExtentHtmlReporter("./ExtentReports/EbaySignInReport.html;");
		extents = new ExtentReports();
		extents.attachReporter(htmlReporter);
	}
	
	@Test(priority = 0)
	public static void CorrectEmailPass()
	{
		ExtentTest CorrectEmailPassTest = extents.createTest("Testing CorrectSignIn Functionality");
		CorrectEmailPassTest.log(Status.INFO, "Starting Test Case");
		
		Click(By.id("gh-ug"));
		CorrectEmailPassTest.log(Status.PASS, "Clicking on sign in button");
		
		
		Type(By.id("userid"), prop.getProperty("username"));
		CorrectEmailPassTest.log(Status.PASS, "Entered Correct Email ID");
		
		Type(By.cssSelector("input[id='pass']"), prop.getProperty("password"));
		CorrectEmailPassTest.log(Status.FAIL, "Entered correct Pass ID");
		
		Click(By.id("sgnBt"));
		CorrectEmailPassTest.log(Status.PASS, "Click on Sign In button");
		
	
		
	}
	
	//@Test(priority = 1)
	public static void CorrectEmailWrongPass()
	{
		//Click(By.id("gh-ug"));
		Type(By.id("userid"), prop.getProperty("username"));
		Type(By.cssSelector("input[id='pass']"), prop.getProperty("wrongPassword"));
		Click(By.id("sgnBt"));
		String errorMsg = driver.findElement(By.className("inline-notice__content")).getText();
		System.out.println("Error Message = " + errorMsg);
		Assert.assertEquals("Oops, that's not a match.", errorMsg);
	}
	
	@AfterSuite
	public static void TearDown()
	{
		extents.flush();
	}
	
}
