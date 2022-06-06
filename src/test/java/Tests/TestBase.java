package Tests;

import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utility.Helper;

import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

public class TestBase  {
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
        else if(browserName.equalsIgnoreCase("headless")){
            DesiredCapabilities caps=new DesiredCapabilities();
            caps.setJavascriptEnabled(true);
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                    System.getProperty("user.dir")+"/Drivers/phantomjs.exe");
            String []phantomJSArgs={"--web-security=no","--ignore-ssl-errors=yes"};
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,phantomJSArgs);

            driver=new PhantomJSDriver(caps);
        }
        else if(browserName.equalsIgnoreCase("chrome-headless"))
        {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
            ChromeOptions options= new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            driver=new ChromeDriver(options);
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
