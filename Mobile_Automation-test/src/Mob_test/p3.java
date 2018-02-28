package Mob_test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Sprint3.Offline;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class p3 

{

	private static AndroidDriver driver;
	private static String appcls = "com.release.stuffpix";
	private static String emailid="bruce12@gmail.com";
	private static String pwd ="1234";
	//private static String title;
	
	  public static void horizontalScroll()
	    {
	       Dimension size=driver.manage().window().getSize();
	        int x_start=(int)(size.width*0.60);
	        int x_end=(int)(size.width*0.30);
	        int y=130;
	        driver.swipe(x_start,y,x_end,y,4000);
	    }
	  
	  public static void swipeElementExample(WebElement el) {
		  String orientation = driver.getOrientation().value();

		  // get the X coordinate of the upper left corner of the element, then add the element's width to get the rightmost X value of the element
		  int leftX = el.getLocation().getX();
		  int rightX = leftX + el.getSize().getWidth();

		  // get the Y coordinate of the upper left corner of the element, then subtract the height to get the lowest Y value of the element
		  int upperY = el.getLocation().getY();
		  int lowerY = upperY - el.getSize().getHeight();
		  int middleY = (upperY - lowerY) / 2;

		/*  if (orientation.equals("portrait")) {
		    // Swipe from just inside the left-middle to just inside the right-middle of the element over 500ms
		      driver.swipe(leftX + 5, middleY, rightX - 5, middleY, 500);
		  }
		  else if (orientation.equals("landscape")) {*/
		    // Swipe from just inside the right-middle to just inside the left-middle of the element over 500ms
		   // driver.swipe(rightX - 5, middleY, leftX + 5, middleY, 500);
		  
		  driver.swipe(leftX + 5, middleY, rightX - 5, middleY, 500);
		//  }
		}
	  
	  public static void ScrollTabs() {
		  //Get the size of screen.
		  Dimension  size = driver.manage().window().getSize();  
		  
		  //Find swipe start and end point from screen's with and height.
		  //Find startx point which is at right side of screen.
		  int startx = (int) (size.width * 0.70);
		  //Find endx point which is at left side of screen.
		  int endx = (int) (size.width * 0.30);
		  //Set Y Coordinates of screen where tabs display.
		  int YCoordinates = 150;  

		  //Swipe tabs from Right to Left.
		  driver.swipe(startx, YCoordinates, endx, YCoordinates, 3000);  
		 }
	  
	  public static void scrolling(WebElement e1,WebElement e2) throws InterruptedException {
		  
		  TouchAction tAction=new TouchAction(driver);
			int startx = e1.getLocation().getX();
			int starty = e1.getLocation().getY();
			int endx = e2.getLocation().getX();
			int endy = e2.getLocation().getY();
			System.out.println(startx + " ::::::: " + starty + " ::::::: " + endx +  " ::::::: " +	endy);

			//First tap on the screen and swipe it right using moveTo function
			//tAction.press(startx+20,starty+20).moveTo(endx+20,endy+20).release().perform(); 
			Thread.sleep(1000);
			
			//Second tap on the screen and swipe it left using moveTo function
			tAction.press(endx+20,endy+20).moveTo(startx+20,starty+20).release().perform();
			Thread.sleep(8000);
	  }
	  
	  public static void scroll_last()
	  {
		  
		  Dimension dimensions = driver.manage().window().getSize();
		  Double screenHeightStart = dimensions.getHeight() * 0.5;
		  int scrollStart = screenHeightStart.intValue();
		  System.out.println("s="+scrollStart);
		  Double screenHeightEnd = dimensions.getHeight() * 0.1;
		  int scrollEnd = screenHeightEnd.intValue();
		  int hgt = dimensions.getHeight();
		  System.out.println("Hight is "+hgt);
		  for (int i = 0; i < dimensions.getHeight(); i++) {
		  driver.swipe(0,scrollStart,0,scrollEnd,2000);
		  
		  }
		  
		  
	  }
	  
	  public static void scroll()
		{
			
			Dimension dimensions = driver.manage().window().getSize();
			
	    	Double screenHeightStart = dimensions.getHeight() * 0.5;
	    	int scrollStart = screenHeightStart.intValue();			
	    	Double screenHeightEnd = dimensions.getHeight() * 0.1;
	    	int scrollEnd = screenHeightEnd.intValue();
	    	driver.swipe(0,scrollStart,0,scrollEnd,2000);
			
			
		}
	  
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
		
	  
	
	@Test(priority=1)
	public static void SapphireAppDemo() throws MalformedURLException, InterruptedException
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
}
