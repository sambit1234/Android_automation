package Sprint3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Generic_Library.Android;
import io.appium.java_client.android.AndroidDriver; 
import io.appium.java_client.remote.MobileCapabilityType;

public class Offline extends Android
{
	
	/*
	 * Open App and login
	 * Click one content 
	 * Download the content
	 * Verify that same content in Mydownloads
	 * Click that content in My Download
	 * delete the content
	 * Check download option is displaying or not
	 * Logout
	 *  
	 * */
	
	// Make sure content should not be in My download. i,e previously downloaded.
	
	
	private static int i = 2; //For any menu section
	private static int j = 1; //For any content
	private static int k = 1; //For any resolution
	public static String title;
	
	
	
	
	
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
	
	
	public static void mydownload() throws InterruptedException
	{
		
		//clcicking submenu button
		driver.findElement(By.id(appcls+":id/submenu")).click();
		Thread.sleep(4000);
		
		//getting contents number present in submenu for clicking "My Downloads".
		int l = driver.findElements(By.xpath("//android.widget.FrameLayout[@index='0']"
				+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout")).size();
		
		System.out.println("Size is "+l);
		
		//loop continues untill clik "My Downloads"
		for(int i=l-2;i>=1;i--)
		{
			//clicking each submenu section
			driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']"
					+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='"+i+"']")).click();
			
			
			boolean st = false;
			
			try {
				//checking If clicked section is My Downloads or not by checking delete button availble. 
				st = driver.findElement(By.id(appcls+":id/imageView1")).isDisplayed();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(st)
			{
				Thread.sleep(4000);
				System.out.println("Clicked My downloads");
				Thread.sleep(6000);
				//System.out.println("Understood string is "+title);
				
				//title is the Downloaded content name
				WebElement content = driver.findElement(By.xpath("//android.widget.TextView[@text='"+title+"']"));
				boolean status = content.isDisplayed();
				
				System.out.println("Content is displaying "+status);
				
				//checking if Downloaded content is showing, then clicking that content.
				if(status)
				{
					//clicking on vdo
					driver.findElement(By.id(appcls+":id/imageView")).click();
					
					//waiting 5 sec and watching vdo
					Thread.sleep(5000);
					
					try {
				    	 
						//resume video 
						driver.findElement(By.id(appcls+":id/cancelButton")).click();
								
								
						} catch (Exception e) {
					// TODO: handle exception
						}
					
					System.out.println("Waiting 10 sec for playing Video");
					Thread.sleep(10000);
					
					//back to My download page
					driver.pressKeyCode(4);
					
					Thread.sleep(5000);
					
					//clicking Downloaded content in My Download Page.
					driver.findElement(By.xpath("//android.widget.LinearLayout[android.widget.LinearLayout[android.widget.TextView[@text='"+title+"']]]"
							+ "/android.widget.ImageView[@index='2']")).click();
					
					
					//clicking delete button from popup
					driver.findElement(By.id("android:id/button1")).click();
					
					//back to content page()
					driver.pressKeyCode(4);
					
					boolean stats = false;
					  
					try {
						stats = driver.findElement(By.id(appcls+":id/playButton")).isDisplayed();
					} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
					

					if(stats)
					{
						Thread.sleep(4000);
						System.out.println("Clicked content is single part content so clicking Play button");
						
						//clicking play button
						driver.findElement(By.id(appcls+":id/playButton")).click();
						
						try {
					    	 
							//resume video 
							driver.findElement(By.id(appcls+":id/cancelButton")).click();
									
									
							} catch (Exception e) {
						// TODO: handle exception
							}
						
						//checking Download Option is displaying ?
						System.out.println("Checking Download Option is displaying or not ");
						
						boolean dwnst = false;
						
						try {
							dwnst = driver.findElement(By.id(appcls+":id/downloadImageView")).isDisplayed();
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						
						//Validating Download option is not visible
						if(dwnst != true) {
							
							Thread.sleep(4000);
							System.out.println("Content is not deleted..Try again");
							driver.pressKeyCode(4);
							logout();
						}
						else {
							
							Thread.sleep(4000);
							System.out.println("Content is successfully deleted");
							driver.pressKeyCode(4);
							logout();
							
						}
						
						
						
				
					}
					else {
						
						Thread.sleep(4000);
						System.out.println("Clicked content is Multipart content so clicking one child content");
						
						//clicking content
						WebElement drp_con = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='2']"
								+ "/android.widget.RelativeLayout[@index='1']"));
						
						
						drp_con.click();
						
						try {
					    	 
							//resume video 
							driver.findElement(By.id(appcls+":id/cancelButton")).click();
									
									
							} catch (Exception e) {
						// TODO: handle exception
							}
						
						//checking Download Option is displaying ?
						System.out.println("Checking Download Option is displaying or not ");
						
						boolean dwnst = false;
						
						try {
							dwnst = driver.findElement(By.id(appcls+":id/downloadImageView")).isDisplayed();
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						
						//Validating Download option is not visible
						if(dwnst != true) {
							
							Thread.sleep(4000);
							System.out.println("Content is not deleted..Try again");
							driver.pressKeyCode(4);
							logout();
						}
						else {
							
							Thread.sleep(4000);
							System.out.println("Content is successfully deleted");
							driver.pressKeyCode(4);
							logout();
							
						}
						
					}
					
					System.out.println("Move for next...");
					
					
				
				}
				
				else {
					Thread.sleep(4000);
					System.out.println("Content is not displaying in My download Page");
				}
				return;
			}
			
			else {
				
				driver.pressKeyCode(4);
				driver.findElement(By.id(appcls+":id/submenu")).click();
				Thread.sleep(4000);
			}
			
			
		}
		
		
	//------------------------------------------Print Clicked My Downloads ----------------------------	
		
		/*
		
		//checking download option is visible or not
		boolean st = driver.findElement(By.id("com.release.magicmovies:id/downloadImageView")).isDisplayed();
		
		if(st)
		{
			
			System.out.println("After deleting vdo from my downloads, download option is displaying");
			
		}
		*/
		
	}
	
	@Test
	public static void offLine() throws MalformedURLException, InterruptedException
	{
		
		DesiredCapabilities capabilities = new  DesiredCapabilities();
		
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Lenovo");
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", appcls);
		capabilities.setCapability("appActivity", "com.home.vod.activity.SplashScreen");
		driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Thread.sleep(30000);
		
		login();
		
		System.out.println("Clicking Menu Button");
		//Clicking Menu Button
		driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/"
				+ "android.view.ViewGroup[@index='0']/android.widget.ImageButton[@index='0']")).click();
		
		Thread.sleep(4000);
		//clicking randomly any menu section [i value for any index of menu section] 
		driver.findElement(By.xpath("//android.widget.ExpandableListView[@index='1']/android.widget.LinearLayout[@index='"+i+"']")).click();
		
		System.out.println("Clicking any random content");
		//clicking randomly one content
		WebElement con = driver.findElement(By.xpath("//android.support.v4.widget.DrawerLayout[@index='0']/android.widget.LinearLayout[@index='0']"
				+ "/android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/"
				+ "android.widget.GridView[@index='1']"
				+ "/android.widget.RelativeLayout[@index='"+j+"']"
				+ "/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']"));
		
		con.click();
		
		Thread.sleep(10000);
		boolean stats = false;
		  
		try {
			stats = driver.findElement(By.id(appcls+":id/playButton")).isDisplayed();
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		

		if(stats)
		{
			Thread.sleep(4000);
			System.out.println("It is single part content");
			
			//clicking play button
			driver.findElement(By.id(appcls+":id/playButton")).click();
			
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
		
			Thread.sleep(5000);
			
			//Getting content title
			String p = driver.findElement(By.id(appcls+":id/videoTitle")).getText();
			System.out.println("Clicked content name is "+p);
			title=p;
			
			//clicking download button
			
			boolean dwnst = false;
			
			
			try {
				dwnst = driver.findElement(By.id(appcls+":id/downloadImageView")).isDisplayed();
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			
			if(dwnst)
			{
				
				Thread.sleep(4000);
				System.out.println("Download option available, Downloading...");
				driver.findElement(By.id(appcls+":id/downloadImageView")).click();
				
				System.out.println("Download option is visible for this content "+dwnst);
				
				Thread.sleep(20000);
				
				//Here checking if download resolution is coming
				try {
					//clicking Resolution
					driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/"
							+ "android.widget.LinearLayout[@index='1']"
							+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='"+k+"']/android.widget.RadioButton[@index='0']")).click();
					
					//clicking save button
					driver.findElement(By.id(appcls+":id/save")).click();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//Here checking if Direct Download is coming
				try {
					//clicking "DOWNLOAD" from popup
					driver.findElement(By.id("android:id/button1")).click();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//Clicking "ok" after successfully downloaded video.
				try {
					driver.findElement(By.id("android:id/button2")).click();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace(); 
				}
				
				//back to content page
				driver.pressKeyCode(4);
				
				logout();
				
			}
			else {
				Thread.sleep(3000);
				System.out.println("Download option is not available for this content.");
				
				//back to content page
				driver.pressKeyCode(4);
				
				logout();
				
			}
			
			
			
		}
		else
		{
			Thread.sleep(4000);
			System.out.println("It is Multipart content");
			
			//clicking dropdown 
			driver.findElement(By.id("android:id/text1")).click();
			
			Thread.sleep(5000);
			
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
			
			String p = driver.findElement(By.id(appcls+":id/videoTitle")).getText();
			System.out.println("Clicked content name is "+p);
			title=p;
			//waiting for 12sec while vdo is playing
			Thread.sleep(12000);
			
			
			boolean dwnst = false;
			
			
			try {
				dwnst = driver.findElement(By.id(appcls+":id/downloadImageView")).isDisplayed();
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			
			if(dwnst)
			{
				
				Thread.sleep(4000);
				System.out.println("Download option available, Downloading...");
				
				//clicking download button
				driver.findElement(By.id(appcls+":id/downloadImageView")).click();
				
				System.out.println("Download option is visible for this content "+dwnst);
				
				Thread.sleep(12000);
				//Here checking if download resolution is coming
				try {
					//clicking Resolution
					driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/"
							+ "android.widget.LinearLayout[@index='1']"
							+ "/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='"+k+"']/android.widget.RadioButton[@index='0']")).click();
					
					//clicking save button
					driver.findElement(By.id(appcls+":id/save")).click();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//Here checking if Direct Download is coming
				try {
					//clicking "DOWNLOAD" from popup
					driver.findElement(By.id("android:id/button1")).click();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//Clicking "ok" after successfully downloaded video.
				
				WebDriverWait wait=new WebDriverWait(driver,2000);
				WebElement DownloadOk= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id( "android:id/button2")));
				DownloadOk.click();

				//back to content page
				driver.pressKeyCode(4);
				
				mydownload();
				
				//logout();
			}
			else {
				
				Thread.sleep(4000);
				System.out.println("Download option is not available for this content.");
				
				//back to content page
				driver.pressKeyCode(4);
				
				logout();
			}
			
			
		}
	
		
	}
	

}
