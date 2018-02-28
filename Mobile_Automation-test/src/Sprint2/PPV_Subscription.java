package Sprint2;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class PPV_Subscription 
{

private static AndroidDriver driver;
private static String appcls = "com.release.muvisdk";
private static String emailid="bruce12@gmail.com";
private static String pwd ="1234";
private static String without_copn_content = "//android.widget.TextView[@text='Allied']";
private static String copn_100_content = "//android.widget.TextView[@text='FRIENDS']";
private static String copn_50content = "//android.widget.TextView[@text='testing Thirdparty Url']";
private static String copn_100amnt_content = "//android.widget.TextView[@text='Test pixel encoding']";
private static String copn_20amnt_content = "//android.widget.TextView[@text='Checking Ios Encoding']";
private static String voucher_content = "//android.widget.TextView[@text='test_IOS_casting']";
private static String coupn_100 = "3O11JMUX";
private static String coupn_50 = "D3KZ31SZ";
private static String copn_100amnt = "1IQT9U0X";
private static String copn_20amnt = "34LTH9KF";
private static String voucher_code = "O0DLYE58";
private static String Trans_content = "//android.widget.LinearLayout[@bounds='[30,974][1050,1467]']";


//change script according to presence of content. (Can remove menu page,tv page,movie page,scroll down)

@BeforeMethod
public void startApp() throws MalformedURLException, InterruptedException
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
	
	Thread.sleep(15000);
	

	System.out.println("LOGIN STARTS");
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

@Test(priority=1,enabled=false)
public void Without_Coupon_VDO() throws MalformedURLException, InterruptedException
{
	
//Here we purchase a content with full payment from card.
	
	//-------------------------------------------------------------------Webelement----------------------------------------------------------
	
	//clicking on Allied content
	driver.findElement(By.xpath(without_copn_content)).click();
	
	//-------------------------------------------------------------------Webelement----------------------------------------------------------
	
	Thread.sleep(3000);
	
	//clicking play button to play vdo
	driver.findElement(By.id(appcls+":id/playButton']")).click();
	
	Thread.sleep(4000);
	//scrolling Down
	Dimension dimensions = driver.manage().window().getSize();
					
	Double screenHeightStart = dimensions.getHeight() * 0.5;
	int scrollStart = screenHeightStart.intValue();			
	Double screenHeightEnd = dimensions.getHeight() * 0.1;
	int scrollEnd = screenHeightEnd.intValue();
	driver.swipe(0,scrollStart,0,scrollEnd,2000);
	
	Thread.sleep(3000);
	
	//giving card name
	driver.findElement(By.id(appcls+":id/nameOnCardEditText")).sendKeys("Scarlet");
	
	driver.hideKeyboard();
	
	//giving card number
	driver.findElement(By.id(appcls+":id/cardNumberEditText")).sendKeys("4111111111111111");
	
	driver.hideKeyboard();
	
	//clicking date drop down
	driver.findElement(By.xpath("//android.widget.TextView[@text='11']")).click();
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//android.widget.TextView[@index='5']")).click();
	
	Thread.sleep(3000);
	
	//clicking year drop down
	driver.findElement(By.xpath("//android.widget.TextView[@text='2017']")).click();
		
	Thread.sleep(3000);
	//scrolling Down
	Dimension dimensions2 = driver.manage().window().getSize();
						
	Double screenHeightStart2 = dimensions.getHeight() * 0.5;
	int scrollStart2 = screenHeightStart.intValue();			
	Double screenHeightEnd2 = dimensions.getHeight() * 0.1;
	int scrollEnd2 = screenHeightEnd.intValue();
	driver.swipe(0,scrollStart,0,scrollEnd,2000);
				
	driver.findElement(By.xpath("//android.widget.TextView[@text='2030']")).click();
		
	Thread.sleep(2000);
		
	//clicking cvv button
	driver.findElement(By.id(appcls+":id/securityCodeEditText")).sendKeys("123");
		
	driver.hideKeyboard();
	
	
	//clicking pay now button
	driver.findElement(By.xpath("//android.widget.Button[@text='Pay Now']")).click();	
	
	
}

@AfterMethod(enabled=false)
public void logout_Close() throws InterruptedException
{
	
	System.out.println("\n"+"---------LOGOUT OPERATION STARTS-------");
	//clicking submenu button
	driver.findElement(By.id(appcls+":id/submenu")).click();
	Thread.sleep(4000);
	//clicking logout button
	driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//android.widget.Button[@text='Yes']")).click();
	
	System.out.println("\n"+"---------LOGOUT OPERATION FINISHED-------");	
	Thread.sleep(5000);
	
	driver.quit();
	
}

@Test(priority=2,enabled=false)
public void coupon_100() throws InterruptedException
{
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	System.out.println("Pressing menu");
	//clicking menu button
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open']")).click();
	
	//clicking Movie button
	driver.findElement(By.xpath("//android.widget.TextView[@text='movie']")).click();
	
	
	Thread.sleep(22000);
	//scrolling Down
	Dimension dimensions = driver.manage().window().getSize();
						
	Double screenHeightStart = dimensions.getHeight() * 0.5;
	int scrollStart = screenHeightStart.intValue();			
	Double screenHeightEnd = dimensions.getHeight() * 0.1;
	int scrollEnd = screenHeightEnd.intValue();
	driver.swipe(0,scrollStart,0,scrollEnd,2000);
	System.out.println("Pressing FRIEND");
	
	//-------------------------------------------------------------------Webelement----------------------------------------------------------
	
	//clicking FRIEND content
	driver.findElement(By.xpath(copn_100_content)).click();
	
	//-------------------------------------------------------------------Webelement----------------------------------------------------------
	
	Thread.sleep(10000);
	
	
	//clicking play button 
	driver.findElement(By.id(appcls+":id/playButton")).click();
	
	Thread.sleep(40000);
	
	//putting coupon code
	driver.findElement(By.id(appcls+":id/couponCodeEditText")).sendKeys(coupn_100);
	driver.findElement(By.id(appcls+":id/addCouponButton")).click();
	
	//clicking next button after giving coupon code
	driver.findElement(By.id(appcls+":id/nextButton")).click();
	
	
	
	
}

@Test(priority=3,enabled=false)
public void coupon_50() throws InterruptedException
{
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	System.out.println("Pressing menu");
	//clicking menu button
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open']")).click();
	
	//clicking Movie button
	driver.findElement(By.xpath("//android.widget.TextView[@text='movie']")).click();
	
	
	Thread.sleep(22000);
	
	//-------------------------------------------------------------------Webelement----------------------------------------------------------
		
	//clicking 'testing Thirdparty Url' content
	driver.findElement(By.xpath(copn_50content)).click();
	
	
	//-------------------------------------------------------------------Webelement----------------------------------------------------------
	
	Thread.sleep(10000);
	
	//clicking play button 
	driver.findElement(By.id(appcls+":id/playButton")).click();
	
	Thread.sleep(40000);
	
	//putting coupon code
	driver.findElement(By.id(appcls+":id/couponCodeEditText")).sendKeys();
	driver.findElement(By.id(appcls+":id/addCouponButton")).click();
		
	//clicking next button after giving coupon code
	//driver.findElement(By.id("com.release.muvisdk:id/nextButton")).click();
	
	//scrolling Down
	Dimension dimensions = driver.manage().window().getSize();
							
	Double screenHeightStart = dimensions.getHeight() * 0.5;
	int scrollStart = screenHeightStart.intValue();			
	Double screenHeightEnd = dimensions.getHeight() * 0.1;
	int scrollEnd = screenHeightEnd.intValue();
	driver.swipe(0,scrollStart,0,scrollEnd,2000);
	
	//gIVING CARD DETAILS
	//giving card name
	driver.findElement(By.id(appcls+":id/nameOnCardEditText")).sendKeys("Scarlet");
		
	driver.hideKeyboard();
		
	//giving card number
	driver.findElement(By.id(appcls+":id/cardNumberEditText")).sendKeys("4111111111111111");
	
	driver.hideKeyboard();
		
	//clicking date drop down
	driver.findElement(By.xpath("//android.widget.TextView[@text='11']")).click();
	Thread.sleep(3000);
		
	driver.findElement(By.xpath("//android.widget.TextView[@index='5']")).click();
		
	Thread.sleep(3000);
		
	//clicking year drop down
	driver.findElement(By.xpath("//android.widget.TextView[@text='2017']")).click();
			
	//clicking delete content
	WebElement delete = driver.findElement(By.xpath("//android.widget.TextView[@text='click ok']"));
	boolean statusdlt = delete.isDisplayed();
	if(statusdlt)
	{
		try {
			
			driver.findElement(By.xpath("//android.widget.TextView[@text='yes']")).click();
			
		} catch (Exception e) {
			// TODO: handle exception
			driver.findElement(By.xpath("//android.widget.TextView[@text='cancel']")).click();
			System.out.println("There is now video in resume format.");
		}
	}
	else
	{
		driver.findElement(By.xpath("//android.widget.TextView[@text='delete all']"));
	}
	
	
	
	Thread.sleep(3000);
	//scrolling Down
	Dimension dimensions2 = driver.manage().window().getSize();
							
	Double screenHeightStart2 = dimensions.getHeight() * 0.5;
	int scrollStart2 = screenHeightStart.intValue();			
	Double screenHeightEnd2 = dimensions.getHeight() * 0.1;
	int scrollEnd2 = screenHeightEnd.intValue();
	driver.swipe(0,scrollStart,0,scrollEnd,2000);
					
	driver.findElement(By.xpath("//android.widget.TextView[@text='2030']")).click();
			
	Thread.sleep(2000);
			
	//clicking cvv button
	driver.findElement(By.id(appcls+":id/securityCodeEditText")).sendKeys("123");
			
	driver.hideKeyboard();
		
		
	//clicking pay now button
	driver.findElement(By.xpath("//android.widget.Button[@text='Pay Now']")).click();	
	
	

}


@Test(priority=4,enabled=false)
public void coupon_amnt_100() throws InterruptedException
{
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	System.out.println("Pressing menu");
	//clicking menu button
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open']")).click();
	
	//clicking Movie button
	driver.findElement(By.xpath("//android.widget.TextView[@text='movie']")).click();
	
	
	Thread.sleep(22000);
	
	//-------------------------------------------------------------------Webelement----------------------------------------------------------
	
	//clicking Test content
	driver.findElement(By.xpath(copn_100amnt_content)).click();
	
	//-------------------------------------------------------------------Webelement----------------------------------------------------------
	
    Thread.sleep(10000);
	
	//clicking play button 
	driver.findElement(By.id(appcls+":id/playButton")).click();
	
	Thread.sleep(20000);
	
	//putting coupon code
	driver.findElement(By.id(appcls+":id/couponCodeEditText")).sendKeys(copn_100amnt);
	driver.findElement(By.id(appcls+":id/addCouponButton")).click();
		
	//clicking next button after giving coupon code
	driver.findElement(By.id(appcls+":id/nextButton")).click();
		
	
	//checking vdo is playing or not by locating VDO name and duration
	WebElement VDOTITLE = driver.findElement(By.id(appcls+":id/videoTitle"));
	WebElement VDODURATION = driver.findElement(By.id(appcls+":id/videoDurationTextView"));
	
	if(VDOTITLE.isDisplayed() && VDODURATION.isDisplayed())
	{
		System.out.println("VDO is playing successfully");
	}
	
	
	
}


@Test(priority=5,enabled=false)
public void coupon_amnt_20() throws InterruptedException
{
	

	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	System.out.println("Pressing menu");
	
	//clicking menu button
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open']")).click();
	
	//clicking Movie button
	driver.findElement(By.xpath("//android.widget.TextView[@text='movie']")).click();
	
	Thread.sleep(22000);
	
	//scrolling Down
	System.out.println("Scrolling down");
	Dimension dimensions = driver.manage().window().getSize();
								
	Double screenHeightStart = dimensions.getHeight() * 0.5;
	int scrollStart = screenHeightStart.intValue();			
	Double screenHeightEnd = dimensions.getHeight() * 0.1;
	int scrollEnd = screenHeightEnd.intValue();
	driver.swipe(0,scrollStart,0,scrollEnd,2000);
	
	//-------------------------------------------------------------------Webelement----------------------------------------------------------
	
	//clicking on "Checking Ios" content
	driver.findElement(By.xpath(copn_20amnt_content)).click();
	
	//-------------------------------------------------------------------Webelement----------------------------------------------------------
	
	//clicking play button 
	driver.findElement(By.id(appcls+":id/playButton")).click();
	
	//clicking ok in unexpected popup
	try {
		
		driver.findElement(By.xpath("//android.widget.Button[@text='Ok']")).click();
		driver.findElement(By.id(appcls+":id/playButton")).click();
		
	} catch (Exception e) {
		// TODO: handle exception
	}
		
	
	Thread.sleep(20000);
		
	//putting coupon code
	driver.findElement(By.id(appcls+":id/couponCodeEditText")).sendKeys(copn_20amnt);
	driver.findElement(By.id(appcls+":id/addCouponButton")).click();
	
	System.out.println("-----Scrolling down for Card Payment for Rest amount-----");
	
	//scrolling Down
	Dimension dimensions1 = driver.manage().window().getSize();
								
	Double screenHeightStart1 = dimensions.getHeight() * 0.5;
	int scrollStart1 = screenHeightStart1.intValue();			
	Double screenHeightEnd1 = dimensions1.getHeight() * 0.1;
	int scrollEnd1 = screenHeightEnd1.intValue();
	driver.swipe(0,scrollStart1,0,scrollEnd1,2000);
		
	//gIVING CARD DETAILS
	//giving card name
	driver.findElement(By.id(appcls+":id/nameOnCardEditText")).sendKeys("Scarlet");
			
	driver.hideKeyboard();
			
	//giving card number
	driver.findElement(By.id(appcls+":id/cardNumberEditText")).sendKeys("4111111111111111");
			
	driver.hideKeyboard();
			
	//clicking date drop down
	driver.findElement(By.xpath("//android.widget.TextView[@text='11']")).click();
	Thread.sleep(3000);
			
	driver.findElement(By.xpath("//android.widget.TextView[@index='5']")).click();
			
	Thread.sleep(3000);
			
	//clicking year drop down
	driver.findElement(By.xpath("//android.widget.TextView[@text='2017']")).click();
				
	Thread.sleep(3000);
	//scrolling Down
	Dimension dimensions2 = driver.manage().window().getSize();
								
	Double screenHeightStart2 = dimensions.getHeight() * 0.5;
	int scrollStart2 = screenHeightStart.intValue();			
	Double screenHeightEnd2 = dimensions.getHeight() * 0.1;
	int scrollEnd2 = screenHeightEnd.intValue();
	driver.swipe(0,scrollStart,0,scrollEnd,2000);
						
	driver.findElement(By.xpath("//android.widget.TextView[@text='2030']")).click();
				
	Thread.sleep(2000);
				
	//clicking cvv button
	driver.findElement(By.id(appcls+":id/securityCodeEditText")).sendKeys("123");
				
	driver.hideKeyboard();
	
	//clicking pay now button
	driver.findElement(By.xpath("//android.widget.Button[@text='Pay Now']")).click();
	
	//Checking VDO is playing or not by validating VDO name and Duration
	WebElement VDOTITLE = driver.findElement(By.id(appcls+":id/videoTitle"));
	WebElement VDODURATION = driver.findElement(By.id(appcls+":id/videoDurationTextView"));
	
	if(VDOTITLE.isDisplayed() && VDODURATION.isDisplayed())
	{
		System.out.println("VDO is playing successfully");
	}
	

}

@Test(priority=6,enabled=false)
public void Voucher_Test() throws InterruptedException
{
	
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Thread.sleep(10000);
	System.out.println("Pressing menu");
	//clicking menu button
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open']")).click();
	
	//clicking Movie button
	driver.findElement(By.xpath("//android.widget.TextView[@text='movie']")).click();
	
	Thread.sleep(22000);
	
	//scrolling Down
	System.out.println("Scrolling down");
	Dimension dimensions = driver.manage().window().getSize();
								
	Double screenHeightStart = dimensions.getHeight() * 0.5;
	int scrollStart = screenHeightStart.intValue();			
	Double screenHeightEnd = dimensions.getHeight() * 0.1;
	int scrollEnd = screenHeightEnd.intValue();
	driver.swipe(0,scrollStart,0,scrollEnd,2000);
	Thread.sleep(10000);
	//scrolling Down again
	System.out.println("Scrolling down");
	Dimension dimensions1 = driver.manage().window().getSize();
									
	Double screenHeightStart1 = dimensions1.getHeight() * 0.5;
	int scrollStart1 = screenHeightStart1.intValue();			
	Double screenHeightEnd1 = dimensions1.getHeight() * 0.1;
	int scrollEnd1 = screenHeightEnd1.intValue();
	driver.swipe(0,scrollStart1,0,scrollEnd1,2000);
	
	
	//-------------------------------------------------------------------Webelement----------------------------------------------------------
	
	//clicking "test_IOS_casting" content
	driver.findElement(By.xpath(voucher_content)).click();
	
	//-------------------------------------------------------------------Webelement----------------------------------------------------------
	
	//clicking play button 
	driver.findElement(By.id(appcls+":id/playButton")).click();
	
	//clicking ok in unexpected popup
		try {
			
			driver.findElement(By.xpath("//android.widget.Button[@text='Ok']")).click();
			driver.findElement(By.id(appcls+":id/playButton")).click();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	//clicking vouchercode radio button
	driver.findElement(By.id(appcls+":id/voucherRadioButton")).click();
	
	//clicking voucher code text box
	driver.findElement(By.id(appcls+":id/voucher_code")).sendKeys(voucher_code);
	
	//clicking apply button
	driver.findElement(By.id(appcls+":id/apply")).click();
	
	Thread.sleep(5000);
	
	//clicking Watch now button
	driver.findElement(By.id(appcls+":id/watch_now")).click();
	
	//Checking VDO is playing or not by validating VDO name and Duration
	WebElement VDOTITLE = driver.findElement(By.id(appcls+":id/videoTitle"));
	WebElement VDODURATION = driver.findElement(By.id(appcls+":id/videoDurationTextView"));
		
	if(VDOTITLE.isDisplayed() && VDODURATION.isDisplayed())
	{
		System.out.println("VDO is playing successfully");
	}
	
}

@Test(priority=7,enabled=false)
public void Purchase_History() throws InterruptedException
{

	String ExpTitle = "Purchase History";
	String ExpTransactionDetail = "Transaction Details";
	//clicking submenu button
	driver.findElement(By.id(appcls+":id/submenu")).click();
	
	//clicking Purchase history button
	driver.findElement(By.xpath("//android.widget.TextView[@text='Purchase History']")).click();
	
	Thread.sleep(7000);
	
	WebElement PurchaseHistory = driver.findElement(By.id(appcls+":id/purchaseHistoryTitleTextView"));
	String ActualTitle = PurchaseHistory.getText();
	
	assertEquals(ActualTitle, ExpTitle, "Title is not Matching");
	
	//clicking on One Transaction
	driver.findElement(By.xpath(Trans_content)).click();
	
	//checking Transaction Details is showing or not
	WebElement TransactionDetail = driver.findElement(By.id(appcls+":id/transactionTitleTextView"));
	String ActualDetail = TransactionDetail.getText();
	
	assertEquals(ActualDetail, ExpTransactionDetail, "Transaction Title is not Matching");
	
	//clicking Download button
	driver.findElement(By.id(appcls+":id/transactionDownloadButton")).click();
	
	
}


@AfterMethod
public void closeApp()
{
	System.out.println("Method finished successfully");
	driver.quit();
}


}
