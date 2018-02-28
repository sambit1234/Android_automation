package Sprint3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextListener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import Generic_Library.Android;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Player_Control extends Android
{
	
	/*
	 * Open App and Login
	 * Click any content
	 * click play button 
	 * wait for 6sec and click pause button
	 * wait for 6sec
	 * Maximize it, Minimize and click back
	 * Logout
	 * */

	
	//before running this script make sure you logges out
	
	
	private static int i = 3; //For any menu section
	private static int j = 1; //For any content

	
	public static void player() throws InterruptedException
	{
		

		//Waiting 6sec till Video is playing properly.
		Thread.sleep(6000);
		//clicking on vdo for getting , play/pause button
		driver.findElement(By.id(appcls+":id/exomedia_video_view")).click();	
		
		System.out.println("Clicking pause button");
		//clicking pause button
		driver.findElement(By.id(appcls+":id/latest_center_play_pause")).click();
		
		System.out.println("Waiting for 6 sec");
		//clicking play button after 6 sec
		Thread.sleep(6000);
		
		System.out.println("After waiting by pause button, Clicking on screen for getting play button");
		// Again clicking on screen for getting play/pause button
		driver.findElement(By.id(appcls+":id/exomedia_video_view")).click();
		
		System.out.println("After clicking on screen ,Clicking play button");
		//clicking play button
		driver.findElement(By.id(appcls+":id/latest_center_play_pause")).click();
		
		System.out.println("Waiting for 6 sec");
		Thread.sleep(6000);
		
		System.out.println("Clicking on screen for getting maximize button");
		//clicking on vdo for getting , screen button
		driver.findElement(By.id(appcls+":id/exomedia_video_view")).click();	
		
		System.out.println("Screen maximizing...");
		//Maximizing
		driver.findElement(By.id(appcls+":id/compress_expand")).click();
		
		
		System.out.println("Waiting for 6 sec after maximizing");
		//Waiting 6 sec for minmizing
		Thread.sleep(6000);
		
		System.out.println("Clicking on screen for getting minimize button");
		// Again clicking on screen for minimizing
		driver.findElement(By.id(appcls+":id/exomedia_video_view")).click();
		
		System.out.println("Clicking on minimize button");
		//clicking minimize button
		driver.findElement(By.id(appcls+":id/compress_expand")).click();
		
		Thread.sleep(3000);
		
		
	}
	@Test
	public void Screen() throws MalformedURLException, InterruptedException {
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
	
	
	login();
	
	//-----------------------------------------------------------------Webelement------------------------------------------------------------------
	
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
					driver.findElement(By.id(appcls+":id/yesButton")).click();
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			
				Thread.sleep(5000);
	
	//-----------------------------------------------------------------Webelement------------------------------------------------------------------
			
	
	player();

			
	    //After minimizing clicking back button
	
	driver.pressKeyCode(4);
			
	Thread.sleep(4000);
	logout();
	
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
				
				Thread.sleep(4000);
				
				//clicking content
				WebElement drp_con = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='2']"
						+ "/android.widget.RelativeLayout[@index='1']"));
				
				
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
					driver.findElement(By.id(appcls+":id/yesButton")).click();
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				player();
				
				//After minimizing clicking back button
				
				driver.pressKeyCode(4);
						
				Thread.sleep(4000);
				logout();
			}

	}
}
