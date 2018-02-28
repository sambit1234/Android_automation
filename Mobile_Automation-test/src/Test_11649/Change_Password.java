package Test_11649;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.POP;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Change_Password 
{

private static AndroidDriver driver;
private static String appcls = "com.release.leasy";
private static String emailid="bruce1@gmail.com";
private static String pwd ="123456";
private static String logoutbutton = "//android.widget.TextView[@text='Log ud']";
private static String profilebutton = "//android.widget.TextView[@text='Profil']";
	
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
		System.out.println("Change password method started...");
		Thread.sleep(25000);
		
		System.out.println("----------Login Starts ---------");
		//clicking submenu button
		driver.findElement(By.id(appcls+":id/submenu")).click();
    	Thread.sleep(3000);
    	
    	//clicking login button
    	driver.findElement(By.id(appcls+":id/title")).click();
    	driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
    	driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys(pwd);
    	
    	
    	driver.hideKeyboard();
    	Thread.sleep(3000);
    	driver.findElement(By.id(appcls+":id/loginButton")).click();
    	System.out.println("\n"+"---------LOGIN OPERATION FINISHED-------");
    	
    	// clicking submenu for getting Profile button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	// clicking Profile button
    	driver.findElement(By.xpath(profilebutton)).click();
    	
    	Thread.sleep(6000);
    	
    	
    	try {
			driver.hideKeyboard();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//clicking on change password button
    	driver.findElement(By.id(appcls+":id/changePasswordButton")).click();
    	
    	//clicking on confirm password
    	driver.findElement(By.id(appcls+":id/editConfirmPassword")).sendKeys("12345");
    	
    	//scrolling Down
    	Dimension dimensions = driver.manage().window().getSize();
    					
    	Double screenHeightStart = dimensions.getHeight() * 0.5;
    	int scrollStart = screenHeightStart.intValue();			
    	Double screenHeightEnd = dimensions.getHeight() * 0.3;
    	int scrollEnd = screenHeightEnd.intValue();
    	driver.swipe(0,scrollStart,0,scrollEnd,2000);
    			
    	//clicking on new password
    	driver.findElement(By.id(appcls+":id/editNewPassword")).sendKeys("12345");
    	
    	driver.hideKeyboard();
    	
    	//Again clicking on change password button
    	driver.findElement(By.id(appcls+":id/changePasswordButton")).click();
    	Thread.sleep(4000);
    	//driver.hideKeyboard();
    	
    	driver.pressKeyCode(4);
    	
    	System.out.println("\n"+"---------LOGOUT OPERATION STARTS-------");
    	//clicking submenu button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	
    	//clicking logout button
    	driver.findElement(By.xpath(logoutbutton)).click();
    	
    	//clicking "yes" on popup
    	driver.findElement(By.id("android:id/button1")).click();
    	
    	System.out.println("\n"+"---------LOGOUT OPERATION FINISHED-------");
    	
    	Thread.sleep(5000);
    	//clicking submenu button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	Thread.sleep(3000);
    	
    	//clicking login button again after changing password
    	driver.findElement(By.id(appcls+":id/title")).click();
    	driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
    	driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys("12345");
    	
    	driver.hideKeyboard();
    	Thread.sleep(3000);
    	driver.findElement(By.id(appcls+":id/loginButton")).click();
    	System.out.println("\n"+"---------LOGIN OPERATION FINISHED WITH NEW PASSWORD-------");
    	
    	Thread.sleep(2000);
    	
    	try {
    		
			WebElement alertmsg = driver.findElement(By.id(appcls+":id/alertTitle"));
			
			boolean poupstatus = alertmsg.isDisplayed();
			if(poupstatus)
			{
				System.out.println("Invalid credentials...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	System.out.println("\n"+"---------LOGOUT OPERATION STARTS-------");
    	//clicking submenu button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	
    	//clicking logout button
    	driver.findElement(By.xpath(logoutbutton)).click();
    	
    	//clicking "yes" on popup
    	driver.findElement(By.id("android:id/button1")).click();
    	
    	System.out.println("\n"+"---------LOGOUT OPERATION FINISHED-------");
    	
    	System.out.println("Change password method finished...");
		
		
	}
	
	
}
