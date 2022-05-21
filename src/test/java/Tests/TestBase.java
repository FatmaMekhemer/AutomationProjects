package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utility.Helper;

import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
            driver=new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
            driver=new FirefoxDriver();

        }

      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
      driver.navigate().to("http://demo.nopcommerce.com/");
    }
    @AfterSuite
    public void stopDriver()
    {
        driver.quit();
    }
    @AfterMethod
    public void screenshotOnFailure(ITestResult result){
        if(result.getStatus()==ITestResult.FAILURE)
        {
            System.out.println("Failed!");
            System.out.println("Taking screenshot....");
            Helper.captureScreenshot(driver,result.getName());
        }

    }
}
