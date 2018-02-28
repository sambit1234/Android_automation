package Mob_test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import Generic_Library.Log;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/*
 * Open App and login
 * click on content
 * add to fav
 * click on My Fav
 * check content is displaying or not
 * click on content
 * remove from fav list
 * Again click on My fav
 * Verify content should not be there.
 * logout
 * */

public class Demo1 {
	
	private static AndroidDriver driver;
	private static String appcls = "com.release.muvisdk";
	private static String emailid="bruce12@gmail.com";
	private static String pwd ="1234";
	private static String content = "//android.widget.TextView[@text='MuviShoot']";
	
	@Test
	public void Succes_Result() throws MalformedURLException, InterruptedException 
	{
		
	DesiredCapabilities capabilities = new  DesiredCapabilities();
	capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
	capabilities.setCapability("deviceName", "Lenovo");
	capabilities.setCapability("platformVersion", "4.2.2");
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("appPackage", appcls);
	capabilities.setCapability("appActivity", "com.home.vod.activity.SplashScreen");
	driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	Thread.sleep(35000);
	
	
	System.out.println("-------LOGIN STARTS------");
	//clicking submenu button
	driver.findElement(By.id(appcls+":id/submenu")).click();
	Thread.sleep(3000);
	
	//clicking login button
	driver.findElement(By.xpath("//android.widget.TextView[@text='Log in']")).click();
	driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your Email Address']")).sendKeys(emailid);
	driver.findElement(By.xpath("//android.widget.EditText[@index='2']")).sendKeys(pwd);
	
	//driver.pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
	
	driver.hideKeyboard();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//android.widget.Button[@text='Login']")).click();
	System.out.println("\n"+"---------LOGIN OPERATION FINISHED-------");

	Thread.sleep(10000);
	
	 System.out.println("----- Logout -----");
	 
	 driver.pressKeyCode(4);
	
	//clicking submenu button
	driver.findElement(By.id(appcls+":id/submenu")).click();
	
	//clicking logout button
	driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();
	
	//clicking "yes" on popup
	driver.findElement(By.xpath("//android.widget.Button[@text='Yes']")).click();
	
	System.out.println("Logout Finished...");		
	
	
	
	}

}
