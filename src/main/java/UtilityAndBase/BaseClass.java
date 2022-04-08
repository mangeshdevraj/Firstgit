package UtilityAndBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

public class BaseClass {
	
	protected WebDriver driver;
	
	public void launchBrowser()
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mvkol\\Desktop\\Software Testing\\Yogendra sir java\\Selenium - Copy\\Selenium\\chromedriver_win32\\chromedriver_win32 (1)\\chromedriver.exe");
		
		ChromeOptions opt=new ChromeOptions();       
		opt.addArguments("--disable-notifications");                
		 
	    driver= new ChromeDriver(opt);

		driver.get("https://kite.zerodha.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		Reporter.log("Browser lauched successfully", true);
		 
	}
	
	public void closeBrowser()
	{
		driver.close();
	}

	
}
