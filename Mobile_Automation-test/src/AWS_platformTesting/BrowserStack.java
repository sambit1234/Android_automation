package AWS_platformTesting;

	import java.net.URL;
	import java.net.MalformedURLException;
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.remote.MobileCapabilityType;

	import org.openqa.selenium.By;
	
	
	import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
	 
	public class BrowserStack {
	  
	  public static String userName = "muvientertainmen1";
	  public static String accessKey = "8weKejvvmYSFrspM9GNn";
	  public static String appcls = "com.release.muvisdk";
	  public static String emailid="bruce12@gmail.com";
	  public static String pwd ="1234";
	  public static AndroidDriver driver;

	  @Test
	  public static void browser() throws MalformedURLException, InterruptedException
	  {
		  
	    DesiredCapabilities caps = new DesiredCapabilities();

	    caps.setCapability(MobileCapabilityType.BROWSER_NAME, "");
	    caps.setCapability("platformVersion", "5.1.1");
	    caps.setCapability("platformName", "Android");
	    caps.setCapability("app_url", "bs://829360659c5b86858b274d8428da218d007284f8");
	    

	    driver = new AndroidDriver(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);
	    
	    Thread.sleep(10000);

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
	

}
