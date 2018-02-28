package Test_11649;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class Profile_Page 
{

	
	private static AndroidDriver driver;
	private static String appcls = "com.release.leasy";
	private static String emailid="bruce1@gmail.com";
	private static String pwd ="123456";
	private static String menubutton = "//android.widget.ImageButton[@bounds='[0,72][168,240]']";
	private static String profilebutton = "//android.widget.TextView[@text='Profil']";
	private static String logoutbutton = "//android.widget.TextView[@text='Log ud']";

	/*
	 * Login
	 * Edit profile name
	 * Click profile page and validate edited user name
	 * Logout
	 * */
	@Test
	public void Profilepage() throws MalformedURLException, InterruptedException
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
		System.out.println("Profile page method started...");
		
		Thread.sleep(25000);
		String ExpectedName = "Bruce Banner";
		String ExpectedEmail = "bruce1@gmail.com";
		
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
		
		
    	//checking email and name
    	// clicking submenu
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	driver.findElement(By.xpath(profilebutton)).click();
    	WebElement emailbox = driver.findElement(By.id(appcls+":id/editProfileNameEditText"));
    	String ActualName = emailbox.getText();
    	WebElement namebox = driver.findElement(By.id(appcls+":id/emailAddressEditText"));
    	String ActualEmail = namebox.getText();
    	
    	//System.out.println(ActualEmail + " " + ActualName);
    	
    	//Validating Email and Name with assert
    	
    	System.out.println("\n"+"----- Validating Email and Username -----");
    	assertEquals(ActualName, ExpectedName, "User name is not matching to actual result");
    	assertEquals(ActualEmail, ExpectedEmail, "User Email is not matching to actual result");
    	System.out.println("\n"+"----- Email and Username Validation is successfull -----");
    	
    	//Editing username
    	emailbox.clear();
    	Thread.sleep(4000);
    	emailbox.sendKeys("Hulk");
    	Thread.sleep(3000);
    	//clicking Update profile button
    	driver.findElement(By.id(appcls+":id/update_profile")).click();
    	Thread.sleep(4000);
    	
    	driver.pressKeyCode(4);
    	
    	String ExpectedEditName = "Hulk";
    	
    	//validating name after editing
    	System.out.println("\n"+"----- Validating Username after edit -----");
    	Thread.sleep(3000);
    	// clicking submenu
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	driver.findElement(By.xpath(profilebutton)).click();
    	String ActualEditName = emailbox.getText();
    	System.out.println(ActualEditName);
    	assertEquals(ActualEditName, ExpectedEditName, "User name is not matching to actual result");
    	System.out.println("\n"+"----- Edited Username Validation is successfull -----");
    	Thread.sleep(4000);
    
        driver.pressKeyCode(4);
    	
    	Thread.sleep(4000);
    	
    	System.out.println("Changing name to previous...");
    	
    	Thread.sleep(3000);
    	
    	// clicking submenu
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	driver.findElement(By.xpath(profilebutton)).click();
    	Thread.sleep(5000);
    	emailbox.clear();
    	Thread.sleep(4000);
    	emailbox.sendKeys(ExpectedName);
    	Thread.sleep(3000);
    	//clicking Update profile button
    	driver.findElement(By.id(appcls+":id/update_profile")).click();
    	Thread.sleep(6000);
    	
    	driver.pressKeyCode(4);
    	System.out.println("----- Logout -----");
	 	
	 	//clicking submenu button
	 	driver.findElement(By.id(appcls+":id/submenu")).click();
	 	
	 	//clicking logout button
	 	driver.findElement(By.xpath(logoutbutton)).click();
	 	
	 	//clicking "yes" on popup
	 	driver.findElement(By.id("android:id/button1")).click();
	 	
	 	System.out.println("----- Logout Ends -----");		
  
	 	
	 	System.out.println("Profile page method finished...");
	}
	
	
}
