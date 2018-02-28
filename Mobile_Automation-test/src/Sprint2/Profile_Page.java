package Sprint2;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import Generic_Library.Android;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class Profile_Page extends Android
{

	/*
	 * Login
	 * Edit profile name
	 * Click profile page and validate edited user name
	 * Again change it to previous
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
		
		Thread.sleep(35000);
		
		String ExpectedName = "Bruce Banner";
		String ExpectedEmail = "bruce12@gmail.com";
		
		
		login();
		
    	Thread.sleep(4000);
    	//checking email and name
    	
    	// clicking submenu
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	
    	//clciking profile button
    	driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
				+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='0']")).click();
    	
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

    	//clicking profile button
    	driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
				+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='0']")).click();
    	
    	String ActualEditName = emailbox.getText();
    	System.out.println(ActualEditName);
    	assertEquals(ActualEditName, ExpectedEditName, "User name is not matching to actual result");
    	System.out.println("\n"+"----- Edited Username Validation is successfull -----");
    	Thread.sleep(4000);
    
    	System.out.println("Again changing profile name to prevoius....");
    	
    	driver.pressKeyCode(4);
    	
    	// clicking submenu
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	
    	//clciking profile button
    	driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
				+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='0']")).click();
    	
    	
    	emailbox.clear();
    	Thread.sleep(4000);
    	emailbox.sendKeys(ExpectedName);
    	Thread.sleep(3000);
    	//clicking Update profile button
    	driver.findElement(By.id(appcls+":id/update_profile")).click();
    	Thread.sleep(4000);
    	
    	driver.pressKeyCode(4);
    	
        logout();
  
	}
	
	
}
