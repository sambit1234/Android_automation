package Test_11649;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.remote.MobileCapabilityType;

public class Offline {
	
	/*
	 * Open App and login
	 * 
	 * */
	
	private static AndroidDriver driver;
	private static String appcls = "com.release.leasy";
	private static String emailid="bruce1@gmail.com";
	private static String pwd ="123456";
	private static String logoutbutton = "//android.widget.TextView[@text='Log ud']";
	private static String menubutton = "//android.widget.ImageButton[@bounds='[0,72][168,240]']";
	private static String content = "//android.widget.TextView[@text='La La Land']";
	private static String r480p = "//android.widget.RadioButton[@text='  480p (632.2 MB)']";
	private static String r720p = "//android.widget.RadioButton[@text='  720p (1093.7 MB)']";
	private static String BEST = "//android.widget.RadioButton[@text='  BEST (2445.3 MB)']";
	
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
		System.out.println("Offline method started...");
		Thread.sleep(20000);
		
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
		
		System.out.println("Clicking On Content...");
		
		//clicking "La La Land" content
		driver.findElement(By.xpath(content)).click();
		Thread.sleep(3000);
		
		//clicking play button in vdo
		driver.findElement(By.id(appcls+":id/playButton")).click();
		
		try {
	    	 
			//driver.findElement(By.xpath("//android.widget.Button[@text='Cancel']")).click();
		      driver.findElement(By.id(appcls+":id/yesButton")).click();
					
					
			} catch (Exception e) {
		// TODO: handle exception
			}
		
		
		System.out.println("Clicking on download button...");
		
		//clicking download button
		driver.findElement(By.id(appcls+ ":id/downloadImageView")).click();
		
		Thread.sleep(3000);
		
		System.out.println("Now displaying Save Offline Video popup");
		
		Thread.sleep(9000);
		
		
		
		
		//---------------------------------------------------CLICKING 480p-------------------------------------------------
		
		try {
			//clicking  480p from "Save Offline Video" popup
			driver.findElement(By.xpath(r480p)).click();
			
			//clicking save button
			driver.findElement(By.id(appcls+":id/save")).click();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//clicking OK button after vdo downloaded.
		//driver.findElement(By.id("android:id/button2")).click();
		
		Thread.sleep(10000);
		driver.pressKeyCode(4);
		
		Thread.sleep(2000);
    	
    	System.out.println("\n"+"---------LOGOUT OPERATION STARTS-------");
    	//clicking submenu button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	
    	//clicking logout button
    	driver.findElement(By.xpath(logoutbutton)).click();
    	
    	//clicking "yes" on popup
    	driver.findElement(By.id("android:id/button1")).click();
    	
    	System.out.println("\n"+"---------LOGOUT OPERATION FINISHED-------");
		
    	System.out.println("Offline method finished...");
		
	}

}
