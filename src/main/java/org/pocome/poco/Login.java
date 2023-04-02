package org.pocome.poco;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.pocome.Utils.AndroidActions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Login extends AndroidActions{

    private static final Login Failed = null;

	AndroidDriver driver;
    public Login(AndroidDriver driver)
    {
    	 super(driver);
    	 this.driver = driver;
    	 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.Button[2]")
	private WebElement googleLogin;
    
    @AndroidFindBy(id = "com.live.hives:id/txtAllowPermission")
    private WebElement allowPermission;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private WebElement recordVideo;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")
    private WebElement deviceLocation;
    @AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")
    private WebElement recordAudio;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")
    private WebElement accessPhotos;
    
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.ImageView")
	private WebElement profileFragment;
    @AndroidFindBy(id = "com.live.hives:id/settingTV")
	private WebElement Settings;
    @AndroidFindBy(id = "com.live.hives:id/log_out")
	private WebElement Logout;

    @AndroidFindBy(id = "com.live.hives:id/fbLoginLV")
    private WebElement FbLogin;
    
    
    public void setGmailId()
    {   
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	googleLogin.click();
    	driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    
    public void setPermission() throws InterruptedException
    {
    	Thread.sleep(3000);
    	allowPermission.click();
    	Thread.sleep(1000);
    	recordVideo.click();
    	Thread.sleep(1000);
    	deviceLocation.click();
    	Thread.sleep(1000);
    	recordAudio.click();
    	Thread.sleep(2000);
    	accessPhotos.click();
    	Thread.sleep(2000);
    }
    
    public void setLogout() throws InterruptedException
    {
    	 profileFragment.click();
    	// scrollToId(driver, "com.live.hives:id/settingTV");
    	 scrollToEnd();
    	 Thread.sleep(1000);
    	 Settings.click();
    	 Thread.sleep(1000);
    	 scrollToEnd();
    	 //scrollToText("Logout");
    	 Logout.click();
    	 driver.findElement(AppiumBy.id("com.live.hives:id/btn_yes")).click();
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    
    public void setFBId()
    {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	FbLogin.click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
     
    public void LoginStatus()
    {
      Login login = new Login(driver);
      if(login == Failed) {
    	  System.out.println("Login Failed"); 
      }
      else {System.out.println("Login TestSuit Run Sucessfully");}
    }
}

