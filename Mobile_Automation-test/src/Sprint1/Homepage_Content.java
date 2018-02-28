package Sprint1;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Library.Android;
import Mob_test.Screnshot;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class Homepage_Content extends Android
{


/*
 * It will check Application Name
 * Menu button visibility and name
 * Search  button visibility and name
 * Submenu  button visibility and name
 * Viewall button visibility and name
 *  
 * */
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
		
		Thread.sleep(20000);
		WebElement menu_button = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/"
 				+ "android.view.ViewGroup[@index='0']/android.widget.ImageButton[@index='0']"));
		boolean menu_status = menu_button.isDisplayed();
		System.out.println("Menu Button is Displayed "+menu_status);
		//assertTrue(status);
		if(menu_status) {
			
			//appname
			WebElement element =  driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/"
					+ "android.view.ViewGroup[@index='0']/android.widget.TextView[@index='1']"));
			boolean status1 = element.isDisplayed();
			String apname = element.getText();
			if(apname != null) {
				System.out.println("\n"+"AppNameText is Displaying "+status1+ " and The AppName is "+apname);

			}
			
			if(status1) {
				
				WebElement searchbutn = driver.findElement(By.id(appcls+":id/action_search"));
				boolean status2 = searchbutn.isDisplayed();
				System.out.println("\n"+"Search button is displaying "+status2);
				
				if(status2)
				{
				  	WebElement optionButn = driver.findElement(By.id(appcls+":id/submenu"));
			    	boolean status3 = optionButn.isDisplayed();
			    	System.out.println("\n"+"Submenu button is displaying "+status3);
			    	
			    	if(status3) {
			    		
			    		WebElement HompgImg = driver.findElement(By.id(appcls+":id/daimajia_slider_image"));
			    		boolean status4 = HompgImg.isDisplayed();
			    		System.out.println("\n"+"HomePage Image is displayed "+status4);
			    		Thread.sleep(4000);
			    		
			    		
			    		if(status4) {
			    			WebElement vewbutn = driver.findElement(By.id(appcls+":id/btnMore"));
			    			boolean status5 = vewbutn.isDisplayed();
			    			String value1 = vewbutn.getText();
			    			System.out.println("\n"+"View All button is displayed "+status5+" And the Text is "+value1);
			    			
			    			if(status5) {
			    				
			    				System.out.println("All contents are displaying on Homepage...");
			    		    	Thread.sleep(4000);
			    		    	
			    		    	
			    			}
			    			
			    		}
			    		
			    	}
			    	
				}
				
			}
			
			
			
		}
		
		
		
  
	
		
		
		/*
		WebElement recmtxt = driver.findElement(By.xpath("//android.widget.TextView[@text='Recommended']"));
		boolean status6 = recmtxt.isDisplayed();
		String rcmText = recmtxt.getText();
		System.out.println("\n"+"Recomnded Text is displayed "+status6+" and the text is "+rcmText);
		Thread.sleep(3000);
		WebElement Mstvwdtxt = driver.findElement(By.xpath("//android.widget.TextView[@text='Most Viewed']"));  
		boolean status7 = Mstvwdtxt.isDisplayed();
		String MostvwdText = Mstvwdtxt.getText();
		System.out.println("\n"+"MostViewd Text is displayed "+status6+" and the text is "+MostvwdText);
		Thread.sleep(3000);
		*/
		//WebElement ContntImg = driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[522,1181][993,1436]']"));
    	//boolean status8 = ContntImg.isDisplayed();
    	//System.out.println("\n"+"Recommended section content is displayed "+status8);
    	
		/*
    	
    	
    	//checking email and name
    	// clicking submenu
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Profile']")).click();
    	String ActualName = driver.findElement(By.id(appcls+":id/editProfileNameEditText")).getText();
    	String ActualEmail = driver.findElement(By.id(appcls+":id/emailAddressEditText")).getText();
    	//System.out.println(ActualEmail + " " + ActualName);
    	
    	//Validating Email and Name with assert
    	
    	System.out.println("\n"+"----- Validating Email and Username -----");
    	assertEquals(ActualName, ExpectedName, "User name is not matching to actual result");
    	assertEquals(ActualEmail, ExpectedEmail, "User Email is not matching to actual result");
    	System.out.println("\n"+"----- Email and Username Validation is successfull -----");
    	
    	Thread.sleep(10000);
    	driver.hideKeyboard();
    	driver.pressKeyCode(AndroidKeyCode.BACK);
    	
    	System.out.println("\n"+"---------LOGOUT OPERATION STARTS-------");
    	
    	//clicking submenu button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	Thread.sleep(4000);
    	//clicking logout button
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//android.widget.Button[@text='Yes']")).click();
    	
    	System.out.println("\n"+"---------LOGOUT OPERATION FINISHED-------");
    	*/
    	/*
    	//Taking ScreenShot
    	
    	*/
 	
	
}
}
