package KiteAppPOM_Pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPage {
	
	@FindBy(id="userid") private WebElement UserID;
	@FindBy(id="password") private WebElement PassWord;
	@FindBy(xpath="//button[@type='submit']") private WebElement loginbutton;
	@FindBy(xpath="//span[text()='Password should be minimum 6 characters.']") private WebElement Errormsg;
	
	public KiteLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void EnterUser(String UN1)
	{
		UserID.sendKeys(UN1);
	}
	public void EnterPass(String PASS)
	{
		PassWord.sendKeys(PASS);
	}
	public void ClickLoginButton()
	{
		loginbutton.click();
	}
	public String ErrorMsgValidate()
	{
		String actual = Errormsg.getText();
		return actual;
	
	}
}
