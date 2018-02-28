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

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Banner_Size_TAB {
	
private static AndroidDriver driver;
	
	//Tested in Iball Phone 
	
	
	@BeforeClass
	public void startApp() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities capabilities = new  DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Lenovo");
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.release.muvisdk");
		capabilities.setCapability("appActivity", "com.home.vod.activity.SplashScreen");
		driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Thread.sleep(30000);
		
		
	}
	
	@Test(priority=1,enabled=true)
	public void HomepageBanner() throws MalformedURLException, InterruptedException
	{
		
		
		int exphight = 330;
		int expwidth = 790;
		
		//checking size of homepage banner
		//WebElement banner = driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[15,258][1065,948]']"));
		WebElement banner = driver.findElement(By.id("com.release.muvisdk:id/daimajia_slider_image"));
		int hight = banner.getSize().height;
		int width = banner.getSize().width;
		
		assertEquals(hight, exphight, "Hight is not matching");
		assertEquals(width, expwidth, "Width is not matching");
		
		System.out.println("Homepage Hight is "+hight+" and Homepage width is "+width);
		System.out.println("Banner size is "+banner.getSize());
		
		Thread.sleep(5000);
	
		
	}
	
	@AfterTest
	public void closeApp()
	{
		
	}
	@Test(priority=2,enabled=true)
	public void SinglepartBanner() throws InterruptedException
	{
		
		int exphight = 300;
		int expwidth = 800;
		
		//clicking on "Deadpool 2 trailer" single part content
		driver.findElement(By.xpath("//android.widget.TextView[@text='Deadpool 2 Trailer']")).click();
		
		//checking size of content banner
		WebElement banner = driver.findElement(By.id("com.release.muvisdk:id/bannerOverlay"));
		
		int hight = banner.getSize().height;
		int width = banner.getSize().width;
		
		assertEquals(hight, exphight, "Hight is not matching");
		assertEquals(width, expwidth, "Width is not matching");
		
		System.out.println("Singlepart Hight is "+hight+" and Singlepart width is "+width);
		System.out.println(" Banner size is "+banner.getSize());
		
		Thread.sleep(5000);
		
		driver.pressKeyCode(4);	
		
		
		
	}
	
	@Test(priority=3,enabled=true)
	public void MultipartBanner() throws InterruptedException
	{
		
		int exphight = 210;
		int expwidth = 800;
		
		
		
		//clicking "Death Note 1" multipart content 
		driver.findElement(By.xpath("//android.widget.TextView[@text='Death Note 1']")).click();
		
		//checking content banner
		WebElement banner = driver.findElement(By.id("com.release.muvisdk:id/bannerOverlay"));
		
		int hight = banner.getSize().height;
		int width = banner.getSize().width;
		
		assertEquals(hight, exphight, "Hight is not matching");
		assertEquals(width, expwidth, "Width is not matching");
		
		System.out.println("Multipart banner Hight is "+hight+" and Multipart banner width is "+width);
		System.out.println("Banner size is "+banner.getSize());
		
        Thread.sleep(5000);
		
		driver.pressKeyCode(4);	
		
		
	}


}
