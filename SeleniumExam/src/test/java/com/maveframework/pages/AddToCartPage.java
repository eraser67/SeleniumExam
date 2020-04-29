package com.maveframework.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.mavenframework.extensions.DriverExtension;

public class AddToCartPage extends DriverExtension{

	WebDriver driver;

	public AddToCartPage(WebDriver CartDriver) {
		super(CartDriver);

	}

	@FindBy(css = "div.product-image-container >a")
	List<WebElement> Products;

	@FindBy(css = "#search_query_top")
	WebElement SearchBox;

	@FindBy(css = "#searchbox > button")
	WebElement SearchButton;

	@FindBy(css = "#center_column > p")
	WebElement NoSearchResult;

	@FindBy(css = "#quantity_wanted")
	WebElement QuantityTextBox;
	
	@FindBy(css = "#add_to_cart > button")
	WebElement AddToCartButton;
	
	@FindBy(css = ".cross")
	WebElement ModalAddToCartCloseButton;
	
	@FindBy(css =   "a.ajax_cart_block_remove_link")
	WebElement RemoveToCart;
	
	@FindBy(css = "span.remove_link >a")
	List<WebElement> RemoveCart;
	
	
	@FindBy(css =   "div.product-name >span > span")
	WebElement AddToCartQuantity;
	
	@FindBy(css =   ".ajax_block_product:nth-child(1) .right-block .price")
	WebElement FistItemPriceProduct;
	
	@FindBy(css =   "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a > span.ajax_cart_quantity")
	WebElement TotalAddBags;
	
	
	@FindBy(css =   "#total_price")
	WebElement TotalOrder;
	@FindBy(css =   "#total_shipping")
	WebElement Shipping;
	
	@FindBy(css =   ".cart_block_total")
	WebElement ThirdItemPrice;
	
	@FindBy(css =   "#center_column")
	WebElement SearchResult;
	
	
	@FindBy(css =   "div.shopping_cart >a")
	WebElement Cart;
	
	@FindBy(css =   "#button_order_cart > span")
	WebElement CheckOutButtom;
	
	@FindBy(css =   "#product_5_19_0_293817 .product-name > a")
	WebElement FirstItem;
	
	@FindBy(css =   "#product_1_1_0_293817 .product-name")
	WebElement SecondItem;
	
	@FindBy(css =   ".special-price")
	WebElement FirstItemPrice;
	
	@FindBy(css =   "#product_price_1_1_293817 > .price")
	WebElement SecondItemPrice;
	
	
	@FindBy(css =   "#product_5_19_0_293817 > td.cart_quantity.text-center > input.cart_quantity_input.form-control.grey")
	WebElement FirstItemQuantity;
	@FindBy(css =   "#product_1_1_0_293817 > td.cart_quantity.text-center > input.cart_quantity_input.form-control.grey")
	WebElement SecondItemQuantity;
	
	@FindBy(css =   "#total_product_price_5_19_293817")
	WebElement FirstItemTotal;
	
	@FindBy(css =   "#total_product_price_1_1_293817")
	WebElement SecondItemTotal;
	
	@FindBy(css =   "#total_product")
	WebElement TotalProduct;

	
	public void SearhInvalid() {
	String Expected = "No results were found for your search";
	String Actual = NoSearchResult.getText();	
		waitForPageLoaded();
		SearchBox.sendKeys("Invalid Keys");
		SearchButton.click();
		Assert.assertTrue(Actual.contains(Expected));
		
		}
	
	public void SearchValid() {
		waitForPageLoaded();
		waitForElement(SearchBox);
		SearchBox.sendKeys("Shoes");
		WebElement elements = null;
		
		Assert.assertTrue(SearchResult.isDisplayed());
		
	}
	
	public void AddToBag() throws InterruptedException {
		String getURL = BaseClass.driver.getCurrentUrl();
		JavascriptExecutor js= (JavascriptExecutor) BaseClass.driver;
		 Actions actions = new Actions(BaseClass.driver);
		waitForPageLoaded();
		SearchBox.clear();
		waitForElement(SearchBox);
		HighLightElement(SearchBox, 1);
		SearchBox.sendKeys("Shoes");
		HighLightElement(SearchButton, 1);
		SearchButton.click();
		waitForElement(SearchResult);
		HighLightElement(SearchResult, 1);
		HighLightElement(Products.get(0), 1);
		js.executeScript("arguments[0].click()", Products.get(0));
		js.executeScript("arguments[0].click()", AddToCartButton);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click()", ModalAddToCartCloseButton);
		
		BaseClass.driver.get(getURL);
		waitForPageLoaded();
		waitForElement(SearchBox);
		SearchBox.clear();
		HighLightElement(SearchBox, 1);
		SearchBox.sendKeys("Shoes");
		HighLightElement(SearchButton, 1);
		SearchButton.click();
		waitForElement(SearchResult);
		HighLightElement(SearchResult, 1);
		HighLightElement(Products.get(4), 1);
		js.executeScript("arguments[0].click()", Products.get(4));
		js.executeScript("arguments[0].click()", AddToCartButton);
		waitForPageLoaded();
		js.executeScript("arguments[0].click()", ModalAddToCartCloseButton);
	
		
		BaseClass.driver.get(getURL);
		waitForPageLoaded();
		SearchBox.clear();
		waitForElement(SearchBox);
		HighLightElement(SearchBox, 1);
		SearchBox.sendKeys("Shoes");
		HighLightElement(SearchButton, 1);
		SearchButton.click();
		waitForElement(SearchResult);
		HighLightElement(SearchResult, 1);
		HighLightElement(Products.get(2), 1);
		js.executeScript("arguments[0].click()", Products.get(2));
		js.executeScript("arguments[0].click()", AddToCartButton);
		waitForPageLoaded();
		js.executeScript("arguments[0].click()", ModalAddToCartCloseButton);
		
		BaseClass.driver.get(getURL);
		waitForElement(TotalAddBags);
		HighLightElement(TotalAddBags, 1);
		Assert.assertTrue(TotalAddBags.isDisplayed());
	}
	
	public void InvalidSearchResult() {
		
		waitForElement(SearchBox);
		SearchBox.clear();
		SearchBox.sendKeys("QWERTY");
		SearchButton.click();
		waitForElement(NoSearchResult);
		HighLightElement(NoSearchResult, 1);
		String InvalidSearch = NoSearchResult.getText();
		String Expected = "No results were found for your search";
		System.out.println(InvalidSearch);
		Assert.assertTrue(InvalidSearch.contains(Expected));
	}
	 public void ValidSearch() {
			waitForPageLoaded();
			waitForElement(SearchBox);
			HighLightElement(SearchBox, 1);
			SearchBox.clear();
			SearchBox.sendKeys("Shoes");
			HighLightElement(SearchButton, 1);
			SearchButton.click();
			waitForElement(SearchResult);
			HighLightElement(SearchResult, 1);
			Assert.assertTrue(SearchResult.isDisplayed());
		 
	 }
	 
	 public void RemoveSecondItem() throws InterruptedException {
		 Actions actions = new Actions(BaseClass.driver);
		 BaseClass.driver.get(BaseClass.driver.getCurrentUrl());
		 waitForElement(Cart);
		 HighLightElement(Cart, 1);
		 actions.moveToElement(Cart).perform();
		 RemoveCart.get(1).click();
		 Thread.sleep(2000);
		 waitForElement(TotalAddBags);
		 HighLightElement(TotalAddBags, 1);
		 Assert.assertTrue(TotalAddBags.isDisplayed());
		 
	 }
	 
	 public void CheckOutItem() {
		 Actions actions = new Actions(BaseClass.driver);
		 waitForElement(Cart);
		 actions.moveToElement(Cart).perform();
		 actions.moveToElement(CheckOutButtom).perform();
		 CheckOutButtom.click();
		 waitForElement(FirstItem);
		 waitForElement(SecondItem);
		 HighLightElement(FirstItem, 1);
		 HighLightElement(SecondItem, 1);
		 HighLightElement(FirstItemPrice, 1);
		 HighLightElement(SecondItemPrice, 1);
		 waitForElement(FirstItemQuantity);
		 SecondItemQuantity.clear();
		 SecondItemQuantity.sendKeys("2");
		 SecondItemTotal.click();
		 
	 }
	 
	 public void VerifyProduct() {
		 String FirstItemNameExpected = "Printed Summer Dress";
		 String ActualNameOfFirstItem = FirstItem.getText();
		 String SecondItemNameExpected = "Faded Short Sleeve T-shirts";
		 String ActualNameOfSecondItem = SecondItem.getText();
		 
		 Assert.assertEquals(ActualNameOfFirstItem, FirstItemNameExpected);
		 Assert.assertEquals(ActualNameOfSecondItem, SecondItemNameExpected);
	 }
	 
	 public void VerifyPrice() {
		 String ExpectedFirstItemPrice = "$28.98";
		 String ActualFirstPrice  =  FirstItemPrice.getText();
		 String ExpectedSecondItemPrice = "$16.51";
		 String ActualSecondPrice = SecondItemPrice.getText();
		 
		 Assert.assertEquals(ActualFirstPrice, ExpectedFirstItemPrice);
		 Assert.assertEquals(ActualSecondPrice, ExpectedSecondItemPrice);
	 }
	 public void VerifyQuantity() {
		
		 HighLightElement(FirstItemQuantity, 1);
		HighLightElement(SecondItemQuantity, 1);
		Assert.assertTrue(FirstItem.isDisplayed());
		Assert.assertTrue(SecondItemQuantity.isDisplayed());
	 }
	 
	 public void VerifyTotal() {
		 SecondItemTotal.click();
		 HighLightElement(SecondItemTotal, 1);
		 BaseClass.driver.navigate().refresh();
		 waitForElement(SecondItemQuantity);
		 double firstItemPrice = 28.98;
		 double secondItemPrice = 16.51;
		 int fistItemQuantity = 1;
		 int seconditemQuantity =2;
		 int shipping = 2;
		 double Total = (firstItemPrice * fistItemQuantity) + (secondItemPrice * seconditemQuantity) + shipping ;
		 SecondItemTotal.click();
		 String TotalFee = TotalOrder.getText();
		 String TotalRemoveDollar = TotalFee.replace("$", "");
				 
		double ParseTotal = Double.parseDouble(TotalRemoveDollar);	 
	
		HighLightElement(TotalOrder, 1);
		HighLightElement(Shipping, 2);
		HighLightElement(TotalProduct, 1);
		Assert.assertEquals(ParseTotal, Total);
		
	 }
	
	}
