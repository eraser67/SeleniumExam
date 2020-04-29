package com.maveframework.pages;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xmlconfig.NamespaceList.Member2.Item;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import com.graphbuilder.struc.Bag;
import com.mavenframework.extensions.DriverExtension;
import com.mavenframework.utility.ConstantClass;
import com.mavenframework.utility.ExcelUtils;

public class LegoPage extends DriverExtension{


	WebDriver driver;

	public LegoPage(WebDriver LegoCart) {
		super(LegoCart);

	}
	@FindBy(css = ".MainBarstyles__OpenButton-sc-1cg7sjw-14 > .Searchstyles__SearchIcon-qaapd1-6")
	WebElement SearchButtonPad;

	@FindBy(css = "#search-input")
	WebElement SearchBox;

	@FindBy(css = ".Searchstyles__SearchButton-qaapd1-4 > .Searchstyles__SearchIcon-qaapd1-6")
	WebElement SearchButton;
	
	@FindBy(css = "div.NoResultsstyles__NoResultsContainer-tph6xh-1 >h3")
	WebElement NoSearchResult;
	
	@FindBy(css = "#main-content > div > div > div.SearchPagestyles__SearchLayout-sc-1d2gqze-2.bHuWTP > div")
	WebElement SearchResult;
	
	@FindBy(css = "#root > div > div:nth-child(6) > div > div.AgeGatestyles__Panel-xudtvj-2.AgeGatestyles__GrownUps-xudtvj-3.jEnvUI > div > button")
	WebElement ExploreButton;
	
	@FindBy(css = ".CookieBannerstyles__StyledButton-sc-1nn4qlf-7")
	WebElement CookieBanner;
	
	
	@FindBy(css = "div.ProductLeafListingstyles__ActionRow-sc-19n1otk-1>button")
	List<WebElement> AddToBag;
	
	

	@FindBy(css = ".UtilityBarstyles__UserMenuItem-sc-1uwh8t8-13:nth-child(3) > .UtilityBarstyles__StyledLink-sc-1uwh8t8-3")
	WebElement MyBag;
	
	@FindBy(xpath =  "//*[contains(@title,'Remove from bag')]")
	List<WebElement> RemoveButton;
	
	@FindBy(xpath =  "//*[contains(@data-test,'product-item')]")
	List<WebElement> ProductItem;
	

	@FindBy(css =  "div.ProductRowstyles__ProductPriceContainer-cbbmmq-6  > span")
	List<WebElement> ProductPrice;

	
	@FindBy(xpath =  "//*[contains(@data-test,'cart-item')]")
	List<WebElement> CartItem;

	@FindBy(css = ".bMBjWv:nth-child(2)")
	WebElement CheckOutButton;
	
	@FindBy(css = ".iSNubF > .Markup__StyledMarkup-ar1l9g-0")
	WebElement OrderTotal;
	
	@FindBy(css = ".styles__Line-ohpjtk-0:nth-child(8) .Markup__StyledMarkup-ar1l9g-0")
	WebElement CheckOutOrderTotal;
	
	@FindBy(css = "div.ProductRowstyles__ProductTextContainer-cbbmmq-3 >a >span >div >span")
	List<WebElement> ItemName;
	
	@FindBy(css = "div.Quantitystyles__InputContainer-sc-7da5de-3  > input")
	List<WebElement> Quantity;
	
	@FindBy(xpath  = "//*[contains(@data-test,'shipping-total-price')]")
	WebElement ShippingFee;
	
	@FindBy(css  = "#root > div.LoadingWrapper__Wrapper-smn8sk-0.dWrmgd > div")
	WebElement CheckOutPage;
	@FindBy(css  = ".LoginReminderstyles__SectionContainer-sc-12fyumu-3:nth-child(1) > .LoginReminderstyles__StyledButton-sc-12fyumu-2:nth-child(3)")
	WebElement ContinueAsGuest;
	
	
	
	public void LegoPageSetUp() {
		waitForPageLoaded();
		waitForElement(ExploreButton);
		ExploreButton.click();
		waitForElement(CookieBanner);
		CookieBanner.click();
		
			}
	
	public void InvalidSearch() throws Exception {
		ExcelUtils.setExcelFile(ConstantClass.Path_TestData + ConstantClass.File_TestData, "ValidSearch");

		String Invalid = ExcelUtils.getCellData(2, 1);
		
		
		
		LegoPageSetUp();
		waitForElement(SearchButtonPad);
		HighLightElement(SearchButtonPad, 1);
		SearchButtonPad.click();
		waitForElement(SearchBox);
		HighLightElement(SearchBox, 1);
		SearchBox.sendKeys(Invalid);
		waitForElement(SearchButton);
		HighLightElement(SearchButton, 1);
		SearchButton.click();
		waitForElement(NoSearchResult);
		
		String Expected = "We couldn't find any results for";
		String Actual = NoSearchResult.getText();
		HighLightElement(NoSearchResult, 1);
		System.out.println(Actual);
		Assert.assertTrue(Actual.contains(Expected));
	}
	
	public void ValidSearch() throws Exception {
		ExcelUtils.setExcelFile(ConstantClass.Path_TestData + ConstantClass.File_TestData, "ValidSearch");

	
		
		String Search = ExcelUtils.getCellData(1, 1);
		
		BaseClass.driver.get(BaseClass.driver.getCurrentUrl());
	
		waitForElement(SearchButtonPad);
		HighLightElement(SearchButtonPad, 1);
		SearchButtonPad.click();
		waitForElement(SearchBox);
		HighLightElement(SearchBox, 1);
		SearchBox.sendKeys(Search);
		waitForElement(SearchButton);
		HighLightElement(SearchButton, 1);
		SearchButton.click();
		waitForElement(SearchResult);
		HighLightElement(SearchResult, 1);
		Assert.assertTrue(SearchResult.isDisplayed());
	}
	
	public void AddToBag() throws InterruptedException {
		JavascriptExecutor js= (JavascriptExecutor) BaseClass.driver;
		waitForPageLoaded();
		Thread.sleep(2000);
		waitForElement(AddToBag.get(0));
		
		AddToBag.get(0).click();
		Thread.sleep(2000);
		AddToBag.get(1).click();
		Thread.sleep(2000);
		AddToBag.get(2).click();
		Thread.sleep(3000);
		waitForElement(MyBag);
		js.executeScript("arguments[0].click()", MyBag);
	
		waitForElement(CartItem.get(0));
		for(WebElement element : CartItem ) {
			HighLightElement(element, 1);
			Assert.assertTrue(element.isDisplayed());
		}
		
		
		
	}
	public void RemoveSecondItem() {
		waitForElement(RemoveButton.get(1));
		HighLightElement(RemoveButton.get(1), 1);
		RemoveButton.get(1).click();
	}
	
	public void VerifyProductName() throws InterruptedException {
		Thread.sleep(3000);
		HighLightElement(ItemName.get(0), 1); 
		HighLightElement(ItemName.get(1), 1); 
		Assert.assertTrue(ItemName.get(0).isDisplayed());
		Assert.assertTrue(ItemName.get(1).isDisplayed());
		/*
		 * String FirstItem = "Lloyd Key Chain"; String SecondItem =
		 * "LEGO® 2x6 Key Chain"; HighLightElement(ItemName.get(0), 1);
		 * HighLightElement(ItemName.get(1), 1); String ExpectedFirstItem =
		 * ItemName.get(0).getText(); String SecondExpectedItem =
		 * ItemName.get(1).getText();
		 * Assert.assertTrue(FirstItem.contains(ExpectedFirstItem));
		 * Assert.assertTrue(SecondItem.contains(SecondExpectedItem));
		 */
		
	}
	
	public void VerifyPrice() {
		
	//	String FirstItemPrice = "$5.99";
	//	String SecondItemPrice = "$5.99";
		HighLightElement(ProductPrice.get(0), 1);
		HighLightElement(ProductPrice.get(1), 1);
	//	String ProductItemFirst = ProductPrice.get(0).getText();
	//	String ProductItemSecond = ProductPrice.get(1).getText();
		
	//	Assert.assertEquals(ProductItemFirst, FirstItemPrice);
	//	Assert.assertEquals(ProductItemSecond, SecondItemPrice);
		Assert.assertTrue(ProductPrice.get(0).isDisplayed());
		Assert.assertTrue(ProductPrice.get(1).isDisplayed());
		
	}
	
	public void VerifyQuantity() {
		
		String FirstItemQty = "1";
		String SecondItemQty = "1";
		String ProductItemQty = Quantity.get(0).getAttribute("value");
		HighLightElement(Quantity.get(0), 1);
		String ProductItemQty2 = Quantity.get(1).getAttribute("value");
		HighLightElement(Quantity.get(1), 1);
		Assert.assertEquals(ProductItemQty, FirstItemQty);
		Assert.assertEquals(ProductItemQty2, SecondItemQty);
	}
	
	public void VerifyTotal() {
		waitForElement(OrderTotal);
		String shipping = ShippingFee.getText();
		 String ShippingReplace = shipping.replace("$", "");
		double ParseShipping = Double.parseDouble(ShippingReplace);
		double firstItemPrice = 5.99;
		 double secondItemPrice = 5.99;
		 double TotalExpected = firstItemPrice  + secondItemPrice + ParseShipping ;
		
		
		String FirstItemActual = ProductPrice.get(0).getText();
		String FirtItemReplace = FirstItemActual.replace("$", "");
		double ParseItemFirstActual  = Double.parseDouble(FirtItemReplace);
		
		String SecondItemActual = ProductPrice.get(1).getText();
		String SecondItemReplace = SecondItemActual.replace("$", "");
		double ParseSecondActual = Double.parseDouble(SecondItemReplace);
		
		double ActualTotal = ParseItemFirstActual + ParseSecondActual + ParseShipping;
		HighLightElement(OrderTotal, 1);
		 Assert.assertEquals(ActualTotal, TotalExpected);
		 
	}
	
	public void ClickCheckOut() {
		waitForElement(CheckOutButton);
		
		CheckOutButton.click();
		waitForElement(ContinueAsGuest);
		waitForElement(CheckOutPage);
		waitForElement(CheckOutOrderTotal);
		HighLightElement(CheckOutPage, 1);
		HighLightElement(CheckOutOrderTotal, 1);
		
		
	}
	

	
}

