package com.maveframework.pages;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mavenframework.utility.BrowserFactory;
import com.mavenframework.utility.ConfigDataProvider;
import com.mavenframework.utility.ExcelDataProvider;
import com.mavenframework.utility.Helper;

public class BaseClass {

	public static WebDriver driver;

	public ExcelDataProvider excel;

	public ConfigDataProvider config;

	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void SetUpSuite() {
		Reporter.log("Setting up Extent Report", true);

		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Report/Extent" + Helper.GetCurrentDateTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
 
	@BeforeClass
	public void Setup() {
		Reporter.log("Browser Application is starting", true);
		driver = BrowserFactory.StartApplication(driver, config.GetBrowser(), config.GetLegoURL());
		Reporter.log("Browser Application is Running", true);
	}

	@AfterClass
	public void TearDown() {
		Reporter.log("Clossing the Browser Driver");
		BrowserFactory.DriverQuit(driver);
		Reporter.log("Browser Driver is Closed", true);
		
	}

	@AfterMethod
	public void TearDownMethod(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {

			Helper.ScreenShot();
//		logger.fail("Login Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.ScreenShot(driver)).build());
			logger.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.ScreenShot()).build());

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			logger.pass("Test Success",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.ScreenShot()).build());

		} else if (result.getStatus() == ITestResult.SKIP) {

			logger.skip("Test Skip", MediaEntityBuilder.createScreenCaptureFromPath(Helper.ScreenShot()).build());

		}
		report.flush();
		Reporter.log("Test is Completed", true);
		
	}

}
