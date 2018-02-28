package Sprint1;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import Generic_Library.Android;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Diff_Login_Scenario extends Android
{


/*
 * Open App
 * click any random content
 * add to fav [Login]
 * logout
 * again click same content
 * add a review [Login]
 * Logout
 * 
 * */


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
		Thread.sleep(30000);
		
		// Here we are checking different login scenario by adding review and fav list.
				
		//content
		WebElement content =driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.support.v7.widget.RecyclerView[@index='2']/"
						+ "android.widget.RelativeLayout[@index='0']/"
						+ "android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']"));
				String content_name = content.getText();
				System.out.println("Clicked content name is  "+content_name);
				content.click();
	    Thread.sleep(3000);
	    
	    boolean st = false;
		
		try {
			st = driver.findElement(By.id(appcls+":id/playButton")).isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(st)
		{
		
		//clicking on Add to Favlist
    	driver.findElement(By.id(appcls+":id/favorite_view")).click();
   	
    	scroll();
    	
    	//clicking login
		driver.findElement(By.id(appcls+":id/alreadyHaveALoginButton")).click();
		
		//giving email id
		driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
		
		//giving password
		driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys(pwd);
		
		driver.hideKeyboard();
		
		//clicking login button
		driver.findElement(By.id(appcls+":id/loginButton")).click();
		
		Thread.sleep(3000);
		System.out.println("Content added to fav list");
		
		System.out.println("Logout starts");
    	//clicking on sub menu for logout button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	
    	//clciking logout button
    	logout();
    	
    	Thread.sleep(10000);
    	//-----------------------------------------------Menu --------------------------------------------------------
    	
    	 WebElement menu_button = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/"
 				+ "android.view.ViewGroup[@index='0']/android.widget.ImageButton[@index='0']"));
    	 menu_button.click();
    	 Thread.sleep(4000);
    	 
	    int Menu_section =  driver.findElements(By.xpath("//android.widget.ExpandableListView[@index='1']/android.widget.LinearLayout")).size();
    	// Searching and clicking same content in Menu section
        for (int i = 2; i <= Menu_section; i++) {
     	   
     	   //menu_button.click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//android.widget.ExpandableListView[@index='1']/android.widget.LinearLayout[@index='"+i+"']")).click();
     	  
 		  boolean stats = false;
     	  
 			try {
 				stats = driver.findElement(By.xpath("//android.widget.TextView[@text='"+content_name+"']")).isDisplayed();
 			} catch (Exception e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 				
 		
     	  if(stats)
     	  {
     		  driver.findElement(By.xpath("//android.widget.TextView[@text='"+content_name+"']")).click();
     		  Thread.sleep(3000);
     		 String title = driver.findElement(By.id(appcls+":id/videoTitle")).getText();
     		 
     		 assertEquals(title,content_name, "Clicked another content");
     		 
     		 System.out.println("After clicking content , Title is ---> "+title);
     		  
     		 //clicking on adding review
     		 driver.findElement(By.id(appcls+":id/viewRatingTextView")).click();
     		 
     		 Thread.sleep(3000);
     		 
     		 //clicking on login message
     		 driver.findElement(By.id(appcls+":id/clickHereToLogin")).click();
     		 
     		//giving email id
 			driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
 			
 			//giving password
 			driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys(pwd);
 			
 			driver.hideKeyboard();
 			
 			//clicking login button
 			driver.findElement(By.id(appcls+":id/loginButton")).click();
 			
 			Thread.sleep(4000);
 			
 			//clicking star rating
 			System.out.println("Giving star rating...");
 			WebElement fiveStarRatingbar = driver.findElement(By.id(appcls+":id/ratingBar"));
 	  	    
 	  	    int startX = fiveStarRatingbar.getLocation().getX();
 	  	    System.out.println(startX);
 	  	    int endX = fiveStarRatingbar.getSize().getWidth();
 	  	    System.out.println(endX);	    
 	  	    int yAxis = fiveStarRatingbar.getLocation().getY();
 	  	    int tapAt = (int) (endX * 0.7);  
 	  	    TouchAction act=new TouchAction(driver);  
 	  	    
 	  	    act.press(tapAt,yAxis).release().perform();
 	  	    System.out.println("star rating ended and giving review message..");
 	  	    
 	  	    //giving review msg
 	  	    driver.findElement(By.id(appcls+":id/reviewEditText")).sendKeys("Good");
 	  	    
 	  	    //clicking post review
 	  	    driver.findElement(By.id(appcls+":id/submitReviewButton")).click();
 	  	    
 	  	 Thread.sleep(5000);
 	  	
	    	
	    	//clciking logout button
	    	logout();
  		
     		  
     		  return;
     	  }
     	  else
     	  {
     		  System.out.println("Content not there");
     		  
     		  //driver.pressKeyCode(4);
     		  
     		 menu_button.click();
     		 
     		 Thread.sleep(4000);
     	  }
     	   
    	    Thread.sleep(3000);
        } 
		
		}
		else
		{
			//clicking on Add to Favlist
			driver.findElement(By.id(appcls+":id/favorite_view_episode")).click();
			
			scroll();
			
			//clicking login
			driver.findElement(By.id(appcls+":id/alreadyHaveALoginButton")).click();
			
			//giving email id
			driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
			
			//giving password
			driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys(pwd);
			
			driver.hideKeyboard();
			
			//clicking login button
			driver.findElement(By.id(appcls+":id/loginButton")).click();
			
			Thread.sleep(3000);
			System.out.println("Content added to fav list");
			
	    	
	    	//clciking logout button
	    	logout();
	    	
	    	Thread.sleep(10000);
	    	//-----------------------------------------------Menu --------------------------------------------------------
	    	
	    	 WebElement menu_button = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/"
	 				+ "android.view.ViewGroup[@index='0']/android.widget.ImageButton[@index='0']"));
	    	 menu_button.click();
	    	 Thread.sleep(4000);
	    	int Menu_section =  driver.findElements(By.xpath("//android.widget.ExpandableListView[@index='1']/android.widget.LinearLayout")).size();
	    	// Searching and clicking same content in Menu section
	        for (int i = 2; i <= Menu_section; i++) {
	     	   
	     	   //menu_button.click();
	            Thread.sleep(3000);
	            driver.findElement(By.xpath("//android.widget.ExpandableListView[@index='1']/android.widget.LinearLayout[@index='"+i+"']")).click();
	     	  
	 		  boolean stats = false;
	     	  
	 			try {
	 				stats = driver.findElement(By.xpath("//android.widget.TextView[@text='"+content_name+"']")).isDisplayed();
	 			} catch (Exception e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 			}
	 				
	 		
	     	  if(stats)
	     	  {
	     		  driver.findElement(By.xpath("//android.widget.TextView[@text='"+content_name+"']")).click();
	     		  Thread.sleep(3000);
	     		 String title = driver.findElement(By.id(appcls+":id/videoTitle")).getText();
	     		 
	     		 assertEquals(title,content_name, "Clicked another content");
	     		 
	     		 System.out.println("After clicking content , Title is ---> "+title);
	     		  
	     		 //clicking on adding review
	     		 driver.findElement(By.id(appcls+":id/viewRatingTextView")).click();
	     		 
	     		 Thread.sleep(3000);
	     		 
	     		 //clicking on login message
	     		 driver.findElement(By.id(appcls+":id/clickHereToLogin")).click();
	     		 
	     		//giving email id
	 			driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
	 			
	 			//giving password
	 			driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys(pwd);
	 			
	 			driver.hideKeyboard();
	 			
	 			//clicking login button
	 			driver.findElement(By.id(appcls+":id/loginButton")).click();
	 			
	 			Thread.sleep(4000);
	 			
	 			//clicking star rating
	 			System.out.println("Giving star rating...");
	 			WebElement fiveStarRatingbar = driver.findElement(By.id(appcls+":id/ratingBar"));
	 	  	    
	 	  	    int startX = fiveStarRatingbar.getLocation().getX();
	 	  	    System.out.println(startX);
	 	  	    int endX = fiveStarRatingbar.getSize().getWidth();
	 	  	    System.out.println(endX);	    
	 	  	    int yAxis = fiveStarRatingbar.getLocation().getY();
	 	  	    int tapAt = (int) (endX * 0.7);  
	 	  	    TouchAction act=new TouchAction(driver);  
	 	  	    
	 	  	    act.press(tapAt,yAxis).release().perform();
	 	  	    System.out.println("star rating ended and giving review message..");
	 	  	    
	 	  	    //giving review msg
	 	  	    driver.findElement(By.id(appcls+":id/reviewEditText")).sendKeys("Good");
	 	  	    
	 	  	    //clicking post review
	 	  	    driver.findElement(By.id(appcls+":id/submitReviewButton")).click();
	 	  	    
	 	  	    Thread.sleep(5000);
		    	
		    	//clciking logout button
		    	logout();
	     		  
	     		  return;
	     	  }
	     	  else
	     	  {
	     		  System.out.println("Content not there");
	     		  
	     		  //driver.pressKeyCode(4);
	     		  
	     		 menu_button.click();
	     		 
	     		 Thread.sleep(4000);
	     	  }
	     	   
	    	    Thread.sleep(3000);
	        } 
	    	
		}
    
		
	}
	
}
