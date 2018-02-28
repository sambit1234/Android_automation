package Test_11649;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Static_Page 
{
	
	/*
	 * click menu button
	 * verify all content inside it
	 * Click each content and verify thier page by their title
	 * 
	 * */
	private static AndroidDriver driver;
	private static String appcls = "com.release.leasy";
	private static String emailid="bruce1@gmail.com";
	private static String pwd ="123456";
	private static String menubutton = "//android.widget.ImageButton[@bounds='[0,72][168,240]']";
	private static String appname = "//android.widget.TextView[@text='Leasy']";
		
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
		
		System.out.println("Static page method started...");
	    Thread.sleep(20000);
	}
	
	@Test(priority=1,enabled=true)
	public void staticPage() throws MalformedURLException, InterruptedException
	{
    
    //clicking Menu button For getting Logo
    
	driver.findElement(By.xpath(menubutton)).click();
  	
  	System.out.println("-------Checking static page all contents-------");
  	
  	WebElement Hjem = driver.findElement(By.xpath("//android.widget.TextView[@text='Hjem']"));
  	boolean st1=Hjem.isDisplayed();
  	System.out.println("Hjem button is displaying "+st1);
  	
  	WebElement Comedy = driver.findElement(By.xpath("//android.widget.TextView[@text='Comedy']"));
  	boolean st2=Comedy.isDisplayed();
  	System.out.println("Comedy button is displaying "+st2);
  	
  	WebElement Action = driver.findElement(By.xpath("//android.widget.TextView[@text='Action']"));
  	boolean st3=Action.isDisplayed();
  	System.out.println("movie button is displaying "+st3);
  	
  	WebElement Drama = driver.findElement(By.xpath("//android.widget.TextView[@text='Drama']"));
  	boolean st4=Drama.isDisplayed();
  	System.out.println("Drama button is displaying "+st4);
  	
  	WebElement Family = driver.findElement(By.xpath("//android.widget.TextView[@text='Family']"));
  	boolean st5=Family.isDisplayed();
  	System.out.println("Family button is displaying "+st5);
  	
  	WebElement Thriller = driver.findElement(By.xpath("//android.widget.TextView[@text='Thriller']"));
  	boolean st6=Thriller.isDisplayed();
  	System.out.println("Thriller button is displaying "+st6);
  	
  	Dimension dimensions = driver.manage().window().getSize();
	
	Double screenHeightStart = dimensions.getHeight() * 0.5;
	int scrollStart = screenHeightStart.intValue();			
	Double screenHeightEnd = dimensions.getHeight() * 0.1;
	int scrollEnd = screenHeightEnd.intValue();
	driver.swipe(0,scrollStart,0,scrollEnd,2000);
  	
  	WebElement Musical = driver.findElement(By.xpath("//android.widget.TextView[@text='Musical']"));
  	boolean st7=Musical.isDisplayed();
  	System.out.println("Musical button is displaying "+st7);
  	
  	
  	WebElement About_Us = driver.findElement(By.xpath("//android.widget.TextView[@text='About Us']"));
  	boolean st8=About_Us.isDisplayed();
  	System.out.println("about_us button is displaying "+st8);
  	
  	WebElement terms_policy = driver.findElement(By.xpath("//android.widget.TextView[@text='Terms & Privacy Policy']"));
  	boolean st9=terms_policy.isDisplayed();
  	System.out.println("Terms Cond button is displaying "+st9);
  	
  	WebElement contact_us = driver.findElement(By.xpath("//android.widget.TextView[@text='Kontakt os']"));
  	boolean st10=contact_us.isDisplayed();
  	System.out.println("contact_us button is displaying "+st10);
  	
  	System.out.println("-----------Checking after clicking every button----------");
  	
	
	}
	
	
	//check title according to id not acc name
	//change xpath in every method , put id in xpath 
	@Test(priority=2,enabled=false)
	public void Hjem() throws InterruptedException 
	{
		//clicking Menu button again For getting home button
		driver.findElement(By.xpath(menubutton)).click();
		WebElement home = driver.findElement(By.xpath("//android.widget.TextView[@text='Hjem']"));
		home.click();
		Thread.sleep(4000);
		WebElement app = driver.findElement(By.xpath(appname));
		
	  	boolean st = app.isDisplayed();
	  	if(st) {
	  	System.out.println("After clicking home button, "+app.getText()+" is displaying "+st);
	  	}
	}
	
	@Test(priority=3,enabled=false)
	public void Comedy() throws InterruptedException
	{
		driver.findElement(By.xpath(menubutton)).click();
		WebElement comedy = driver.findElement(By.xpath("//android.widget.TextView[@bounds='[30,812][780,947]']"));
		//clicking Menu button again For getting tv button
		comedy.click();
		Thread.sleep(3000);
		WebElement page = driver.findElement(By.id(appcls+":id/categoryTitle"));
	  	boolean st = page.isDisplayed();
	  	if(st) {
	  	System.out.println("After clicking home button, "+page.getText()+" is displaying "+st);
	  	}
	  	
		
	}
	@Test(priority=4,enabled=false)
	public void action() throws InterruptedException
	{
		driver.findElement(By.xpath(menubutton)).click();
		WebElement action = driver.findElement(By.xpath("//android.widget.TextView[@bounds='[30,1084][780,1219]']"));
	    //clicking Menu button again For getting movie button
		action.click();
		Thread.sleep(3000);
		WebElement page = driver.findElement(By.id(appcls+":id/categoryTitle"));
	  	boolean st = page.isDisplayed();
	  	
	  	if(st) {
	  	System.out.println("After clicking action button, "+page.getText()+" is displaying "+st);
	  	}
	}
	
	@AfterMethod
	public void closeApp()
	{
		driver.quit();
	}
	
	@Test(priority=5,enabled=false)
	public void Drama()
	{
		driver.findElement(By.xpath(menubutton)).click();
		WebElement drama = driver.findElement(By.xpath("//android.widget.TextView[@bounds='[30,1220][780,1355]']"));
		//clicking Menu button again For getting tv button
		drama.click();
		WebElement page = driver.findElement(By.id(appcls+":id/categoryTitle"));
	  	boolean st = page.isDisplayed();
	  	if(st) {
	  	System.out.println("After clicking drama button, "+page.getText()+" is displaying "+st);
	  	}
		
	}
	
	@Test(priority=6,enabled=false)
	public void About_us() throws InterruptedException
	{
		
		
		//failing
		driver.findElement(By.xpath(menubutton)).click();
		Thread.sleep(3000);
		Dimension dimensions = driver.manage().window().getSize();
		
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();			
		Double screenHeightEnd = dimensions.getHeight() * 0.1;
		int scrollEnd = screenHeightEnd.intValue();
		driver.swipe(0,scrollStart,0,scrollEnd,2000);
		
		
		WebElement about_us = driver.findElement(By.xpath("//android.widget.TextView[@bounds='[30,1541][780,1676]']"));
		//clicking Menu button again For getting tv button
		about_us.click();
		WebElement page = driver.findElement(By.id(appcls+":id/categoryTitle"));
	  	boolean st = page.isDisplayed();
	  	if(st) {
	  	System.out.println("After clicking About_us button, "+page.getText()+" is displaying "+st);
	  	}
		
	}
	
	@Test(priority=7,enabled=false)
	public void TermsPage() throws InterruptedException
	{
		
		//failing
		driver.findElement(By.xpath(menubutton)).click();
		Thread.sleep(3000);
		Dimension dimensions = driver.manage().window().getSize();
		
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();			
		Double screenHeightEnd = dimensions.getHeight() * 0.1;
		int scrollEnd = screenHeightEnd.intValue();
		driver.swipe(0,scrollStart,0,scrollEnd,2000);
		
		WebElement terms_policy = driver.findElement(By.xpath("//android.widget.TextView[@bounds='[30,1677][780,1812]']"));
		//clicking Menu button again For getting tv button
		terms_policy.click();
		WebElement page = driver.findElement(By.id(appcls+":id/categoryTitle"));
	  	boolean st = page.isDisplayed();
	  	if(st) {
	  	System.out.println("After clicking TermsCondition button, "+page.getText()+" is displaying "+st);
	  	}
		
	}
	
	@Test(priority=8,enabled=false)
	public void Family()
	{
		driver.findElement(By.xpath(menubutton)).click();
		WebElement fam = driver.findElement(By.xpath("//android.widget.TextView[@text='Family']"));
		//clicking Menu button again For getting tv button
		fam.click();
		WebElement page = driver.findElement(By.id(appcls+":id/categoryTitle"));
	  	boolean st = page.isDisplayed();
	  	if(st) {
	  	System.out.println("After clicking Family button, "+page.getText()+" is displaying "+st);
	  	}
		
	}
	
	@Test(priority=9,enabled=false)
	public void Thriller()
	{
		driver.findElement(By.xpath(menubutton)).click();
		WebElement thriller = driver.findElement(By.xpath("//android.widget.TextView[@bounds='[30,946][780,1081]']"));
		//clicking Menu button again For getting tv button
		thriller.click();
		WebElement page = driver.findElement(By.id(appcls+":id/categoryTitle"));
	  	boolean st = page.isDisplayed();
	  	if(st) {
	  	System.out.println("After clicking Thriller button, "+page.getText()+" is displaying "+st);
	  	}
		
	}
	
	@Test(priority=10,enabled=false)
	public void Musical()
	{
		driver.findElement(By.xpath(menubutton)).click();
		WebElement musical = driver.findElement(By.xpath("//android.widget.TextView[@bounds='[30,1082][780,1217]']"));
		//clicking Menu button again For getting tv button
		musical.click();
		WebElement page = driver.findElement(By.id(appcls+":id/categoryTitle"));
	  	boolean st = page.isDisplayed();
	  	if(st) {
	  	System.out.println("After clicking Musical button, "+page.getText()+" is displaying "+st);
	  	}
		
	}
	
	@Test(priority=11,enabled=false)
	public void Contact() throws InterruptedException
	{
		driver.findElement(By.xpath(menubutton)).click();
		Thread.sleep(3000);
		Dimension dimensions = driver.manage().window().getSize();
		
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();			
		Double screenHeightEnd = dimensions.getHeight() * 0.1;
		int scrollEnd = screenHeightEnd.intValue();
		driver.swipe(0,scrollStart,0,scrollEnd,2000);
		
		WebElement contact = driver.findElement(By.xpath("//android.widget.TextView[@bounds='[30,1405][780,1540]']"));
		//clicking Menu button again For getting tv button
		contact.click();
		WebElement page = driver.findElement(By.id(appcls+":id/categoryTitle"));
	  	boolean st = page.isDisplayed();
	  	if(st) {
	  	System.out.println("After clicking Musical button, "+page.getText()+" is displaying "+st);
	  	}
		
	  	
	  	System.out.println("Static page method finished...");
	}
	

	
}
