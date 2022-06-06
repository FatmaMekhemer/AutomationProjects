package Steps;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisterationPage;
import Tests.TestBase;

import Tests.TestBaseCucumber;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class UserRegisteration  {
    HomePage homeObject;
    UserRegisterationPage registerationObject;

    public static WebDriver driver;
    String browserName="chrome";
    @Before

    public void startDriver( ){
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
    @After
    public void stopDriver()
    {
        driver.quit();
    }

    @Given("user is in the home page")
    public void user_is_in_the_home_page() {
        homeObject = new HomePage(driver);
        homeObject.openRegistration();
    }

    @When("I click on the register Link")
    public void i_click_on_the_register_Link() {
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));

    }

   /* @And("fill in the required data which are {string},{string}<lastname>{string}<email>{string}<password>\"")
    public void fill_in_the_required_data(String firstname, String lastname, String email, String password) {
        registerationObject = new UserRegisterationPage(driver);
        registerationObject.filluserRegisterationForm(firstname, lastname, email, password);
    }*/
   @And("fill in the required data which are {string} and {string} and {string} and {string}")
   public void fillInTheRequiredDataWhichAreLastnameEmailPassword(String firstname, String lastname, String email, String password)  {
       registerationObject = new UserRegisterationPage(driver);
       registerationObject.filluserRegisterationForm(firstname, lastname, email, password);
   }

    @Then("The registration page is displayed successfully")
    public void the_registration_page_is_displayed_successfully() {
        Assert.assertTrue(registerationObject.sucessMessage.getText().contains("Your registration completed"));

    }




}