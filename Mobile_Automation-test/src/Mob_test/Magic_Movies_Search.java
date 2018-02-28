package Mob_test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class Magic_Movies_Search {

	
private static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		DesiredCapabilities capabilities = new  DesiredCapabilities();
		
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Lenovo");
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.release.magicmovies");
		capabilities.setCapability("appActivity", "com.home.vod.activity.SplashScreen");
		driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Thread.sleep(30000);
		
		driver.findElement(By.id("com.release.magicmovies:id/action_search")).click();
		
		driver.findElement(By.id("com.release.magicmovies:id/search_src_text")).sendKeys("friends");
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		
		System.out.println("Finished");
		
	}
}
