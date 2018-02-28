package Sprint1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Saphr_RegBy_FB
{

	
	private static AndroidDriver driver;
	private static String appcls = "com.release.muvisdk";
	
	@Test
	public void Register_Using_FB() throws MalformedURLException, InterruptedException
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
		//scrolling Down
		Dimension dimensions = driver.manage().window().getSize();
						
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();			
		Double screenHeightEnd = dimensions.getHeight() * 0.1;
		int scrollEnd = screenHeightEnd.intValue();
		driver.swipe(0,scrollStart,0,scrollEnd,2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='REGISTER WITH FACEBOOK']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.EditText[@text='Email address or phone number']")).sendKeys("tuser1581@gmail.com");
		driver.findElement(By.xpath("//android.widget.EditText[@text='Facebook password']")).sendKeys("india12345");
		//driver.findElement(By.xpath("//android.widget.Button[@resource-id='u_0_5']")).click();
		String act = driver.currentActivity();
		System.out.println(act);
		
		
		}	
}
