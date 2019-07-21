package com.ebay.qa.util;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ebay.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static void Click(By selector)
	{
		WebElement element = driver.findElement(selector);
		element.click();
	}
	
	public static void Type(By selector, String setValue)
	{
		WebElement element = driver.findElement(selector);
		element.sendKeys(setValue);
	}
	
	public static void ClearField(By selector)
	{
		WebElement element = driver.findElement(selector);
		element.clear();
	}
	
	public static void GetText(By selector)
	{
		WebElement element = driver.findElement(selector);
		element.getText();
	}
	
	public static void ExplicitWait(By selector, int x)
	{
		WebDriverWait wait = new WebDriverWait(driver, x);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(selector)));
	}
	
	public static void SwicthWindow()
	{
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		String parentWindow = it.next();
		System.out.println("Parent Window ID = " + parentWindow);
		System.out.println("Parent Window Title = " + driver.getTitle());
		
		String childWindow = it.next();
		System.out.println("Child Window ID = " + childWindow);
		
		driver.switchTo().window(childWindow);
		
		System.out.println("Child Window Title = " + driver.getTitle());
		
	}
	
	
	

	
	
	
	
	
	
	
	
}
