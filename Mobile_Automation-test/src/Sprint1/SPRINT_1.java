package Sprint1;

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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SPRINT_1 
{

	private static AndroidDriver driver;
	
	@BeforeMethod
	public void startApp() throws MalformedURLException
	{
		DesiredCapabilities capabilities = new  DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Lenovo");
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.release.muvisdk");
		capabilities.setCapability("appActivity", "com.home.vod.activity.SplashScreen");
		driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test(priority=1,enabled= true)
	public void SapphireAppDemo() throws MalformedURLException, InterruptedException
	{
		
	    System.out.println("SapphireAppDemo method is running");
		String ExpectedName="Scarlett Johansson";
		String ExpectedEmail="scar46@muvi.com";
		Thread.sleep(20000);
		WebElement MenuBtn = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open']"));
		boolean status = MenuBtn.isDisplayed();
		System.out.println("Menu Button is Displayed "+status);
		//assertTrue(status);
		
		WebElement Apname=  driver.findElement(By.xpath("//android.widget.TextView[@text='Sapphire']"));
		boolean status1 = Apname.isDisplayed();
		String Appname = Apname.getText();
		System.out.println("\n"+"AppNameText is Displayed "+status1+ " And The AppName is "+Appname);
		
		WebElement searchbutn = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='search']"));
		boolean status2 = searchbutn.isDisplayed();
		System.out.println("\n"+"Search button is displayed "+status2);
		
    	WebElement optionButn = driver.findElement(By.xpath("//android.widget.TextView[@bounds='[936,87][1080,231]']"));
    	boolean status3 = optionButn.isDisplayed();
    	System.out.println("\n"+"Option button is displayed "+status3);
	
		WebElement HompgImg = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.release.muvisdk:id/daimajia_slider_image']"));
		boolean status4 = HompgImg.isDisplayed();
		System.out.println("\n"+"HomePage Image is displayed "+status4);
		Thread.sleep(4000);
		WebElement vewbutn = driver.findElement(By.xpath("//android.widget.Button[@text='View All']"));
		boolean status5 = vewbutn.isDisplayed();
		String value1 = vewbutn.getText();
		System.out.println("\n"+"View All button is displayed "+status5+" And the Text is "+value1);
		
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
		WebElement ContntImg = driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[522,1181][993,1436]']"));
    	boolean status8 = ContntImg.isDisplayed();
    	System.out.println("\n"+"Recommended section content is displayed "+status8);
    	
    	System.out.println("\n"+"---------LOGIN OPERATION STARTS-------");
    	Thread.sleep(3000);
    	//clicking submenu button
    	driver.findElement(By.xpath("//android.widget.TextView[@bounds='[936,87][1080,231]']")).click();
    	Thread.sleep(3000);
    	
    	//clicking login button
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Log in']")).click();
    	driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your Email Address']")).sendKeys("scar46@muvi.com");
    	driver.findElement(By.xpath("//android.widget.EditText[@index='2']")).sendKeys("123456");
    	driver.hideKeyboard();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//android.widget.Button[@text='Login']")).click();
    	System.out.println("\n"+"---------LOGIN OPERATION FINISHED-------");
    	Thread.sleep(4000);
    	//checking email and name
    	// clicking submenu
    	driver.findElement(By.xpath("//android.widget.TextView[@bounds='[936,87][1080,231]']")).click();
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Profile']")).click();
    	String ActualName = driver.findElement(By.xpath("//android.widget.EditText[@text='Scarlett Johansson']")).getText();
    	String ActualEmail = driver.findElement(By.xpath("//android.widget.EditText[@text='scar46@muvi.com']")).getText();
    	//System.out.println(ActualEmail + " " + ActualName);
    	
    	//Validating Email and Name with assert
    	
    	System.out.println("\n"+"----- Validating Email and Username -----");
    	assertEquals(ActualName, ExpectedName, "User name is not matching to actual result");
    	assertEquals(ActualEmail, ExpectedEmail, "User Email is not matching to actual result");
    	System.out.println("\n"+"----- Email and Username Validation is successfull -----");
    	
    	driver.findElement(By.xpath("//android.widget.ImageButton[@bounds='[0,75][168,243]']")).click();
    	
    	System.out.println("\n"+"---------LOGOUT OPERATION STARTS-------");
    	//clicking submenu button
    	driver.findElement(By.xpath("//android.widget.TextView[@bounds='[936,87][1080,231]']")).click();
    	Thread.sleep(4000);
    	//clicking logout button
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//android.widget.Button[@text='Yes']")).click();
    	
    	System.out.println("\n"+"---------LOGOUT OPERATION FINISHED-------");
	}
	
	@Test(priority=2,enabled= true)
	public void Registering() throws MalformedURLException, InterruptedException
	{
		System.out.println("Registering method is running");
		try {
			
			Thread.sleep(25000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//android.widget.TextView[@bounds='[936,87][1080,231]']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Register']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your Name']")).sendKeys("Trevar");
		
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your Email Address']")).sendKeys("Trevar913@muvi.com");
		
		driver.findElement(By.xpath("//android.widget.EditText[@index='3']")).sendKeys("123456");
		driver.hideKeyboard();
		
		driver.findElement(By.xpath("//android.widget.EditText[@index='4']")).sendKeys("123456");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.Button[@text='Register']")).click();
		System.out.println("\n"+"---------LOGOUT OPERATION STARTS-------");
    	//clicking submenu button
    	driver.findElement(By.xpath("//android.widget.TextView[@bounds='[936,87][1080,231]']")).click();
    	Thread.sleep(4000);
    	//clicking logout button
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//android.widget.Button[@text='Yes']")).click();
    	
    	System.out.println("\n"+"---------LOGOUT OPERATION FINISHED-------");
		
	}
	
	@Test(priority=3,enabled=false)
	public void Register_Using_Gmail() throws MalformedURLException, InterruptedException
	{
		System.out.println("Register_Using_Gmail method is running");
		try {
			
			Thread.sleep(25000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//android.widget.TextView[@bounds='[936,87][1080,231]']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Register']")).click();
		Thread.sleep(3000);
		
		//TouchAction Tact =new TouchAction(driver);\
		
		
		//scrolling Down
		Dimension dimensions = driver.manage().window().getSize();
		
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();
		
		System.out.println("s="+scrollStart);
		
		Double screenHeightEnd = dimensions.getHeight() * 0.1;
		int scrollEnd = screenHeightEnd.intValue();
		driver.swipe(0,scrollStart,0,scrollEnd,2000);
		
		Thread.sleep(3000);
		//clicking Register google button
		driver.findElement(By.xpath("//android.widget.TextView[@text='Register with Google']")).click();
		
		//clicking add account button in new popup
		driver.findElement(By.xpath("//android.widget.Button[@text='Add account']")).click();
		
		//clicking email id in next page
		driver.findElement(By.xpath("//android.widget.EditText[@text='Email or phone']")).sendKeys("tuser10581@gmail.com");
		driver.findElement(By.xpath("//android.view.View[@content-desc='NEXT']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@text='Password']")).sendKeys("india12345");
		driver.findElement(By.xpath("//android.view.View[@content-desc='NEXT']")).click();
		Thread.sleep(3000);
		//clicking accept button
		driver.findElement(By.xpath("//android.view.View[@content-desc='ACCEPT']")).click();
		System.out.println("\n"+"---------LOGOUT OPERATION STARTS-------");
    	//clicking submenu button
    	driver.findElement(By.xpath("//android.widget.TextView[@bounds='[936,87][1080,231]']")).click();
    	Thread.sleep(4000);
    	//clicking logout button
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//android.widget.Button[@text='Yes']")).click();
    	
    	System.out.println("\n"+"---------LOGOUT OPERATION FINISHED-------");
		
		
		
}
	
	@Test(priority=4,enabled=false)
	public void Register_Using_FB() throws MalformedURLException, InterruptedException
	{
		System.out.println("Register_Using_FB method is running");
		try {
			
			Thread.sleep(25000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//android.widget.TextView[@bounds='[936,87][1080,231]']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Register']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='REGISTER WITH FACEBOOK']")).click();
		
//		Set<String> set = driver.getWindowHandles();
//		
//		Iterator<String> itr = set.iterator();
//		String parentid = itr.next();
//		String childid =  itr.next();
//		String childid1 = itr.next();
//		//switching another tab for handeling webelement
//		driver.switchTo().window(childid);
//		
		driver.findElement(By.xpath("//android.widget.EditText[@text='Email address or phone number']")).sendKeys("tuser1581@gmail.com");
		driver.findElement(By.xpath("//android.widget.EditText[@text='Facebook password']")).sendKeys("india12345");
		//driver.findElement(By.xpath("//android.widget.Button[@resource-id='u_0_5']")).click();
		String act = driver.currentActivity();
		System.out.println(act);
		System.out.println("\n"+"---------LOGOUT OPERATION STARTS-------");
    	//clicking submenu button
    	driver.findElement(By.xpath("//android.widget.TextView[@bounds='[936,87][1080,231]']")).click();
    	Thread.sleep(4000);
    	//clicking logout button
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//android.widget.Button[@text='Yes']")).click();
    	
    	System.out.println("\n"+"---------LOGOUT OPERATION FINISHED-------");
		
		
		
		}	
	
	@Test(priority=5,enabled=true)
	public void Language() throws MalformedURLException, InterruptedException
	{
		System.out.println("Language method is running");
		try {
			
			Thread.sleep(25000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		WebElement subMenu = driver.findElement(By.xpath("//android.widget.TextView[@bounds='[936,87][1080,231]']"));
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
	
	@Test(priority=6,enabled=true)
	public void ID_1212() throws MalformedURLException, InterruptedException
	{
		
		System.out.println("ID_1212 method is running");
		Thread.sleep(6000);
		//clicking menu button
		driver.findElement(By.xpath("//android.widget.ImageButton[@bounds='[0,75][168,243]']")).click();
		
		//clicking tv button
		driver.findElement(By.xpath("//android.widget.TextView[@text='tv']")).click();
		Thread.sleep(12000);
		//checking clicked Menu title
		String ExpectedMenuName = "TV";
		WebElement MenuNam=driver.findElement(By.xpath("//android.widget.TextView[@text='TV']"));
		boolean status = MenuNam.isDisplayed();
		System.out.println("Clicked Menu button is displaying "+status);
		String MenuName = MenuNam.getText();
		
		System.out.println("Clicked menu name is "+MenuName);
		assertEquals(MenuName, ExpectedMenuName, "Actual is not Matching with Expected  ");
		
		//clicking "friends" content
		driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[31,672][517,957]']")).click();
		
		//Now content menu opened And we are checking Content menu text
		WebElement frindsContnt = driver.findElement(By.xpath("//android.widget.TextView[@text='friends']"));
		boolean status1 = frindsContnt.isDisplayed();
		System.out.println("Content is displaying "+status1);
		String ActualContentName = frindsContnt.getText();
		String ExpctdContent = "friends";
		assertEquals(ActualContentName, ExpctdContent, "Actual is not Matching with Expected  ");
		
		//Checking Banner
		WebElement banner = driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[0,243][1080,873]']"));
		boolean status2 = banner.isDisplayed();
		System.out.println("Banner is displaying "+status2);
		
		//checking view trailer button
		WebElement viewTrlr = driver.findElement(By.xpath("//android.widget.Button[@text='View Trailer']"));
		boolean status3 = viewTrlr.isDisplayed();
		String ViewTrlrText = viewTrlr.getText();
		System.out.println("View Trailer button is displaying  "+status3+" and button text is "+ViewTrlrText);
		String ExpctedButton = "View Trailer";
		assertEquals(ViewTrlrText, ExpctedButton, "Actual is not Matching with Expected  ");
		
		//cliking view Trailer button
		viewTrlr.click();
		//Thread.sleep(4000);
		//clicking playbutton
		Thread.sleep(10000);
		//clicking on screen for getting play/pause button
		driver.findElement(By.xpath("//android.view.View[@bounds='[0,155][1080,763]']")).click();
		//driver.findElement(By.xpath("//android.widget.ImageButton[@bounds='[30,768][90,828]']")).click();
		//clicking pause button
		driver.findElement(By.xpath("//android.widget.ImageButton[@bounds='[440,359][640,559]']")).click();
		//clicking play button after 6 sec
		Thread.sleep(6000);
		// Again clicking on screen for getting play/pause button
		driver.findElement(By.xpath("//android.view.View[@bounds='[0,155][1080,763]']")).click();
		//clicking play button
		driver.findElement(By.xpath("//android.widget.ImageButton[@bounds='[440,359][640,559]']")).click();
		Thread.sleep(6000);
		// Again clicking on screen for maximizing
		driver.findElement(By.xpath("//android.view.View[@bounds='[0,155][1080,763]']")).click();
		//Maximizing
		driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[999,768][1059,828]']")).click();
		//Waiting 6 sec for minmizing
		Thread.sleep(6000);
		// Again clicking on screen for minimizing
		driver.findElement(By.xpath("//android.view.View[@bounds='[0,0][1920,1080]']")).click();
		//clicking minimize button
		driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[1839,1005][1899,1065]']")).click();
		
		//After minimizing clicking back button
		driver.findElement(By.xpath("//android.widget.ImageButton[@bounds='[39,127][103,191]']")).click();
		
		Thread.sleep(4000);
		// clicking on play button on friends Page
		driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[450,468][630,648]']")).click();
		
		
		//scrolling Down
		Dimension dimensions = driver.manage().window().getSize();
				
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();			
		Double screenHeightEnd = dimensions.getHeight() * 0.1;
		int scrollEnd = screenHeightEnd.intValue();
		driver.swipe(0,scrollStart,0,scrollEnd,2000);
		
		//After scroll down Clicking on Login button
		driver.findElement(By.xpath("//android.widget.TextView[@text='Login']")).click();
		
		//Giving Credentials
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your Email Address']")).sendKeys("scar46@muvi.com");
    	driver.findElement(By.xpath("//android.widget.EditText[@index='2']")).sendKeys("123456");
    	driver.hideKeyboard();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//android.widget.Button[@text='Login']")).click();
    	Thread.sleep(10000);
    	try {
    		driver.findElement(By.xpath("//android.widget.LinearLayout[@bounds='[24,75][1056,404]']"));
    		driver.findElement(By.xpath("//android.widget.Button[@text='Continue']")).click();
    		
		} catch (Exception e) {
			
		}
    	
    	Thread.sleep(10000);
    	//clicking on screen for back button
    	driver.findElement(By.xpath("//android.view.View[@bounds='[0,155][1080,763]']")).click();
    	
    	//clicking back button
    	driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id='com.release.muvisdk:id/back']")).click();
    	//driver.findElement(By.xpath("//android.widget.ImageButton[@bounds='[45,127][109,191]']")).click();
    	//driver.findElement(By.xpath("//android.widget.ImageButton[@bounds='[45,130][109,194]']")).click();
		
    	
		//clicking on Add to Favlist
    	driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[930,303][1020,393]']")).click();
    	
		//Clicking on adding a review
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Add a Review']")).click();
    	
    	// clicking on Star
    	WebElement fiveStarRatingbar = driver.findElement(By.xpath("//android.widget.RatingBar[@bounds='[30,429][510,519]']"));
  	    
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
        driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your Review here...max 50 characters']")).sendKeys("Good");
    	driver.findElement(By.xpath("//android.widget.Button[@text='Post Review']")).click();
    	
    	//checking fav button clicked or not
    	boolean favstatus = driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[930,303][1020,393]']")).isSelected();
    	System.out.println("Fav button is seleted "+favstatus);
    	
    	//check in My fav list
    	//clicking in submenu to get "MyFav" button
    	driver.findElement(By.xpath("//android.widget.TextView[@bounds='[936,87][1080,231]']")).click();
    	//clicking on "My fav" button
    	driver.findElement(By.xpath("//android.widget.TextView[@text='My Favorites']")).click();
    	//checking "friends" content is displaying
    	boolean addtofavstatus = driver.findElement(By.xpath("//android.widget.TextView[@text='friends']")).isDisplayed();
    	System.out.println("After add to favourite , the content is displaying "+addtofavstatus );
    	
    	//clicking back button
    	driver.findElement(By.xpath("//android.widget.ImageButton[@bounds='[0,75][168,243]']")).click();
    	
    	//clicking on Add to Favlist again to remove favourite
    	driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[930,303][1020,393]']")).click();
    	//clicking in submenu to get "MyFav" button
    	driver.findElement(By.xpath("//android.widget.TextView[@bounds='[936,87][1080,231]']")).click();
    	//clicking on "My fav" button
    	driver.findElement(By.xpath("//android.widget.TextView[@text='My Favorites']")).click();
    	//checking Content is present or not
    	WebElement favcontent = driver.findElement(By.xpath("//android.widget.TextView[@bounds='[24,946][1056,1217]']"));
    	//checking "friends" content is displaying
    	
//    	try {
//    		boolean addtofavstatus1 = driver.findElement(By.xpath("//android.widget.TextView[@text='friends']")).isDisplayed();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
    	
    	String favcontetvalue = favcontent.getText();
    	System.out.println("Friends content is displaying "+" instaed of this, here is displaying "+favcontetvalue);
    	Thread.sleep(4000);
    	//clicking back button
    	driver.findElement(By.xpath("//android.widget.ImageButton[@bounds='[0,75][168,243]']")).click();
    	
    	
    	//checking Review(2) is visible or not
    	WebElement reviewbutn =  driver.findElement(By.xpath("//android.widget.TextView[@text='Reviews (2) ']"));
    	boolean rvwstatus = reviewbutn.isDisplayed();
    	boolean rvwstatus1 = reviewbutn.isEnabled();
    	System.out.println("Review Button is enbled "+rvwstatus1+" review is displayed "+rvwstatus);
    	reviewbutn.click();
    	
    	//After clicking Review(2), checking review listing is available or not
    	WebElement review1Name = driver.findElement(By.xpath("//android.widget.TextView[@text='Scarlett Johansson']"));
    	boolean rvwnmStats = review1Name.isDisplayed();
    	String rvwnmText = review1Name.getText();
    	System.out.println("1st review user is "+rvwnmText+" and it is displaying "+rvwnmStats);
    	
    	WebElement review2Name = driver.findElement(By.xpath("//android.widget.TextView[@text='Muvi Backup']"));
    	boolean rvwnm2Stats = review2Name.isDisplayed();
    	String rvwnm2Text = review2Name.getText();
    	System.out.println("2nd review user is "+rvwnm2Text+" and it is displaying "+rvwnm2Stats);
    	
    	
    	String ReviewValue = driver.findElement(By.xpath("//android.widget.TextView[@text='Good']")).getText();
    	System.out.println("User has reviewed "+ReviewValue);
    	
    	////////////////////////////////////////
    	//clicking back button
    	driver.findElement(By.xpath("//android.widget.ImageButton[@bounds='[0,75][168,243]']")).click();
    	
    	System.out.println("\n"+"---------LOGOUT OPERATION STARTS-------");
    	//clicking submenu button
    	driver.findElement(By.xpath("//android.widget.TextView[@bounds='[936,87][1080,231]']")).click();
    	Thread.sleep(4000);
    	//clicking logout button
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//android.widget.Button[@text='Yes']")).click();
    	
    	System.out.println("\n"+"---------LOGOUT OPERATION FINISHED-------");
    	
	}
	
	@Test(priority=7,enabled=true)
	public void Login_Scenario() throws MalformedURLException, InterruptedException
	{
		
		System.out.println("Login_Scenario method is running");
		Thread.sleep(30000);
				
		//clicking menu button
	    driver.findElement(By.xpath("//android.widget.ImageButton[@bounds='[0,75][168,243]']")).click();
		//clicking TV button from menu
		driver.findElement(By.xpath("//android.widget.TextView[@text='tv']")).click();
		//clicking "friends" content
		driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[31,672][517,957]']")).click();
		
		//clicking on Add to Favlist
    	driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[930,303][1020,393]']")).click();
   	
   
   	
    	//scrolling Down for getting login button 
    	Dimension dimensions = driver.manage().window().getSize();
    	        
    	Double screenHeightStart = dimensions.getHeight() * 0.5;
    	int scrollStart = screenHeightStart.intValue();			
    	Double screenHeightEnd = dimensions.getHeight() * 0.1;
    	int scrollEnd = screenHeightEnd.intValue();
    	driver.swipe(0,scrollStart,0,scrollEnd,2000);
    			
    	//After scroll down Clicking on Login button
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Login']")).click();
    			
    	//Giving Credentials
    	driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your Email Address']")).sendKeys("scar46@muvi.com");
    	driver.findElement(By.xpath("//android.widget.EditText[@index='2']")).sendKeys("123456");
    	driver.hideKeyboard();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//android.widget.Button[@text='Login']")).click();
    	

    	
    	//clicking on sub menu for logout button
    	driver.findElement(By.xpath("//android.widget.TextView[@bounds='[936,87][1080,231]']")).click();
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();
    	driver.findElement(By.xpath("//android.widget.Button[@text='Yes']")).click();
    	
    	Thread.sleep(10000);
    	
    	//clicking menu button
	    driver.findElement(By.xpath("//android.widget.ImageButton[@bounds='[0,75][168,243]']")).click();
		//clicking TV button from menu
		driver.findElement(By.xpath("//android.widget.TextView[@text='tv']")).click();
		//clicking "friends" content
		driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[31,672][517,957]']")).click();
    	
    	//clicking on add a review
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Add a Review']")).click();
    	driver.findElement(By.xpath("//android.widget.TextView[@text='You need to activity_login to add your review. Click here to activity_login.']")).click();
    	
    	//Giving Credentials
    	driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your Email Address']")).sendKeys("scar46@muvi.com");
    	driver.findElement(By.xpath("//android.widget.EditText[@index='2']")).sendKeys("123456");
    	driver.hideKeyboard();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//android.widget.Button[@text='Login']")).click();
    	
    	//Now homepage is coming instead of content page so repeating code
    	
    	Thread.sleep(6000);
    	//clicking menu button
	    driver.findElement(By.xpath("//android.widget.ImageButton[@bounds='[0,75][168,243]']")).click();
		//clicking TV button from menu
		driver.findElement(By.xpath("//android.widget.TextView[@text='tv']")).click();
		//clicking "friends" content
		driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[31,672][517,957]']")).click();
    	
    	//clicking on add a review
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Add a Review']")).click();
    	
    	WebElement fiveStarRatingbar = driver.findElement(By.xpath("//android.widget.RatingBar[@bounds='[30,429][510,519]']"));
  	    
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
        driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your Review here...max 50 characters']")).sendKeys("Good");
    	driver.findElement(By.xpath("//android.widget.Button[@text='Post Review']")).click();
    	
	}
	
	@Test(priority=8,enabled=true)
	public void Forgot_Password() throws MalformedURLException, InterruptedException
	{
		System.out.println("Forgot_Password method is running");
		
		Thread.sleep(30000);
		
		driver.findElement(By.xpath("//android.widget.TextView[@bounds='[936,87][1080,231]']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Log in']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Forgot Password?']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your Email Address']")).sendKeys("scar46@muvi.com");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
		
		//after submitting capturing msg
		String msg = driver.findElement(By.xpath("//android.widget.TextView[@text='Password Reset link has been emailed to your registered email ID. "
				+ "Please check your email to reset password.']")).getText();
		System.out.println("After submitting we are getting message "+msg);
		
		//clicking ok button
		driver.findElement(By.xpath("//android.widget.Button[@text='Ok']")).click();	
	
	}
	
	@AfterMethod
	public void successmethod()
	{
		System.out.println("Method run Successfully");
	}
	
	@AfterClass
	public void closeApp()
	{
		driver.quit();
	}
	
	
}
