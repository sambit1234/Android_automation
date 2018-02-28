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

public class Saphr_Register extends Android
{


	private static String email = "Franklin124@mvrht.net";
	
	//Change email before running script
	
	
	/*Open app
	 * click option then register
	 * Give all credential in displaying options
	 * click register
	 * Logout
	 * 
	 * */
	
	public static void logout() throws InterruptedException
	{
		System.out.println("Logout starts...");
		//clicking submenu button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	
    	Thread.sleep(6000);
		
		int l = driver.findElements(By.xpath("//android.widget.FrameLayout[@index='0']"
				+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout")).size();
		
		System.out.println("Size is "+l);
		
		driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
				+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='"+(l-1)+"']")).click();
			 driver.findElement(By.id("android:id/button1")).click();
		    	
		    	System.out.println("Logout ends");
		
	}
	
	@Test
	public void Registering() throws MalformedURLException, InterruptedException
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
		try {
			
			Thread.sleep(25000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id(appcls+":id/submenu")).click();
		
		//clicking register button
		driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
				+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='1']")).click();
		
		driver.findElement(By.id(appcls+":id/editNameStr")).sendKeys("Franklin");
		
		driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(email);
		driver.hideKeyboard();
		
		driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys("123456");
		driver.hideKeyboard();
		
		driver.findElement(By.id(appcls+":id/editConfirmPasswordStr")).sendKeys("123456");
		driver.hideKeyboard();
		driver.findElement(By.id(appcls+":id/registerButton")).click();
		
		Thread.sleep(5000);
		
		System.out.println("Waiting for Homepage visibility");
		
		Thread.sleep(15000);
		
		logout();
	
	}
	
}
