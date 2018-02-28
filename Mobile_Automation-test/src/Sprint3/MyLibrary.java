package Sprint3;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Generic_Library.Android;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MyLibrary extends Android
{
	
	/*
	 * Open app amd Login
	 * Click Menu button
	 * Click My Library 
	 * verify page title
	 * Verify purchased content displaying or not
	 * */
	

private static int My_library = 5;


//Note:- Change "My_library"


	@Test(enabled=false)
	public void ContentName() throws InterruptedException, MalformedURLException {
		
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
		
		//clicking submenu button
		driver.findElement(By.id(appcls+":id/submenu")).click();
		Thread.sleep(5000);
		
		//getting total number of submenu section
		int l = driver.findElements(By.xpath("//android.widget.FrameLayout[@index='0']"
				+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout")).size();
		
		System.out.println("Size is "+l);
		
		
		//i starts from 1 bcoz of 1st element[0] always should be profile 
		for (int i = 1; i < l; i++) {
			
			//clicking each submenu section
			driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
					+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='"+i+"']")).click();
			 
				 
				 boolean st1 = false;
					
					try {
						
						st1 = driver.findElement(By.id(appcls+":id/transactionHistoryRowLayout")).isDisplayed();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					if(st1)
					{
						Thread.sleep(3000);
						System.out.println("This section is Purchase History Page");
						WebElement purchs_histry = driver.findElement(By.id(appcls+":id/transactionHistoryRowLayout"));
						purchs_histry.click();
						
						Thread.sleep(4000);
						
						//
						
						return;
					}
					else {
						Thread.sleep(3000);
						System.out.println("This section is not purchase History");
						driver.pressKeyCode(4);
						//clicking submenu button
						driver.findElement(By.id(appcls+":id/submenu")).click();
					}
			
		}
		
		
		
		
		
	}


	@Test(enabled=true)
	public void Mylibrary() throws InterruptedException, MalformedURLException
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
		
		Thread.sleep(35000);
		
		login();
			
		
		
		//clicking menu button
		
		driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/"
				+ "android.view.ViewGroup[@index='0']/android.widget.ImageButton[@index='0']")).click();
		
		int x = driver.findElements(By.xpath("//android.widget.ExpandableListView[@index='1']/android.widget.LinearLayout")).size();
		System.out.println("Menu section items total number is "+x);
		
		//clicking Mylibrary 
		driver.findElement(By.xpath("//android.widget.ExpandableListView[@index='1']/android.widget.LinearLayout[@index='"+My_library+"']")).click();
		
		int j =1;  // j value is for clicking any random content
		
		
		//clicking one random content
		driver.findElement(By.xpath("//android.support.v4.widget.DrawerLayout[@index='0']/"
				+ "android.widget.LinearLayout[@index='0']/android.widget.FrameLayout[@index='1']/"
				+ "android.widget.RelativeLayout[@index='0']/android.widget.GridView[@index='1']/"
				+ "android.widget.RelativeLayout[@index='"+j+"']/"
				+ "android.widget.RelativeLayout[@index='0']/"
				+ "android.widget.TextView[@index='2']")).click();
		
		
		 
		String ActualTitle = driver.findElement(By.id(appcls+":id/videoTitle")).getText();
		//assertEquals(ActualTitle, ExpTitle, "Title is not matching");
		System.out.println("Clicked content title is "+ActualTitle);
		
		
        logout();
		
	}
		
	
}
