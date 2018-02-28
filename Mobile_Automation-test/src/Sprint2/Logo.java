package Sprint2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Logo {
	
private static AndroidDriver driver;


	@BeforeMethod
	public void startApp() throws MalformedURLException, InterruptedException
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
	}
	
	@Test(priority=1)
	public void MenuLogo()
	{
		
		int ExpectedWidth = 732;
		int ExpectedHeight = 600;
		
		//clicking Menu button For getting Logo
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open']")).click();
				
		//finding Logo in Menu
		WebElement Logo_In_Menu = driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[48,75][780,675]']"));
	    boolean status1 = Logo_In_Menu.isDisplayed();
		System.out.println("Menu Logo is displaying "+status1);
		//System.out.println(Logo_In_Menu.getSize());
			    
		int MenuLogohight = Logo_In_Menu.getSize().getHeight();
		int MenuLogowidth = Logo_In_Menu.getSize().getWidth();
		System.out.println("Menu Logo width is "+MenuLogowidth+" and height is "+MenuLogohight);
		assertEquals(MenuLogowidth, ExpectedWidth, "Menu Logo width is not matching");
		assertEquals(MenuLogohight, ExpectedHeight, "Menu Logo height is not matching");
		
		
			    
	}
	
	@Test(priority=2)
	public void LoginmenuLogo() throws MalformedURLException, InterruptedException
	{
		int ExpectedWidth = 450;
		int ExpectedHeight = 450;
		
	    //clicking in submenu to get Logo
	    WebElement submenuButton = driver.findElement(By.xpath("//android.widget.TextView[@bounds='[936,87][1080,231]']"));
	    
	    submenuButton.click();
	    
    	
    	//clicking login button
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Log in']")).click();
    	
    	//finding login Menu logo
    	WebElement LoginLogo = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.release.muvisdk:id/loginImageView']"));
    	boolean status2 = LoginLogo.isDisplayed();
    	System.out.println("Login Logo is diplaying "+status2);
    	int loginlogowid = LoginLogo.getSize().getWidth();
    	int loginlogohgt = LoginLogo.getSize().getHeight();
    	System.out.println("Login Menu Logo width is "+loginlogowid+" and height is "+loginlogohgt);
    	
    	assertEquals(loginlogowid, ExpectedWidth, "Login Logo width is not matching");
		assertEquals(loginlogohgt, ExpectedHeight, "Login Logo height is not matching");
    	
    	//clicking back button
    	driver.findElement(By.xpath("//android.widget.ImageButton[@bounds='[0,75][168,243]']")).click();
		
		
		
	}
	
	@Test(priority=3)
	public void RegisterMenuLogo() throws MalformedURLException, InterruptedException
	{
		int ExpectedWidth = 450;
		int ExpectedHeight = 450;
		
	    //clicking in submenu to get Logo
	    WebElement submenuButton = driver.findElement(By.xpath("//android.widget.TextView[@bounds='[936,87][1080,231]']"));
	    System.out.println("Submenu displying "+submenuButton.isDisplayed());
	    submenuButton.click();
	    
    	
    	//clicking login button
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Register']")).click();
    	
    	//finding login Menu logo
    	WebElement RegisterLogo = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.release.muvisdk:id/registerImageView']"));
    	boolean status3 = RegisterLogo.isDisplayed();
    	System.out.println("Login Logo is diplaying "+status3);
    	int Reglogowid = RegisterLogo.getSize().getWidth();
    	int Reglogohgt = RegisterLogo.getSize().getHeight();
    	System.out.println("Register Menu Logo width is "+Reglogowid+" and height is "+Reglogohgt);
    	
    	assertEquals(Reglogowid, ExpectedWidth, "Register width is not matching");
		assertEquals(Reglogohgt, ExpectedHeight, "Register height is not matching");
    	
    	//clicking back button
    	driver.findElement(By.xpath("//android.widget.ImageButton[@bounds='[0,75][168,243]']")).click();
		
		
		
	}
	
	@AfterMethod
	public void Sucmsg()
	{
		System.out.println("Test is Completed");
	}
	

}
