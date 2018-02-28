package Sprint3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import Generic_Library.Android;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Fav_Review extends Android
{
	
	/*
	 * Open App and Login
	 * Click one random content from Homepage
	 * add to fav
	 * add a review
	 * Check content is displaying in MyFav
	 * Check the content in menu section 
	 * Logout
	 * */
	
	private static String content ;
	
	//Make sure all fav and review is removed.
	public static void logout() throws InterruptedException
	{
		System.out.println("Logout starts...");
		//clicking submenu button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	
    	Thread.sleep(6000);
		
		int l = driver.findElements(By.xpath("//android.widget.FrameLayout[@index='0']"
				+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout")).size();
		
		System.out.println("Size is "+l);
		
		driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
				+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='"+(l-1)+"']")).click();
			 driver.findElement(By.id("android:id/button1")).click();
		    	
		    	System.out.println("Logout ends");
		
	}
	
	public static void login() throws InterruptedException
	{
		
		System.out.println("Login Starts...");
		//clicking submenu button
		driver.findElement(By.id(appcls+":id/submenu")).click();
		
		//clicking login button
		driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
				+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='0']")).click();
		
    	driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
    	driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys(pwd);
    	
    	driver.hideKeyboard();
    	Thread.sleep(3000);
    	driver.findElement(By.id(appcls+":id/loginButton")).click();
    	
    	System.out.println("Login ended...");
		
	}
	
	public static void Menu() throws InterruptedException
	{
		
		Thread.sleep(6000);
		//Back 3 time for getting Menu button
		driver.pressKeyCode(4);
		Thread.sleep(3000);
		driver.pressKeyCode(4);
		Thread.sleep(3000);
		driver.pressKeyCode(4);
		
		WebElement menu_button = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/"
				+ "android.view.ViewGroup[@index='0']/android.widget.ImageButton[@index='0']"));
   
	
		menu_button.click();
		Thread.sleep(5000);
		int Menu_section = driver.findElements(By.xpath("//android.widget.ExpandableListView[@index='1']/android.widget.LinearLayout")).size();
	
		// Searching and clicking same content in Menu section [i=2 --> [0]=logo,[1]=Home]
		for (int i = 2; i <= Menu_section; i++) 
		{
	   
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//android.widget.ExpandableListView[@index='1']/android.widget.LinearLayout[@index='"+i+"']")).click();
	  
			boolean stats = false;
	  
			//checking same content is present or not. If not present it will move to next menu section
			
			try {
				stats = driver.findElement(By.xpath("//android.widget.TextView[@text='"+content+"']")).isDisplayed();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			
	
			if(stats)
			{
				//clcicking same content
				driver.findElement(By.xpath("//android.widget.TextView[@text='"+content+"']")).click();
				Thread.sleep(3000);
				String title = driver.findElement(By.id(appcls+":id/videoTitle")).getText();
				System.out.println("Searching content name is "+title);
				Thread.sleep(4000);
				logout();
				
				break;
			}
			else
			{
				System.out.println("Content not there so Moving to Next menu section.....");
		  
				
				menu_button.click();
			}
		}
		
		
		
	}
	
	public static void myfavourite() throws InterruptedException
	{
		
		Thread.sleep(4000);
		
		System.out.println("Searching fav content in My Favourite...");
		
		
		//clicking option button
		driver.findElement(By.id(appcls+":id/submenu")).click();
    	
    	Thread.sleep(6000);
		
		int l = driver.findElements(By.xpath("//android.widget.FrameLayout[@index='0']"
				+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout")).size();
		
		System.out.println("Size is "+l);
			 
		//clicking My Fav section from option
			 for (int i = 1; i < (l-1); i++) 
			 {
				 driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
							+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='"+i+"']")).click();
				 
				 boolean st = false;
				 
				 st = driver.findElement(By.xpath("//android.widget.TextView[@text='"+content+"']")).isDisplayed();
				 
				 if(st)
				 {
					 
					 driver.findElement(By.xpath("//android.widget.TextView[@text='"+content+"']")).click();
					 Thread.sleep(3000);
						String title = driver.findElement(By.id(appcls+":id/videoTitle")).getText();
						System.out.println(title+" added to fav is displaying in My Favourite "+st);
						Thread.sleep(4000);
						
						
						break;
					 
					 
				 }
				 else
				 {
					 Thread.sleep(4000);
					 System.out.println("Conten not present in this section so moving to another section"); 
					 
				 }
				
			 }
		
	}
	
	@Test
	public void Fav_n_Review() throws MalformedURLException, InterruptedException
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
		
		Thread.sleep(40000);
		
		login();
		
		//change value of x below for any  random content.
		int x = 0;
		
		//clicking random content from Homepage
		driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='0']/android.widget.LinearLayout[@index='1']/"
				+ "android.support.v7.widget.RecyclerView[@index='1']/"
				+ "android.widget.RelativeLayout[@index='"+x+"']/"
				+ "android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']")).click();
		
		//checking content is single part or multipart by validating play button visibility
				boolean st = false;
				
				try {
					st = driver.findElement(By.id(appcls+":id/playButton")).isDisplayed();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(st)
				{
					Thread.sleep(4000);
					System.out.println("It is a single part content"); 
					
					
					//getting video title
					String title = driver.findElement(By.id(appcls+":id/videoTitle")).getText();
					content = title;
					System.out.println("Clicked Content title is "+title);
					
					boolean favst = false;
					
					//check fav button is displaying or not
					
					try {
						favst = driver.findElement(By.id(appcls+":id/favorite_view")).isDisplayed();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(favst)
					{
						Thread.sleep(4000);
						System.out.println("Favourite button is displaying..."+favst);
						
						System.out.println("Adding content to favourite list");
						driver.findElement(By.id(appcls+":id/favorite_view")).click();
						
						Thread.sleep(5000);
						
						boolean revwst = false;
						
						//check fav button is displaying or not
						
						try {
							revwst = driver.findElement(By.id(appcls+":id/viewRatingTextView")).isDisplayed();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						if(revwst)
						{
							//clicking add a review
							driver.findElement(By.id(appcls+":id/viewRatingTextView")).click();
							
							System.out.println("Adding review...");
							
							// clicking on Star
					    	WebElement fiveStarRatingbar = driver.findElement(By.id(appcls+":id/ratingBar"));
					    	
					    	System.out.println("Giving Start rating...");
					  	    
					  	    int startX = fiveStarRatingbar.getLocation().getX();
					  	    
					  	    int endX = fiveStarRatingbar.getSize().getWidth();
					  	        
					  	    int yAxis = fiveStarRatingbar.getLocation().getY();
					  	    int tapAt = (int) (endX * 0.7);  
					  	    TouchAction act=new TouchAction(driver);  
					  	    
					  	    act.press(tapAt,yAxis).release().perform();
					  	    //clicking star Ended
					  	    
					  	    
					  	    //adding review is good
					        driver.findElement(By.id(appcls+":id/reviewEditText")).sendKeys("Good");
					        
					        //clicking post review
					    	driver.findElement(By.id(appcls+":id/submitReviewButton")).click();
					    	
					    	System.out.println("Rating Review Added...");
					    	Thread.sleep(8000);
					    	
					    	myfavourite();
					    	Thread.sleep(3000);
					    	Menu();
					 		
						}
						else
						{
							Thread.sleep(4000);
							System.out.println("Review option is not there...");
						}
					
					}
					else
					{
						Thread.sleep(4000);
						System.out.println("Favourite button is not present");
						
					}
					
				}
				else
				{
					
					Thread.sleep(4000);
					System.out.println("It is a Multi part content"); 
					
					//getting video title
					String title = driver.findElement(By.id(appcls+":id/videoTitle")).getText();
					content = title;
					System.out.println("Clicked Content title is "+title);
					
					boolean favst = false;
					
					//check fav button is displaying or not
					
					try {
						favst = driver.findElement(By.id(appcls+":id/favorite_view_episode")).isDisplayed();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(favst)
					{
						Thread.sleep(4000);
						System.out.println("Favourite button is displaying..."+favst);
						
						System.out.println("Adding content to favourite list");
						driver.findElement(By.id(appcls+":id/favorite_view_episode")).click();
						
						Thread.sleep(5000);
						
						boolean revwst = false;
						
						//check fav button is displaying or not
						
						try {
							revwst = driver.findElement(By.id(appcls+":id/viewRatingTextView")).isDisplayed();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						if(revwst)
						{
							
							//clicking add a review
							driver.findElement(By.id(appcls+":id/viewRatingTextView")).click();
							
							System.out.println("Adding review...");
							// clicking on Star
					    	WebElement fiveStarRatingbar = driver.findElement(By.id(appcls+":id/ratingBar"));
					    	System.out.println("Giving Start rating...");
					  	    int startX = fiveStarRatingbar.getLocation().getX();
					  	 
					  	    int endX = fiveStarRatingbar.getSize().getWidth();
					  	    	    
					  	    int yAxis = fiveStarRatingbar.getLocation().getY();
					  	    int tapAt = (int) (endX * 0.7);  
					  	    TouchAction act=new TouchAction(driver);  
					  	    
					  	    act.press(tapAt,yAxis).release().perform();
					  	    //clicking star Ended
					  	    
					  	    //adding review is good
					  	      driver.findElement(By.id(appcls+":id/reviewEditText")).sendKeys("Good");
					  	      
					  	      //clicking post review
					    	  driver.findElement(By.id(appcls+":id/submitReviewButton")).click();
					    	  System.out.println("Rating Review Added...");
					    	  Thread.sleep(8000);
					    	  
					    	  	myfavourite();
						    	Thread.sleep(3000);
						    	Menu();
					    	
						}
						else
						{
							Thread.sleep(4000);
							System.out.println("Review option is not there...");
						}
						
					}
					else
					{
						Thread.sleep(4000);
						System.out.println("Favourite button is not present");
						
					}
					
				}
		
	System.out.println("Content name is "+content);
	
	
	}
	
}
