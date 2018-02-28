package Test_11649;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ContactUs {
	
	/*
	 * Open App and login
	 * click Menu
	 * click contact us
	 * check page title
	 * Enter name,email,msg and submit.
	 * */
	
	private static AndroidDriver driver;
	private static String appcls = "com.release.leasy";
	private static String emailid="bruce1@gmail.com";
	private static String pwd ="123456";
	private static String logoutbutton = "//android.widget.TextView[@text='Log ud']";
	private static String profilebutton = "//android.widget.TextView[@text='Profil']";
	private static String menubutton = "//android.widget.ImageButton[@bounds='[0,72][168,240]']";
	private static String contactus = "//android.widget.TextView[@text='Kontakt os']";
	
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
		System.out.println("Contact us Method started...");
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
		Thread.sleep(4000);
			
		
	}
	
	
	@Test
	public void Contact_Us() throws InterruptedException
	{
		Thread.sleep(3000);
		String ExpTitle = "Kontakt os";
		//clicking menu button
		driver.findElement(By.xpath(menubutton)).click();
		 
		Thread.sleep(3000);
		//scrolling Down
				Dimension dimensions = driver.manage().window().getSize();
						
				Double screenHeightStart = dimensions.getHeight() * 0.5;
				int scrollStart = screenHeightStart.intValue();			
				Double screenHeightEnd = dimensions.getHeight() * 0.1;
				int scrollEnd = screenHeightEnd.intValue();
				driver.swipe(0,scrollStart,0,scrollEnd,2000);
		
		//clicking contactus 
		driver.findElement(By.xpath(contactus)).click();
		
		String ActualTitle = driver.findElement(By.id(appcls+":id/categoryTitle")).getText();
		assertEquals(ActualTitle, ExpTitle, "Title is not matching");
		
		System.out.println(ActualTitle+" is matching-----> pls proced next");
		Thread.sleep(3000);
		
		//entering Name in box
		driver.findElement(By.id(appcls+":id/contact_name")).sendKeys("Thor");
		
		//entering email in the box
		driver.findElement(By.id(appcls+":id/contact_email")).sendKeys("sonofodin006@gmail.com");
		
		driver.hideKeyboard();
		
		//entering message in the msg box
		driver.findElement(By.id(appcls+":id/contact_msg")).sendKeys("Thor Ragnarok");
		
		driver.hideKeyboard();
		
		//clicking submit button
		driver.findElement(By.id(appcls+":id/submit_cont")).click();
		
		System.out.println("Form submitted...");
		
		Thread.sleep(3000);
		
		
		
	}
	
	@AfterClass
	public void Logout_Quit()throws InterruptedException
	{
		
		Thread.sleep(3000);
		
		
		System.out.println("\n"+"---------LOGOUT OPERATION STARTS-------");
    	//clicking submenu button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	
    	//clicking logout button
    	driver.findElement(By.xpath(logoutbutton)).click();
    	
    	//clicking "yes" on popup
    	driver.findElement(By.id("android:id/button1")).click();
    	
    	System.out.println("\n"+"---------LOGOUT OPERATION FINISHED-------");
    	System.out.println("Contact us Method Finished...");
		//driver.quit();
			
	}
	
	
}
