package Sprint3;

import static org.testng.Assert.assertEquals;

import java.io.Console;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Generic_Library.Android;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ContactUs extends Android
{
	
	/*
	 * Open App and login
	 * click Menu
	 * click contact us
	 * check page title
	 * Enter name,email,msg and submit.
	 * */
	
	
	
	// Verify "Menu_section" in App [Except Logo count rest]
	
	
	@Test
	public void Contact_Us() throws InterruptedException, MalformedURLException
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
		
		Thread.sleep(5000);
		//clicking menu button
		WebElement menu = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/"
				+ "android.view.ViewGroup[@index='0']/android.widget.ImageButton[@index='0']"));
		
		menu.click();
		
		//clicking contactus 
		
		
		//Getting size of total number of menu section
		int x = driver.findElements(By.xpath("//android.widget.ExpandableListView[@index='1']/android.widget.LinearLayout")).size();
		System.out.println("Size is "+x);
		
		//(x-3) -> max 3 static page section can be added.
		for (int i = x; i > x-3; i--) 
		{
			
			//clicking each menu section from last untill it find contact us
			driver.findElement(By.xpath("//android.widget.ExpandableListView[@index='1']/android.widget.LinearLayout[@index='"+i+"']")).click();
			Thread.sleep(3000);
			boolean stats = false;
			
			//checking contact us section by verifying email id box visibility
			try {
				stats = driver.findElement(By.id(appcls+":id/contact_name")).isDisplayed();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(stats)
			{
				String ActualTitle = driver.findElement(By.id(appcls+":id/categoryTitle")).getText();
				//assertEquals(ActualTitle, ExpTitle, "Title is not matching");
				
				System.out.println("After clicking contact us button, Title is displaying is  "+ActualTitle);
				Thread.sleep(3000);
				
				//entering Name in box
				driver.findElement(By.id(appcls+":id/contact_name")).sendKeys("Thor");
				
				//entering email in the box
				driver.findElement(By.id(appcls+":id/contact_email")).sendKeys("sonofodin006@mvrht.com");
				
				driver.hideKeyboard();
				
				//entering message in the msg box
				driver.findElement(By.id(appcls+":id/contact_msg")).sendKeys("Thor Ragnarok");
				
				driver.hideKeyboard();
				
				//clicking submit button
				driver.findElement(By.id(appcls+":id/submit_cont")).click();
				
				System.out.println("Form submitted...");
				
				Thread.sleep(3000);
				
				
				
				return;
			}
			else {
				
				
				menu.click();
				Thread.sleep(3000);
			}
			
			Thread.sleep(3000);
			
		}
		
		
		
	}
	
	
	
}
