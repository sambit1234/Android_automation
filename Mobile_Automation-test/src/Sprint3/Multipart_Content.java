package Sprint3;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
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

public class Multipart_Content {
	
	/*
	 * Open App and Login
	 * Click "Award Distribution" content in homepage
	 * Verify Content title
	 * Verify "View trailer",episode dropdown,"view all", "Add a Review",star rating
	 * clicking "View trailer" button wait for 12sec 
	 * click back
	 * click "View All" button
	 * Verify "All Episode" title is coming or not
	 * clicking last option from dropdown
	 * Clicking one content
	 * Purchase is if it is not been purchased.
	 * Wait 5sec for playing video.
	 * back to content page and click View all
	 * Click same content that was previously played from dropdown
	 * Back to Main content page
	 * Click add to fav
	 * Wait for 4sec and click add review
	 * Give rating and add review
	 * Back to content page
	 * 
	 * */
	
	//SKIPPING clicking same content from view all [While clicking child content it is showing parent content name. So cant Differentiate.]
	
	// *Before running this script make sure that review is removed from CMS. 
	
	private static AndroidDriver driver;
	private static String appcls = "com.release.muvisdk";
	private static String emailid="bruce12@gmail.com";
	private static String pwd ="1234";
	private static int Menu_section = 4;
	private static int logout_ind = 4;
	
	//change "Menu_section","logout_ind" 
	
	public static void scroll()
	{
		
		Dimension dimensions = driver.manage().window().getSize();
		
    	Double screenHeightStart = dimensions.getHeight() * 0.5;
    	int scrollStart = screenHeightStart.intValue();			
    	Double screenHeightEnd = dimensions.getHeight() * 0.1;
    	int scrollEnd = screenHeightEnd.intValue();
    	driver.swipe(0,scrollStart,0,scrollEnd,2000);
    	
		
		
	}
	
	public static void logout() throws InterruptedException
	{
		System.out.println("Logout starts...");
		//clicking submenu button
    	driver.findElement(By.id(appcls+":id/submenu")).click();
    	
    	Thread.sleep(6000);
		
		int l = driver.findElements(By.xpath("//android.widget.FrameLayout[@index='0']"
				+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout")).size();
		
		System.out.println("Size is "+l);
		
		driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
				+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='"+(l-1)+"']")).click();
			 driver.findElement(By.id("android:id/button1")).click();
		    	
		    	System.out.println("Logout ends");
		
	}
	
	
	public static void login() throws InterruptedException
	{
		
		System.out.println("Login Starts...");
		//clicking submenu button
		driver.findElement(By.id(appcls+":id/submenu")).click();
		
		//clicking login button
		driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
				+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='0']")).click();
		
    	driver.findElement(By.id(appcls+":id/editEmailStr")).sendKeys(emailid);
    	driver.findElement(By.id(appcls+":id/editPasswordStr")).sendKeys(pwd);
    	
    	driver.hideKeyboard();
    	Thread.sleep(3000);
    	driver.findElement(By.id(appcls+":id/loginButton")).click();
    	
    	System.out.println("Login ended...");
		
	}
	
	
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
		
		login();
		
	}
	
	@Test(priority=1,enabled=true)
	public void Verify_All_Titles() throws MalformedURLException, InterruptedException
	{
		int x =0;  //[For terminating menu items loop ]
		// Here Testing content title  (Homepage > Award...> CEO Awarding) 
		
		WebElement menu_button = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/"
				+ "android.view.ViewGroup[@index='0']/android.widget.ImageButton[@index='0']"));
		
		//Clicking each Menu items [LOOP]
		for (int i = 2; i <= Menu_section; i++) {
	    	   
			menu_button.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//android.widget.ExpandableListView[@index='1']/android.widget.LinearLayout[@index='"+i+"']")).click();
			Thread.sleep(4000);
			
			//Getting total number of contents present in a section. [for clicking each content untill finding multipart content]
			List<WebElement> contents = driver.findElements(By.id(appcls+":id/movieImageOverlay"));
			
			int size = contents.size();
			
			//clicking each content present inside each menu section untill getting multipart content.
			for (int j = 0; j <size; j++) {
				
				WebElement con = driver.findElement(By.xpath("//android.support.v4.widget.DrawerLayout[@index='0']/android.widget.LinearLayout[@index='0']"
						+ "/android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/"
						+ "android.widget.GridView[@index='1']"
						+ "/android.widget.RelativeLayout[@index='"+j+"']"
						+ "/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']"));
				String actTitl = con.getText();
				con.click();
				
				Thread.sleep(4000);
				boolean stats = false;
				  
				try {
					stats = driver.findElement(By.id(appcls+":id/playButton")).isDisplayed();
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
				
		
				if(stats)
				{
					System.out.println("It is single part content , find next content for multipart...");
					driver.pressKeyCode(4);
				}
				else
				{
					
					Thread.sleep(3000);
					System.out.println("It is Multipart content...");
					System.out.println("Clicked title "+actTitl);
					//checking content title
					String title = driver.findElement(By.id(appcls+":id/videoTitle")).getText();
					System.out.println("Content title is "+title);
					assertEquals(title, actTitl, "Title is not matching");
					
					//checking view trailer button is displaying or not
					boolean st = driver.findElement(By.id(appcls+":id/viewTrailerButton")).isDisplayed();
					System.out.println("view trailer is diplaying "+st);
					
					
					
					//checking cast and crew is displaying or not
					boolean castst = driver.findElement(By.id(appcls+":id/videoCastCrewTitleTextView")).isDisplayed();
					System.out.println("Cast and crew is diplaying "+castst);
					
					
					//checking dropdown is displaying
					boolean drpst = driver.findElement(By.id("android:id/text1")).isDisplayed();
					System.out.println("drop down is diplaying "+drpst);
					
					//cheking view all button is displaying or not
					boolean viwallst = driver.findElement(By.id(appcls+":id/btnMore")).isDisplayed();
					System.out.println("Viewall button is diplaying "+viwallst);
					
					//checking star rating is displaying or not
					boolean starst = driver.findElement(By.id(appcls+":id/ratingBar")).isDisplayed();
					System.out.println("Star rating is diplaying "+starst);
					
					//checking add review is displaying or not
					boolean reviwst = driver.findElement(By.id(appcls+":id/viewRatingTextView")).isDisplayed();
					System.out.println("Add review is diplaying "+reviwst);
					
					//checking all sections are displaying or not [If displaying it will naviagte to next method else will show missing]
					if(drpst && viwallst && starst && reviwst)
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
					
					//clicking dropdown 
					driver.findElement(By.id("android:id/text1")).click();
					
					//counting total options from dropdown
					List<WebElement> droplist = driver.findElements(By.id("android:id/text1"));
					int size1 = droplist.size();
					System.out.println("Dropdown size is "+size1);
					
					//clicking last option from dropdown. [clicking size1-1 (index starts frm 0)]
					driver.findElement(By.xpath("//android.widget.TextView[@index='"+(size1-1)+"']")).click();
					
					Thread.sleep(4000);
					
					//clicking content
					WebElement drp_con = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='2']"
							+ "/android.widget.RelativeLayout[@index='1']"));
					
					
					drp_con.click();
					
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
					
					
					try {
						driver.findElement(By.id(appcls+":id/yesButton")).click();
						
					} catch (Exception e) {
						// TODO: handle exception
					}
					//waiting for 12sec while vdo is playing
					Thread.sleep(12000);
					
					driver.pressKeyCode(4);
					
					//-------------------------------------------------------SKIPING HERE---------------------------------------------------
					//clicking view all
					//driver.findElement(By.id(appcls+":id/btnMore")).click();
					
					//clicking same content
					//driver.findElement(By.xpath("//android.widget.TextView[@text='"+con_name+"']")).click();
					
					//-------------------------------------------------------SKIPING HERE---------------------------------------------------
					
					
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
					
			    	
					x++;
					return;
					
				}
				
				
			}
			
			if(x==1)
			{
				System.out.println("Multipart content already clicked....closing menu section");
				break;
			}
			else {
				System.out.println("Clicking another menu section.");
			}
			
		}
		
	}

	@AfterClass
	public void logout_Close() throws InterruptedException
	{
		
       logout();
    	
    	System.out.println("Finished");
    	Thread.sleep(3000);
    	
	}
	
	
	

}
