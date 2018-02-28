package Test_11649;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Diff_Login_Scenario
{

private static AndroidDriver driver;
private static String appcls = "com.release.leasy";
private static String emailid="bruce12@mvrht.net";
private static String pwd ="123456";
private static String menubutton = "//android.widget.ImageButton[@bounds='[0,72][168,240]']";
private static String content = "//android.widget.TextView[@text='MuviShoot- Team Muvi']";

//   Make sure you have deleted all reviews from backend and Logged out as well.
//	 This script is regarding, check different login scenario by clicking "add to fav" and  "add a review".
	
	@Test
	public void SapphireAppDemo() throws MalformedURLException, InterruptedException
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
		System.out.println("Diff login method started...");
		Thread.sleep(25000);
		
		// Here we are checking different login scenario by adding review and fav list.
				
		//clicking menu button
		//clicking menu button
		driver.findElement(By.xpath(menubutton)).click();
	    
		//clicking Movie button from menu
		driver.findElement(By.xpath("//android.widget.TextView[@text='movie']")).click();
		
		// -----------------------------------------Webelement--------------------------------------------------
		
		//clicking "MovishootTeam" content
		WebElement Muvishot = driver.findElement(By.xpath(content));
		Muvishot.click();
		
		// -----------------------------------------Webelement--------------------------------------------------
		
		//clicking on Add to Favlist
    	driver.findElement(By.id(appcls+":id/favorite_view")).click();
   	
   
   	
    	//scrolling Down for getting login button 
    	Dimension dimensions = driver.manage().window().getSize();
    	        
    	Double screenHeightStart = dimensions.getHeight() * 0.5;
    	int scrollStart = screenHeightStart.intValue();			
    	Double screenHeightEnd = dimensions.getHeight() * 0.1;
    	int scrollEnd = screenHeightEnd.intValue();
    	driver.swipe(0,scrollStart,0,scrollEnd,2000);
    			
    	//After scroll down Clicking on Login button
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Login']")).click();
    		
    	//Giving Credentials
    	driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your Email Address']")).sendKeys(emailid);
    	driver.findElement(By.xpath("//android.widget.EditText[@index='2']")).sendKeys(pwd);
    	driver.hideKeyboard();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//android.widget.Button[@text='Login']")).click();
    	
    	System.out.println("Content added to fav list");
    	
    	System.out.println("Logout starts");
    	//clicking on sub menu for logout button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();
    	driver.findElement(By.xpath("//android.widget.Button[@text='Yes']")).click();
    	
    	System.out.println("Logout ends");
    	
    	Thread.sleep(10000);
    	
    	System.out.println("Anaother scenario starts for adding review");
    	//clicking menu button
    	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open']")).click();
    	//clicking Movie button from menu
    	driver.findElement(By.xpath("//android.widget.TextView[@text='movie']")).click();
    			
    			
    	//clicking "MovishootTeam" content
    	Muvishot.click();
    			
    	//clicking on add a review
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Add a Review']")).click();
    	driver.findElement(By.xpath("//android.widget.TextView[@text='You need to activity_login to add your review. Click here to activity_login.']")).click();
    	
    	System.out.println("Login starts again for add review");
    	//Giving Credentials
    	driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your Email Address']")).sendKeys(emailid);
    	driver.findElement(By.xpath("//android.widget.EditText[@index='2']")).sendKeys(pwd);
    	driver.hideKeyboard();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//android.widget.Button[@text='Login']")).click();
    
    	
    	/*
    	//Now homepage is coming instead of content page so repeating code
    	
    	Thread.sleep(6000);
    	//clicking menu button
    	driver.findElement(By.xpath("//android.widget.TextView[@text='movie']")).click();
    	//clicking Movie button from menu
    	driver.findElement(By.xpath("//android.widget.TextView[@text='movie']")).click();
    			
    			
    	//clicking "MovishootTeam" content
    	driver.findElement(By.xpath("//android.widget.TextView[@text='MuviShoot- Team Muvi']")).click();
    			
    	//clicking on add a review
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Add a Review']")).click();
    	*/
    	WebElement fiveStarRatingbar = driver.findElement(By.id(appcls+":id/ratingBar"));
  	    
  	    int startX = fiveStarRatingbar.getLocation().getX();
  	    System.out.println(startX);
  	    int endX = fiveStarRatingbar.getSize().getWidth();
  	    System.out.println(endX);	    
  	    int yAxis = fiveStarRatingbar.getLocation().getY();
  	    int tapAt = (int) (endX * 0.7);  
  	    TouchAction act=new TouchAction(driver);  
  	    
  	    act.press(tapAt,yAxis).release().perform();
  	    //clicking star Ended
  	    
  	    //adding review is good
        driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your Review here...max 50 characters']")).sendKeys("Good");
    	driver.findElement(By.xpath("//android.widget.Button[@text='Post Review']")).click();
    	System.out.println("Review added");
    	
    	System.out.println("----- Logout -----");
    	
    	//clicking submenu button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	
    	//clicking logout button
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();
    	
    	//clicking "yes" on popup
    	driver.findElement(By.xpath("//android.widget.Button[@text='Yes']")).click();
    	
    	System.out.println("----- Logout Ends -----");
    	System.out.println("Diff login method Finished...");
		
	}
	
}
