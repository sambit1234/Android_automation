package Mob_test;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MuviApp_Demo 
{

	private static AndroidDriver driver;
	
	@Test
	public void PlusNightsAppDemo() throws MalformedURLException, InterruptedException
	{
		
		DesiredCapabilities capabilities = new  DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Lenovo");
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.release.plusnights");
		capabilities.setCapability("appActivity", "com.home.vod.activity.SplashScreen");
		driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Thread.sleep(25000);
		//driver.findElement(By.xpath("//android.widget.ImageButton[@package='com.release.plusnights']")).click();
		Thread.sleep(30000);
//		driver.findElement(By.xpath("//android.widget.TextView[@text='movies']")).click();
//		Thread.sleep(10000);
//		driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[24,801][348,1251]']")).click();
		
		WebElement wb = driver.findElement(By.xpath("//android.widget.TextView[@text='Plusnights']"));
		boolean status = wb.isDisplayed();
		System.out.println("Title is Displayed "+status);
		//assertTrue(status);
		
		WebElement open=  driver.findElement(By.xpath("//android.widget.ImageButton[@package='com.release.plusnights']"));
		boolean status1 = open.isDisplayed();
		System.out.println("Open button is Displayed "+status1);
		
		WebElement searchbutn = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='search']"));
		boolean status2 = searchbutn.isDisplayed();
		System.out.println("Search button is displayed "+status2);
		
		WebElement optionButn = driver.findElement(By.xpath("//android.widget.TextView[@bounds='[936,87][1080,231]']"));
		boolean status3 = optionButn.isDisplayed();
		System.out.println("Option button is displayed "+status3);
		
		WebElement wlcmNot = driver.findElement(By.xpath("//android.widget.TextView[@text='Sit back, relax and enjoy a movie on us']"));
		boolean status4 = wlcmNot.isDisplayed();
		String value = wlcmNot.getText();
		System.out.println("WelcomeNote is displayed "+status4+" And the Text is "+value);
		
		WebElement vewbutn = driver.findElement(By.xpath("//android.widget.Button[@text='View More']"));
		boolean status5 = searchbutn.isDisplayed();
		String value1 = vewbutn.getText();
		System.out.println("ViewMore button is displayed "+status5+" And the Text is "+value1);
		
		WebElement content = driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[12,1071][336,1533]']"));
		boolean status6 = content.isDisplayed();
		System.out.println("Content is displayed "+status6);
		
		if(status && status1 && status2 && status3 && status4 && status5 && status6)
		{
			System.out.println("Logic Begins From Now");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
