package org.pocome.Utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {
	AppiumDriver driver;
	public AppiumDriverLocalService service;
	
	
	public AppiumUtils() {
		super();
	}

	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	public AppiumUtils(AppiumDriver driver)
	{
		this.driver = driver;
	}
	
	public void waitForElementToAppear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains((ele),"text" , "cart"));
	}
	
	public String getScreenshotPath(String testCaseName , AppiumDriver driver) throws IOException
	{
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"//reports"+testCaseName+".png";
		FileHandler.copy(source , new File(destinationFile));
		return destinationFile;
		//1. capture and place in folder 2. extent report pick file and attach to report
	}
	
	public AppiumDriverLocalService startAppiumServer()
	{
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\tahmi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		return service;
	}

}
