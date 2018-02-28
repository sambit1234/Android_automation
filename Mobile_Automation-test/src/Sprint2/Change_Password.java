package Sprint2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import Generic_Library.Android;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Change_Password extends Android
{

	/*Open app and Login
	 * click profile
	 * change password
	 * logout
	 * Again login with chnage pasword
	 * again change password to previous 
	 * logout
	 * 
	 * */


	@Test
	public void ChnagePassword() throws MalformedURLException, InterruptedException
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
		
		login();
    	
    	// clicking submenu for getting Profile button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	
    	//clicking profile button
    	driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
    			+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='0']")).click();
    	
    	Thread.sleep(6000);
    	//driver.hideKeyboard();
    	//clicking on change password button
    	driver.findElement(By.id(appcls+":id/changePasswordButton")).click();
    	
    	//clicking on confirm password
    	driver.findElement(By.id(appcls+":id/editConfirmPassword")).sendKeys("12345");
    	
    	
    	//clicking on new password
    	driver.findElement(By.id(appcls+":id/editNewPassword")).sendKeys("12345");
    	
    	driver.hideKeyboard();
    	
    	//Again clicking on change password button
    	driver.findElement(By.id(appcls+":id/update_profile")).click();
    	Thread.sleep(4000);
    	//driver.hideKeyboard();
    	
    	driver.pressKeyCode(4);
    	
    	
    	logout();
    	
    	Thread.sleep(5000);
    	//clicking submenu button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	Thread.sleep(3000);
    	
    	//clicking login button again after changing password
    	driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
    			+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='0']")).click();
    	
    	driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your Email Address']")).sendKeys(emailid);
    	
    	driver.findElement(By.xpath("//android.widget.EditText[@index='2']")).sendKeys("12345");
    	
    	driver.hideKeyboard();
    	Thread.sleep(3000);
    	driver.findElement(By.id(appcls+":id/loginButton")).click();
    	System.out.println("\n"+"---------LOGIN OPERATION FINISHED WITH NEW PASSWORD-------");
    	
    	Thread.sleep(4000);
    	
    	System.out.println("Again changing password to prevoius...");
    	
    	//clicking submenu button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	
    	//clicking profile button
    	driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
    			+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='0']")).click();
    	
    	Thread.sleep(6000);
    	//driver.hideKeyboard();
    	//clicking on change password button
    	driver.findElement(By.id(appcls+":id/changePasswordButton")).click();
    	
    	//clicking on confirm password
    	driver.findElement(By.id(appcls+":id/editConfirmPassword")).sendKeys(pwd);
    	
    	
    	//clicking on new password
    	driver.findElement(By.id(appcls+":id/editNewPassword")).sendKeys(pwd);
    	
    	driver.hideKeyboard();
    	
    	//Again clicking on change password button
    	driver.findElement(By.id(appcls+":id/update_profile")).click();
    	Thread.sleep(4000);
    	//driver.hideKeyboard();
    	
    	driver.pressKeyCode(4);
    	
    	logout();
    	
    	System.out.println("Change Password is finished");
		
		
	}
	
	
}
