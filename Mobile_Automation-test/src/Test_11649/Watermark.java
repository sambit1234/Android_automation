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
import Generic_Library.Log;

public class Watermark {
	
	/*
	 * Open app and login
	 * Click Muvishoot content
	 * click play button
	 * Verify watermark is displaying or not
	 * Verify ip,email,Date
	 * click back
	 * logout
	 * */
	
	//before running this script make sure you have logged out
	
	private static AndroidDriver driver;
	private static String appcls = "com.release.muvisdk";
	private static String emailid="bruce1@gmail.com";
	private static String pwd ="1234";
	private static String content = "//android.widget.TextView[@text='MuviShoot']";
	
	@Test
	public void watermark() throws MalformedURLException, InterruptedException 
	{
		
	DesiredCapabilities capabilities = new  DesiredCapabilities();
	capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
	capabilities.setCapability("deviceName", "Lenovo");
	capabilities.setCapability("platformVersion", "4.2.2");
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("appPackage", appcls);
	capabilities.setCapability("appActivity", "com.home.vod.activity.SplashScreen");
	driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	Thread.sleep(35000);
	
	
	System.out.println("-------LOGIN STARTS------");
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
	Log.info("\n"+"---------LOGIN OPERATION FINISHED BY LOG4J-------");
	
	
	Thread.sleep(4000);
	
	//-----------------------------------------------------------------Webelement------------------------------------------------------------------
	
	//clicking "MuviShoot" content
	driver.findElement(By.xpath(content)).click();
	Thread.sleep(4000);
	
	//-----------------------------------------------------------------Webelement------------------------------------------------------------------
			
	//clicking play button
	driver.findElement(By.id(appcls+":id/playButton")).click();
	Log.info("Play button clicked");
			
	try {
	    	 
		driver.findElement(By.id(appcls+":id/cancelButton")).click();
		
		} catch (Exception e) {
	// TODO: handle exception
		}
			
	
	Thread.sleep(4000);
	
    WebElement wtrmrk = driver.findElement(By.id(appcls+":id/linearLayout1"));
	boolean wtr_status = wtrmrk.isDisplayed();
	System.out.println("Watermark is displaying ..."+wtr_status);
	Thread.sleep(2000);
	if(wtr_status)
	{
		
	Log.info("Now checking ip,email,date in watermark...");
	Thread.sleep(3000);
	WebElement ip = driver.findElement(By.id(appcls+":id/emailAddressTextView"));
	WebElement email = driver.findElement(By.id(appcls+":id/ipAddressTextView"));
	WebElement date = driver.findElement(By.id(appcls+":id/dateTextView"));
	
	boolean ip_status = ip.isDisplayed();
	boolean email_status = email.isDisplayed();
	boolean date_status = date.isDisplayed();
	
	System.out.println("ip is displaying..."+ip_status);
	System.out.println("email is displaying..."+email_status);
	System.out.println("date is displaying..."+date_status);
	
	Thread.sleep(3000);
	
		if(ip_status && email_status && date_status)
		{
			Log.info("Watermark's contents are displaying correctly");
			
		}
		else
		{
			System.out.println("Watermark contents are not there...try again");
		}
	
	}
	else {
		System.out.println("Watermark is not displaying");
	}
	
	
	Thread.sleep(4000);
	
	 System.out.println("----- Logout -----");
	 
	 driver.pressKeyCode(4);
	
	//clicking submenu button
	driver.findElement(By.id(appcls+":id/submenu")).click();
	
	//clicking logout button
	driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();
	
	//clicking "yes" on popup
	driver.findElement(By.xpath("//android.widget.Button[@text='Yes']")).click();
	
	Log.info("----- Logout Ends -----");		
	
	
	}
}
