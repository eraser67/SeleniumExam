package com.maveframework.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mavenframework.extensions.DriverExtension;
import com.mavenframework.utility.ConstantClass;
import com.mavenframework.utility.ExcelDataProvider;
import com.mavenframework.utility.ExcelUtils;

import freemarker.cache.MruCacheStorage;

public class CreateAccountPage extends DriverExtension {

	WebDriver driver;

	public CreateAccountPage(WebDriver CreateAccount) {
		super(CreateAccount);

	}

	@FindBy(css = "#email_create")
	WebElement EmailAddressTextBox;

	@FindBy(css = "#id_gender1")
	WebElement GenderMale;
	@FindBy(css = "#id_gender2")
	WebElement GenderFemale;
	@FindBy(css = "#customer_firstname")
	WebElement FirstName;
	@FindBy(css = "#customer_lastname")
	WebElement LastName;
	@FindBy(css = "#email")
	WebElement Email;
	@FindBy(css = "#passwd")
	WebElement Password;
	@FindBy(name  = "days")
	WebElement DropDownDay;
	@FindBy(css = "#months")
	WebElement DropDownMonth;
	@FindBy(css = "#years")
	WebElement DropDownYear;
	@FindBy(css = "#newsletter")
	WebElement CheckBoxNewsLetter;
	@FindBy(css = "#optin")
	WebElement CheckBoxOptIn;
	@FindBy(css = "#firstname")
	WebElement AddFirstname;
	@FindBy(css = "#city")
	WebElement City;
	@FindBy(css = "#company")
	WebElement Company;
	@FindBy(css = "#address1")
	WebElement Address1;
	@FindBy(css = "#address2")
	WebElement Address2;
	@FindBy(css = "#id_state")
	WebElement DropDownState;
	@FindBy(css = "#postcode")
	WebElement ZipCode;
	@FindBy(css = "#lastname")
	WebElement AddLasttname;
	@FindBy(css = "#id_country")
	WebElement DropDownCountry;
	@FindBy(css = "#other")
	WebElement AdditionalInfo;
	@FindBy(css = "#phone")
	WebElement HomePhone;
	@FindBy(css = "#phone_mobile")
	WebElement MobilePhone;
	@FindBy(css = "#alias")
	WebElement AliasAdd;
	@FindBy(css = "#center_column > div > p")WebElement AlertDanger;
	@FindBy(css = "#submitAccount")
	WebElement RegisterButton;
	@FindBy(css = "#SubmitCreate")
	WebElement CreateAccountButton;
	@FindBy(css = "#center_column > p")
	WebElement InfoAccountMessage;
	

	public void EmptyEmailCreateAccount() throws Exception {
		ExcelUtils.setExcelFile(ConstantClass.Path_TestData + ConstantClass.File_TestData, "Register Account");

		HighLightElement(EmailAddressTextBox, 1);
		EmailAddressTextBox.sendKeys("Testyyy@gmail.com");
		CreateAccountButton.click();
		String FirstNameText = ExcelUtils.getCellData(1, 1);
		String LastNameText = ExcelUtils.getCellData(1, 2);
		String EmailText = ExcelUtils.getCellData(1, 3);
		String PasswordText = ExcelUtils.getCellData(1, 4);
		
		String Month = ExcelUtils.getCellData(1, 6);
		
		String Year = ExcelUtils.getCellData(1, 7);
		String FirtNameAdd = ExcelUtils.getCellData(1, 8);
		String LastNameAdd = ExcelUtils.getCellData(1, 9);
		String CompanyText = ExcelUtils.getCellData(1, 10);
		String Address1Text = ExcelUtils.getCellData(1, 11);
		String Address2Text = ExcelUtils.getCellData(1, 12);
		String CityText = ExcelUtils.getCellData(1, 13);
		String StateText = ExcelUtils.getCellData(1, 14);
		String ZipCodeText = ExcelUtils.getCellData(2, 15);
		String CountryText = ExcelUtils.getCellData(1, 16);
		String AdditionalInput = ExcelUtils.getCellData(1, 17);
		String Home = ExcelUtils.getCellData(1, 18);
		String Mobile = ExcelUtils.getCellData(1, 19);
		String Alias = ExcelUtils.getCellData(1, 20);


		Select drpDay = new Select(DropDownDay);
		Select drpMonth = new Select(DropDownMonth);
		Select drpYear = new Select(DropDownYear);
		Select drpState = new Select(DropDownState);
		Select drpCountry = new Select(DropDownCountry);

		
		waitForPageLoaded();
		
		
		GenderMale.click();
		HighLightElement(GenderMale, 1);

		FirstName.clear();
		LastName.clear();
		Password.clear();
		AddFirstname.clear();
		AddLasttname.clear();
		Company.clear();
		Address1.clear();
		Address2.clear();
		City.clear();
		ZipCode.clear();
		HomePhone.clear();
		AliasAdd.clear();
	
		FirstName.sendKeys(FirstNameText);
		HighLightElement(FirstName, 1);
		LastName.sendKeys(LastNameText);
		HighLightElement(LastName, 1);
		Email.clear();
		HighLightElement(Email, 1);
		Password.sendKeys(PasswordText);
		HighLightElement(Password, 1);
		drpDay.selectByValue(ExcelUtils.getNumericData("Register Account", 1, 5));
		HighLightElement(DropDownDay, 1);
		drpMonth.selectByValue(ExcelUtils.getNumericData("Register Account", 1, 6));
		HighLightElement(DropDownMonth, 1);
		drpYear.selectByValue(ExcelUtils.getNumericData("Register Account", 1, 7));
		HighLightElement(DropDownYear, 1);
		CheckBoxNewsLetter.click();
		HighLightElement(CheckBoxNewsLetter, 1);
		CheckBoxOptIn.click();
		HighLightElement(CheckBoxOptIn, 1);
		AddFirstname.clear();
		AddFirstname.sendKeys(FirtNameAdd);		
		HighLightElement(AddFirstname, 1);
		AddLasttname.clear();
		AddLasttname.sendKeys(LastNameAdd);
		HighLightElement(AddLasttname, 1);

		Company.sendKeys(CompanyText);
		HighLightElement(Company, 1);
		Address1.sendKeys(Address1Text);
		HighLightElement(Address1, 1);
		Address2.sendKeys(Address2Text);
		HighLightElement(Address2, 1);
		City.sendKeys(CityText);
		HighLightElement(City, 1);
		drpState.selectByVisibleText(StateText);
		HighLightElement(DropDownState, 1);
		ZipCode.sendKeys(ZipCodeText);
		HomePhone.sendKeys(ExcelUtils.getNumericData("Register Account", 1, 18));
		HighLightElement(HomePhone, 1);
		MobilePhone.sendKeys(ExcelUtils.getNumericData("Register Account", 1, 19));
		HighLightElement(MobilePhone, 1);
		AliasAdd.sendKeys(Alias);
		HighLightElement(AliasAdd, 1);
		HighLightElement(RegisterButton, 1);
		RegisterButton.click();
		
		waitForPageLoaded();
	
		waitForElement(AlertDanger);
		HighLightElement(AlertDanger, 1);
		
		String Expected =  "There is 1 error";
		String Actual = AlertDanger.getText();
		
		Assert.assertEquals(Actual, Expected);

	}
	
	public void InvalidEmail() throws Exception {
		ExcelUtils.setExcelFile(ConstantClass.Path_TestData + ConstantClass.File_TestData, "Register Account");
		waitForPageLoaded();
		HighLightElement(EmailAddressTextBox, 1);
		EmailAddressTextBox.sendKeys("Testyyy@gmail.com");
		CreateAccountButton.click();
		String FirstNameText = ExcelUtils.getCellData(1, 1);
		String LastNameText = ExcelUtils.getCellData(1, 2);
		String EmailText = ExcelUtils.getCellData(2, 3);
		String PasswordText = ExcelUtils.getCellData(2, 4);
		
		String Month = ExcelUtils.getCellData(2, 6);
		
		String Year = ExcelUtils.getCellData(2, 7);
		String FirtNameAdd = ExcelUtils.getCellData(2, 8);
		String LastNameAdd = ExcelUtils.getCellData(2, 9);
		String CompanyText = ExcelUtils.getCellData(2, 10);
		String Address1Text = ExcelUtils.getCellData(2, 11);
		String Address2Text = ExcelUtils.getCellData(2, 12);
		String CityText = ExcelUtils.getCellData(2, 13);
		String StateText = ExcelUtils.getCellData(2, 14);
		String ZipCodeText = ExcelUtils.getCellData(2, 15);
		String CountryText = ExcelUtils.getCellData(2, 16);
		String AdditionalInput = ExcelUtils.getCellData(2, 17);
		String Home = ExcelUtils.getCellData(2, 18);
		String Mobile = ExcelUtils.getCellData(2, 19);
		String Alias = ExcelUtils.getCellData(2, 20);


		Select drpDay = new Select(DropDownDay);
		Select drpMonth = new Select(DropDownMonth);
		Select drpYear = new Select(DropDownYear);
		Select drpState = new Select(DropDownState);
		Select drpCountry = new Select(DropDownCountry);

		waitForPageLoaded();
		GenderMale.click();
		HighLightElement(GenderMale, 1);

		FirstName.clear();
		LastName.clear();
		Password.clear();
		AddFirstname.clear();
		AddLasttname.clear();
		Company.clear();
		Address1.clear();
		Address2.clear();
		City.clear();
		ZipCode.clear();
		HomePhone.clear();
		AliasAdd.clear();
		
		FirstName.sendKeys(FirstNameText);
		HighLightElement(FirstName, 1);
		LastName.sendKeys(LastNameText);
		HighLightElement(LastName, 1);
		Email.clear();
		Email.sendKeys(EmailText);;
		HighLightElement(Email, 1);
		Password.sendKeys(PasswordText);
		HighLightElement(Password, 1);
		drpDay.selectByValue(ExcelUtils.getNumericData("Register Account", 2, 5));
		HighLightElement(DropDownDay, 1);
		drpMonth.selectByValue(ExcelUtils.getNumericData("Register Account", 2, 6));
		HighLightElement(DropDownMonth, 1);
		drpYear.selectByValue(ExcelUtils.getNumericData("Register Account", 2, 7));
		HighLightElement(DropDownYear, 1);
		CheckBoxNewsLetter.click();
		HighLightElement(CheckBoxNewsLetter, 1);
		CheckBoxOptIn.click();
		HighLightElement(CheckBoxOptIn, 1);
		AddFirstname.clear();
		AddFirstname.sendKeys(FirtNameAdd);		
		HighLightElement(AddFirstname, 1);
		AddLasttname.clear();
		AddLasttname.sendKeys(LastNameAdd);
		HighLightElement(AddLasttname, 1);

		Company.sendKeys(CompanyText);
		HighLightElement(Company, 1);
		Address1.sendKeys(Address1Text);
		HighLightElement(Address1, 1);
		Address2.sendKeys(Address2Text);
		HighLightElement(Address2, 1);
		City.sendKeys(CityText);
		HighLightElement(City, 1);
		drpState.selectByVisibleText(StateText);
		HighLightElement(DropDownState, 1);
		ZipCode.sendKeys(ZipCodeText);
		HomePhone.sendKeys(ExcelUtils.getNumericData("Register Account", 1, 18));
		HighLightElement(HomePhone, 1);
		MobilePhone.sendKeys(ExcelUtils.getNumericData("Register Account", 1, 19));
		HighLightElement(MobilePhone, 1);
		AliasAdd.sendKeys(Alias);
		HighLightElement(AliasAdd, 1);
		HighLightElement(RegisterButton, 1);
		RegisterButton.click();
		
		waitForPageLoaded();
	
		waitForElement(AlertDanger);
		HighLightElement(AlertDanger, 1);
		
		String Expected =  "There is 1 error";
		String Actual = AlertDanger.getText();
		
		Assert.assertEquals(Actual, Expected);
		
	}
	
	public void CreateAccountEmptyPassword() throws Exception {
		ExcelUtils.setExcelFile(ConstantClass.Path_TestData + ConstantClass.File_TestData, "Register Account");
		waitForPageLoaded();
		HighLightElement(EmailAddressTextBox, 1);
		EmailAddressTextBox.sendKeys("Testyyy@gmail.com");
		CreateAccountButton.click();
		String FirstNameText = ExcelUtils.getCellData(1, 1);
		String LastNameText = ExcelUtils.getCellData(1, 2);
		String EmailText = ExcelUtils.getCellData(1, 3);
		String PasswordText = ExcelUtils.getCellData(2, 4);
		
		String Month = ExcelUtils.getCellData(2, 6);
		
		String Year = ExcelUtils.getCellData(2, 7);
		String FirtNameAdd = ExcelUtils.getCellData(2, 8);
		String LastNameAdd = ExcelUtils.getCellData(2, 9);
		String CompanyText = ExcelUtils.getCellData(2, 10);
		String Address1Text = ExcelUtils.getCellData(2, 11);
		String Address2Text = ExcelUtils.getCellData(2, 12);
		String CityText = ExcelUtils.getCellData(2, 13);
		String StateText = ExcelUtils.getCellData(2, 14);
		String ZipCodeText = ExcelUtils.getCellData(2, 15);
		String CountryText = ExcelUtils.getCellData(2, 16);
		String AdditionalInput = ExcelUtils.getCellData(2, 17);
		String Home = ExcelUtils.getCellData(2, 18);
		String Mobile = ExcelUtils.getCellData(2, 19);
		String Alias = ExcelUtils.getCellData(2, 20);


		Select drpDay = new Select(DropDownDay);
		Select drpMonth = new Select(DropDownMonth);
		Select drpYear = new Select(DropDownYear);
		Select drpState = new Select(DropDownState);
		Select drpCountry = new Select(DropDownCountry);

		waitForPageLoaded();
		GenderMale.click();
		HighLightElement(GenderMale, 1);

		FirstName.clear();
		LastName.clear();
		Password.clear();
		AddFirstname.clear();
		AddLasttname.clear();
		Company.clear();
		Address1.clear();
		Address2.clear();
		City.clear();
		ZipCode.clear();
		HomePhone.clear();
		AliasAdd.clear();
		
		FirstName.sendKeys(FirstNameText);
		HighLightElement(FirstName, 1);
		LastName.sendKeys(LastNameText);
		HighLightElement(LastName, 1);
		Email.clear();
		Email.sendKeys(EmailText);;
		HighLightElement(Email, 1);
		Password.clear();
		HighLightElement(Password, 1);
		drpDay.selectByValue(ExcelUtils.getNumericData("Register Account", 2, 5));
		HighLightElement(DropDownDay, 1);
		drpMonth.selectByValue(ExcelUtils.getNumericData("Register Account", 2, 6));
		HighLightElement(DropDownMonth, 1);
		drpYear.selectByValue(ExcelUtils.getNumericData("Register Account", 2, 7));
		HighLightElement(DropDownYear, 1);
		CheckBoxNewsLetter.click();
		HighLightElement(CheckBoxNewsLetter, 1);
		CheckBoxOptIn.click();
		HighLightElement(CheckBoxOptIn, 1);
		AddFirstname.clear();
		AddFirstname.sendKeys(FirtNameAdd);		
		HighLightElement(AddFirstname, 1);
		AddLasttname.clear();
		AddLasttname.sendKeys(LastNameAdd);
		HighLightElement(AddLasttname, 1);

		Company.sendKeys(CompanyText);
		HighLightElement(Company, 1);
		Address1.sendKeys(Address1Text);
		HighLightElement(Address1, 1);
		Address2.sendKeys(Address2Text);
		HighLightElement(Address2, 1);
		City.sendKeys(CityText);
		HighLightElement(City, 1);
		drpState.selectByVisibleText(StateText);
		HighLightElement(DropDownState, 1);
		ZipCode.sendKeys(ZipCodeText);
		HomePhone.sendKeys(ExcelUtils.getNumericData("Register Account", 1, 18));
		HighLightElement(HomePhone, 1);
		MobilePhone.sendKeys(ExcelUtils.getNumericData("Register Account", 1, 19));
		HighLightElement(MobilePhone, 1);
		AliasAdd.sendKeys(Alias);
		HighLightElement(AliasAdd, 1);
		HighLightElement(RegisterButton, 1);
		RegisterButton.click();
		
		waitForPageLoaded();
	
		waitForElement(AlertDanger);
		HighLightElement(AlertDanger, 1);
		
		String Expected =  "There is 1 error";
		String Actual = AlertDanger.getText();
		
		Assert.assertEquals(Actual, Expected);
		
	}
	
	public void CreateAccountInvalidZipCode() throws Exception {
		ExcelUtils.setExcelFile(ConstantClass.Path_TestData + ConstantClass.File_TestData, "Register Account");
		waitForPageLoaded();
		HighLightElement(EmailAddressTextBox, 1);
		EmailAddressTextBox.sendKeys("Testyyy@gmail.com");
		CreateAccountButton.click();
		String FirstNameText = ExcelUtils.getCellData(1, 1);
		String LastNameText = ExcelUtils.getCellData(1, 2);
		String EmailText = ExcelUtils.getCellData(1, 3);
		String PasswordText = ExcelUtils.getCellData(1, 4);
		
		String Month = ExcelUtils.getCellData(1, 6);
		
		String Year = ExcelUtils.getCellData(1, 7);
		String FirtNameAdd = ExcelUtils.getCellData(1, 8);
		String LastNameAdd = ExcelUtils.getCellData(1, 9);
		String CompanyText = ExcelUtils.getCellData(1, 10);
		String Address1Text = ExcelUtils.getCellData(1, 11);
		String Address2Text = ExcelUtils.getCellData(1, 12);
		String CityText = ExcelUtils.getCellData(1, 13);
		String StateText = ExcelUtils.getCellData(1, 14);
		String ZipCodeText = ExcelUtils.getCellData(1, 15);
		String CountryText = ExcelUtils.getCellData(1, 16);
		String AdditionalInput = ExcelUtils.getCellData(1, 17);
		String Home = ExcelUtils.getCellData(1, 18);
		String Mobile = ExcelUtils.getCellData(1, 19);
		String Alias = ExcelUtils.getCellData(1, 20);


		Select drpDay = new Select(DropDownDay);
		Select drpMonth = new Select(DropDownMonth);
		Select drpYear = new Select(DropDownYear);
		Select drpState = new Select(DropDownState);
		Select drpCountry = new Select(DropDownCountry);

		waitForPageLoaded();
		GenderMale.click();
		HighLightElement(GenderMale, 1);

		FirstName.clear();
		LastName.clear();
		Password.clear();
		AddFirstname.clear();
		AddLasttname.clear();
		Company.clear();
		Address1.clear();
		Address2.clear();
		City.clear();
		ZipCode.clear();
		HomePhone.clear();
		AliasAdd.clear();
		
		FirstName.sendKeys(FirstNameText);
		HighLightElement(FirstName, 1);
		LastName.sendKeys(LastNameText);
		HighLightElement(LastName, 1);
		Email.clear();
		Email.sendKeys(EmailText);;
		HighLightElement(Email, 1);
		Password.sendKeys(PasswordText);
		HighLightElement(Password, 1);
		drpDay.selectByValue(ExcelUtils.getNumericData("Register Account", 2, 5));
		HighLightElement(DropDownDay, 1);
		drpMonth.selectByValue(ExcelUtils.getNumericData("Register Account", 2, 6));
		HighLightElement(DropDownMonth, 1);
		drpYear.selectByValue(ExcelUtils.getNumericData("Register Account", 2, 7));
		HighLightElement(DropDownYear, 1);
		CheckBoxNewsLetter.click();
		HighLightElement(CheckBoxNewsLetter, 1);
		CheckBoxOptIn.click();
		HighLightElement(CheckBoxOptIn, 1);
		AddFirstname.clear();
		AddFirstname.sendKeys(FirtNameAdd);		
		HighLightElement(AddFirstname, 1);
		AddLasttname.clear();
		AddLasttname.sendKeys(LastNameAdd);
		HighLightElement(AddLasttname, 1);

		Company.sendKeys(CompanyText);
		HighLightElement(Company, 1);
		Address1.sendKeys(Address1Text);
		HighLightElement(Address1, 1);
		Address2.sendKeys(Address2Text);
		HighLightElement(Address2, 1);
		City.sendKeys(CityText);
		HighLightElement(City, 1);
		drpState.selectByVisibleText(StateText);
		HighLightElement(DropDownState, 1);
		ZipCode.sendKeys(ZipCodeText);
		HomePhone.sendKeys(ExcelUtils.getNumericData("Register Account", 1, 18));
		HighLightElement(HomePhone, 1);
		MobilePhone.sendKeys(ExcelUtils.getNumericData("Register Account", 1, 19));
		HighLightElement(MobilePhone, 1);
		AliasAdd.sendKeys(Alias);
		HighLightElement(AliasAdd, 1);
		HighLightElement(RegisterButton, 1);
		RegisterButton.click();
		
		waitForPageLoaded();
	
		waitForElement(AlertDanger);
		HighLightElement(AlertDanger, 1);
		
		String Expected =  "There is 1 error";
		String Actual = AlertDanger.getText();
		
		Assert.assertEquals(Actual, Expected);
		
	}
	
	public void CreateAccountValidAccount() throws Exception {
		ExcelUtils.setExcelFile(ConstantClass.Path_TestData + ConstantClass.File_TestData, "Register Account");
		waitForPageLoaded();
		HighLightElement(EmailAddressTextBox, 1);
		EmailAddressTextBox.sendKeys("Testyyy@gmail.com");
		CreateAccountButton.click();
		String FirstNameText = ExcelUtils.getCellData(3, 1);
		String LastNameText = ExcelUtils.getCellData(3, 2);
		String EmailText = ExcelUtils.getCellData(3, 3);
		String PasswordText = ExcelUtils.getCellData(3, 4);
		
		String Month = ExcelUtils.getCellData(3, 6);
		
		String Year = ExcelUtils.getCellData(3, 7);
		String FirtNameAdd = ExcelUtils.getCellData(3, 8);
		String LastNameAdd = ExcelUtils.getCellData(3, 9);
		String CompanyText = ExcelUtils.getCellData(3, 10);
		String Address1Text = ExcelUtils.getCellData(3, 11);
		String Address2Text = ExcelUtils.getCellData(3, 12);
		String CityText = ExcelUtils.getCellData(3, 13);
		String StateText = ExcelUtils.getCellData(3, 14);
		String ZipCodeText = ExcelUtils.getCellData(3, 15);
		String CountryText = ExcelUtils.getCellData(3, 16);
		String AdditionalInput = ExcelUtils.getCellData(3, 17);
		String Home = ExcelUtils.getCellData(3, 18);
		String Mobile = ExcelUtils.getCellData(3, 19);
		String Alias = ExcelUtils.getCellData(3, 20);


		Select drpDay = new Select(DropDownDay);
		Select drpMonth = new Select(DropDownMonth);
		Select drpYear = new Select(DropDownYear);
		Select drpState = new Select(DropDownState);
		Select drpCountry = new Select(DropDownCountry);

		waitForPageLoaded();
		GenderMale.click();
		HighLightElement(GenderMale, 1);

		FirstName.clear();
		LastName.clear();
		Password.clear();
		AddFirstname.clear();
		AddLasttname.clear();
		Company.clear();
		Address1.clear();
		Address2.clear();
		City.clear();
		ZipCode.clear();
		HomePhone.clear();
		AliasAdd.clear();
		
		FirstName.sendKeys(FirstNameText);
		HighLightElement(FirstName, 1);
		LastName.sendKeys(LastNameText);
		HighLightElement(LastName, 1);
		Email.clear();
		Email.sendKeys(EmailText);;
		HighLightElement(Email, 1);
		Password.sendKeys(PasswordText);
		HighLightElement(Password, 1);
		drpDay.selectByValue(ExcelUtils.getNumericData("Register Account", 3, 5));
		HighLightElement(DropDownDay, 1);
		drpMonth.selectByValue(ExcelUtils.getNumericData("Register Account", 3, 6));
		HighLightElement(DropDownMonth, 1);
		drpYear.selectByValue(ExcelUtils.getNumericData("Register Account", 3, 7));
		HighLightElement(DropDownYear, 1);
		CheckBoxNewsLetter.click();
		HighLightElement(CheckBoxNewsLetter, 1);
		CheckBoxOptIn.click();
		HighLightElement(CheckBoxOptIn, 1);
		AddFirstname.clear();
		AddFirstname.sendKeys(FirtNameAdd);		
		HighLightElement(AddFirstname, 1);
		AddLasttname.clear();
		AddLasttname.sendKeys(LastNameAdd);
		HighLightElement(AddLasttname, 1);

		Company.sendKeys(CompanyText);
		HighLightElement(Company, 1);
		Address1.sendKeys(Address1Text);
		HighLightElement(Address1, 1);
		Address2.sendKeys(Address2Text);
		HighLightElement(Address2, 1);
		City.sendKeys(CityText);
		HighLightElement(City, 1);
		drpState.selectByVisibleText(StateText);
		HighLightElement(DropDownState, 1);
		ZipCode.sendKeys(ZipCodeText);
		HomePhone.sendKeys(ExcelUtils.getNumericData("Register Account", 3, 18));
		HighLightElement(HomePhone, 1);
		MobilePhone.sendKeys(ExcelUtils.getNumericData("Register Account", 3, 19));
		HighLightElement(MobilePhone, 1);
		AliasAdd.sendKeys(Alias);
		HighLightElement(AliasAdd, 1);
		HighLightElement(RegisterButton, 1);
		RegisterButton.click();
		
		waitForPageLoaded();
	
		waitForElement(InfoAccountMessage);
		HighLightElement(InfoAccountMessage, 1);
		
		String Expected =  "Welcome to your account. Here you can manage all of your personal information and orders.";
		String Actual = InfoAccountMessage.getText();
		
		Assert.assertEquals(Actual, Expected);
		
	}

}
