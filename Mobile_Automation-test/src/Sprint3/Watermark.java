package Sprint3;

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
	private static String emailid="bruce12@gmail.com";
	private static String pwd ="1234";
	private static int Menu_section = 4;
	private static int logout_ind = 4;
	
	//change i value according to requirement
	private static int i =3;
	
	
	//Note- //change "Menu_section","logout_ind"
	
	public static void logout()
	{
		System.out.println("Logout starts...");
		//clicking submenu button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
		switch(logout_ind)
	      {
		 case 1:
			 driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
						+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='1']")).click();
			 driver.findElement(By.id("android:id/button1")).click();
		    	
		    	System.out.println("Logout ends");
		   break;
		 case 2:
			 driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
						+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='2']")).click();
			 driver.findElement(By.id("android:id/button1")).click();
		    	
		    	System.out.println("Logout ends");
		   break;
		 case 3:
			 driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
						+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='3']")).click();
			 driver.findElement(By.id("android:id/button1")).click();
		    	
		    	System.out.println("Logout ends");
		   break;
		 case 4:
			 driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
						+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='4']")).click();
			 driver.findElement(By.id("android:id/button1")).click();
		    	
		    	System.out.println("Logout ends");
	           break;
		 default:
			 driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
						+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='5']")).click();
			 driver.findElement(By.id("android:id/button1")).click();
		    	
		    	System.out.println("Logout ends");
	      }
		
		
		
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
	
	
	//login();
	
	
	Thread.sleep(4000);
	
	//-----------------------------------------------------------------Webelement------------------------------------------------------------------
	
	System.out.println("clicking on content");
	//clicking Menu button
	driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/"
			+ "android.view.ViewGroup[@index='0']/android.widget.ImageButton[@index='0']")).click();
	
	//clicking on randomly menu section 
	driver.findElement(By.xpath("//android.widget.ExpandableListView[@index='1']/android.widget.LinearLayout[@index='"+i+"']")).click();
	
	//clicking on random content
	
	int j = 1;  //change acc to requirment.
	
	driver.findElement(By.xpath("//android.support.v4.widget.DrawerLayout[@index='0']/android.widget.LinearLayout[@index='0']"
			+ "/android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/"
			+ "android.widget.GridView[@index='1']"
			+ "/android.widget.RelativeLayout[@index='"+j+"']"
			+ "/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']")).click();
	
	
	Thread.sleep(4000);
	
	//-----------------------------------------------------------------Webelement------------------------------------------------------------------
		
	
	
	boolean stats = false;
	  
	try {
		stats = driver.findElement(By.id(appcls+":id/playButton")).isDisplayed();
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	

	if(stats)
	{
		Thread.sleep(4000);
		System.out.println("Clicking singlepart content...");
		//clicking play button
		driver.findElement(By.id(appcls+":id/playButton")).click();
		
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
			
		
		Thread.sleep(3000);
		WebElement ip = driver.findElement(By.id(appcls+":id/emailAddressTextView"));
		WebElement email = driver.findElement(By.id(appcls+":id/ipAddressTextView"));
		WebElement date = driver.findElement(By.id(appcls+":id/dateTextView"));
		
		boolean ip_status = ip.isDisplayed();
		boolean email_status = email.isDisplayed();
		boolean date_status = date.isDisplayed();
		
		String ip_value = ip.getText();
		String email_value = email.getText();
		String date_value = date.getText();
		
		System.out.println("ip is displaying..."+ip_status);
		System.out.println("email is displaying..."+email_status);
		System.out.println("date is displaying..."+date_status);
		
		Thread.sleep(3000);
		
			if(ip_status && email_status && date_status)
			{
				System.out.println("Watermark's contents are displaying correctly");
				System.out.println("Ip is "+ip_value);
				System.out.println("email is "+email_value);
				System.out.println("Date is "+date_value );
				
				
				logout();
				
			}
			else
			{
				System.out.println("Watermark contents are not there...try again");
			}
		
		
		}
		
		else {
			System.out.println("Watermark is not displaying");
		}
		
		
	}
	else {
		
		Thread.sleep(4000);
		System.out.println("Clicking Multipart Content...");
		
		//clicking content
		driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='2']"
				+ "/android.widget.RelativeLayout[@index='1']")).click();
		
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
			
		
		Thread.sleep(3000);
		WebElement ip = driver.findElement(By.id(appcls+":id/emailAddressTextView"));
		WebElement email = driver.findElement(By.id(appcls+":id/ipAddressTextView"));
		WebElement date = driver.findElement(By.id(appcls+":id/dateTextView"));
		
		boolean ip_status = ip.isDisplayed();
		boolean email_status = email.isDisplayed();
		boolean date_status = date.isDisplayed();
		
		String ip_value = ip.getText();
		String email_value = email.getText();
		String date_value = date.getText();
		
		System.out.println("ip is displaying..."+ip_status);
		System.out.println("email is displaying..."+email_status);
		System.out.println("date is displaying..."+date_status);
		
		Thread.sleep(3000);
		
			if(ip_status && email_status && date_status)
			{
				System.out.println("Watermark's contents are displaying correctly");
				System.out.println("Ip is "+ip_value);
				System.out.println("email is "+email_value);
				System.out.println("Date is "+date_value );
				
				logout();
				
			}
			else
			{
				System.out.println("Watermark contents are not there...try again");
			}
		
		
		}
		
		else {
			System.out.println("Watermark is not displaying");
		}
		
		
		
	}
	
	
	
	 	
	
	
	}
}
