package Sprint1;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import Generic_Library.Android;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Sapphire_Lang extends Android
{


	
	@Test
	public void Language() throws MalformedURLException, InterruptedException
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
		
		
		WebElement subMenu = driver.findElement(By.id(appcls+":id/submenu"));
		subMenu.click();
		String Expcted = driver.findElement(By.xpath("//android.widget.TextView[@text='Register']")).getText();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Language']")).click();
		WebElement Danish = driver.findElement(By.xpath("//android.widget.RelativeLayout[@bounds='[111,881][968,1061]']"));
		boolean status = Danish.isSelected();
		System.out.println("Danish Lang checkbox is selected "+status);
		Danish.click();
		
		driver.findElement(By.xpath("//android.widget.Button[@text='Apply']")).click();
		System.out.println(Expcted);
		Thread.sleep(15000);
		//Checking Lang chang is working or not by validating in submenu
		subMenu.click();
		String Actual = driver.findElement(By.xpath("//android.widget.TextView[@text='Opret konto']")).getText();
		System.out.println("Expected result is "+Expcted+" and Actual Result is "+Actual);
		//assertEquals(Actual, Expcted, "Result is not Matching  ");
		
	
}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
