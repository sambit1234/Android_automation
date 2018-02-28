package Sprint1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import Generic_Library.Android;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Forgot_Password extends Android
{

	/*
	 * Open App
	 * click option button
	 * Then click login
	 * Click forgot password
	 * Enter registerd email id
	 * Click "Ok" after successfull message
	 * quit
	 * */
	@Test
	public void SapphireAppDemo() throws MalformedURLException, InterruptedException
	{
		
		DesiredCapabilities capabilities = new  DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Lenovo");
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", appcls);
		capabilities.setCapability("appActivity", "com.home.vod.activity.SplashScreen");
		driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(30000);
		
		driver.findElement(By.id(appcls+":id/submenu")).click();
		
		//clciking login button
		driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
				+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='0']")).click();
		
		Thread.sleep(3000);
				
		driver.findElement(By.id(appcls+":id/forgotPasswordTextView")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
		driver.hideKeyboard();
		
		driver.findElement(By.id(appcls+":id/submitButton")).click();
		
		//after submitting capturing msg
		String msg = driver.findElement(By.id("android:id/message")).getText();
		System.out.println("After submitting we are getting message "+msg);
		
		Thread.sleep(3000);
		//clicking ok button
		driver.findElement(By.id("android:id/button1")).click();
		
		
		
		
		
		
	
	}
}
