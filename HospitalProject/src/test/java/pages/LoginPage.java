package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class LoginPage extends BaseClass
{

	@FindBy(id="Txtuserid")
	WebElement user_id;
	
	@FindBy(id="txtPass")
	WebElement password;
	
	@FindBy(id="thoughtbot")
	WebElement btnlogin;

	@FindBy(xpath="//*[@id='container']/header/a/b")
	WebElement dashbord;

	public LoginPage(WebDriver driver)
	{
		this.Driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void HIMSLoginPage(String userid, String pass ) throws InterruptedException
	{
		user_id.sendKeys(userid);
		password.sendKeys(pass);
		Thread.sleep(5000);
		btnlogin.click();
		
	}
	public boolean IsDashbordLogin()
	{
		if(dashbord.getText().equals("dashbord"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
