package Generic_Library;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Android {
	
	public static AndroidDriver driver;
	public static String appcls = "com.release.muvisdk";
	public static String emailid="bruce12@gmail.com";
	public static String pwd ="1234";


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
	
	public static void login() throws InterruptedException
	{
		
		System.out.println("Login Starts...");
		//clicking submenu button
		driver.findElement(By.id(appcls+":id/submenu")).click();
		
		//clicking login button
		driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
				+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='0']")).click();
		
    	driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
    	driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys(pwd);
    	
    	driver.hideKeyboard();
    	Thread.sleep(3000);
    	driver.findElement(By.id(appcls+":id/loginButton")).click();
    	
    	System.out.println("Login ended...");
		
	}
	
	public static void scroll()
	{
		
		Dimension dimensions = driver.manage().window().getSize();
		
    	Double screenHeightStart = dimensions.getHeight() * 0.5;
    	int scrollStart = screenHeightStart.intValue();			
    	Double screenHeightEnd = dimensions.getHeight() * 0.1;
    	int scrollEnd = screenHeightEnd.intValue();
    	driver.swipe(0,scrollStart,0,scrollEnd,2000);
		
	}
	
	public static void screenshot()
	{
		
		EventFiringWebDriver ed = new EventFiringWebDriver(driver);
    	
    	File src = ed.getScreenshotAs(OutputType.FILE);
    	File dst = new File("D:\\Screenshots\\Sapphire.png");
    	
    	try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
