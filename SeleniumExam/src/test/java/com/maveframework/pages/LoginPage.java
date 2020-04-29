package com.maveframework.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.beust.jcommander.internal.Console;
import com.mavenframework.extensions.DriverExtension;
import com.mavenframework.utility.ConstantClass;
import com.mavenframework.utility.ExcelUtils;

public class LoginPage extends DriverExtension {

	WebDriver driver;

	public LoginPage(WebDriver driverLogin) {
		super(driverLogin);

	}

	@FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
	WebElement SignInLandingPage;
	@FindBy(css = ".#page > div.columns-container")
	WebElement DashBoard;
	@FindBy(css = "#email")
	WebElement Email;
	@FindBy(css = "#passwd")
	WebElement Password;
	@FindBy(css = "#center_column > div.alert.alert-danger")
	WebElement Alert;
	@FindBy(css = "#SubmitLogin")
	WebElement SignButton;
	@FindBy(css = "#header > div.nav > div > div > nav > div:nth-child(1) > a > span") 	WebElement AccountName;

	
	public void LoginToAutomatinPractice() {
		waitForPageLoaded();
		HighLightElement(SignInLandingPage, 1);
		SignInLandingPage.click();
		waitForElement(Email);
		HighLightElement(Email, 1);
		waitForElement(Password);
		HighLightElement(Password, 1);
		waitForElement(SignButton);
		HighLightElement(SignButton, 1);

	}

	public void EmptyField() {

		Email.sendKeys("");
		Password.sendKeys("");
		SignButton.click();

	}

	public void ErrorAlertMessage() {
		waitForPageLoaded();
		String ExpectedText = "There is 2 error";

		String ActualTextAlert = Alert.getText();
		waitForPageLoaded();
		waitForElement(Alert);
		HighLightElement(Alert, 1);
		System.out.println(ActualTextAlert);
		Assert.assertTrue(ActualTextAlert.contains(ExpectedText));

	}

	public void InvalidEmailFormat() throws Exception {

		ExcelUtils.setExcelFile(ConstantClass.Path_TestData + ConstantClass.File_TestData, "Invalid Credentials");
		
		String EmailText = ExcelUtils.getCellData(1, 1);
		String PasswordText = ExcelUtils.getCellData(1, 2);
		
		System.out.println("Invalid Email Format " + EmailText );
		System.out.println("Invalid Email Format " + PasswordText );
		
		String ExpectedText = "There is 1 error";

		String ActualTextAlert = Alert.getText();
		Email.clear();
		Password.clear();
		Email.sendKeys(EmailText);
		Password.sendKeys(PasswordText);
		HighLightElement(Email, 1);
		SignButton.click();
		HighLightElement(Alert, 1);
		Assert.assertTrue(ActualTextAlert.contains(ExpectedText));
		
	}

	public void NonRegisteredLogin() throws Exception {
		ExcelUtils.setExcelFile(ConstantClass.Path_TestData + ConstantClass.File_TestData, "Invalid Credentials");
		
		String EmailText = ExcelUtils.getCellData(4, 1);
		String PasswordText = ExcelUtils.getCellData(4, 2);
		
		System.out.println("Non Reg " + EmailText );
		System.out.println("Non Reg " + PasswordText );
		
		
		String ExpectedText = "There is 1 error";
		String ActualTextAlert = Alert.getText();
		
		Email.clear();
		Password.clear();;
		HighLightElement(Email, 1);
		Email.sendKeys(EmailText);
		HighLightElement(Email, 1);
		Password.sendKeys(PasswordText);
		HighLightElement(Password, 1);
		SignButton.click();
		HighLightElement(Alert, 1);
		Assert.assertTrue(ActualTextAlert.contains(ExpectedText));
		
	}
	
	public void RegisteredAccountInvalidCred() throws Exception {
		ExcelUtils.setExcelFile(ConstantClass.Path_TestData + ConstantClass.File_TestData, "Invalid Credentials");
		String ExpectedText = "There is 1 error";
		String ActualTextAlert = Alert.getText();
		
		String EmailText = ExcelUtils.getCellData(5, 1);
		String PasswordText = ExcelUtils.getCellData(5, 2);
		System.out.println("RegisteredAccountInvalidCred " + EmailText );
		System.out.println("RegisteredAccountInvalidCred " + PasswordText );
		
		Email.clear();
		Password.clear();
		HighLightElement(Email, 1);
		Email.sendKeys(EmailText);
		HighLightElement(Email, 1);
		Password.sendKeys(PasswordText);
		HighLightElement(Password, 1);
		SignButton.click();
		HighLightElement(Alert, 1);
		Assert.assertTrue(ActualTextAlert.contains(ExpectedText));
	}
	
public void RegisteredValidCred() throws Exception {
	ExcelUtils.setExcelFile(ConstantClass.Path_TestData + ConstantClass.File_TestData, "LoginCredentials");
	String EmailText = ExcelUtils.getCellData(1, 1);
	String PasswordText = ExcelUtils.getCellData(1, 2);
	String Expected = "Christle Jude Ayop";
	
	Email.clear();
	Password.clear();
	
	HighLightElement(Email, 1);
	Email.sendKeys(EmailText);
	HighLightElement(Email, 1);
	Password.sendKeys(PasswordText);
	HighLightElement(Password, 1);
	SignButton.click();
	waitForPageLoaded();
	String Actual = AccountName.getText();
	HighLightElement(AccountName, 1);
	Assert.assertEquals(Actual, Expected);
	
	}
	
}
