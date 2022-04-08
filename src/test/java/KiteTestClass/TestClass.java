package KiteTestClass;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import KiteAppPOM_Pack.KiteHomePage;
import KiteAppPOM_Pack.KiteLoginPage;
import KiteAppPOM_Pack.KitePinPage;
import UtilityAndBase.BaseClass;
import UtilityAndBase.Utility;


public class TestClass extends BaseClass 
{
	KiteLoginPage login ;
	KitePinPage pin;
	KiteHomePage home;
	
  @BeforeClass
  public void LaunchBrowser1() {
	  
	  launchBrowser();
	  login =new KiteLoginPage(driver);
	  pin=new KitePinPage(driver);
	  home=new KiteHomePage(driver);
	
  }
  
  @BeforeMethod
  public void LoginKiteApp() throws EncryptedDocumentException, IOException
  {
	  login.EnterUser(Utility.readDataFromExcel(0, 0));
	  login.EnterPass(Utility.readDataFromExcel(0, 1));
	  login.ClickLoginButton();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
	  
	  pin.enterPin(Utility.readDataFromExcel(0, 2));
	  pin.enterContinueButtton();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
	  
  }
  @Test
  public void ValidateKiteID() throws EncryptedDocumentException, IOException
  {
	 String expected = Utility.readDataFromExcel(0, 0);
	 String actual = home.ValidateID();
	 Assert.assertEquals(actual, expected, "actual and exp not match");
	 Utility.takeScreenShoot(driver, 12);
	 Reporter.log("validate userID ", true);
	 
  }
  @AfterMethod
  public void logoutKite() throws InterruptedException
  {
	  home.enterLogoutButton();
  }
  @AfterClass
  public void closeBrowser1()
  {
	 closeBrowser();
  }
  
}
