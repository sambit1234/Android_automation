package Sprint1;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class Saphr_RegBy_GMAIL 
{

private static AndroidDriver driver;
private static String appcls = "com.release.muvisdk";
	
	@Test
	public void Register_Using_Gmail() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities capabilities = new  DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Lenovo");
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", appcls);
		capabilities.setCapability("appActivity", "com.home.vod.activity.SplashScreen");
		driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			
			Thread.sleep(25000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.id(appcls+":id/submenu")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Register']")).click();
		Thread.sleep(3000);
		
		//TouchAction Tact =new TouchAction(driver);\
		
		
		//scrolling Down
		Dimension dimensions = driver.manage().window().getSize();
		
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();	
		Double screenHeightEnd = dimensions.getHeight() * 0.1;
		int scrollEnd = screenHeightEnd.intValue();
		driver.swipe(0,scrollStart,0,scrollEnd,2000);
		
		Thread.sleep(3000);
		//clicking Register google button
		driver.findElement(By.xpath("//android.widget.TextView[@text='Register with Google']")).click();
		
		//clicking add account button in new popup
		driver.findElement(By.xpath("//android.widget.Button[@text='Add account']")).click();
		
		//clicking email id in next page
		driver.findElement(By.xpath("//android.widget.EditText[@text='Email or phone']")).sendKeys("tuser151@gmail.com");

		driver.pressKeyCode(AndroidKeyCode.ENTER);
		
		driver.findElement(By.xpath("//android.widget.EditText[@text='Password']")).sendKeys("india12345");
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		Thread.sleep(3000);
		//clicking accept button
		driver.findElement(By.xpath("//android.view.View[@content-desc='ACCEPT']")).click();
		
		// User already registered so use new credentials.
		
}
}
