package com.ebay.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.utils.FileUtil;
import com.ebay.qa.base.TestBase;

public class TestScreenShot extends TestBase{
	
	public static void TakeScreenShot(String errorShot) throws Exception
	{
		try
		{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyDirectory(src, new File("./ErrorScreenShots/"+errorShot+".png"));
		System.out.println("ScreenShot was taken");
		
		}
		
		catch(Exception e)
		{
			System.out.println("Error while taking a screenshot = " + e.getMessage());
		}
	
		
		}

}
