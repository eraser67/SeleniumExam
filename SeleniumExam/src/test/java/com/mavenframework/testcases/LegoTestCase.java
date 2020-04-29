package com.mavenframework.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.maveframework.pages.AddToCartPage;
import com.maveframework.pages.BaseClass;
import com.maveframework.pages.LegoPage;
import com.maveframework.pages.LoginPage;

public class LegoTestCase extends BaseClass{

	
	@Test(priority = 1)
	public void InvalidSearch() throws Exception {
		logger = report.createTest("Invalid Search Result");
		System.out.println(driver.getTitle());
		
		
		LegoPage lego = PageFactory.initElements(BaseClass.driver, LegoPage.class);
		lego.InvalidSearch();
		
		logger.pass("Invalid Search");
	}
	@Test(priority = 2)
	public void ValidSearch() throws Exception {
		logger = report.createTest("Valid Search");

		System.out.println(driver.getTitle());
		
		LegoPage lego = PageFactory.initElements(BaseClass.driver, LegoPage.class);
		lego.ValidSearch();
		
		logger.pass("Items are Displayed");
	}
	@Test(priority = 3)
	public void AddItemToCart() throws Exception {
		logger = report.createTest("Add Item");

		System.out.println(driver.getTitle());
		
		LegoPage lego = PageFactory.initElements(BaseClass.driver, LegoPage.class);
		lego.AddToBag();
		
		
		logger.pass("Items are added to the Cart");
	}

	@Test(priority = 4)
	public void RemoveSecondItem() throws Exception {
		logger = report.createTest("Remove Second Item");

		System.out.println(driver.getTitle());
		LegoPage lego = PageFactory.initElements(BaseClass.driver, LegoPage.class);
		lego.RemoveSecondItem();
		
		
		logger.pass("Second Item is removed");
	}
	
	@Test(priority = 5)
	public void CheckOutItem() throws Exception {
		logger = report.createTest("Verify Product Name");

		System.out.println(driver.getTitle());
		LegoPage lego = PageFactory.initElements(BaseClass.driver, LegoPage.class);
		lego.VerifyProductName();
		
		logger.pass("Product is correct");
	}
	
	
	@Test(priority = 6)
	public void VerifyProductQuantity() throws Exception {
		logger = report.createTest("Verify Product Quantity");

		System.out.println(driver.getTitle());
		LegoPage lego = PageFactory.initElements(BaseClass.driver, LegoPage.class);
		lego.VerifyQuantity();
		
		logger.pass("Quantity is correct");
	}
	@Test(priority = 7)
	public void VerifyProductPrice() throws Exception {
		logger = report.createTest("Verify Product Price");

		System.out.println(driver.getTitle());
		LegoPage lego = PageFactory.initElements(BaseClass.driver, LegoPage.class);
		lego.VerifyPrice();
		logger.pass("Product Price is correct");
	}

	@Test(priority = 8)
	public void VerifyTotal() throws Exception {
		logger = report.createTest("Verify Total");

		System.out.println(driver.getTitle());
		LegoPage lego = PageFactory.initElements(BaseClass.driver, LegoPage.class);
		lego.VerifyTotal();
		logger.pass("Total Value is correct");
	}
	
	@Test(priority = 9)
	public void CheckOutPage() throws Exception {
		logger = report.createTest("Check out All Item");

		System.out.println(driver.getTitle());
		LegoPage lego = PageFactory.initElements(BaseClass.driver, LegoPage.class);
		lego.ClickCheckOut();
		logger.pass("Items are Check out");
	}
}
