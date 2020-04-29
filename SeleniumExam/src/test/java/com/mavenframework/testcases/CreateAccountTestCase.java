package com.mavenframework.testcases;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import com.maveframework.pages.BaseClass;
import com.maveframework.pages.CreateAccountPage;
import com.maveframework.pages.LoginPage;
import com.mavenframework.utility.ConstantClass;
import com.mavenframework.utility.ExcelUtils;

public class CreateAccountTestCase extends BaseClass {

	WebDriver driver;
	
	
	@Test(priority = 1)
	public void CreateAccountEmptyEmail() throws Exception {
		logger=	report.createTest("Create Account with Empty Email Address");
		logger.info("Starting Application");
	//	System.out.println(driver.getTitle());
		CreateAccountPage createAccount = PageFactory.initElements(BaseClass.driver, CreateAccountPage.class);
		createAccount.EmptyEmailCreateAccount();
		logger.pass("Creating Account is not Sucessful");
	
	}
	
	@Test(priority = 2)
	public void CreateAccountInvalidEmail() throws Exception { 
		logger=	report.createTest("Create Account with Invalid Email");
		logger.info("Create account with Invalid Account");
		String getCurrentURL = BaseClass.driver.getCurrentUrl();
	//	System.out.println(driver.getTitle());
		BaseClass.driver.get(getCurrentURL);
		CreateAccountPage createAccount = PageFactory.initElements(BaseClass.driver, CreateAccountPage.class);
		createAccount.InvalidEmail();
		logger.pass("Creating Account is not Sucessful");
	}

	@Test(priority = 3)
	public void CreateAccountEmptyPassword() throws Exception { 
		logger=	report.createTest("Create Account with Empty Password");
		logger.info("Create account with Invalid Account");
		String getCurrentURL = BaseClass.driver.getCurrentUrl();
	//	System.out.println(driver.getTitle());
		BaseClass.driver.get(getCurrentURL);
		CreateAccountPage createAccount = PageFactory.initElements(BaseClass.driver, CreateAccountPage.class);
		createAccount.CreateAccountEmptyPassword();
		logger.pass("Creating Account is not Sucessful");
	}
	@Test(priority = 4)
	public void CreateAccountInvalidZipcode() throws Exception { 
		logger=	report.createTest("Create Account with Invalid Zipcode");
		logger.info("Create account with Invalid Account");
		String getCurrentURL = BaseClass.driver.getCurrentUrl();
	//	System.out.println(driver.getTitle());
		BaseClass.driver.get(getCurrentURL);
		CreateAccountPage createAccount = PageFactory.initElements(BaseClass.driver, CreateAccountPage.class);
		createAccount.CreateAccountInvalidZipCode();
		logger.pass("Creating Account is not Sucessful");
	}
	 
	@Test(priority = 5)
	public void CrateAccountValidAccount() throws Exception { 
		logger=	report.createTest("Create Account with Details");
		logger.info("Create account with Invalid Account");
		String getCurrentURL = BaseClass.driver.getCurrentUrl();
	//	System.out.println(driver.getTitle());
		BaseClass.driver.get(getCurrentURL);
		CreateAccountPage createAccount = PageFactory.initElements(BaseClass.driver, CreateAccountPage.class);
		createAccount.CreateAccountValidAccount();
		logger.pass("Creating Account is Sucessful");
	}
}
