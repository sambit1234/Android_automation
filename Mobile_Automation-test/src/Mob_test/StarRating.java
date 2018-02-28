package Mob_test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class StarRating 
{

private static AndroidDriver driver;
	
	@Test
	public void Demo() throws MalformedURLException, InterruptedException
	{
		
		DesiredCapabilities capabilities = new  DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Lenovo");
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.release.muvisdk");
		capabilities.setCapability("appActivity", "com.home.vod.activity.SplashScreen");
		driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Thread.sleep(10000);
		//clicking menu button
		driver.findElement(By.xpath("//android.widget.ImageButton[@bounds='[0,75][168,243]']")).click();
		
		//clicking tv button
		driver.findElement(By.xpath("//android.widget.TextView[@text='tv']")).click();
		
		//clicking "friends" content
	    driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[31,672][517,957]']")).click();
		
	    //Clicking on adding a review
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Add a Review']")).click();
    	
    	WebElement fiveStarRatingbar = driver.findElement(By.xpath("//android.widget.RatingBar[@bounds='[30,429][510,519]']"));
    	
    	//Get start point of fiveStarRatingbar.
    	int startX = fiveStarRatingbar.getLocation().getX();
    	System.out.println(startX);
    	
    	//Get end point of fiveStarRatingbar.
    	int endX = fiveStarRatingbar.getSize().getWidth();
    	System.out.println(endX);
    	
    	//Get vertical location of fiveStarRatingbar.
    	int yAxis = fiveStarRatingbar.getLocation().getY();
    	  
    	//Set fiveStarRatingbar tap position to set Rating = 4 star.
    	
    	//You can use endX * 0.2 for 1 star, endX * 0.4 for 2 star, endX * 0.6 for 3 star, endX * 0.8 for 4 star, endX * 1 for 5 star.
    	int tapAt = (int) (endX * 0.8);  
    	//Set fiveStarRatingbar to Rating = 4 star using TouchAction class.
    	TouchAction act=new TouchAction(driver);  
    	act.press(tapAt,yAxis).release().perform();
    	
    	/*
    	 * You can use endX * 0.3 for 1 star, endX * 0.6 for 2 star, endX * 1 for 3 star.
         * int tapAt = (int) (endX * 0.3);    
         * Set threeStarRatingbar to Rating = 1.0 using TouchAction class.
    	 * */
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
