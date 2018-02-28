package Test_11649;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Forgot_Password 
{

private static AndroidDriver driver;
private static String appcls = "com.release.leasy";
private static String emailid="bruce1@gmail.com";
private static String pwd ="123456";

	
	@Test
	public void SapphireAppDemo() throws MalformedURLException, InterruptedException
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
		
		System.out.println("Forgot password method started...");
		Thread.sleep(20000);
		
		driver.findElement(By.id(appcls+":id/submenu")).click();
		driver.findElement(By.id(appcls+":id/title")).click();
		Thread.sleep(3000);
		driver.findElement(By.id(appcls+":id/forgotPasswordTextView")).click();
		Thread.sleep(3000);
		driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
		driver.hideKeyboard();
		driver.findElement(By.id(appcls+":id/submitButton")).click();
		
		//after submitting capturing msg
		String msg = driver.findElement(By.id("android:id/message")).getText();
		System.out.println("After submitting we are getting message "+msg);
		
		//clicking ok button
		driver.findElement(By.xpath("//android.widget.Button[@text='Ok']")).click();
		
		System.out.println("Forgot password method finished...");
		
		
		
		
	
	}
}
