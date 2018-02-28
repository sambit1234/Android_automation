package Sprint2;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Generic_Library.Android;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Logo_honor extends Android
{

	//Check homepage banner in backend.
	//This Testing will vary device to device due to log size.
	
	/*
	 * Open App
	 * Click Menu and check Logo back to Homepage
	 * click submenu and click Login ,check Logo back to Homepage
	 * click submenu and click Register ,check Logo back to Homepage
	 * 
	 * */

	@BeforeMethod
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
	

	    
	    Thread.sleep(30000);
	}
	
	@Test(priority=1)
	public void MenuLogo()
	{
		
		//int ExpectedWidth = 732;
		//int ExpectedHeight = 600;
		
		int ExpectedWidth = 1080;
		int ExpectedHeight = 510;
		
		//clicking Menu button For getting Logo
		WebElement menu_button = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/"
				+ "android.view.ViewGroup[@index='0']/android.widget.ImageButton[@index='0']"));
		menu_button.click();
				
		//finding Logo in Menu	{honor Device}
		WebElement Logo_In_Menu = driver.findElement(By.xpath("//android.widget.ImageView[@index='0']"));
		
		
	    boolean status1 = Logo_In_Menu.isDisplayed();
		System.out.println("Menu Logo is displaying "+status1);
		//System.out.println(Logo_In_Menu.getSize());
			    
		int MenuLogohight = Logo_In_Menu.getSize().getHeight();
		int MenuLogowidth = Logo_In_Menu.getSize().getWidth();
		System.out.println("Menu Logo width is "+MenuLogowidth+" and height is "+MenuLogohight);
		assertEquals(MenuLogowidth, ExpectedWidth, "Menu Logo width is not matching");
		assertEquals(MenuLogohight, ExpectedHeight, "Menu Logo height is not matching");
		System.out.println("Menu Logo Veried");
		
			    
	}
	
	@Test(priority=2,enabled=true)
	public void LoginmenuLogo() throws MalformedURLException, InterruptedException
	{
		int ExpectedWidth = 450;
		int ExpectedHeight = 450;
		
	    //clicking in submenu to get Logo
	    WebElement submenuButton = driver.findElement(By.id(appcls+":id/submenu"));
	    
	    submenuButton.click();
	    
    	//clicking login button
	    driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
				+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='0']")).click();
    	
    	//finding login Menu logo
    	WebElement LoginLogo = driver.findElement(By.id(appcls+":id/loginImageView"));
    	boolean status2 = LoginLogo.isDisplayed();
    	System.out.println("Login Logo is diplaying "+status2);
    	int loginlogowid = LoginLogo.getSize().getWidth();
    	int loginlogohgt = LoginLogo.getSize().getHeight();
    	System.out.println("Login Menu Logo width is "+loginlogowid+" and height is "+loginlogohgt);
    	
    	assertEquals(loginlogowid, ExpectedWidth, "Login Logo width is not matching");
		assertEquals(loginlogohgt, ExpectedHeight, "Login Logo height is not matching");
    	
		System.out.println("Login Menu Logo Veried");
		
		
	}
	
	@Test(priority=3,enabled=true)
	public void RegisterMenuLogo() throws MalformedURLException, InterruptedException
	{
		int ExpectedWidth = 450;
		int ExpectedHeight = 450;
		
	    //clicking in submenu to get Logo
	    WebElement submenuButton = driver.findElement(By.id(appcls+":id/submenu"));
	    System.out.println("Submenu displying "+submenuButton.isDisplayed());
	    submenuButton.click();
	    
    	
    	//clicking login button
	    driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
				+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='1']")).click();
    	
    	//finding login Menu logo
    	WebElement RegisterLogo = driver.findElement(By.id(appcls+":id/registerImageView"));
    	boolean status3 = RegisterLogo.isDisplayed();
    	System.out.println("Login Logo is diplaying "+status3);
    	int Reglogowid = RegisterLogo.getSize().getWidth();
    	int Reglogohgt = RegisterLogo.getSize().getHeight();
    	System.out.println("Register Menu Logo width is "+Reglogowid+" and height is "+Reglogohgt);
    	
    	assertEquals(Reglogowid, ExpectedWidth, "Register width is not matching");
		assertEquals(Reglogohgt, ExpectedHeight, "Register height is not matching");
    	
    	driver.pressKeyCode(4);
		
    	System.out.println("Register Logo Veried");
		
	}
	
	@AfterClass
	public void Sucmsg()
	{
		System.out.println("Logo Test is Completed");
	}
	

}
