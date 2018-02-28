package Test_11649;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextListener;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Player_Control 
{
	
	/*
	 * Open App and Login
	 * Click "MuviShoot" content
	 * click play button 
	 * wait for 6sec and click pause button
	 * wait for 6sec
	 * Maximize it, Minimize and click back
	 * Logout
	 * */

	
	//before running this script make sure you logges out
	
	private static AndroidDriver driver;
	private static String appcls = "com.release.leasy";
	private static String emailid="bruce1@gmail.com";
	private static String pwd ="123456";
	private static String logoutbutton = "//android.widget.TextView[@text='Log ud']";
	private static String content = "//android.widget.TextView[@text='La La Land']";
	
	@Test
	public void Screen() throws MalformedURLException, InterruptedException {
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
	
	
	System.out.println("Player control method started..."); 
	
	Thread.sleep(25000);
	
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
	Thread.sleep(8000);
	
	//-----------------------------------------------------------------Webelement------------------------------------------------------------------
	
	System.out.println("Clicking on Content...");
	//clicking "La La Land" content
	driver.findElement(By.xpath(content)).click();
	Thread.sleep(8000);
	
	//-----------------------------------------------------------------Webelement------------------------------------------------------------------
	
	
	System.out.println("Clicking Play button");
	//clicking play button
	driver.findElement(By.id(appcls+":id/playButton")).click();
	
	
	Thread.sleep(20000);
	try {
	    	 
		driver.findElement(By.id(appcls+":id/cancelButton")).click();
		
		} catch (Exception e) {
	// TODO: handle exception
		}
			
	
	Thread.sleep(6000);
	
	//clicking on vdo for getting , play/pause button
	driver.findElement(By.id(appcls+":id/exomedia_video_view")).click();	
	
	//clicking pause button
	driver.findElement(By.id(appcls+":id/latest_center_play_pause")).click();
	
	//clicking play button after 6 sec
	Thread.sleep(6000);
	
	// Again clicking on screen for getting play/pause button
	driver.findElement(By.id(appcls+":id/exomedia_video_view")).click();
	
	//clicking play button
	driver.findElement(By.id(appcls+":id/latest_center_play_pause")).click();
	
	Thread.sleep(6000);

	//clicking on vdo for getting , screen button
	driver.findElement(By.id(appcls+":id/exomedia_video_view")).click();	
	
	
	System.out.println("Maximizing ......");
	//Maximizing
	driver.findElement(By.id(appcls+":id/compress_expand")).click();
	
	//Waiting 6 sec for minmizing
	Thread.sleep(6000);
			
	// Again clicking on screen for minimizing
	driver.findElement(By.id(appcls+":id/exomedia_video_view")).click();
	
	
	System.out.println("Minimizing .....");
	//clicking minimize button
	driver.findElement(By.id(appcls+":id/compress_expand")).click();
	
	Thread.sleep(6000);
	
	// Again clicking on screen for minimizing
	driver.findElement(By.id(appcls+":id/exomedia_video_view")).click();
			
	    //After minimizing clicking back button
	
	driver.pressKeyCode(4);
			
	Thread.sleep(4000);
	 System.out.println("----- Logout -----");
 	
 	//clicking submenu button
 	driver.findElement(By.id(appcls+":id/submenu")).click();
 	
 	//clicking logout button
 	driver.findElement(By.xpath(logoutbutton)).click();
 	
 	//clicking "yes" on popup
 	driver.findElement(By.id("android:id/button1")).click();
 	
 	System.out.println("----- Logout Ends -----");		
 	System.out.println("Player control method Finished..."); 
	}

}
