package Sprint2;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import Generic_Library.Android;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Cast_N_Crew extends Android
{


//check "Menu_section"

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
		
		Thread.sleep(35000);
	
		login();
		
    	Thread.sleep(5000);
    	
    	//---------------------------------------------------Content----------------------------------------------
    	
    	//Clicking content [2nd(64) line change 1/2 ]
    	WebElement content =driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.support.v7.widget.RecyclerView[@index='2']/"
				+ "android.widget.RelativeLayout[@index='1']/"
				+ "android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']"));
    	
    	
    	String content_name = content.getText();
		System.out.println("Name is "+content_name);
    	content.click();
    	
    	//---------------------------------------------------Content----------------------------------------------
	
    	//checking content is single part or multipart by validating play button visibility
		boolean st = false;
		
		try {
			st = driver.findElement(By.id(appcls+":id/playButton")).isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(st)
		{
		
			//clicking on cast and crew button
			WebElement cast_n_crew = driver.findElement(By.id(appcls+":id/videoCastCrewTitleTextView"));
			
			boolean st1 = false;
			
			try {
				st1 = cast_n_crew.isDisplayed();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(st1)
			{
			cast_n_crew.click();
				
			//verifying cast and crew page opened or not
			String actualtitle = driver.findElement(By.id(appcls+":id/castCrewTitleTextView")).getText();
			System.out.println("After clicking cast page Title is displaying "+actualtitle);
				
				
			//checking cast image
			boolean castimagestatus = driver.findElement(By.id(appcls+":id/castImageView")).isDisplayed();
			
			//checking cast name
			String actualcastname = driver.findElement(By.id(appcls+":id/castNameTextView")).getText();
			System.out.println("Cast image is displaying "+castimagestatus+" and cast name is "+actualcastname);
				
			//clicking Cast page
			driver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']")).click();
			Thread.sleep(4000);
			//checking Image of cast after clicking Cast Layout
			boolean status = driver.findElement(By.id(appcls+":id/castImageView")).isDisplayed();
			System.out.println("After clicking CastLayout , Image is diplaying "+status);
		
			String CastNameIn_castPage = driver.findElement(By.id(appcls+":id/castNameTextView")).getText();
			System.out.println("In cast page, displaying castname is "+CastNameIn_castPage);
			Thread.sleep(4000);
		
		
			WebElement con_in_page = driver.findElement(By.xpath("//android.widget.TextView[@text='"+content_name+"']"));
			String con_name = con_in_page.getText();
			boolean RespectiveContent = con_in_page.isDisplayed();
			System.out.println("In cast detail Page , Respective content is showing "+RespectiveContent+" and content name is "+con_name);
		
			for (int i = 1; i <=3; i++) {
        	
				driver.pressKeyCode(4);
    		
				Thread.sleep(3000);
	
			}
			//-------------------------------------------Another scenario----------------------------------------
        
			System.out.println("Viewing cast and crew in another scenario by menu section...");
			
			WebElement menu_button = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/"
					+ "android.view.ViewGroup[@index='0']/android.widget.ImageButton[@index='0']"));
       
		
			menu_button.click();
			Thread.sleep(4000);
    	
			// Searching and clicking same content in Menu section [i=2 --> [0]=logo,[1]=Home]
			int Menu_section =  driver.findElements(By.xpath("//android.widget.ExpandableListView[@index='1']/android.widget.LinearLayout")).size();
	    	// Searching and clicking same content in Menu section
	        for (int i = 2; i <= Menu_section; i++) {
	     	   
	     	   //menu_button.click();
	            
				Thread.sleep(3000);
				driver.findElement(By.xpath("//android.widget.ExpandableListView[@index='1']/android.widget.LinearLayout[@index='"+i+"']")).click();
    	  
				boolean stats = false;
    	  
				//checking same content is present or not. If not present it will move to next menu section
				
				try {
					stats = driver.findElement(By.xpath("//android.widget.TextView[@text='"+content_name+"']")).isDisplayed();
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
				
		
				if(stats)
				{
					//clcicking same content
					driver.findElement(By.xpath("//android.widget.TextView[@text='"+content_name+"']")).click();
					Thread.sleep(3000);
					String title = driver.findElement(By.id(appcls+":id/videoTitle")).getText();
    		 
					//Verifying same content or not
					assertEquals(title,content_name, "Clicked another content");
    		 
					System.out.println("After clicking content , Title is ---> "+title);
    		  
					Thread.sleep(3000);
					
					driver.pressKeyCode(4);
					
					
					Thread.sleep(7000);
					
					logout();
					System.out.println("Finished");
    		  
					return;
				}
				else
				{
					System.out.println("Content not there so Moving to Next menu section.....");
    		  
					menu_button.click();
					Thread.sleep(4000);
				}
    	   
				Thread.sleep(3000);
			} 
		
		}
			else {
				System.out.println("In this content , cast and crew are not added...");
				
				logout();
				
			}
			
			
		}
		
		else {
			
			System.out.println("Clicked content is Multipart");
			
			Thread.sleep(4000);
			
			String vdo_title = driver.findElement(By.id(appcls+":id/videoTitle")).getText();
			System.out.println("After clicking Multipart content, titile is "+vdo_title);
			
			Thread.sleep(5000);
			boolean cast_status = false;
			
			//checking cast and crew button is present or not (If not present it'll show cast and crew not added)
			try {
				cast_status = driver.findElement(By.id(appcls+":id/videoCastCrewTitleTextView")).isDisplayed();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(cast_status)
			{
				driver.findElement(By.id(appcls+":id/videoCastCrewTitleTextView")).click();
				
			//verifying cast and crew page opened or not
			String actualtitle = driver.findElement(By.id(appcls+":id/castCrewTitleTextView")).getText();
			System.out.println("After clicking cast page Title is displaying "+actualtitle);
				
				
			//checking cast image
			boolean castimagestatus = driver.findElement(By.id(appcls+":id/castImageView")).isDisplayed();
			
			//checking cast name
			String actualcastname = driver.findElement(By.id(appcls+":id/castNameTextView")).getText();
			System.out.println("Cast image is displaying "+castimagestatus+" and cast name is "+actualcastname);
				
			//clicking Cast page
			driver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']")).click();
			Thread.sleep(4000);
			//checking Image of cast after clicking Cast Layout
			boolean status = driver.findElement(By.id(appcls+":id/castImageView")).isDisplayed();
			System.out.println("After clicking CastLayout , Image is diplaying "+status);
		
			String CastNameIn_castPage = driver.findElement(By.id(appcls+":id/castNameTextView")).getText();
			System.out.println("In cast page, displaying castname is "+CastNameIn_castPage);
			
			Thread.sleep(8000);
		
			driver.pressKeyCode(4);
			
			Thread.sleep(3000);
			
			driver.pressKeyCode(4);
			
			Thread.sleep(5000);
			
			
			logout();
			
		}
			
			else {
				
				System.out.println("In this Multi part content , cast and crew are not added...");
				
				logout();
			}
	}
	
		System.out.println("Cast and crew is Finished.."); 
		

}
}
