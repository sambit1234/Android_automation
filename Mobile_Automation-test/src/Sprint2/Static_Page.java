package Sprint2;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Generic_Library.Android;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Static_Page extends Android
{
	
	/*
	 * click menu button
	 * Click each content and verify thier page title by their Menu section name
	 * 
	 * */
	
		
	@BeforeMethod
	public void startApp() throws MalformedURLException, InterruptedException
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
	}
	
	@Test
	public void staticPage() throws MalformedURLException, InterruptedException
	{
    
    //clicking Menu button 
		WebElement menu_button = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/"
				+ "android.view.ViewGroup[@index='0']/android.widget.ImageButton[@index='0']"));
		
		menu_button.click();
		Thread.sleep(6000);
		
		//counting total number of menu section are displaying
		int s = driver.findElements(By.xpath("//android.widget.ExpandableListView[@index='1']/android.widget.LinearLayout")).size();
		System.out.println("Total Menu section is "+s);
		
		//i starts from beacuse  1st two sections are "Menu Logo" [0] and "Home" [1].
		for(int i = 2; i <= s; i++)
		{
			
			
				boolean status = false;
			
				//checking each dynamic menu section name
			try {
				status = driver.findElement(By.xpath("//android.widget.ExpandableListView[@index='1']/android.widget.LinearLayout[@index='"+i+"']"
							+ "/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']")).isDisplayed();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//if those name is present then
			if(status)
			{
				
				//getting menu section name
				String name = driver.findElement(By.xpath("//android.widget.ExpandableListView[@index='1']/android.widget.LinearLayout[@index='"+i+"']"
						+ "/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']")).getText();
				System.out.println("Menu section name is "+name);
				
				//clicking each section
				driver.findElement(By.xpath("//android.widget.ExpandableListView[@index='1']/android.widget.LinearLayout[@index='"+i+"']"
						+ "/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']")).click();
				Thread.sleep(3000);
				String MenuName = driver.findElement(By.id(appcls+":id/categoryTitle")).getText();
				System.out.println("After clicking Menu section displaying name is "+MenuName);
				
				//Verifying menu section title with its menu page title
				assertEquals(MenuName, name, "Content name is same as Menu Section name");
				//clicking menu button for getting another menu section
				menu_button.click();
				Thread.sleep(4000);
			}
			else {
				//if static menu content name appears 
				Thread.sleep(4000);
				System.out.println("Static contents name appearing");
				
				//getting menu section name
				String staticname = driver.findElement(By.xpath("//android.widget.ExpandableListView[@index='1']/android.widget.LinearLayout[@index='"+i+"']"
						+ "/android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='0']")).getText();
				System.out.println("Menu section name is "+staticname);
				
				//clicking each section
				driver.findElement(By.xpath("//android.widget.ExpandableListView[@index='1']/android.widget.LinearLayout[@index='"+i+"']"
						+ "/android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='0']")).click();
				
				Thread.sleep(3000);
				String MenuName = driver.findElement(By.id(appcls+":id/categoryTitle")).getText();
				System.out.println("After clicking Menu section displaying name is "+MenuName);
				
				//if keyboard appears , Hiding
				try {
					driver.hideKeyboard();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Verifying menu section title with its menu page title
				assertEquals(MenuName, staticname, "Content name is same as Menu Section name");
				//clicking menu button for getting another menu section
				menu_button.click();
				Thread.sleep(4000);
				
			}
		 
		}
	
	}
	@AfterTest
	public void closeapp()
	{
		driver.quit();
		
	}
	
}
