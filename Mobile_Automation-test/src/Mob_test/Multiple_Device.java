package Mob_test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Multiple_Device implements Runnable
{

	private static AndroidDriver driver;
	private static AndroidDriver driver1;
	public void run()
	{
        DesiredCapabilities capabilities = new  DesiredCapabilities();
		
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Lenovo");
		capabilities.setCapability("udid", "0123456789ABCDEF");
		capabilities.setCapability("platformVersion", "6.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.flipkart.android");
		capabilities.setCapability("appActivity", "com.flipkart.android.SplashActivity");
		try {
			driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Complete");
        
		
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Lenovo");
		capabilities.setCapability("udid", "bf58d332");
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.flipkart.android");
		capabilities.setCapability("appActivity", "com.flipkart.android.SplashActivity");
		
		try {
			driver1 =  new AndroidDriver(new URL("http://127.0.0.2:4724/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	

	public static void main(String[] args) throws InterruptedException, IOException 
	{
				
		
		Multiple_Device x = new Multiple_Device();
		Thread t = new Thread(x);
		t.start();
		
	
	}
}
