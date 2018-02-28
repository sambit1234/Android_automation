package Sprint3;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Generic_Library.Android;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class Banner_Content_size extends Android
{
	
	/*
	 * Open App check homepage banner
	 * open single part content and check banner
	 * Open multipart content and check banner
	 * 
	 * */
	
	
	
	
	// Ask for making script manually for separate like single part and multipart.
	
	
	
	@BeforeClass
	public void startApp() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities capabilities = new  DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Lenovo");
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", appcls);
		capabilities.setCapability("appActivity", "com.home.vod.activity.SplashScreen");
		driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Thread.sleep(15000);
		
		
	}
	
	@Test(priority=1,enabled=true)
	public void HomepageBanner() throws MalformedURLException, InterruptedException
	{
		
		System.out.println("Homepage banner method...");
		//int exphight = 510;
		//int expwidth = 1080;
		
		//checking size of homepage banner
		WebElement banner = driver.findElement(By.id(appcls+":id/daimajia_slider_image"));
		int hight = banner.getSize().height;
		int width = banner.getSize().width;
		
		boolean status = banner.isDisplayed();
		
		//assertEquals(hight, exphight, "Hight is not matching");
		//assertEquals(width, expwidth, "Width is not matching");
		
		System.out.println("Homepage banner is displaying "+status );
		System.out.println("Hight is "+hight+" and width is "+width);
		System.out.println("Banner size is "+banner.getSize());
		
		Thread.sleep(5000);
	
		
	}
	
	@AfterTest
	public void closeApp()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.pressKeyCode(4);
		System.out.println("Closing app for next Method");
		driver.quit();
	}
	
	@Test(priority=2,enabled=true)
	public void ContentBanner() throws InterruptedException
	{
		
		Thread.sleep(4000);
		//int exphight = 630;
		//int expwidth = 1080;
		
		//--------------------------------------------------------Webelement------------------------------------------------------
		
		WebElement content =driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.support.v7.widget.RecyclerView[@index='2']/"
				+ "android.widget.RelativeLayout[@index='0']/"
				+ "android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']"));
    	
    	
    	String content_name = content.getText();
		System.out.println("Content name is "+content_name);
    	content.click();
		
		//--------------------------------------------------------Webelement-------------------------------------------------------
		
    	boolean st = false;
		
		try {
			st = driver.findElement(By.id(appcls+":id/playButton")).isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(st)
		{
			Thread.sleep(3000);
			System.out.println("This is single part content...");
			
		//checking size of content banner
		WebElement banner = driver.findElement(By.id(appcls+":id/bannerOverlay"));
		
		boolean singlpst = banner.isDisplayed();
		int hight = banner.getSize().height;
		int width = banner.getSize().width;
		
		//assertEquals(hight, exphight, "Hight is not matching");
		//assertEquals(width, expwidth, "Width is not matching");
		
		System.out.println("Hight is "+hight+" and width is "+width);
		System.out.println("Banner size is "+banner.getSize());
		System.out.println("Single part content banner is displaying "+singlpst);
		
		Thread.sleep(5000);
		
		driver.pressKeyCode(4);	
		}
		else {
			
			Thread.sleep(4000);
			System.out.println("It is Multipart content");
			
			Thread.sleep(3000);
			//checking size of content banner
			WebElement banner = driver.findElement(By.id(appcls+":id/bannerOverlay"));
			
			boolean Multipst = banner.isDisplayed();
			int hight = banner.getSize().height;
			int width = banner.getSize().width;
			
			//assertEquals(hight, exphight, "Hight is not matching");
			//assertEquals(width, expwidth, "Width is not matching");
			
			System.out.println("Hight is "+hight+" and width is "+width);
			System.out.println("Banner size is "+banner.getSize());
			System.out.println("Multi part content banner is displaying "+Multipst);
			
			Thread.sleep(5000);
			
			driver.pressKeyCode(4);	
			
		}
		
		
	}

}
