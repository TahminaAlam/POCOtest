package org.pocome.Utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends AppiumUtils{
		
		 AndroidDriver driver;
		 
	     public AndroidActions(AndroidDriver driver)
	     {
	    	 super(driver);
	    	 this.driver = driver;
	     }
		
		 public void longPressAction(WebElement ele)
		 {
			((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
					ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
							"duration",2000));
		 }
		
		 public void scrollToEndAction()
		 {
			boolean canScrollMore;
			do
			{
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 3.0
				    ));
			}
			while (canScrollMore);
		  }
		 
		 public void scrollToText(String text)
		 {
			 driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
		 }
		 
		 public void scrollToEndStart()
		 {
			 driver.findElement(MobileBy.AndroidUIAutomator(
			            "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));
			   driver.findElement(MobileBy.AndroidUIAutomator(
			            "new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(100000)")); 
		 }
		 
		 public void scrollToEnd()
		 {
			 driver.findElement(MobileBy.AndroidUIAutomator(
			            "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));
		 }
		
		 public void scrollToStart()
		 {
			 driver.findElement(MobileBy.AndroidUIAutomator(
			            "new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(100000)")); 
		 }
		 
		public void swipeAction(WebElement ele,String direction)
		{
			((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
						    "elementId",(((RemoteWebElement)ele).getId()),
						    "direction", direction,
						    "percent", 0.75
						));
		}
		
	

		public static void scrollToId(AndroidDriver driver, String id) {
			WebElement ele = (WebElement) driver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
							+ "new UiSelector().resourceIdMatches(\"" + id + "\"));"));
		}
		
		
		public static void scrollToXpath(AndroidDriver driver, String xpath) {
			WebElement ele = (WebElement) driver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
							+ "new UiSelector().resourceIdMatches(\"" + xpath + "\"));"));
		}
		
		public static void scrollToResourceId(AndroidDriver driver, String resourceId) {
			WebElement ele = (WebElement) driver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
							+ "new UiSelector().resourceIdMatches(\"" + resourceId + "\"));"));
		}
		
		public static void swipeStartToEnd(AndroidDriver driver) {		
		WebElement panel = driver.findElement(AppiumBy.id("lists_pager"));
	    Dimension dimension = panel.getSize();//MobileDriver.getDriver().ranage().window()
	    
	    int Anchor = panel.getSize().getHeight()/2;
	    
	    Double ScreenWidthStart = dimension.getWidth() * 0.8;
	    int swipeStart = ScreenWidthStart.intValue();
	    
	    Double ScreenWidthEnd = dimension.getWidth() * 0.2;
	    int swipeEnd = ScreenWidthStart.intValue();		
		}
		
		public static void swipeVerticaly(AndroidDriver driver) {
			WebElement element = (WebElement) driver.findElement(MobileBy.AndroidUIAutomator(
			        "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
			         ".scrollIntoView(new UiSelector().text(\"exact_text\"))"));
		}
       
		public static void swipeHorizontally(AndroidDriver driver) {
			WebElement element = (WebElement) driver.findElement(MobileBy.AndroidUIAutomator(
			        "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList()" +
			         ".scrollIntoView(new UiSelector().text(\"exact_text\"))"));
		}

}
