package Sprint3;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ImeActivationFailedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver.ImeHandler;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.handler.ImeActivateEngine;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.event.KeyboardEvent;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class Search_button 
{

private static AndroidDriver driver;
private static String appcls = "com.release.muvisdk";
private static AppiumDriver app ;
private static Robot robot;



	@Test
	public void Searching() throws InterruptedException, IOException
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
		
		Thread.sleep(30000);
	    
		driver.findElement(By.id(appcls+":id/action_search")).click();
		
		//clicking search box
		driver.findElement(By.id(appcls+":id/search_src_text")).sendKeys("Muvi");
		Thread.sleep(4000);
		
		
		//driver.pressKeyCode(AndroidKeyCode.KEYCODE_SEARCH);
		//driver.pressKeyCode(3);
		
		
		
		
		
		
	}
	
}
