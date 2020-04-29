package com.mavenframework.extensions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.maveframework.pages.BaseClass;

public class DriverExtension {

	WebDriver driver;
	static WebDriver drivers;

	public DriverExtension(WebDriver driverExtension) {

		PageFactory.initElements(driver, this);
		this.driver = driverExtension;

	}

	public void waitForElement(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement target = wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			System.out.println("Timeout waiting for Page Load Request to complete.");
		}
	}

	public static Boolean isElementExist(WebElement element) {

		try {

			boolean result = element.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void CheckElementIfPresent(WebElement element) {
		if (!isElementExist(element)) {

			throw new IllegalArgumentException("Element not Found");
		}

	}

	public static void HighLightElement(WebElement element, int duration) {

		// try {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
		String original_style = element.getAttribute("style");
		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
				+ "var elementTop = arguments[0].getBoundingClientRect().top;"
				+ "window.scrollBy(0, elementTop-(viewPortHeight/2));";
		js.executeScript(scrollElementIntoMiddle, element);

		js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 6px solid red; border-style: solid;");

		if (duration > 0) {
			try {
				Thread.sleep(duration * 1000);
			} catch (InterruptedException e) {

			}
		}

	}
	
	public Boolean isAttributePresent(WebElement element, String attribute) {
		boolean result = false;
		
		try
        {
            String value = element.getAttribute(attribute);
            if (value != null)
            {
                result = true;
            }

        }
        catch (Exception e)
        {
            return false;
        }
        return result;
		
	}
	
	public static boolean CheckIfNavigatedCorrectly(String href, WebDriver driver) {
		
		boolean result = false;
		if(driver.getCurrentUrl().toLowerCase().contains(href.toLowerCase())) {
			
			System.out.println("Navigate URL" + driver.getCurrentUrl());
			result = true;
		}
		
		List<String> browserTabs = new ArrayList<>(BaseClass.driver.getWindowHandles());
		if(browserTabs.size() >0) {
			System.out.println("Count Browser window before Closse " +  browserTabs.size());
			driver.switchTo().window(browserTabs.get(1));
			System.out.println(driver.getTitle());
			
			 try
             {
				 
				 JavascriptExecutor js = (JavascriptExecutor) driver;
				 js.executeScript("window.close();");
             }
             catch (Exception e)
             {

             }
             System.out.println("Tab closed");
		
		}
		List<String> browserTabs2 = new ArrayList<>(driver.getWindowHandles());
		System.out.println("Count after closing: " + browserTabs2.size());
         driver.switchTo().window(browserTabs2.get(2));
         return result;
		}
	
	

}
