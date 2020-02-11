package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass
{


	public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
	
   public WebDriver Driver ;
    
    @BeforeTest
    public void startReport()
    {

    htmlReporter = new ExtentHtmlReporter("D:\\Report.html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);

            extent.setSystemInfo("OS", "Mac ");
            extent.setSystemInfo("Host Name", "test");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("User Name", "Krishna Sakinala");
    }
	
    @AfterMethod
    public void getResult(ITestResult result){

 if(result.getStatus() == ITestResult.SUCCESS) {

 logger.log(Status.PASS, "Test Case Passed " + result.getName());
 }

      if(result.getStatus() == ITestResult.FAILURE){

             logger.log(Status.FAIL, "Test Case Failed is"
 +result.getName() + result.getThrowable());
                //logger.log(LogStatus.FAIL, "Test Case Failed is
 //"+result.getThrowable());
    }
      else if(result.getStatus() == ITestResult.SKIP){

                logger.log(Status.SKIP, "Test Case Skipped is"
 +result.getName());
    }

 //extent.endTest(logger);
 }  



 @AfterSuite
   public void endReport(){

                  extent.flush();
                  //extent.close();
     }
	
	

	
	@Parameters({"browser","url"})
	@BeforeMethod
	public WebDriver LounchBrowser(String browser, String url )
	{
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		
			//System.setProperty("webdriver.Chrome.driver", "E:\\Selenium Testing\\Software\\selenium\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium Testing\\Software\\selenium\\chromedriver_win32\\chromedriver.exe");
			Driver=new ChromeDriver();
			Driver.get(url);
			Driver.manage().window().maximize();
		}
		
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "E:\\Selenium Testing\\Software\\selenium\\IEDriverServer_x64_2.53.1");
			Driver=new InternetExplorerDriver();
			Driver.get(url);
			Driver.manage().window().maximize();
			
		}
		return Driver;
		
	}
	@AfterTest
	public void CloseBrowser()
	{
		Driver.quit();
	}


}
