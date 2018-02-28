package Test_11649;

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
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class Banner_Content_size {
	
	/*
	 * Open App check homepage banner
	 * open single part content and check banner
	 * Open multipart content and check banner
	 * 
	 * */
	
	private static AndroidDriver driver;
	private static String appcls = "com.release.leasy";
	private static String emailid="bruce1@gmail.com";
	private static String pwd ="123456";
	private static String singlcontent = "//android.widget.TextView[@text='La La Land']";
	//single part content is "Cultural Singing"
	private static String multicontent = "//android.widget.TextView[@text='Awards Distribution among Muvians']";
	
	
	
	
	
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
		
		System.out.println("Banner size method started...");
		Thread.sleep(15000);
		
		
	}
	
	@Test(priority=1,enabled=true)
	public void HomepageBanner() throws MalformedURLException, InterruptedException
	{
		
		
		int exphight = 510;
		int expwidth = 1080;
		
		//checking size of homepage banner
		WebElement banner = driver.findElement(By.id(appcls+":id/daimajia_slider_image"));
		int hight = banner.getSize().height;
		int width = banner.getSize().width;
		
		//assertEquals(hight, exphight, "Hight is not matching");
		//assertEquals(width, expwidth, "Width is not matching");
		
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
	public void SinglepartBanner() throws InterruptedException
	{
		
		int exphight = 630;
		int expwidth = 1080;
		
		//--------------------------------------------------------Webelement------------------------------------------------------
		
		//clicking on "Cultural Singing" single part content
		driver.findElement(By.xpath(singlcontent)).click();
		
		//--------------------------------------------------------Webelement------------------------------------------------------
		
		//checking size of content banner
		WebElement banner = driver.findElement(By.id(appcls+":id/bannerOverlay"));
		
		int hight = banner.getSize().height;
		int width = banner.getSize().width;
		
		assertEquals(hight, exphight, "Hight is not matching");
		assertEquals(width, expwidth, "Width is not matching");
		
		System.out.println("Hight is "+hight+" and width is "+width);
		System.out.println("Banner size is "+banner.getSize());
		
		Thread.sleep(5000);
		
		driver.pressKeyCode(4);	
		
		
		
	}
	
	@Test(priority=3,enabled=false)
	public void MultipartBanner()
	{
		
		int exphight = 630;
		int expwidth = 1080;
		
		//scrolling Down
		Dimension dimensions = driver.manage().window().getSize();
						
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();			
		Double screenHeightEnd = dimensions.getHeight() * 0.3;
		int scrollEnd = screenHeightEnd.intValue();
		driver.swipe(0,scrollStart,0,scrollEnd,2000);
		
		
		//-----------------------------------------------------------Webelement-----------------------------------------------------
		
		//clicking "Death Note 1" multipart content 
		driver.findElement(By.xpath(multicontent)).click();
		
		//-----------------------------------------------------------Webelement-----------------------------------------------------
		
		//checking content banner
		WebElement banner = driver.findElement(By.id(appcls+":id/bannerOverlay"));
		
		int hight = banner.getSize().height;
		int width = banner.getSize().width;
		
		assertEquals(hight, exphight, "Hight is not matching");
		assertEquals(width, expwidth, "Width is not matching");
		
		System.out.println("Hight is "+hight+" and width is "+width);
		System.out.println("Banner size is "+banner.getSize());
		
		System.out.println("Banner size method finished...");
		
	}

}
