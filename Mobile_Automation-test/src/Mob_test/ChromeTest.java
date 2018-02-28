package Mob_test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ChromeTest 
{

	@Test
	public void testing() throws MalformedURLException
	{
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
		
		capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
		
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Lenovo");
		
		capabilities.setCapability(MobileCapabilityType.VERSION, "5.1.1");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		WebDriver driver = new AndroidDriver(url,capabilities);
		
		driver.get("https://www.google.co.in/");
		
		driver.findElement(By.id("m_login_email")).sendKeys("tuser1581@gmail.com");
		
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("india12345");
		
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		String title = driver.getTitle();
//		
		System.out.println(title);
		
		
		
		
		
		
		
		
	}
	
}
