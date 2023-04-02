package org.pocome.TestUtils;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class ParallelBaseTest {
	
	 public ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();
	 public void setDriver(AndroidDriver driver) {
		 this.driver.set(driver);
	 }

	 public AndroidDriver getDriver(){
		 return this.driver.get();
	 }
	 
	 @BeforeMethod(alwaysRun=true)
	 @Parameters({"deviceName","platformVersion","portNumber"})
	 public void initiateDriver(String deviceName, String platformVersion, String portNumber) throws InterruptedException, MalformedURLException {
		
		    startAppiumService(portNumber);
		    UiAutomator2Options options = new UiAutomator2Options();
			options.setCapability("deviceName",deviceName); //emulator
			options.setChromedriverExecutable("C:\\Users\\tahmi\\Downloads\\chromedriver");
			options.setCapability("platformVersion", platformVersion);
			options.setCapability("platformName", "Android");
			options.setApp("C:\\Users\\tahmi\\eclipse-workspace\\TestHive\\src\\test\\java\\org\\elivehive\\resources\\Hive_debug_2022-10-10_version_1.5.4 (1).apk");
			options.setCapability("appPackage", "com.live.hives");
			options.setCapability("appActivity", "com.live.hives.activity.SplashActivity");
			setDriver(new AndroidDriver(new URL("http://127.0.0.1:"+portNumber+"/wd/hub"),options));
			Thread.sleep(5000);
	 }
	 
	 @AfterMethod(alwaysRun=true)
	 public void closeDriver() {
		 getDriver().quit();
	 }
	 
	 public void startAppiumService(String portNumber) {
		 AppiumDriverLocalService service;
		 AppiumServiceBuilder builder = new AppiumServiceBuilder();
		 builder.withIPAddress("127.0.0.1");
		 builder.usingPort(Integer.parseInt(portNumber));
		 service = AppiumDriverLocalService.buildService(builder);
		 service.start();
		 System.out.println("Service has been started with portnumber" + portNumber);
	 }

}
