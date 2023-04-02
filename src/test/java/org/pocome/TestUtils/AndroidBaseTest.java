
package org.pocome.TestUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.pocome.Utils.AppiumUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class AndroidBaseTest extends AppiumUtils{

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\tahmi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Android"); //emulator
		options.setChromedriverExecutable("C:\\Users\\tahmi\\Downloads\\chromedriver");
		options.setApp("C:\\Users\\tahmi\\eclipse-workspace\\AppiumPoco\\Poco\\src\\test\\java\\org\\pocome\\resources\\Poco_debug_2023-03-30_version_1.3.0.apk");
		driver = new AndroidDriver(new URL ("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
		
	@AfterClass
	public void TearDown() 
	{
		
	} 
	
}

