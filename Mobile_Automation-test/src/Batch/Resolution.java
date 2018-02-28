package Batch;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Resolution {
	
	
private static AndroidDriver driver;
private static String appcls = "com.release.muvisdk";
private static String emailid="bruce12@gmail.com";
private static String pwd ="1234";
private static String content = "//android.widget.TextView[@text='MuviShoot']";





// CHANGE ALL CONTENT XPATH LIKE THIS SCRIPT

	
	@BeforeClass
	public void startApp() throws MalformedURLException, InterruptedException
	{
		
		DesiredCapabilities capabilities = new  DesiredCapabilities();
		//capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Lenovo");
		capabilities.setCapability("platformVersion", "4.2.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", appcls);
		capabilities.setCapability("appActivity", "com.home.vod.activity.SplashScreen");
		driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Thread.sleep(15000);
		
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
	public void Quality_144p() throws InterruptedException
	{
		
		System.out.println("-----Selecting 144p Quality-----");
		
		//-------------------------------------------------------------Webelement----------------------------------------------------------------
		
		//clicking "MuviShoot" content
		driver.findElement(By.xpath(content)).click();
		Thread.sleep(4000);
		
		//-------------------------------------------------------------Webelement----------------------------------------------------------------
		
		
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
		
		//clicking Quality button
		driver.findElement(By.id(appcls+":id/resolution_text")).click();
		
		//clicking 144p quality
		driver.findElement(By.xpath("//android.widget.TextView[@text='144p']")).click();
		
		Thread.sleep(5000);
		
		
		
		System.out.println("-----Selected 144p Quality-----");	
		
	}
	
	@AfterMethod(enabled=true)
	public void Back_To_Homepage()
	{
		
		
		driver.pressKeyCode(4);	
		
	}
	
	@Test(priority=2,enabled=true)
	public void Quality_240p() throws InterruptedException
	{
		
		System.out.println("-----Selecting 240p Quality-----");
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
				
		//clicking Quality button
		driver.findElement(By.id(appcls+":id/resolution_text")).click();
				
		//clicking 240p quality
		driver.findElement(By.xpath("//android.widget.TextView[@text='240p']")).click();
				
		Thread.sleep(5000);
		System.out.println("-----Selected 240p Quality-----");
		
		
		
		
	}
	
	@Test(priority=3,enabled=true)
	public void Quality_480p() throws InterruptedException
	{
		
		System.out.println("-----Selecting Best Quality-----");
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
				
		//clicking Quality button
		driver.findElement(By.id(appcls+":id/resolution_text")).click();
					
		//clicking BEST quality
		driver.findElement(By.xpath("//android.widget.TextView[@text='480p']")).click();
				
		Thread.sleep(5000);
		
		System.out.println("-----Selected Best Quality-----");
		
		
		
	}
	@Test(priority=4,enabled=true)
	public void Quality_BEST() throws InterruptedException
	{
		
		System.out.println("-----Selecting Best Quality-----");
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
				
		//clicking Quality button
		driver.findElement(By.id(appcls+":id/resolution_text")).click();
					
		//clicking BEST quality
		driver.findElement(By.xpath("//android.widget.TextView[@text='BEST']")).click();
				
		Thread.sleep(5000);
		
		System.out.println("-----Selected Best Quality-----");
		
		
		
	}
	
	@AfterClass(enabled=true)
	public void Logout() throws InterruptedException
	{
		
		Thread.sleep(3000);
		
        System.out.println("----- Logout -----");
    	
    	//clicking submenu button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	
    	//clicking logout button
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();
    	
    	//clicking "yes" on popup
    	driver.findElement(By.xpath("//android.widget.Button[@text='Yes']")).click();
    	
    	System.out.println("----- Logout Ends -----");
    	
		
		driver.quit();
		
		
		
	}
	


}
