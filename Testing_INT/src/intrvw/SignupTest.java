package intrvw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignupTest 
{

	WebDriver driver;

	@BeforeClass
	public void openBrowser()
	{
		
		
		String driverPath = "F:/lib/chromedriver/";
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver(); 
		
		String driverPath1 = "F:/lib/iedriver/";
		System.setProperty("webdriver.ie.driver", driverPath+"iedriver.exe");
		driver = new InternetExplorerDriver();
		
		
		System.setProperty("webdriver.gecko.driver", "D:\\driver\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void SignupTest()
	{
		driver.get("https://www.muvi.com/signup");
		
		driver.findElement(By.id("name")).sendKeys("Chandu");
		driver.findElement(By.id("companyname")).sendKeys("Muvii");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("7437018992");
		driver.findElement(By.id("email")).sendKeys("tech.chandu@yahoo.com");
		driver.findElement(By.id("inputPassword")).sendKeys("chandu@32151me!");
		driver.findElement(By.xpath("//input[@id='subdomain']")).sendKeys("QA Engineer");

		driver.findElement(By.xpath("//input[@name='terms']")).click();
		driver.findElement(By.xpath("//button[@id='nextbtn']")).click();
		driver.findElement(By.id("nextbtn")).click();
		String Title = driver.getTitle();
		System.out.println(Title);
		
		
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
}
