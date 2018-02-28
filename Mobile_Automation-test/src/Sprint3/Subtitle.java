package Sprint3;

import static org.testng.Assert.assertEquals;

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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Generic_Library.Android;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Subtitle extends Android
{
	
	
	/*
	 * Open App and login
	 * Click one content 
	 * click setting and click subtitle
	 * Wait for few seconds again change subtitle
	 * Back and logout
	 * 
	 * */
	

	private static int i = 2; //For any menu section
	private static int j = 1; //For any content
	
	public void subtitle() throws InterruptedException
	{
		
		//Thread.sleep(5000);
		//clicking on vdo for getting , setting button
		driver.findElement(By.id(appcls+":id/exomedia_video_view")).click();
		
		//clicking on setting button
		driver.findElement(By.id(appcls+":id/subtitle_change_btn")).click();
		
		//checking subtitle button is displaying or not
		
		boolean status = false;
				
				
			try {
				status = driver.findElement(By.id(appcls+":id/subtitle_text")).isDisplayed();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		if(status)
		{
			Thread.sleep(4000);
			System.out.println("Subtitle option is enabled. ");
			
			//clicking subtitle button
			driver.findElement(By.id(appcls+":id/subtitle_text")).click();
			
			//getting total number of option availble
			int x = driver.findElements(By.xpath("//android.widget.ListView[@index='0']/android.widget.LinearLayout")).size();
			System.out.println("Total number of subtile options are "+(x-1)); //(x-1) is for 1st option is for subtitle off.
			
			
			String suboption = driver.findElement(By.xpath("//android.widget.ListView[@index='0']/"
					+ "android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='0']")).getText();
			
			System.out.println("To be clicked option is "+suboption);
			//clicking another subtitle option
			driver.findElement(By.xpath("//android.widget.TextView[@text='"+suboption+"']")).click();
			
			//-----------------------
			
			System.out.println("Verifying selected option...");
			Thread.sleep(6000);
			//verifying subtitle is off or not by again clicking subtitle
			//clicking on vdo for getting , setting button
			driver.findElement(By.id(appcls+":id/exomedia_video_view")).click();
			
			//clicking on setting button
			driver.findElement(By.id(appcls+":id/subtitle_change_btn")).click();
			
			//getting enabled current subtitle (i,e previously selected) 
			String enblsub1 = driver.findElement(By.id(appcls+":id/subtitle_text")).getText();
			
			//spliting subtitle option for printing exact status of enbles subtitle
			String[] parts1 = enblsub1.split(":");
			String part21 = parts1[1];
			System.out.println("Selected subtitle is "+part21);
			
			assertEquals(part21, suboption, "Current subtitle is not matching with Selected subtitle");
			
			System.out.println("Subtitle verified successfully....");
			
			
			
		}
		else
		{
			Thread.sleep(4000);
			System.out.println("Subtitle is not added.");
		}
		
	}
	
	@Test
	public void startApp() throws MalformedURLException, InterruptedException
	{
		
		DesiredCapabilities capabilities = new  DesiredCapabilities();
		//capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Lenovo");
		capabilities.setCapability("platformVersion", "4.2.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.release.muvisdk");
		capabilities.setCapability("appActivity", "com.home.vod.activity.SplashScreen");
		driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Thread.sleep(35000);
		
		
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
			
			subtitle();
			
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
			
			String title1 = driver.findElement(By.id(appcls+":id/videoTitle")).getText();
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
			subtitle();
			
			//clicking  back for logout
			driver.pressKeyCode(4);
			Thread.sleep(4000);
			driver.pressKeyCode(4);
			logout();
			
			System.out.println("Resolution checked successfully");
			
			
		}
		
	}

	
	
	
	
}
