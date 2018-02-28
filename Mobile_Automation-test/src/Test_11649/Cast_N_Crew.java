package Test_11649;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Cast_N_Crew
{

private static AndroidDriver driver;
private static String appcls = "com.release.leasy";
private static String emailid="bruce1@gmail.com";
private static String pwd ="123456";
private static String logoutbutton = "//android.widget.TextView[@text='Log ud']";
//private static String yesbutton = "//android.widget.Button[@text='Ja']";
private static String content = "//android.widget.TextView[@text='La La Land']";

//private static WebElement Content = driver.findElement(By.xpath("//android.widget.TextView[@text='Odissi Dance']"));


//Note in xpath take "log ind"

/*
 * Login
 * Click content
 * clicking cast and crew
 * verifying cast and crew page opened or not by title
 * checking cast name, cast image and Profession
 * clicking Cast page
 * checking Image of cast after clicking Cast Layout.
 * checking cast name and details in  Cast Layout page.
 * Checking Respective Content in Cast Detail page
 * Logout
 * */
	
	@Test
	public void CastAndCrew() throws MalformedURLException, InterruptedException
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
		
		System.out.println("Cast_N_Crew method started...");
		Thread.sleep(25000);
		
		String ExpectedTitle = "Skuespillere og instruktører";
		String ExpectedCastName = "Damien Chazelle";
		//String ExpctedCastNameIn_castPage = "Rasmus Berg";
		String ExpectedProfname = "Instruktør";
		//String ExpectedCastDetails = "Tech Support";
		
		System.out.println("Login Starts...");
		//clicking submenu button
		driver.findElement(By.id(appcls+":id/submenu")).click();
		
		//clicking login button
    	driver.findElement(By.id(appcls+":id/title")).click();
    	driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
    	driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys(pwd);
    	
    	driver.hideKeyboard();
    	Thread.sleep(3000);
    	driver.findElement(By.id(appcls+":id/loginButton")).click();
    	
    	Thread.sleep(9000);
    	
    	/*
    	//scrolling Down
    	Dimension dimensions = driver.manage().window().getSize();
    					
    	Double screenHeightStart = dimensions.getHeight() * 0.5;
    	int scrollStart = screenHeightStart.intValue();			
    	Double screenHeightEnd = dimensions.getHeight() * 0.1;
    	int scrollEnd = screenHeightEnd.intValue();
    	driver.swipe(0,scrollStart,0,scrollEnd,2000);
		*/
    	
    	//---------------------------------------------------Content----------------------------------------------
    	
    	System.out.println("Clicking on Content...");
    	
		//clicking "Odissi Dance" content from homepage
    	WebElement Content = driver.findElement(By.xpath(content));
    	Content.click();
    	
    	//---------------------------------------------------Content----------------------------------------------
		
    	System.out.println("Checking cast and crew ...");
    	
    	Thread.sleep(4000);
    	
		//clicking on cast and crew button
		driver.findElement(By.id(appcls+":id/videoCastCrewTitleTextView")).click();
		
		//verifying cast and crew page opened or not
		String actualtitle = driver.findElement(By.id(appcls+":id/castCrewTitleTextView")).getText();
		//assertEquals(actualtitle, ExpectedTitle, "Title is not matching");
		System.out.println(actualtitle);
		
		
		//checking cast image
		boolean castimagestatus = driver.findElement(By.id(appcls+":id/castImageView")).isDisplayed();
		System.out.println("Cast image is displaying "+castimagestatus);
		
		//checking cast name
		String actualcastname = driver.findElement(By.id(appcls+":id/castNameTextView")).getText();
		assertEquals(actualcastname, ExpectedCastName, "Cast is not Matching");
		System.out.println(actualcastname);
		
		
		//checking cast profession
		String actualprofName = driver.findElement(By.id(appcls+":id/castDescriptionTextView")).getText();
		assertEquals(actualprofName, ExpectedProfname, "Profession Name is not matching");
		 
		/*
		//clicking Cast page
		driver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']")).click();
		Thread.sleep(4000);
		//checking Image of cast after clicking Cast Layout
		boolean status = driver.findElement(By.id(appcls+":id/castImageView")).isDisplayed();
		System.out.println("After clicking CastLayout , Image is diplaying "+status);
		
		String CastNameIn_castPage = driver.findElement(By.xpath("//android.widget.TextView[@text='Sonali']")).getText();
		assertEquals(CastNameIn_castPage, ExpctedCastNameIn_castPage, "Cast in Cast Page is not Matching");
		
		String CastDetails = driver.findElement(By.id(appcls+ ":id/castDescriptionTextView")).getText();
		assertEquals(CastDetails, ExpectedCastDetails, "Cast Details is not Matching");
		
		//Checking Respective Content in Cast Detail page
		boolean RespectiveContent = driver.findElement(By.xpath("//android.widget.TextView[@text='Cultural Event']")).isDisplayed();
		System.out.println("In cast detail Page , Respective content is showing "+RespectiveContent);
		
		driver.pressKeyCode(4);
		*/
		Thread.sleep(4000);
		
		driver.pressKeyCode(4);
		
        System.out.println("----- Logout -----");
    	
    	//clicking submenu button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	
    	//clicking logout button
    	driver.findElement(By.xpath(logoutbutton)).click();
    	
    	//clicking "yes" on popup
    	driver.findElement(By.id("android:id/button1")).click();
    	
    	System.out.println("----- Logout Ends -----");
    	System.out.println("Cast_N_Crew method finished...");
		
	}
	
}
