package Test_11649;

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

private KeyboardEvent ke;
	
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
		//driver.findElement(By.xpath("//android.widget.EditText[@text='Search']")).sendKeys("Death");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//android.widget.EditText[@text='Search']")).sendKeys("odi");
		Thread.sleep(4000);
		
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		//String command = "adb shell input keyevent 66";
		//Process result = Runtime.getRuntime().exec(command);
		

		/*
		
		try {
	        robot = new Robot();
	        
	         robot.keyPress(KeyEvent.VK_ENTER);
	       
	         //robot.keyRelease(KeyEvent.VK_ENTER);
	    }
		catch (AWTException e) {
			
			
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
		*/
		
		
		//driver.pressKeyCode(AndroidKeyCode.ENTER);
		
		//
		//app.getKeyboard().pressKey(Keys.ENTER);
		//app.getKeyboard().sendKeys(Keys.ENTER);
		
		//driver.getKeyboard().pressKey(Keys.ENTER);
		
		/*
		driver.pressKeyCode(AndroidKeyCode.SPACE);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_A);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_NUMPAD_ENTER);
		*/
		
		//driver.pressKeyCode(84);
		//srch.sendKeys(Keys.ENTER);
		//driver.pressKeyCode(AndroidKeyCode.KEYCODE_SEARCH);
		
		//driver.pressKeyCode(66);
		//driver.pressKeyCode(84);
		//TouchAction tc;
		//TouchScreen ts;
		//ts.singleTap();
		
		
		//driver.tap
		//driver.tap(1, 710, 1260, 1);
		//Thread.sleep(3000);
		
		System.out.println(AndroidKeyCode.KEYCODE_SEARCH);
		
		//srch.submit();
		
		
		//srch.sendKeys("DTH");
		
		//Actions act = new Actions(driver);
		//act.sendKeys("death").sendKeys(Keys.RIGHT.SHIFT).perform();
		
		//act.sendKeys(Keys.ENTER).perform();
		
		
		//act.sendKeys(srch, sendKeys("Death"),Keys.ENTER).perform();
		//(AndroidKeyCode.KEYCODE_SEARCH).build().perform();
		
		
		
		
		
		//driver.findElement(By.xpath("//android.widget.EditText[@text='Search']")).sendKeys(Keys.ENTER);
		//driver.pressKeyCode(AndroidKeyCode.KEYCODE_SEARCH);
		
		//driver.pressKeyCode(84);
		//srch.sendKeys("dea");
		
		//driver.pressKeyCode(66);
		
		//System.out.println(AndroidKeyCode.KEYCODE_SEARCH);
		
		//driver.pressKeyCode(81);
		
		//driver.hideKeyboard();
		
		//driver.longPressKeyCode(AndroidKeyCode.KEYCODE_SEARCH);
		
		//driver.execute("mobile:keyevent", "keycode:66");
		
		
	}
	
}
