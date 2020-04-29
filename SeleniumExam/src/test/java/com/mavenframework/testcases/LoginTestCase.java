package com.mavenframework.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.maveframework.pages.BaseClass;
import com.maveframework.pages.LoginPage;
import com.mavenframework.utility.BrowserFactory;
import com.mavenframework.utility.ExcelDataProvider;
import com.mavenframework.utility.Helper;

public class LoginTestCase extends BaseClass {

	@Test(priority = 1)
	public void Login() {

		logger = report.createTest("Login with Empty Fields");

		System.out.println(driver.getTitle());
		LoginPage login = PageFactory.initElements(BaseClass.driver, LoginPage.class);
		logger.info("Starting Application");
		login.LoginToAutomatinPractice();
		login.EmptyField();
		login.ErrorAlertMessage();
		logger.pass("Login is not Successful");
	}

	@Test(priority = 2)
	public void LoginWithInvalidEmailFormat() throws Exception {
		logger = report.createTest("Login with Invalid Email Format");
		System.out.println(driver.getTitle());
		LoginPage login = PageFactory.initElements(BaseClass.driver, LoginPage.class);
		login.InvalidEmailFormat();
		logger.pass("Login is not Successful");
	}

	@Test(priority = 3)
	public void LoginWithInvalidCredentials() throws Exception {

		logger = report.createTest("Login with Invalid Credentials");

		System.out.println(driver.getTitle());

		LoginPage login = PageFactory.initElements(BaseClass.driver, LoginPage.class);

		login.RegisteredAccountInvalidCred();
		logger.pass("Login is not Successful");
	}

	@Test(priority = 4)
	public void NonRegisteredLogin() throws Exception {
		logger = report.createTest("Login with Non Registered User");
		
		System.out.println(driver.getTitle());
		LoginPage login = PageFactory.initElements(BaseClass.driver, LoginPage.class);
		login.NonRegisteredLogin();
		logger.pass("Login is not Successful");
				
	}
	
	@Test(priority = 5)
	public void LoginWithValidCredentials() throws Exception {
		logger = report.createTest("Login with Valid Credentials");

		System.out.println(driver.getTitle());

		LoginPage login = PageFactory.initElements(BaseClass.driver, LoginPage.class);
		login.RegisteredValidCred();
		logger.pass("Login Successfuly");
	}

}
