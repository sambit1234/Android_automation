package Test_11649;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ZMyDownloads {
	
	
	private static AndroidDriver driver;
	private static String appcls = "com.release.leasy";
	private static String emailid="bruce1@gmail.com";
	private static String pwd ="123456";
	private static String menubutton = "//android.widget.ImageButton[@bounds='[0,72][168,240]']";
	private static String mydownload = "//android.widget.TextView[@text='Mine downloads']";
	private static String con = "//android.widget.TextView[@text='La La Land']";
	private static String logoutbutton = "//android.widget.TextView[@text='Log ud']";
	
	@Test
	public void OffLine() throws MalformedURLException, InterruptedException
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
		
		System.out.println("My download method started...");
		
		Thread.sleep(30000);
		
		System.out.println("----------Login Starts ---------");
		//clicking submenu button
		driver.findElement(By.id(appcls+":id/submenu")).click();
    	Thread.sleep(3000);
    	
    	//clicking login button
    	driver.findElement(By.id(appcls+":id/title")).click();
    	driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
    	driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys(pwd);
    	
    	
    	driver.hideKeyboard();
    	Thread.sleep(3000);
    	driver.findElement(By.id(appcls+":id/loginButton")).click();
    	System.out.println("\n"+"---------LOGIN OPERATION FINISHED-------");
		Thread.sleep(4000);
		
		System.out.println("Clicking My Downloads...");
		//clicking in submenu 
	    WebElement submenuButton = driver.findElement(By.id(appcls+":id/submenu"));
	    submenuButton.click();
	    
	    //clicking "My Download" 
	    driver.findElement(By.xpath(mydownload)).click();
	    
	    //----------------------------------------------------------Webelement-------------------------------------------------------///////
	    
	    WebElement content = driver.findElement(By.xpath(con));
		boolean status = content.isDisplayed();
		
		if(status)
		{
			System.out.println("Downloaded content is showing properly...");
			//clicking on content
			content.click();
			
			
			//waiting 5 sec and watching vdo
			Thread.sleep(5000);
			
			try {
		    	 
				//driver.findElement(By.xpath("//android.widget.Button[@text='Cancel']")).click();
			      driver.findElement(By.id(appcls+":id/yesButton")).click();
						
						
				} catch (Exception e) {
			// TODO: handle exception
				}
			
			//wait 5sec for checking vdo is playing
			Thread.sleep(5000);
			
			driver.pressKeyCode(4);
			
			//clicking delete icon
			driver.findElement(By.id(appcls+":id/imageView1")).click();
			
			//clicking DELETE in popup
			//driver.findElement(By.id("android:id/button1")).click();
			
			
			
		}
		
		Thread.sleep(3000);
		
		driver.pressKeyCode(4);
		
		Thread.sleep(3000);
		
		 System.out.println("----- Logout -----");
		 	
		 	//clicking submenu button
		 	driver.findElement(By.id(appcls+":id/submenu")).click();
		 	
		 	//clicking logout button
		 	driver.findElement(By.xpath(logoutbutton)).click();
		 	
		 	//clicking "yes" on popup
		 	driver.findElement(By.id("android:id/button1")).click();
		 	
		 	System.out.println("----- Logout Ends -----");		
			
		 	System.out.println("My download method finished...");
		
		// Following comment section is written acc previous app where in one flow, all script were running.
		
		/*
		//clicking play button in vdo
		driver.findElement(By.id("com.release.magicmovies:id/playButton")).click();
				
		try {
			    	 
			
			driver.findElement(By.id(appcls+":id/yesButton")).click();
							
							
			} catch (Exception e) {
			// TODO: handle exception
			}
		
		//checking download option is visible or not
		boolean st = driver.findElement(By.id("com.release.magicmovies:id/downloadImageView")).isDisplayed();
		
		if(st)
		{
			
			System.out.println("After deleting vdo from my downloads, download option is displaying");
			
		}
		*/
		
		
		
		
		
		
		
	}

}
