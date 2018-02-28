package Test_11649;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Purchase_Subscription {
	
	
	/*
	 * NOT DONE DUE TO BUG (AFTER ADDING SUBSCRIPTION FRONTEND SHOWING WITHOUT SUBCRIPTION)
	 * */
	
	private static AndroidDriver driver;
	private static String appcls = "com.release.leasy";
	private static String emailid="bruce12@mvrht.net";
	private static String pwd ="123456";
	private static String menubutton = "//android.widget.ImageButton[@bounds='[0,72][168,240]']";

	/*
	 * Open App
	 * Enter name,email,password,confirm password
	 * Choose Gold plan
	 * Follow purchase steps and pay
	 * 
	 * */
	
	// Before running this script make sure that "Subscription" option is enabled from CMS.
	@BeforeMethod
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
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Thread.sleep(15000);
	}
	
	
	@Test
	public void Choose_Plans() throws InterruptedException
	{
		
		//clicking name text box
		driver.findElement(By.id(appcls+":id/editNameStr")).sendKeys("Bruce Banner");
		
		driver.hideKeyboard();
		
		//clicking email id box
		driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys("paypa@gmail.com");
		
		driver.hideKeyboard();
		
		//clicking edit password box
		driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys("12345");
		
		driver.hideKeyboard();
		
		//clicking edit confrm password box
		driver.findElement(By.id(appcls+":id/editConfirmPasswordStr")).sendKeys("12345");
		
		driver.hideKeyboard();
		
		//clicking register button
		driver.findElement(By.id(appcls+":id/registerButton")).click();
		
	    //choosing gold plan
		driver.findElement(By.xpath("//android.widget.TextView[@text='Silver']")).click();
		
		//clicking "Activate Plan" button
		driver.findElement(By.id(appcls+":id/activationplan")).click();
		
		
		//clicking Card Name
		driver.findElement(By.id(appcls+":id/nameOnCardEditText")).sendKeys("Scarlet");
		
		
		//clicking card number
		driver.findElement(By.id(appcls+":id/cardNumberEditText")).sendKeys("4111111111111111");
		
		//clicking date drop down
		driver.findElement(By.xpath("//android.widget.TextView[@text='12']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='6']")).click();
		
		Thread.sleep(3000);
		
		//clicking year drop down
			
			
			WebElement x = driver.findElement(By.xpath("//android.widget.TextView[@text='2017']"));
			x.click();
			
			Thread.sleep(3000);
			/*
			//scrolling Down
					Dimension dimensions = driver.manage().window().getSize();
							
					Double screenHeightStart = dimensions.getHeight() * 0.5;
					int scrollStart = screenHeightStart.intValue();			
					Double screenHeightEnd = dimensions.getHeight() * 0.1;
					int scrollEnd = screenHeightEnd.intValue();
					driver.swipe(0,scrollStart,0,scrollEnd,2000);
					
					//check for scrolling up
					 */
			
			
			int topY = x.getLocation().getY();
		    int bottomY = topY + x.getSize().getHeight();
		    int centerX = x.getLocation().getX() + (x.getSize().getWidth()/2);
		    driver.swipe(centerX, bottomY, centerX, topY, 3000);
		    driver.swipe(centerX, bottomY, centerX, topY, 3000);
		    driver.swipe(centerX, bottomY, centerX, topY, 3000);
		    driver.swipe(centerX, bottomY, centerX, topY, 3000);
		    driver.swipe(centerX, bottomY, centerX, topY, 3000);
		    driver.swipe(centerX, bottomY, centerX, topY, 3000);
		    driver.swipe(centerX, bottomY, centerX, topY, 3000);
		    driver.swipe(centerX, bottomY, centerX, topY, 3000);
		    driver.swipe(centerX, bottomY, centerX, topY, 3000);
		    driver.swipe(centerX, bottomY, centerX, topY, 3000);
		   
		
			driver.findElement(By.xpath("//android.widget.TextView[@text='2030']")).click();
			
			Thread.sleep(2000);
		//clicking cvv
		driver.findElement(By.id(appcls+":id/securityCodeEditText")).sendKeys("123");
		
		driver.hideKeyboard();
		
		//clicking on paynow button
		//driver.findElement(By.id("com.release.magicmovies:id/payNowButton")).click();
	
		
	}
	
	
}
