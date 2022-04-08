package KiteAppPOM_Pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage {

	@FindBy(xpath="//span[@class='user-id']") private WebElement userID1;
	@FindBy(xpath="//a[@target='_self']") private WebElement LogoutButton;
	
	
	public KiteHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public String ValidateID()
	{
		String actual = userID1.getText();
		return actual;
		
	}
	public void enterLogoutButton() throws InterruptedException
	{
		userID1.click();
		Thread.sleep(3000);
		LogoutButton.click();
	}
}
