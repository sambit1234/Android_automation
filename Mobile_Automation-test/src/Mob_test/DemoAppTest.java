package Mob_test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class DemoAppTest {

	
	private static AndroidDriver driver;
	//private static Robot robot;
	
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		DesiredCapabilities capabilities = new  DesiredCapabilities();
		
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Lenovo");
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.flipkart.android");
		capabilities.setCapability("appActivity", "com.flipkart.android.SplashActivity");
		driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		driver.findElement(By.id("com.flipkart.android:id/search_widget_textbox")).click();
		driver.findElement(By.id("com.flipkart.android:id/search_autoCompleteTextView")).sendKeys("iphone7");
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		Thread.sleep(4000);
		/*
		try {
	        robot = new Robot();
	        
	         robot.keyPress(KeyEvent.VK_ENTER);
	       
	         robot.keyRelease(KeyEvent.VK_ENTER);
	    }
		catch (AWTException e) {
			
			
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }*/
		
		//String command = "adb shell input keyevent 66";
		//Process result = Runtime.getRuntime().exec(command);
		
	}

}
