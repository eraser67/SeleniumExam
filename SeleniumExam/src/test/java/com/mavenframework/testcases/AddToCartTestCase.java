package com.mavenframework.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.maveframework.pages.AddToCartPage;
import com.maveframework.pages.BaseClass;
import com.maveframework.pages.LoginPage;

public class AddToCartTestCase extends BaseClass {

	
		@Test(priority = 1)
		public void InvalidSearch() throws Exception {
			logger = report.createTest("Invalid Search Result");
			System.out.println(driver.getTitle());
			
			LoginPage login = PageFactory.initElements(BaseClass.driver, LoginPage.class);
			login.RegisteredValidCred();
			AddToCartPage addCart = PageFactory.initElements(BaseClass.driver, AddToCartPage.class);
			addCart.InvalidSearchResult();
			
			logger.pass("Invalid Search");
		}
	@Test(priority = 2)
	public void ValidSearch() throws Exception {
		logger = report.createTest("Valid Search");

		System.out.println(driver.getTitle());
		
		AddToCartPage addCart = PageFactory.initElements(BaseClass.driver, AddToCartPage.class);
		addCart.ValidSearch();
		
		logger.pass("Items are Displayed");
	}

	@Test(priority = 3)
	public void AddItemToCart() throws Exception {
		logger = report.createTest("Add Item To Cart");

		System.out.println(driver.getTitle());
		AddToCartPage addCart = PageFactory.initElements(BaseClass.driver, AddToCartPage.class);
		addCart.AddToBag();
		
		logger.pass("Items are added to Cart");
	}

	@Test(priority = 4)
	public void RemoveSecondItem() throws Exception {
		logger = report.createTest("Remove Second Item");

		System.out.println(driver.getTitle());
		AddToCartPage addCart = PageFactory.initElements(BaseClass.driver, AddToCartPage.class);
		addCart.RemoveSecondItem();
		
		logger.pass("Second Item is removed");
	}

	@Test(priority = 5)
	public void CheckOutItem() throws Exception {
		logger = report.createTest("Check Out Items");

		System.out.println(driver.getTitle());
		AddToCartPage addCart = PageFactory.initElements(BaseClass.driver, AddToCartPage.class);
		addCart.CheckOutItem();
		addCart.VerifyProduct();
		addCart.VerifyPrice();
		addCart.VerifyQuantity();
		addCart.VerifyTotal();
		logger.pass("Total Value is correct");
	}


}
