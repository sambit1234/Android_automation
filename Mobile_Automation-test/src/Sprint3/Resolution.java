package Sprint3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Generic_Library.Android;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Resolution extends Android
{
	
	/*
	 * Login
	 * Clicking one random content
	 * play that content
	 * click option and then resolution
	 * select one resolution
	 * again select resolution and check 'Tick Mark' is appearing at same selected option [Resolution properly selected or not]
	 * logout
	 * */

private static int i = 3; //For any menu section
private static int j = 1; //For any content
private static int k = 1; //For any resolution


public static void resolution() throws InterruptedException
{
	

	Thread.sleep(5000);
	//clicking on vdo for getting , setting button
	driver.findElement(By.id(appcls+":id/exomedia_video_view")).click();
	
	//clicking on setting button
	driver.findElement(By.id(appcls+":id/subtitle_change_btn")).click();
	
	boolean status = false;
	
	//checking resolution option is displaying or not
	try {
		status = driver.findElement(By.id(appcls+":id/resolution_text")).isDisplayed();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	//if resolution option is enabled then continue
    if(status)
    {
    	//clicking Quality button
    	driver.findElement(By.id(appcls+":id/resolution_text")).click();
    	
    	//clicking Resolution from options [Below 'k' value is for desired resolution]
    	WebElement res = driver.findElement(By.xpath("//android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='"+k+"']"
    			+ "/android.widget.TextView[@index='0']"));
    	//selecting resolution name
    	String name = res.getText();
    	
    	System.out.println("Selected resolution is "+name);
    	
    	//clicking on random resolution
    	res.click();
    	Thread.sleep(6000);
    	//clicking on vdo for getting , setting button
    			driver.findElement(By.id(appcls+":id/exomedia_video_view")).click();
    			
    			//clicking on setting button
    			driver.findElement(By.id(appcls+":id/subtitle_change_btn")).click();
    			
    			//clicking Quality button
    			driver.findElement(By.id(appcls+":id/resolution_text")).click();
    			
    	//counting total number of resolution option availble.
    	int s = driver.findElements(By.xpath("//android.widget.ListView[@index='0']/android.widget.LinearLayout")).size();
    	System.out.println("Total number of resolution options are "+s); 
    	
    	//checking each resolution in loop.
    	for(int i =0;i < s; i++)
    	{
    		boolean st = false;
    		
    		//checking eack resolution options , where "tick mark" is displaying. [Tick Mark should at your clicked resolution] 
    		try {
    			st = driver.findElement(By.xpath("//android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='"+i+"']"
    					+ "/android.widget.ImageView[@index='0']")).isDisplayed();
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		//if 'tick mark' is displying, then checking 'tick mark' is at clicked resolution or not 
    		if(st) {
    			
    			Thread.sleep(4000);
    			System.out.println("Condition true ");
    			String res1 = driver.findElement(By.xpath("//android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='"+i+"']"
    					+ "/android.widget.TextView[@index='1']")).getText();
    			
    			System.out.println("Resolution is "+res1);
    			
    			//checking 'tick mark' is at clicked resolution or not by comparing clicked resolution with verifed each resolution Option section
    			if(name.equalsIgnoreCase(res1)) {
    				
    				Thread.sleep(4000);
    				System.out.println("Slected resolution is correct...");
    			}
    			
    			return;
    		}
    		else {
    			
    			//if 'tick mark'  is not there then, searching at next resolution section. 
    			Thread.sleep(4000);
    			System.out.println("Moving to next...");
    		}
    		
    		
    	}

    }
    else
    {
    	Thread.sleep(4000);
    	System.out.println("Resolution is not displaying in this content's option");
    }
	
}
	
	@Test
	public void ResolutionChecking() throws MalformedURLException, InterruptedException
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
		
		Thread.sleep(15000);
		
		login();
		Thread.sleep(5000);
		
		//Clicking Menu Button
		driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/"
				+ "android.view.ViewGroup[@index='0']/android.widget.ImageButton[@index='0']")).click();
		Thread.sleep(6000);
		//clicking randomly any menu section [i value for any index of menu section] 
		driver.findElement(By.xpath("//android.widget.ExpandableListView[@index='1']/android.widget.LinearLayout[@index='"+i+"']")).click();
		
		//clicking randomly one content
		WebElement con = driver.findElement(By.xpath("//android.support.v4.widget.DrawerLayout[@index='0']/android.widget.LinearLayout[@index='0']"
				+ "/android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/"
				+ "android.widget.GridView[@index='1']"
				+ "/android.widget.RelativeLayout[@index='"+j+"']"
				+ "/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']"));
		
		con.click();
		Thread.sleep(5000);
		String title = driver.findElement(By.id(appcls+":id/videoTitle")).getText();
		System.out.println("Content name is "+title);
		
		Thread.sleep(10000);
	
		
		boolean stats = false;
		
		//Checking single part or Multipartby Play button visibility
		try {
			stats = driver.findElement(By.id(appcls+":id/playButton")).isDisplayed();
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		

		if(stats)
		{
			Thread.sleep(4000);
			System.out.println("It is single part content");
			
			//clicking play button
			driver.findElement(By.id(appcls+":id/playButton")).click();
			
			try {
				//clicking pay button
				driver.findElement(By.id(appcls+":id/payNowButton")).click();
				
				//In purchase page , clicking "Use New card" drop down
				driver.findElement(By.id(appcls+":id/cardTextView")).click();
				
				//After clicking dropdown click "Use New Card"
				driver.findElement(By.xpath("//android.widget.TextView[@text='############1111']")).click();
				
				//Clicking paynow button
				driver.findElement(By.id(appcls+":id/payNowButton")).click();
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			try {
				driver.findElement(By.id(appcls+":id/cancelButton")).click();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		
			Thread.sleep(5000);
			
			resolution();
			
			//clicking  back for logout
			driver.pressKeyCode(4);
			Thread.sleep(4000);
			driver.pressKeyCode(4);
			logout();
			
			System.out.println("Resolution checked successfully");
		}
		
		else {
			
			Thread.sleep(4000);
			
			System.out.println("It is Multipart content.");
			
			//clicking dropdown 
			driver.findElement(By.id("android:id/text1")).click();
			
			Thread.sleep(5000);
			
			//counting total options from dropdown
			List<WebElement> droplist = driver.findElements(By.id("android:id/text1"));
			int size1 = droplist.size();
			System.out.println("Dropdown size is "+size1);
			
			//clicking last option from dropdown. [clicking size1-1 (index starts frm 0)]
			driver.findElement(By.xpath("//android.widget.TextView[@index='"+(size1-1)+"']")).click();
			
			Thread.sleep(8000);
			
			//clicking content
			WebElement drp_con = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='2']"
					+ "/android.widget.RelativeLayout[@index='1']"));
			
			String title1 = drp_con.getText();
			System.out.println("Clicked content name is "+title1);
			drp_con.click();
			
			try {
				//clicking pay button
				driver.findElement(By.id(appcls+":id/payNowButton")).click();
				
				//In purchase page , clicking "Use New card" drop down
				driver.findElement(By.id(appcls+":id/cardTextView")).click();
				
				//After clicking dropdown click "Use New Card"
				driver.findElement(By.xpath("//android.widget.TextView[@text='############1111']")).click();
				
				//Clicking paynow button
				driver.findElement(By.id(appcls+":id/payNowButton")).click();
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			try {
				driver.findElement(By.id(appcls+":id/cancelButton")).click();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			Thread.sleep(4000);
			resolution();
			
			//clicking  back for logout
			driver.pressKeyCode(4);
			Thread.sleep(4000);
			driver.pressKeyCode(4);
			logout();
			
			System.out.println("Resolution checked successfully");
			
			
		}
		
	}
	
}
