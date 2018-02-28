package Mob_test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.appium.java_client.android.AndroidDriver;

public class Screnshot 
{

	public static AndroidDriver driver;
	public void takescreenshot()
	{
		EventFiringWebDriver ed = new EventFiringWebDriver(driver);
    	File src = ed.getScreenshotAs(OutputType.FILE);
    	File dst = new File("D:\\Screenshots\\Demo_Sapphire_06Nov\\Sapphire.png");
    	try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		
		Screnshot v = new Screnshot();
	}

}
