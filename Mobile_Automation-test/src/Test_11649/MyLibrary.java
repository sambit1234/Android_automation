package Test_11649;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


/*
 * NOT DONE
 * */
public class MyLibrary 
{
	
	/*
	 * Open app amd Login
	 * Click Menu button
	 * Click My Library 
	 * verify page title
	 * Verify purchased content displaying or not
	 * */
	
private static AndroidDriver driver;
private static String appcls = "com.release.leasy";
private static String emailid="bruce12@mvrht.net";
private static String pwd ="123456";
private static String menubutton = "//android.widget.ImageButton[@bounds='[0,72][168,240]']";
private static String loginbutton = "//android.widget.TextView[@text='Log ind']";

	
	@BeforeClass
	public void startApp() throws MalformedURLException, InterruptedException
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
		
		System.out.println("----------Login Starts ---------");
		//clicking submenu button
		driver.findElement(By.id(appcls+":id/submenu")).click();
    	Thread.sleep(3000);
    	
    	//clicking login button
    	driver.findElement(By.xpath(loginbutton)).click();
    	driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
    	driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys(pwd);
    	
    	
    	driver.hideKeyboard();
    	Thread.sleep(3000);
    	driver.findElement(By.id(appcls+":id/loginButton")).click();
    	System.out.println("\n"+"---------LOGIN OPERATION FINISHED-------");
		Thread.sleep(4000);
			
		
	}
	
	@Test
	public void Mylibrary()
	{
		
		
		String ExpTitle = "My Library";
		//clicking menu button
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open']")).click();
		
		//clicking Mylibrary 
		driver.findElement(By.xpath("//android.widget.TextView[@text='my library']")).click();
		
		String ActualTitle = driver.findElement(By.id(appcls+":id/sectionTitle")).getText();
		assertEquals(ActualTitle, ExpTitle, "Title is not matching");
		System.out.println(ActualTitle);
		
		WebElement content = driver.findElement(By.id(appcls+":id/movieTitle"));
		boolean status = content.isDisplayed();
		
		if(status) {
			
			System.out.println("Purchased content is displaying in Mylibrary");
		}
		
        System.out.println("----- Logout -----");
    	
    	//clicking submenu button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	
    	//clicking logout button
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();
    	
    	//clicking "yes" on popup
    	driver.findElement(By.xpath("//android.widget.Button[@text='Yes']")).click();
    	
    	System.out.println("----- Logout Ends -----");
		
	}
		
	
}
