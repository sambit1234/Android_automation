package Batch;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Generic_Library.Log;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class Batch_execution {
	
	private static AndroidDriver driver;
	private static String appcls = "com.release.muvisdk";
	private static String emailid="bruce12@gmail.com";
	private static String pwd ="1234";
	private static String logout = "//android.widget.TextView[@text='Logout']";
	private static String login = "//android.widget.TextView[@text='Log in']";
	private static String register = "//android.widget.TextView[@text='Register']";
	private static String profile = "//android.widget.TextView[@text='Profile']";
	private static String menu = "//android.widget.ImageButton[@content-desc='Open']";
	private static String con1 = "//android.widget.TextView[@text='MuviShoot']";
	private static String con2 = "//android.widget.TextView[@text='Odissi Dance']";
	
	//[Multipart Content]------------------------------------------------------------------------------------------------------
	private static String con3 = "//android.widget.TextView[@text='Awards Distribution among Muvians']";
	
	private static String con4 = "//android.widget.TextView[@text='CEO Awarding']";
	//[Multipart Content]-------------------------------------------------------------------------------------------------------
	private static String singlcontent = "//android.widget.TextView[@text='Cultural Singing']";
	private static String multicontent = "//android.widget.TextView[@text='Awards Distribution among Muvians']";
	
	//  Note: Dont run 13-20, 24 Method before changing script according to default App static page.
	//  Note: connect to QA network (Both PC & Device) & ping google then run script.
	
	
	
	@BeforeMethod
	public void OpenApp() throws MalformedURLException, InterruptedException
	{
		
		DesiredCapabilities capabilities = new  DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Lenovo");
		capabilities.setCapability("platformVersion", "4.2.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", appcls);
		capabilities.setCapability("appActivity", "com.home.vod.activity.SplashScreen");
		driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Thread.sleep(25000);
		
	}
	
	
	@Test(priority=1,enabled=false)
	public void Different_Login_Scenario() throws InterruptedException
	{
		
		//Content = con1
		// Here we are checking different login scenario by adding review and fav list.
		//Remove all reviews from CMS before executing this method.
		
		System.out.println("Login scenario Method Started...");
	
		// -----------------------------------------Webelement--------------------------------------------------
				
		//clicking "MovishootTeam" content
		WebElement Muvishot = driver.findElement(By.xpath(con1));
		Muvishot.click();
				
		// -----------------------------------------Webelement--------------------------------------------------
				
		//clicking on Add to Favlist
		driver.findElement(By.id(appcls+":id/favorite_view")).click();
		   	
		   
		   	
		//scrolling Down for getting login button 
		Dimension dimensions = driver.manage().window().getSize();
		    	        
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();			
		Double screenHeightEnd = dimensions.getHeight() * 0.1;
		int scrollEnd = screenHeightEnd.intValue();
		    	driver.swipe(0,scrollStart,0,scrollEnd,2000);
		    			
		    	//After scroll down Clicking on Login button
		    	driver.findElement(By.id(appcls+":id/alreadyHaveALoginButton")).click();
		    		
		    	//Giving Credentials
		    	driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
		    	driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys(pwd);
		    	driver.hideKeyboard();
		    	Thread.sleep(3000);
		    	driver.findElement(By.id(appcls+":id/loginButton")).click();
		    	
		    	System.out.println("Content added to fav list");
		    	Thread.sleep(4000);
		    	//clicking on Add to Favlist to remove from fav list
				driver.findElement(By.id(appcls+":id/favorite_view")).click();
				
				System.out.println("Removed from fav list..."); 
				
		    	
		    	System.out.println("Logout starts");
		    	//clicking on sub menu for logout button
		    	driver.findElement(By.id(appcls+":id/submenu")).click();
		    	driver.findElement(By.xpath(logout)).click();
		    	driver.findElement(By.id("android:id/button1")).click();
		    	
		    	System.out.println("Logout ends");
		    	
		    	Thread.sleep(10000);
		    	
		    	System.out.println("Anaother scenario starts for adding review");
		    	
		    			
		    	//clicking "MovishootTeam" content
		    	Muvishot.click();
		    			
		    	//clicking on add a review
		    	driver.findElement(By.id(appcls+":id/viewRatingTextView")).click();
		    	Thread.sleep(5000);
		    	driver.findElement(By.id(appcls+":id/clickHereToLogin")).click();
		    	
		    	System.out.println("Login starts again for add review");
		    	//Giving Credentials
		    	driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
		    	driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys(pwd);
		    	driver.hideKeyboard();
		    	Thread.sleep(3000);
		    	driver.findElement(By.id(appcls+":id/loginButton")).click();
		    
		//------------------------------------------------Remove review from backend Then Run Script ----------------------------------------------
		    	
		    	/*
		    	//Now homepage is coming instead of content page so repeating code
		    	
		    	Thread.sleep(6000);
		    	//clicking menu button
		    	driver.findElement(By.xpath("//android.widget.TextView[@text='movie']")).click();
		    	//clicking Movie button from menu
		    	driver.findElement(By.xpath("//android.widget.TextView[@text='movie']")).click();
		    			
		    			
		    	//clicking "MovishootTeam" content
		    	driver.findElement(By.xpath("//android.widget.TextView[@text='MuviShoot- Team Muvi']")).click();
		    			
		    	//clicking on add a review
		    	driver.findElement(By.xpath("//android.widget.TextView[@text='Add a Review']")).click();
		    	*/
		    	WebElement fiveStarRatingbar = driver.findElement(By.id(appcls+":id/ratingBar"));
		  	    
		  	    int startX = fiveStarRatingbar.getLocation().getX();
		  	    System.out.println(startX);
		  	    int endX = fiveStarRatingbar.getSize().getWidth();
		  	    System.out.println(endX);	    
		  	    int yAxis = fiveStarRatingbar.getLocation().getY();
		  	    int tapAt = (int) (endX * 0.7);  
		  	    TouchAction act=new TouchAction(driver);  
		  	    
		  	    act.press(tapAt,yAxis).release().perform();
		  	    //clicking star Ended
		  	    
		  	    //adding review is good
		        driver.findElement(By.id(appcls+":id/reviewEditText")).sendKeys("Good");
		    	driver.findElement(By.id(appcls+":id/submitReviewButton")).click();
		    	System.out.println("Review added");
		    	
		    	System.out.println("Logout starts");
		    	//clicking on sub menu for logout button
		    	driver.findElement(By.id(appcls+":id/submenu")).click();
		    	driver.findElement(By.xpath(logout)).click();
		    	driver.findElement(By.id("android:id/button1")).click();
		    	
		    	System.out.println("Logout ends");
		    	
		    	Thread.sleep(5000);
		    	System.out.println("Login scenario Method Finished...");
				
	}

	@Test(priority=2,enabled=false)
	public void forgot_password() throws InterruptedException
	{
		
		//check you already have logged out.
		System.out.println("Forgot Password Method Started...");
		
		driver.findElement(By.id(appcls+":id/submenu")).click();
		driver.findElement(By.xpath(login)).click();
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
		driver.findElement(By.id("android:id/button1")).click();
		System.out.println("Forgot Password Method Finished...");
		
		
	}
	
	@Test(priority=3,enabled=false)
	public void reg_FB() throws InterruptedException
	{
		
		
		//change xpath below 
		
		System.out.println("Registering using FB Method Started...");
		driver.findElement(By.id(appcls+":id/submenu")).click();
		driver.findElement(By.xpath(register)).click();
		//scrolling Down
		Dimension dimensions = driver.manage().window().getSize();
						
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();			
		Double screenHeightEnd = dimensions.getHeight() * 0.1;
		int scrollEnd = screenHeightEnd.intValue();
		driver.swipe(0,scrollStart,0,scrollEnd,2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='REGISTER WITH FACEBOOK']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.EditText[@text='Email address or phone number']")).sendKeys("tuser1581@gmail.com");
		driver.findElement(By.xpath("//android.widget.EditText[@text='Facebook password']")).sendKeys("india12345");
		//driver.findElement(By.xpath("//android.widget.Button[@resource-id='u_0_5']")).click();
		String act = driver.currentActivity();
		System.out.println(act);
		Thread.sleep(5000);
		System.out.println("reg using FB Method Finished...");
		
		}	
		
	@Test(priority=4,enabled=false)
	public void Reg_GMAIL() throws InterruptedException
	{
		//Change xpath below
		
		System.out.println("Registering using GMAIL Method Started...");
		driver.findElement(By.id(appcls+":id/submenu")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Register']")).click();
		Thread.sleep(3000);
		
		//TouchAction Tact =new TouchAction(driver);\
		
		
		//scrolling Down
		Dimension dimensions = driver.manage().window().getSize();
		
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();	
		Double screenHeightEnd = dimensions.getHeight() * 0.1;
		int scrollEnd = screenHeightEnd.intValue();
		driver.swipe(0,scrollStart,0,scrollEnd,2000);
		
		Thread.sleep(3000);
		//clicking Register google button
		driver.findElement(By.xpath("//android.widget.TextView[@text='Register with Google']")).click();
		
		//clicking add account button in new popup
		driver.findElement(By.xpath("//android.widget.Button[@text='Add account']")).click();
		
		//clicking email id in next page
		driver.findElement(By.xpath("//android.widget.EditText[@text='Email or phone']")).sendKeys("tuser151@gmail.com");

		driver.pressKeyCode(AndroidKeyCode.ENTER);
		
		driver.findElement(By.xpath("//android.widget.EditText[@text='Password']")).sendKeys("india12345");
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		Thread.sleep(3000);
		//clicking accept button
		driver.findElement(By.xpath("//android.view.View[@content-desc='ACCEPT']")).click();
		
		// User already registered so use new credentials.
		Thread.sleep(5000);
		System.out.println("reg using GMAIL Method Finished...");
		
	}
	
	@Test(priority=5,enabled=false)
	public void Register() throws InterruptedException
	{
		System.out.println("Registering Method Started...");
		driver.findElement(By.id(appcls+":id/submenu")).click();
		driver.findElement(By.xpath(register)).click();
		driver.findElement(By.id(appcls+":id/editNameStr")).sendKeys("Trevar");
		
		driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys("Tevar234@muvi.com");
		driver.hideKeyboard();
		driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys("123456");
		driver.hideKeyboard();
		
		driver.findElement(By.id(appcls+":id/editConfirmPasswordStr")).sendKeys("123456");
		driver.hideKeyboard();
		driver.findElement(By.id(appcls+":id/registerButton")).click();
		Thread.sleep(5000);
		System.out.println("Register Method Finished...");
		
	}
	
	@Test(priority=6,enabled=false)
	public void Language() throws InterruptedException
	{
		// change xpath below
		WebElement subMenu = driver.findElement(By.id(appcls+":id/submenu"));
		subMenu.click();
		String Expcted = driver.findElement(By.xpath("//android.widget.TextView[@text='Register']")).getText();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Language']")).click();
		WebElement Danish = driver.findElement(By.xpath("//android.widget.RelativeLayout[@bounds='[111,881][968,1061]']"));
		boolean status = Danish.isSelected();
		System.out.println("Danish Lang checkbox is selected "+status);
		Danish.click();
		
		driver.findElement(By.xpath("//android.widget.Button[@text='Apply']")).click();
		System.out.println(Expcted);
		Thread.sleep(15000);
		//Checking Lang chang is working or not by validating in submenu
		subMenu.click();
		String Actual = driver.findElement(By.xpath("//android.widget.TextView[@text='Opret konto']")).getText();
		System.out.println("Expected result is "+Expcted+" and Actual Result is "+Actual);
		//assertEquals(Actual, Expcted, "Result is not Matching  ");
		
	
}
	@AfterMethod
	public void CloseMethod() throws InterruptedException
	{
		
		System.out.println("Method Completed...");
		Thread.sleep(5000);
		driver.quit();
		
	}
	
	@Test(priority=7,enabled=false)
	public void cast_n_crew() throws InterruptedException
	{
		
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
			
				String ExpectedTitle = "Cast and Crew";
				String ExpectedCastName = "Sonali";
				String ExpctedCastNameIn_castPage = "Sonali";
				String ExpectedProfname = "Actor";
				String ExpectedCastDetails = "Tech Support";
				
				System.out.println("Login Starts...");
				//clicking submenu button
				driver.findElement(By.id(appcls+":id/submenu")).click();
				
				//clicking login button
		    	driver.findElement(By.xpath(login)).click();
		    	driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
		    	driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys(pwd);
		    	
		    	driver.hideKeyboard();
		    	Thread.sleep(3000);
		    	driver.findElement(By.id(appcls+":id/loginButton")).click();
		    	
		    	System.out.println("Login finished"); 
		    	
		    	
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
		    	
				//clicking "Odissi Dance" content from homepage
		    	WebElement Content = driver.findElement(By.xpath(con2));
		    	Content.click();
		    	
		    	//---------------------------------------------------Content----------------------------------------------
				
				//clicking on cast and crew button
				driver.findElement(By.id(appcls+":id/videoCastCrewTitleTextView")).click();
				
				//verifying cast and crew page opened or not
				String actualtitle = driver.findElement(By.id(appcls+":id/castCrewTitleTextView")).getText();
				//assertEquals(actualtitle, ExpectedTitle, "Title is not matching");
				
				
				//checking cast image
				boolean castimagestatus = driver.findElement(By.id(appcls+":id/castImageView")).isDisplayed();
				System.out.println("Cast image is displaying "+castimagestatus);
				
				//checking cast name
				String actualcastname = driver.findElement(By.id(appcls+":id/castNameTextView")).getText();
				assertEquals(actualcastname, ExpectedCastName, "Cast is not Matching");
				
				
				
				//checking cast profession
				String actualprofName = driver.findElement(By.xpath("//android.widget.TextView[@text='Actor']")).getText();
				assertEquals(actualprofName, ExpectedProfname, "Profession Name is not matching");
				
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
				
				Thread.sleep(4000);
				
				driver.pressKeyCode(4);
				
				System.out.println("Logout starts");
		    	//clicking on sub menu for logout button
		    	driver.findElement(By.id(appcls+":id/submenu")).click();
		    	driver.findElement(By.xpath(logout)).click();
		    	driver.findElement(By.id("android:id/button1")).click();
		    	
		    	System.out.println("Logout ends");
		
	}
	
	@Test(priority=8,enabled=false)
	public void Change_Password() throws InterruptedException
	{
		
				//clicking submenu button
				driver.findElement(By.id(appcls+":id/submenu")).click();
		    	Thread.sleep(3000);
		    	
		    	//clicking login button
		    	driver.findElement(By.xpath(login)).click();
		    	driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
		    	driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys(pwd);
		    	
		    	driver.hideKeyboard();
		    	Thread.sleep(3000);
		    	driver.findElement(By.id(appcls+":id/loginButton")).click();
		    	System.out.println("\n"+"---------LOGIN OPERATION FINISHED-------");
		    	
		    	// clicking submenu for getting Profile button
		    	driver.findElement(By.id(appcls+":id/submenu")).click();
		    	
		    	//clicking on profile button
		    	driver.findElement(By.xpath(profile)).click();
		    	
		    	Thread.sleep(6000);
		    	driver.hideKeyboard();
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
		    	
		    	System.out.println("Logout starts");
		    	//clicking on sub menu for logout button
		    	driver.findElement(By.id(appcls+":id/submenu")).click();
		    	driver.findElement(By.xpath(logout)).click();
		    	driver.findElement(By.id("android:id/button1")).click();
		    	
		    	System.out.println("Logout ends");
		    	
		    	Thread.sleep(5000);
		    	//clicking submenu button
		    	driver.findElement(By.id(appcls+":id/submenu")).click();
		    	Thread.sleep(3000);
		    	
		    	//clicking login button again after changing password
		    	driver.findElement(By.xpath(login)).click();
		    	driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
		    	driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys("12345");
		    	
		    	driver.hideKeyboard();
		    	Thread.sleep(3000);
		    	driver.findElement(By.id(appcls+":id/loginButton")).click();
		    	System.out.println("\n"+"---------LOGIN OPERATION FINISHED WITH NEW PASSWORD-------");
		    	
		    	Thread.sleep(3000);
		    	
		    	System.out.println("Changing password to previous one... ");
		    	
		    	// clicking submenu for getting Profile button
		    	driver.findElement(By.id(appcls+":id/submenu")).click();
		    	
		    	driver.findElement(By.xpath(profile)).click();
		    	
		    	Thread.sleep(6000);
		    	driver.hideKeyboard();
		    	//clicking on change password button
		    	driver.findElement(By.id(appcls+":id/changePasswordButton")).click();
		    	
		    	//clicking on confirm password
		    	driver.findElement(By.id(appcls+":id/editConfirmPassword")).sendKeys(pwd);
		    	
		    	//scrolling Down
		    	Dimension dimensions1 = driver.manage().window().getSize();
		    					
		    	Double screenHeightStart1 = dimensions1.getHeight() * 0.5;
		    	int scrollStart1 = screenHeightStart1.intValue();			
		    	Double screenHeightEnd1 = dimensions1.getHeight() * 0.3;
		    	int scrollEnd1 = screenHeightEnd1.intValue();
		    	driver.swipe(0,scrollStart1,0,scrollEnd1,2000);
		    			
		    	//clicking on new password
		    	driver.findElement(By.id(appcls+":id/editNewPassword")).sendKeys(pwd);
		    	
		    	driver.hideKeyboard();
		    	
		    	//Again clicking on change password button
		    	driver.findElement(By.id(appcls+":id/changePasswordButton")).click();
		    	Thread.sleep(4000);
		    	
		    	driver.pressKeyCode(4);
		    	
		    	Thread.sleep(3000);
		    	
		    	System.out.println("Logout starts");
		    	//clicking on sub menu for logout button
		    	driver.findElement(By.id(appcls+":id/submenu")).click();
		    	driver.findElement(By.xpath(logout)).click();
		    	driver.findElement(By.id("android:id/button1")).click();
		    	
		    	System.out.println("Logout ends");
		    	
		    	
		
	}
	@Test(priority=9,enabled=false)
	public void Menu_Logo() throws InterruptedException
	{
		
		//This Testing will vary device to device due to in xpath, we have only bounds to add.
		
		/*
		 * Open App
		 * Click Menu and check Logo back to Homepage
		 * click submenu and click Login ,check Logo back to Homepage
		 * click submenu and click Register ,check Logo back to Homepage
		 * 
		 * */
		String logo = "//android.widget.ImageView[@bounds='[48,72][780,672]']";
		int ExpectedWidth = 732;
		int ExpectedHeight = 600;
		
		System.out.println("Checking Menu Logo...");
		
		//clicking Menu button For getting Logo
		driver.findElement(By.xpath(menu)).click();
				
		//finding Logo in Menu	{honor Device}
		WebElement Logo_In_Menu = driver.findElement(By.xpath(logo));
		
		//finding Logo in Menu	{Lenovo Device}
		//WebElement Logo_In_Menu = driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[48,75][780,675]']"));
		
	    boolean status1 = Logo_In_Menu.isDisplayed();
		System.out.println("Menu Logo is displaying "+status1);
		//System.out.println(Logo_In_Menu.getSize());
			    
		int MenuLogohight = Logo_In_Menu.getSize().getHeight();
		int MenuLogowidth = Logo_In_Menu.getSize().getWidth();
		System.out.println("Menu Logo width is "+MenuLogowidth+" and height is "+MenuLogohight);
		assertEquals(MenuLogowidth, ExpectedWidth, "Menu Logo width is not matching");
		assertEquals(MenuLogohight, ExpectedHeight, "Menu Logo height is not matching");
		
		//clicking outside menu for getting homepage
		driver.findElement(By.id(appcls+":id/daimajia_slider_image")).click();
		
		System.out.println("Menu Logo Checked");
		
		Thread.sleep(2000);
		
		//----------------------------------------------------------------------------------------------------------------------------------
		//----------------------------------------------------------------------------------------------------------------------------------
		
		
		
		
		
	}
		
	@Test(priority=10,enabled=false)
	public void Login_Logo() throws InterruptedException
	{
		
		System.out.println("Checking Login Menu Logo...");
		
		
		
		Thread.sleep(5000);
		
		int ExpectedWidth1 = 450;
		int ExpectedHeight1 = 450;
		
	    //clicking in submenu to get Logo
	    WebElement submenuButton = driver.findElement(By.id(appcls+":id/submenu"));
	    
	    submenuButton.click();
	    
    	//clicking login button
    	driver.findElement(By.xpath(login)).click();
    	
    	//finding login Menu logo
    	WebElement LoginLogo = driver.findElement(By.id(appcls+":id/loginImageView"));
    	boolean status2 = LoginLogo.isDisplayed();
    	System.out.println("Login Logo is diplaying "+status2);
    	int loginlogowid = LoginLogo.getSize().getWidth();
    	int loginlogohgt = LoginLogo.getSize().getHeight();
    	System.out.println("Login Menu Logo width is "+loginlogowid+" and height is "+loginlogohgt);
    	
    	assertEquals(loginlogowid, ExpectedWidth1, "Login Logo width is not matching");
		assertEquals(loginlogohgt, ExpectedHeight1, "Login Logo height is not matching");
		
		driver.pressKeyCode(4);
		Thread.sleep(5000);
				
		System.out.println("Login Logo Checked...");
		
		
		
	}
	
	@Test(priority=11,enabled=false)
	public void Register_Logo() throws InterruptedException
	{
		

		System.out.println("Checking register menu logo...");
		
		
		
	    //clicking in submenu to get Logo
	    WebElement submenuButton = driver.findElement(By.id(appcls+":id/submenu"));
		int ExpectedWidth2 = 450;
		int ExpectedHeight2 = 450;
		
		Thread.sleep(10000);
	    System.out.println("Submenu displying "+submenuButton.isDisplayed());
	    submenuButton.click();
	    
    	Thread.sleep(3000);
    	//clicking login button
    	driver.findElement(By.xpath(register)).click();
    	
    	//finding login Menu logo
    	WebElement RegisterLogo = driver.findElement(By.id(appcls+":id/registerImageView"));
    	boolean status3 = RegisterLogo.isDisplayed();
    	System.out.println("Login Logo is diplaying "+status3);
    	int Reglogowid = RegisterLogo.getSize().getWidth();
    	int Reglogohgt = RegisterLogo.getSize().getHeight();
    	System.out.println("Register Menu Logo width is "+Reglogowid+" and height is "+Reglogohgt);
    	
    	assertEquals(Reglogowid, ExpectedWidth2, "Register width is not matching");
		assertEquals(Reglogohgt, ExpectedHeight2, "Register height is not matching");
    	
		Thread.sleep(2000);
		
    	driver.pressKeyCode(4);
    	
    	System.out.println("Register menu Logo checked...");
		
		
	}
	
	@Test(priority=12,enabled=false)
	public void Profile_Page() throws InterruptedException
	{
		
		// Make sure you have logged out before
		
		String ExpectedName = "Bruce Banner";
		String ExpectedEmail = "bruce12@gmail.com";
		
		
		System.out.println("Login Starts...");
		//clicking submenu button
		driver.findElement(By.id(appcls+":id/submenu")).click();
		
		//clicking login button
    	driver.findElement(By.xpath(login)).click();
    	driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
    	driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys(pwd);
    	
    	driver.hideKeyboard();
    	Thread.sleep(3000);
    	driver.findElement(By.id(appcls+":id/loginButton")).click();
    	
    	System.out.println("Login finished"); 
    	Thread.sleep(4000);
    	//checking email and name
    	// clicking submenu
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	driver.findElement(By.xpath(profile)).click();
    	WebElement emailbox = driver.findElement(By.id(appcls+":id/editProfileNameEditText"));
    	String ActualName = emailbox.getText();
    	WebElement namebox = driver.findElement(By.id(appcls+":id/emailAddressEditText"));
    	String ActualEmail = namebox.getText();
    	
    	//System.out.println(ActualEmail + " " + ActualName);
    	
    	//Validating Email and Name with assert
    	
    	System.out.println("\n"+"----- Validating Email and Username -----");
    	assertEquals(ActualName, ExpectedName, "User name is not matching to actual result");
    	assertEquals(ActualEmail, ExpectedEmail, "User Email is not matching to actual result");
    	System.out.println("\n"+"----- Email and Username Validation is successfull -----");
    	
    	//Editing username
    	emailbox.clear();
    	Thread.sleep(4000);
    	emailbox.sendKeys("Hulk");
    	Thread.sleep(3000);
    	//clicking Update profile button
    	driver.findElement(By.id(appcls+":id/update_profile")).click();
    	Thread.sleep(4000);
    	
    	driver.pressKeyCode(4);
    	
    	String ExpectedEditName = "Hulk";
    	
    	//validating name after editing
    	System.out.println("\n"+"----- Validating Username after edit -----");
    	Thread.sleep(3000);
    	// clicking submenu
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	driver.findElement(By.xpath(profile)).click();
    	String ActualEditName = emailbox.getText();
    	System.out.println(ActualEditName);
    	assertEquals(ActualEditName, ExpectedEditName, "User name is not matching to actual result");
    	System.out.println("\n"+"----- Edited Username Validation is successfull -----");
    	Thread.sleep(4000);
    
    	driver.pressKeyCode(4);
    	
    	Thread.sleep(4000);
    	
    	System.out.println("Changing name to previous...");
    	
    	
    	driver.pressKeyCode(4);
    	Thread.sleep(3000);
    	// clicking submenu
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	driver.findElement(By.xpath(profile)).click();
    	Thread.sleep(5000);
    	emailbox.clear();
    	Thread.sleep(4000);
    	emailbox.sendKeys(ExpectedName);
    	Thread.sleep(3000);
    	//clicking Update profile button
    	driver.findElement(By.id(appcls+":id/update_profile")).click();
    	Thread.sleep(6000);
    	
    	driver.pressKeyCode(4);
    	Thread.sleep(3000);
    	
    	System.out.println("Logout starts");
    	//clicking on sub menu for logout button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	driver.findElement(By.xpath(logout)).click();
    	driver.findElement(By.id("android:id/button1")).click();
    	
    	System.out.println("Logout ends");

  
		
		
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------
	
	
	@Test(priority=13,enabled=false)
	public void staticPage() throws MalformedURLException, InterruptedException
	{
    
		//Change according to App static Page
		
		//checking all titles present in Static page
		
    //clicking Menu button For getting Logo
    
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open']")).click();
  	
  	System.out.println("-------Checking static page all contents-------");
  	
  	WebElement home = driver.findElement(By.xpath("//android.widget.TextView[@text='home']"));
  	boolean st1=home.isDisplayed();
  	System.out.println("home button is displaying "+st1);
  	
  	WebElement tv = driver.findElement(By.xpath("//android.widget.TextView[@text='tv']"));
  	boolean st2=tv.isDisplayed();
  	System.out.println("tv button is displaying "+st2);
  	
  	WebElement movie = driver.findElement(By.xpath("//android.widget.TextView[@text='movie']"));
  	boolean st3=movie.isDisplayed();
  	System.out.println("movie button is displaying "+st3);
  	
  	WebElement series = driver.findElement(By.xpath("//android.widget.TextView[@text='live stream']"));
  	boolean st4=series.isDisplayed();
  	System.out.println("series button is displaying "+st4);
  	
  	WebElement about_us = driver.findElement(By.xpath("//android.widget.TextView[@text='about us']"));
  	boolean st5=about_us.isDisplayed();
  	System.out.println("about_us button is displaying "+st5);
  	
  	WebElement terms_policy = driver.findElement(By.xpath("//android.widget.TextView[@text='terms & privacy policy']"));
  	boolean st6=about_us.isDisplayed();
  	System.out.println("about_us button is displaying "+st6);
  	
  	WebElement contact_us = driver.findElement(By.xpath("//android.widget.TextView[@text='contact us']"));
  	boolean st7=contact_us.isDisplayed();
  	System.out.println("contact_us button is displaying "+st7);
  	
  	System.out.println("-----------Checking after clicking every button----------");
  	
	
	}
	
	
	//check title according to id not acc name
	//change xpath in every method , put id in xpath 
	@Test(priority=14,enabled=false)
	public void home() throws InterruptedException 
	{
		//checking Application name is displying on Homepage or not.
		
		//clicking Menu button again For getting home button
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open']")).click();
		WebElement home = driver.findElement(By.xpath("//android.widget.TextView[@text='home']"));
		home.click();
		Thread.sleep(4000);
	  	boolean st = driver.findElement(By.xpath("//android.widget.TextView[@text='Sapphire']")).isDisplayed();
	  	if(st) {
	  	System.out.println("After clicking home button, Application name is displaying "+st);
	  	}
	}
	
	@Test(priority=15,enabled=false)
	public void Tv() throws InterruptedException
	{
		// checking respective title is displaying or not.
		
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open']")).click();
		
		Thread.sleep(6000);
		WebElement tv = driver.findElement(By.xpath("//android.widget.TextView[@text='tv']"));
		//clicking Menu button again For getting tv button
		tv.click();
		Thread.sleep(6000);
	  	boolean st = driver.findElement(By.id(appcls+":id/categoryTitle")).isDisplayed();
	  	if(st) {
	  	System.out.println("After clicking tv button, tv is displaying "+st);
	  	}
	  	
		
	}
	@Test(priority=16,enabled=false)
	public void movie() throws InterruptedException
	{
		
		// checking respective title is displaying or not.
		
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open']")).click();
		
		Thread.sleep(6000);
		WebElement movie = driver.findElement(By.xpath("//android.widget.TextView[@text='movie']"));
	    //clicking Menu button again For getting movie button
		movie.click();
		Thread.sleep(6000);
	  	boolean st = driver.findElement(By.id(appcls+":id/categoryTitle")).isDisplayed();
	  	
	  	if(st) {
	  	System.out.println("After clicking movie button, Movie is displaying "+st);
	  	}
	}
	
	@Test(priority=17,enabled=false)
	public void LiveStream() throws InterruptedException
	{
		
		// checking respective title is displaying or not.
		
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open']")).click();
		Thread.sleep(6000);
		WebElement live = driver.findElement(By.xpath("//android.widget.TextView[@text='live stream']"));
		//clicking Menu button again For getting tv button
		live.click();
		Thread.sleep(6000);
	  	boolean st = driver.findElement(By.id(appcls+":id/categoryTitle")).isDisplayed();
	  	if(st) {
	  	System.out.println("After clicking LiveStream button, livestream is displaying "+st);
	  	}
		
	}
	
	@Test(priority=18,enabled=false)
	public void About_us() throws InterruptedException
	{
		
		// checking respective title is displaying or not.
		
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open']")).click();
		
		Thread.sleep(6000);
		WebElement about_us = driver.findElement(By.xpath("//android.widget.TextView[@text='about us']"));
		//clicking Menu button again For getting tv button
		about_us.click();
		Thread.sleep(6000);
	  	boolean st = driver.findElement(By.id(appcls+":id/categoryTitle")).isDisplayed();
	  	if(st) {
	  	System.out.println("After clicking About_us button, About_us is displaying "+st);
	  	}
		
	}
	
	@Test(priority=19,enabled=false)
	public void TermsPage() throws InterruptedException
	{
		
		// checking respective title is displaying or not.
		
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open']")).click();
		Thread.sleep(6000);
		WebElement terms_policy = driver.findElement(By.xpath("//android.widget.TextView[@text='terms & privacy policy']"));
		//clicking Menu button again For getting tv button
		terms_policy.click();
		Thread.sleep(6000);
	  	boolean st = driver.findElement(By.id(appcls+":id/categoryTitle")).isDisplayed();
	  	if(st) {
	  	System.out.println("After clicking TermsCondition button, TermsCondition Page is displaying "+st);
	  	}
		
	}
	
	@Test(priority=20,enabled=false)
	public void ContactUs() throws InterruptedException
	{
		
		// checking respective title is displaying or not.
		
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open']")).click();
		Thread.sleep(6000);
		WebElement contact_us = driver.findElement(By.xpath("//android.widget.TextView[@text='contact us']"));
		//clicking Menu button again For getting tv button
		contact_us.click();
		Thread.sleep(6000);
	  	boolean st = driver.findElement(By.id(appcls+":id/categoryTitle")).isDisplayed();
	  	if(st) {
	  	System.out.println("After clicking ContactUs button, ContactUs is displaying "+st);
	  	}
		
	}
	
	@Test(priority=21,enabled=false)
	public void HomepageBanner() throws MalformedURLException, InterruptedException
	{
		
		
		int exphight = 510;
		int expwidth = 1080;
		
		//checking size of homepage banner
		WebElement banner = driver.findElement(By.id(appcls+":id/daimajia_slider_image"));
		int hight = banner.getSize().height;
		int width = banner.getSize().width;
		
		//assertEquals(hight, exphight, "Hight is not matching");
		//assertEquals(width, expwidth, "Width is not matching");
		
		System.out.println("Hight is "+hight+" and width is "+width);
		System.out.println("Banner size is "+banner.getSize());
		
		Thread.sleep(5000);
	
		
	}

	@Test(priority=22,enabled=false)
	public void SinglepartBanner() throws InterruptedException
	{
		
		int exphight = 630;
		int expwidth = 1080;
		
		//--------------------------------------------------------Webelement------------------------------------------------------
		
		//clicking on "Cultural Singing" single part content
		driver.findElement(By.xpath(singlcontent)).click();
		
		//--------------------------------------------------------Webelement------------------------------------------------------
		
		//checking size of content banner
		WebElement banner = driver.findElement(By.id(appcls+":id/bannerOverlay"));
		
		int hight = banner.getSize().height;
		int width = banner.getSize().width;
		
		assertEquals(hight, exphight, "Hight is not matching");
		assertEquals(width, expwidth, "Width is not matching");
		
		System.out.println("Hight is "+hight+" and width is "+width);
		System.out.println("Banner size is "+banner.getSize());
		
		Thread.sleep(5000);
		
		driver.pressKeyCode(4);	
		
		
		
	}
	
	@Test(priority=23,enabled=false)
	public void MultipartBanner()
	{
		
		int exphight = 630;
		int expwidth = 1080;
		
		//scrolling Down
		Dimension dimensions = driver.manage().window().getSize();
						
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();			
		Double screenHeightEnd = dimensions.getHeight() * 0.3;
		int scrollEnd = screenHeightEnd.intValue();
		driver.swipe(0,scrollStart,0,scrollEnd,2000);
		
		
		//-----------------------------------------------------------Webelement-----------------------------------------------------
		
		//clicking "Award Distribution" multipart content. 
		driver.findElement(By.xpath(multicontent)).click();
		
		//-----------------------------------------------------------Webelement-----------------------------------------------------
		
		//checking content banner
		WebElement banner = driver.findElement(By.id(appcls+":id/bannerOverlay"));
		
		int hight = banner.getSize().height;
		int width = banner.getSize().width;
		
		assertEquals(hight, exphight, "Hight is not matching");
		assertEquals(width, expwidth, "Width is not matching");
		
		System.out.println("Hight is "+hight+" and width is "+width);
		System.out.println("Banner size is "+banner.getSize());
		
	}
	
	@Test(priority=24,enabled=false)
	public void contact_us() throws InterruptedException
	{
		
		System.out.println("Login Starts...");
		//clicking submenu button
		driver.findElement(By.id(appcls+":id/submenu")).click();
		
		//clicking login button
    	driver.findElement(By.xpath(login)).click();
    	driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
    	driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys(pwd);
    	
    	driver.hideKeyboard();
    	Thread.sleep(3000);
    	driver.findElement(By.id(appcls+":id/loginButton")).click();
    	
    	System.out.println("Login finished"); 
		Thread.sleep(4000);
		
		String ExpTitle = "Contact Us";
		//clicking menu button
		driver.findElement(By.xpath(menu)).click();
		
		//clicking contactus 
		driver.findElement(By.xpath("//android.widget.TextView[@text='contact us']")).click();
		
		String ActualTitle = driver.findElement(By.id(appcls+":id/categoryTitle")).getText();
		assertEquals(ActualTitle, ExpTitle, "Title is not matching");
		
		System.out.println(ActualTitle+" is matching-----> pls proceed next");
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
	
		System.out.println("\n"+"---------LOGOUT OPERATION STARTS-------");
		//clicking submenu button
		driver.findElement(By.id(appcls+":id/submenu")).click();
		Thread.sleep(4000);
		//clicking logout button
		driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Yes']")).click();
		
		System.out.println("\n"+"---------LOGOUT OPERATION FINISHED-------");	
		
		
	}
	
	@Test(priority=25,enabled=false)
	public void MultiPart_Content() throws InterruptedException
	{
		
		System.out.println("Login Starts...");
		//clicking submenu button
		driver.findElement(By.id(appcls+":id/submenu")).click();
		
		//clicking login button
    	driver.findElement(By.xpath(login)).click();
    	driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
    	driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys(pwd);
    	
    	driver.hideKeyboard();
    	Thread.sleep(3000);
    	driver.findElement(By.id(appcls+":id/loginButton")).click();
    	
    	System.out.println("Login finished"); 
		
		Thread.sleep(4000);
		
		// Here Testing content title  (Homepage > Award...> CEO Awarding) 
		
		String expected_title = "Awards Distribution among Muvians";
		
		WebElement Award = driver.findElement(By.xpath(con3));
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
		boolean contentst = driver.findElement(By.xpath(con4)).isDisplayed();
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
		driver.findElement(By.xpath(con4)).click();
				
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
		//driver.findElement(By.id(appcls+":id/exomedia_video_view")).click();
		Thread.sleep(5000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(3000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
				
		//clicking on Add to Favlist
		driver.findElement(By.id(appcls+":id/favorite_view_episode")).click();
		    	
		//waiting for response of fav button
		Thread.sleep(4000);
		
		//clicking on Add to Favlist to remove from favlist.
		driver.findElement(By.id(appcls+":id/favorite_view_episode")).click();
		
		Thread.sleep(4000);
		
		//Reviews are not removed form the backend.
		
		
		/*		
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
		*/
		
		System.out.println("Logout starts");
    	//clicking on sub menu for logout button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	driver.findElement(By.xpath(logout)).click();
    	driver.findElement(By.id("android:id/button1")).click();
    	
    	System.out.println("Logout ends");

		    	
		System.out.println("Finished");
		Thread.sleep(3000);
		
	}
	
	
	
	@Test(priority=26,enabled=false)
	public void Offline() throws InterruptedException
	{
		
		//Dont run Feature is not avail....
		
		System.out.println("Login Starts...");
		//clicking submenu button
		driver.findElement(By.id(appcls+":id/submenu")).click();
		
		//clicking login button
    	driver.findElement(By.xpath(login)).click();
    	driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
    	driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys(pwd);
    	
    	driver.hideKeyboard();
    	Thread.sleep(3000);
    	driver.findElement(By.id(appcls+":id/loginButton")).click();
    	
    	System.out.println("Login finished"); 
		
		Thread.sleep(5000);
		
		
		
		//clicking FRIEND content
		driver.findElement(By.xpath("//android.widget.TextView[@text='FRIENDS']")).click();
		Thread.sleep(3000);
		
		//clicking play button in vdo
		driver.findElement(By.id("com.release.magicmovies:id/playButton")).click();
		
		try {
	    	 
			//driver.findElement(By.xpath("//android.widget.Button[@text='Cancel']")).click();
		      driver.findElement(By.xpath("//android.widget.Button[@text='Continue']")).click();
					
					
			} catch (Exception e) {
		// TODO: handle exception
			}
		
		//clicking download button
		driver.findElement(By.id("com.release.magicmovies:id/downloadImageView")).click();
		
		Thread.sleep(3000);
		
		//clicking DOWNLOAD from popup
		driver.findElement(By.xpath("//android.widget.Button[@text='DOWNLOAD']")).click();
		
		//waitng 6 sec for vdo download
		Thread.sleep(10000);
		try {
			
			
			//clicking ok button after download finished
			driver.findElement(By.xpath("//android.widget.Button[@text='Ok']")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		//clicking on vdo to get back button
		driver.findElement(By.id("com.release.magicmovies:id/exomedia_video_view")).click();
		
		//clicking back button
		driver.findElement(By.id("com.release.magicmovies:id/back")).click();
		
		Thread.sleep(3000);
		//clicking submenu botton
		driver.findElement(By.id("com.release.magicmovies:id/submenu")).click();
		
		//clicking My Download button
		driver.findElement(By.xpath("//android.widget.TextView[@text='My Download']")).click();
		
		WebElement content = driver.findElement(By.xpath("//android.widget.TextView[@text='FRIENDS']"));
		boolean status = content.isDisplayed();
		
		if(status)
		{
			//clicking on vdo
			driver.findElement(By.id("com.release.magicmovies:id/imageView")).click();
			
			//waiting 5 sec and watching vdo
			Thread.sleep(5000);
			
			try {
		    	 
				//driver.findElement(By.xpath("//android.widget.Button[@text='Cancel']")).click();
			      driver.findElement(By.xpath("//android.widget.Button[@text='Continue']")).click();
						
						
				} catch (Exception e) {
			// TODO: handle exception
				}
			
			//clicking on vdo to get back button
			driver.findElement(By.id("com.release.magicmovies:id/exomedia_video_view")).click();
			
			//clicking back button
			driver.findElement(By.id("com.release.magicmovies:id/back")).click();
			
			//clicking delete icon
			driver.findElement(By.id("com.release.magicmovies:id/imageView1")).click();
			
			//clicking DELETE in popup
			driver.findElement(By.xpath("//android.widget.Button[@text='Delete']")).click();
			
			
			
		}
		
		Thread.sleep(3000);
		
		//clicking back button
		driver.findElement(By.xpath("//android.widget.ImageButton[@bounds='[0,75][168,243]']")).click();
		
		//clicking play button in vdo
		driver.findElement(By.id("com.release.magicmovies:id/playButton")).click();
				
		try {
			    	 
			//driver.findElement(By.xpath("//android.widget.Button[@text='Cancel']")).click();
			driver.findElement(By.xpath("//android.widget.Button[@text='Continue']")).click();
							
							
			} catch (Exception e) {
			// TODO: handle exception
			}
		
		//checking download option is visible or not
		boolean st = driver.findElement(By.id("com.release.magicmovies:id/downloadImageView")).isDisplayed();
		
		if(st)
		{
			
			System.out.println("After deleting vdo from my downloads, download option is displaying");
			
		}
			
	}
	
	@Test(priority=27,enabled=false)
	public void player_control() throws InterruptedException
	{
		
		System.out.println("Login Starts...");
		//clicking submenu button
		driver.findElement(By.id(appcls+":id/submenu")).click();
		
		//clicking login button
    	driver.findElement(By.xpath(login)).click();
    	driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
    	driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys(pwd);
    	
    	driver.hideKeyboard();
    	Thread.sleep(3000);
    	driver.findElement(By.id(appcls+":id/loginButton")).click();
    	
    	System.out.println("Login finished"); 
		
		Thread.sleep(4000);
		
		//-----------------------------------------------------------------Webelement------------------------------------------------------------------
		
		//clicking "MuviShoot" content
		driver.findElement(By.xpath(con1)).click();
		Thread.sleep(4000);
		
		//-----------------------------------------------------------------Webelement------------------------------------------------------------------
				
		//clicking play button
		driver.findElement(By.id(appcls+":id/playButton")).click();
				
		try {
		    	 
			driver.findElement(By.id(appcls+":id/cancelButton")).click();
			
			} catch (Exception e) {
		// TODO: handle exception
			}
				
		
		Thread.sleep(4000);
		
		//clicking on vdo for getting , play/pause button
		driver.findElement(By.id(appcls+":id/exomedia_video_view")).click();	
		
		//clicking pause button
		driver.findElement(By.id(appcls+":id/latest_center_play_pause")).click();
		
		//clicking play button after 6 sec
		Thread.sleep(6000);
		
		// Again clicking on screen for getting play/pause button
		driver.findElement(By.id(appcls+":id/exomedia_video_view")).click();
		
		//clicking play button
		driver.findElement(By.id(appcls+":id/latest_center_play_pause")).click();
		
		Thread.sleep(6000);

		//clicking on vdo for getting , screen button
		driver.findElement(By.id(appcls+":id/exomedia_video_view")).click();	
			
		//Maximizing
		driver.findElement(By.id(appcls+":id/compress_expand")).click();
		
		//Waiting 6 sec for minmizing
		Thread.sleep(6000);
				
		// Again clicking on screen for minimizing
		driver.findElement(By.id(appcls+":id/exomedia_video_view")).click();
				
		//clicking minimize button
		driver.findElement(By.id(appcls+":id/compress_expand")).click();
		
		Thread.sleep(3000);
		
		// Again clicking on screen for minimizing
		driver.findElement(By.id(appcls+":id/exomedia_video_view")).click();
				
		    //After minimizing clicking back button
		
		driver.pressKeyCode(4);
				
		Thread.sleep(4000);
		System.out.println("Logout starts");
    	//clicking on sub menu for logout button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	driver.findElement(By.xpath(logout)).click();
    	driver.findElement(By.id("android:id/button1")).click();
    	
    	System.out.println("Logout ends");

		
		
	}
	
	@Test(priority=28,enabled=false)
	public void Search() throws InterruptedException
	{
		
		driver.findElement(By.id(appcls+":id/action_search")).click();
		
		//clicking search box
		//driver.findElement(By.xpath("//android.widget.EditText[@text='Search']")).sendKeys("Death");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//android.widget.EditText[@text='Search']")).sendKeys("odi");
		Thread.sleep(4000);
		
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		
	}
	
	@Test(priority=29,enabled=true)
	public void Watermark() throws InterruptedException
	{
		
		System.out.println("Login Starts...");
		//clicking submenu button
		driver.findElement(By.id(appcls+":id/submenu")).click();
		
		//clicking login button
    	driver.findElement(By.xpath(login)).click();
    	driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
    	driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys(pwd);
    	
    	driver.hideKeyboard();
    	Thread.sleep(3000);
    	driver.findElement(By.id(appcls+":id/loginButton")).click();
    	
    	System.out.println("Login finished"); 
		
		
		Thread.sleep(4000);
		
		//-----------------------------------------------------------------Webelement----------------------------------------------------------------
		
		//clicking "MuviShoot" content
		driver.findElement(By.xpath(con1)).click();
		Thread.sleep(4000);
		
		//-----------------------------------------------------------------Webelement----------------------------------------------------------------
				
		//clicking play button
		driver.findElement(By.id(appcls+":id/playButton")).click();
		Log.info("Play button clicked");
				
		try {
		    	 
			driver.findElement(By.id(appcls+":id/cancelButton")).click();
			
			} catch (Exception e) {
		// TODO: handle exception
			}
				
		
		Thread.sleep(4000);
		
	    WebElement wtrmrk = driver.findElement(By.id(appcls+":id/linearLayout1"));
		boolean wtr_status = wtrmrk.isDisplayed();
		System.out.println("Watermark is displaying ..."+wtr_status);
		Thread.sleep(2000);
		if(wtr_status)
		{
			
		Log.info("Now checking ip,email,date in watermark...");
		Thread.sleep(3000);
		WebElement ip = driver.findElement(By.id(appcls+":id/emailAddressTextView"));
		WebElement email = driver.findElement(By.id(appcls+":id/ipAddressTextView"));
		WebElement date = driver.findElement(By.id(appcls+":id/dateTextView"));
		
		boolean ip_status = ip.isDisplayed();
		boolean email_status = email.isDisplayed();
		boolean date_status = date.isDisplayed();
		
		System.out.println("ip is displaying..."+ip_status);
		System.out.println("email is displaying..."+email_status);
		System.out.println("date is displaying..."+date_status);
		
		Thread.sleep(3000);
		
			if(ip_status && email_status && date_status)
			{
				Log.info("Watermark's contents are displaying correctly");
				
			}
			else
			{
				System.out.println("Watermark contents are not there...try again");
			}
		
		}
		else {
			System.out.println("Watermark is not displaying");
		}
		
		
		Thread.sleep(4000);
		
		System.out.println("Logout starts");
    	//clicking on sub menu for logout button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	driver.findElement(By.xpath(logout)).click();
    	driver.findElement(By.id("android:id/button1")).click();
    	
    	System.out.println("Logout ends");





		
	}
	
	
}
