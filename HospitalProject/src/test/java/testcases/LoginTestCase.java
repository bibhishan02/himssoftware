package testcases;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.LoginPage;
import utility.BaseClass;

public class LoginTestCase extends BaseClass 
{

	@Test(description="Login Page Sucesfully")
	public void tc01() throws InterruptedException
	{
		logger= extent.createTest("tc01");
		LoginPage obj= new LoginPage(Driver);
	//	LoginPage obj=new LoginPage(Driver);
		logger.log(Status.INFO, "Open the Hr Software");
		obj.HIMSLoginPage("admin","admin");
		logger.log(Status.INFO, "Login Sucessfull");
		boolean res=obj.IsDashbordLogin();
		Assert.assertTrue(res);
		logger.log(Status.INFO, "HRM Software Login Sucessfull");
	}
	

}
