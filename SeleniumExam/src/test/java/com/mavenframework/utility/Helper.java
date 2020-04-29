package com.mavenframework.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.maveframework.pages.BaseClass;

public class Helper {

	public static String ScreenShot() {
		
		File src = ((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.FILE);
		
		String screenshotPath =  System.getProperty("user.dir") + "/Screenshot/"+"Screenshot"+Helper.GetCurrentDateTime()+".png";
		  
		
		try {
			FileHandler.copy(src, new File(screenshotPath));
		} catch (IOException e) {
			
			System.out.print("Unable to take Screenshot" + e.getMessage());
		}
		return screenshotPath;
	}
	

 public static String GetCurrentDateTime() {
	 
	 DateFormat Customformat = new SimpleDateFormat("MM_dd_yy_HH_mm_ss");
	 
	 Date currentdate = new Date();
	 
	 return Customformat.format(currentdate);
	 
 }
	
}
