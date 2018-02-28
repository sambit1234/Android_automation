package Test_11649;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

/*
 * NOT DONE
 * */

public class Multipart_Content {
	
	/*
	 * Open App and Login
	 * Click "Award Distribution" content in homepage
	 * Verify Content title
	 * Verify "View trailer",episode dropdown,"view all", "Add a Review",star rating, "CEO Awarding" content
	 * clicking "View trailer" button wait for 12sec 
	 * click back
	 * click "View All" button
	 * Verify "All Episode" title is coming or not
	 * Clicking "CEO Awarding" content
	 * Purchase is if it is not been purchased.
	 * Wait 5sec for playing video.
	 * Back to Main content page
	 * Click add to fav
	 * Wait for 4sec and click add review
	 * Give rating and add review
	 * Back to content page
	 * 
	 * */
	
	
	// *Before running this script make sure that review is removed from CMS. 
	
	private static AndroidDriver driver;
	private static String appcls = "com.release.muvisdk";
	private static String emailid="bruce12@gmail.com";
	private static String pwd ="1234";
	private static String content = "//android.widget.TextView[@text='Awards Distribution among Muvians']";
	private static String content1 = "//android.widget.TextView[@text='CEO Awarding']";
	
	@BeforeClass
	public void Open_Login_App() throws MalformedURLException, InterruptedException
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
		
		Thread.sleep(15000);
		
		
		System.out.println("-------LOGIN STARTS------");
		//clicking submenu button
		driver.findElement(By.id(appcls+":id/submenu")).click();
		Thread.sleep(3000);
		
		//clicking login button
		driver.findElement(By.xpath("//android.widget.TextView[@text='Log in']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your Email Address']")).sendKeys(emailid);
		driver.findElement(By.xpath("//android.widget.EditText[@index='2']")).sendKeys(pwd);
		
		//driver.pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
		
		driver.hideKeyboard();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Login']")).click();
		System.out.println("\n"+"---------LOGIN OPERATION FINISHED-------");
		
		Thread.sleep(4000);
		
		
	}
	
	@Test(priority=1,enabled=true)
	public void Verify_All_Titles() throws MalformedURLException, InterruptedException
	{
		
		// Here Testing content title  (Homepage > Award...> CEO Awarding) 
		
		String expected_title = "Awards Distribution among Muvians";
		
		/*
		//clicking menu button
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open']")).click();
				
		//clicking tv button
		driver.findElement(By.xpath("//android.widget.TextView[@text='tv']")).click();
		*/
		
		Thread.sleep(10000);
		/*
		//scrolling Down
		Dimension dimensions = driver.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();			
		Double screenHeightEnd = dimensions.getHeight() * 0.1;
		int scrollEnd = screenHeightEnd.intValue();
		driver.swipe(0,scrollStart,0,scrollEnd,2000);
		*/
		
		
		//-------------------------------------------------------------Webelement-------------------------------------------------------------
		
		//clicking "Award Distribution" multipart content
		WebElement Award = driver.findElement(By.xpath(content));
		Award.click();
		
		//-------------------------------------------------------------Webelement--------------------------------------------------------------
		Thread.sleep(6000);
		
		//checking content title
		String title = driver.findElement(By.id(appcls+":id/videoTitle")).getText();
		System.out.println(title);
		//assertEquals(title, expected_title, "Title is not matching");
		
		
		//checking view trailer button is displaying or not
		boolean st = driver.findElement(By.id(appcls+":id/viewTrailerButton")).isDisplayed();
		System.out.println("view trailer is diplaying "+st);
		
		
		/*
		//checking cast and crew is displaying or not
		boolean castst = driver.findElement(By.id(appcls+":id/videoCastCrewTitleTextView")).isDisplayed();
		System.out.println("Cast and crew is diplaying "+castst);
		*/
		
		//checking dropdown is displaying
		boolean drpst = driver.findElement(By.id("android:id/text1")).isDisplayed();
		System.out.println("drop down is diplaying "+drpst);
		
		//cheking view all button is displaying or not
		boolean viwallst = driver.findElement(By.id(appcls+":id/btnMore")).isDisplayed();
		System.out.println("Viewall button is diplaying "+viwallst);
		
		//-------------------------------------------------------------Webelement-------------------------------------------------------------
		
		//checking "CEO Awarding" content is displaying
		boolean contentst = driver.findElement(By.xpath(content1)).isDisplayed();
		System.out.println("Deathnote content is diplaying "+contentst);
		
		//-------------------------------------------------------------Webelement-------------------------------------------------------------
		
		//checking star rating is displaying or not
		boolean starst = driver.findElement(By.id(appcls+":id/ratingBar")).isDisplayed();
		System.out.println("Star rating is diplaying "+starst);
		
		//checking add review is displaying or not
		boolean reviwst = driver.findElement(By.id(appcls+":id/viewRatingTextView")).isDisplayed();
		System.out.println("Add review is diplaying "+reviwst);
		
		
		if(drpst && viwallst && contentst && starst && reviwst)
		{
			System.out.println("Move for next Method");
			
		}
		else
		{
			System.out.println("SOMETHING NOT PRESENT.....CHECK AGAIN");
		}
	
	}
	
	@Test(priority=2,enabled=true)
	public void Testing() throws InterruptedException
	{
		//clicking viewtrailer button
		driver.findElement(By.id(appcls+":id/viewTrailerButton")).click();
		
		Thread.sleep(12000);
		
		driver.pressKeyCode(AndroidKeyCode.BACK);
		
		//clicking view all
		driver.findElement(By.id(appcls+":id/btnMore")).click();
		
		//checking "All Episodes" is displaying or not
		boolean status = driver.findElement(By.id(appcls+":id/sectionTitle")).isDisplayed();
		System.out.println("All episodes is displaying after clicking ViewAll button");
		
		//-------------------------------------------------------------Webelement-------------------------------------------------------------
		
		//clicking "CEO Awarding" in All episode page
		driver.findElement(By.xpath(content1)).click();
		
		//-------------------------------------------------------------Webelement-------------------------------------------------------------
		
		Thread.sleep(6000);
		
		try {
			//clicking pay button
			driver.findElement(By.id(appcls+":id/payNowButton")).click();
			
			//In purchase page , clicking "Use New card" drop down
			driver.findElement(By.id(appcls+":id/cardTextView")).click();
			
			//After clicking dropdown click "Use New Card"
			driver.findElement(By.xpath("//android.widget.TextView[@text='############1111']")).click();
			
			//Clicking paynow button
			driver.findElement(By.id(appcls+":id/payNowButton")).click();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(3000);
		
		try {
			driver.findElement(By.id(appcls+":id/yesButton")).click();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		//clicking on screen 
		driver.findElement(By.id(appcls+":id/exomedia_video_view")).click();
		Thread.sleep(5000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(3000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		
		
		/*
		//clicking dropdown
		driver.findElement(By.xpath("//android.widget.TextView[@bounds='[33,1271][483,1376]']")).click();
		//clicking "Season 2" from drop down
		driver.findElement(By.xpath("//android.widget.TextView[@text='Season 2']")).click();
		
		Thread.sleep(4000);
		
		//clicking 2nd content
		driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[33,1429][522,1708]']")).click();
		Thread.sleep(4000);
		//clicking on screen 
		driver.findElement(By.id("com.release.muvisdk:id/exomedia_video_view")).click();
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		*/
		
		//clicking on Add to Favlist
    	driver.findElement(By.id(appcls+":id/favorite_view_episode")).click();
    	
    	//waiting for response of fav button
    	Thread.sleep(4000);
		
    	//Clicking on adding a review
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Add a Review']")).click();
    	
    	// clicking on Star
    	WebElement fiveStarRatingbar = driver.findElement(By.id(appcls+":id/ratingBar"));
  	    
  	    int startX = fiveStarRatingbar.getLocation().getX();
  	    //System.out.println(startX);
  	    int endX = fiveStarRatingbar.getSize().getWidth();
  	    //System.out.println(endX);	    
  	    int yAxis = fiveStarRatingbar.getLocation().getY();
  	    int tapAt = (int) (endX * 0.7);  
  	    TouchAction act=new TouchAction(driver);  
  	    
  	    act.press(tapAt,yAxis).release().perform();
  	    //clicking star Ended
  	    
  	    //adding review is good
        driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your Review here...max 50 characters']")).sendKeys("Very Good");
    	driver.findElement(By.xpath("//android.widget.Button[@text='Post Review']")).click();
    	
    	driver.pressKeyCode(AndroidKeyCode.BACK);
		
    	
	}
	
	@AfterClass
	public void logout_Close() throws InterruptedException
	{
		
        System.out.println("----- Logout -----");
    	
    	//clicking submenu button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	
    	//clicking logout button
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();
    	
    	//clicking "yes" on popup
    	driver.findElement(By.xpath("//android.widget.Button[@text='Yes']")).click();
    	
    	System.out.println("----- Logout Ends -----");
    	
    	System.out.println("Finished");
    	Thread.sleep(3000);
    	
	}
	
	
	

}
