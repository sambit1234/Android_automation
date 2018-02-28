package Batch;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Subtitle {
	
	
	private static AndroidDriver driver;
	private static String appcls = "com.release.muvisdk";
	private static String emailid="bruce12@gmail.com";
	private static String pwd ="1234";
	
	@BeforeClass
	public void startApp() throws MalformedURLException, InterruptedException
	{
		
		DesiredCapabilities capabilities = new  DesiredCapabilities();
		//capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Lenovo");
		capabilities.setCapability("platformVersion", "4.2.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.release.muvisdk");
		capabilities.setCapability("appActivity", "com.home.vod.activity.SplashScreen");
		driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Thread.sleep(35000);
		
		System.out.println("LOGIN STARTS");
		//clicking submenu button
		driver.findElement(By.id(appcls+":id/submenu")).click();
		Thread.sleep(3000);
		
		//clicking login button
		driver.findElement(By.xpath("//android.widget.TextView[@text='Log in']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your Email Address']")).sendKeys(emailid);
		driver.findElement(By.xpath("//android.widget.EditText[@index='2']")).sendKeys(pwd);
		
		//driver.pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
		
		driver.hideKeyboard();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Login']")).click();
		System.out.println("\n"+"---------LOGIN OPERATION FINISHED-------");
		Thread.sleep(4000);
		
			
		
	}
	
	
	@Test(priority=1)
	public void Subtitle_English() throws InterruptedException
	{
		
		//clicking "Dance plus" content
		driver.findElement(By.xpath("//android.widget.TextView[@text='Dance plus']")).click();
		Thread.sleep(4000);
		
		
		//clicking play button
		driver.findElement(By.id(appcls+":id/playButton")).click();
		
     try {
    	 
			driver.findElement(By.xpath("//android.widget.Button[@text='Cancel']")).click();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Thread.sleep(4000);
		
		//clicking on vdo for getting , setting button
		driver.findElement(By.id(appcls+":id/exomedia_video_view")).click();
		
		//clicking on setting button
		driver.findElement(By.id(appcls+":id/subtitle_change_btn")).click();
		
		//clicking subtitle button
		driver.findElement(By.id(appcls+":id/subtitle_text")).click();
		
		//clicking English subtitle
		driver.findElement(By.xpath("//android.widget.TextView[@text='English']")).click();
		
		Thread.sleep(5000);
		
		
		
		//clicking play button
		//driver.findElement(By.id("com.release.muvisdk:id/playButton")).click();
		
		//clciking back button		
		
	}
	
	@AfterMethod
	public void Back_To_Homepage()
	{
		
		//clicking on vdo fro Back button
		driver.findElement(By.id(appcls+":id/exomedia_video_view")).click();
		
		//clicking back button
		driver.findElement(By.id(appcls+":id/back")).click();		
		
	}
	
	@Test(priority=2)
	public void Subtitle_Abkhazian() throws InterruptedException
	{
		//clicking play button
		driver.findElement(By.id(appcls+":id/playButton")).click();
				
		try {
		    	 
			driver.findElement(By.xpath("//android.widget.Button[@text='Cancel']")).click();
					
					
		} catch (Exception e) {
					// TODO: handle exception
		}
				
		Thread.sleep(4000);
				
		//clicking on vdo for getting , setting button
		driver.findElement(By.id(appcls+":id/exomedia_video_view")).click();
				
		//clicking on vdo for getting , setting button
		//driver.findElement(By.id("com.release.muvisdk:id/exomedia_video_view")).click();
				
		//clicking on setting button
		driver.findElement(By.id(appcls+":id/subtitle_change_btn")).click();
				
		//clicking subtitle button
		driver.findElement(By.id("com.release.muvisdk:id/subtitle_text")).click();
				
		//clicking Abkhazian subtitle
		driver.findElement(By.xpath("//android.widget.TextView[@text='Abkhazian']")).click();
				
		Thread.sleep(5000);
		
		
		
	}
	
	@Test(priority=3)
	public void Subtitle_OFF() throws InterruptedException
	{
		//clicking play button
		driver.findElement(By.id("com.release.muvisdk:id/playButton")).click();
				
		try {
		    	 
			driver.findElement(By.xpath("//android.widget.Button[@text='Cancel']")).click();
					
					
		} catch (Exception e) {
					// TODO: handle exception
		}
				
		Thread.sleep(4000);
				
		//clicking on vdo for getting , setting button
		driver.findElement(By.id("com.release.muvisdk:id/exomedia_video_view")).click();
				
		//clicking on vdo for getting , setting button
		//driver.findElement(By.id("com.release.muvisdk:id/exomedia_video_view")).click();
				
		//clicking on setting button
		driver.findElement(By.id("com.release.muvisdk:id/subtitle_change_btn")).click();
				
		//clicking subtitle button
		driver.findElement(By.id("com.release.muvisdk:id/subtitle_text")).click();
				
		//clicking Abkhazian subtitle
		driver.findElement(By.xpath("//android.widget.TextView[@text='Off']")).click();
				
		Thread.sleep(5000);	
		
	}
	
	@Test
	public void DemoTest()
	{
		
		driver.findElement(By.xpath("//android.widget.Button[@text='Cancel']")).click();
		
	}
	
	@AfterClass
	public void Logout() throws InterruptedException
	{
		
		Thread.sleep(3000);
		
		//clicking back button
		//driver.findElement(By.id("com.release.muvisdk:id/back")).click();
		
		System.out.println("\n"+"---------LOGOUT OPERATION STARTS-------");
		//clicking submenu button
		driver.findElement(By.id(appcls+":id/submenu")).click();
		Thread.sleep(4000);
		//clicking logout button
		driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Yes']")).click();
		
		System.out.println("\n"+"---------LOGOUT OPERATION FINISHED-------");	
		Thread.sleep(5000);
		
		driver.quit();
		
		
		
	}
	
	
	
}
