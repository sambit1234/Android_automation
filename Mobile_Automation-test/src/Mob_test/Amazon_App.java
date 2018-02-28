package Mob_test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Amazon_App 
{

	private static AndroidDriver driver;
	
		public static void main(String[] args) throws MalformedURLException, InterruptedException
		{
 
			//File classpathRoot = new File(System.getProperty("user.dir")); 
			File appDir = new File("D://APK_FILES");
			File app = new File(appDir, "Amazon India Online Shopping_v14.1.0.300_apkpure.com.apk");
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
			
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Lenovo");
			
			capabilities.setCapability(MobileCapabilityType.VERSION, "5.1.1");
	        //other caps
	        capabilities.setCapability("app", app.getAbsolutePath());
	        
	        driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	        driver.quit();

	}

}
