package Mob_test;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import Generic_Library.Android;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class P2 extends Android 
{
	
	private static AndroidDriver driver;
	private static String appcls = "com.release.muvisdk";
	private static String emailid="bruce12@gmail.com";
	private static String pwd ="1234";
	private static int Menu_section = 4;
	//make sure download option is enbaled fro  cms, if disble then chnage [dwn = 0]
	private static int dwn = 1;
	
	@Test
	public void testing() throws MalformedURLException, InterruptedException,NoSuchElementException
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
		
		WebElement menu_button = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/"
				+ "android.view.ViewGroup[@index='0']/android.widget.ImageButton[@index='0']"));
		
		menu_button.click();
		Thread.sleep(4000);
		
		int v = driver.findElements(By.xpath("//android.widget.ExpandableListView[@index='1']/android.widget.LinearLayout")).size();
		
		System.out.println(v);
			
			
		
		
       
	}
	
}
