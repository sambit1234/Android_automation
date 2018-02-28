package Mob_test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class test1 {
	
	private static AndroidDriver driver;
	private static String appcls = "com.release.muvisdk";
	public static final String DOWNLOAD_VIEW = "1";
	
	@Test(invocationCount=3)
	public void multipart() throws MalformedURLException, InterruptedException
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
		
		Thread.sleep(40000);
		
//		WebElement con = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']"
//				+ "/android.support.v7.widget.RecyclerView[@index='2']/android.widget.RelativeLayout[@index='0']/"
//				+ "android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']"));
//		con.click();
//		String title = con.getText();
//		System.out.println("my content value =============="+title);
		
		//menu button
		/*driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/"
				+ "android.view.ViewGroup[@index='0']/android.widget.ImageButton[@index='0']")).click();*/
		//appname
		WebElement element =  driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/"
				+ "android.view.ViewGroup[@index='0']/android.widget.TextView[@index='1']"));
		String apname = element.getText();
		if(apname != null) {
			System.out.println("appname ----------"+apname);

		}
		
		driver.findElement(By.id(appcls+":id/submenu")).click();
		//download button 
		//appname/"
		
				
				if(DOWNLOAD_VIEW.equalsIgnoreCase("1")) {
				/* driver.findElement(By.xpath("//android.widget.ListView[@index='0']"
							+ "/android.widget.LinearLayout[@index='3']"));*/
					for(int i=0;i < 5; i++) {
						WebElement e = driver.findElement(By.xpath("//android.widget.ListView[@index='0']"
								+ "/android.widget.LinearLayout[@index='"+ i +"']/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='0']"));
						System.out.println("download================"+e.getText());
					}
				

				}
				
		
		System.out.println("...");
		
	}

}
