package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class P1 {

private static AndroidDriver driver;
	
	@Test
	public void Searching() throws MalformedURLException, InterruptedException
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
		
		Thread.sleep(30000);
	    
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.release.muvisdk:id/action_search']")).click();
		
		//clicking search box
		//driver.findElement(By.xpath("//android.widget.EditText[@text='Search']")).sendKeys("Death");
		Thread.sleep(5000);
		
		WebElement srch = driver.findElement(By.xpath("//android.widget.EditText[@text='Search']"));
		srch.sendKeys("Death");
		//srch.sendKeys(Keys.ENTER);
	    
		driver.sendKeyEvent(AndroidKeyCode.KEYCODE_SEARCH);
		
		Thread.sleep(3000);
		
		
		
		//srch.submit();
		
		System.out.println("IME methods input");
		//srch.sendKeys("DTH");
		
		
		
		
		
		
		
		
	}
}
