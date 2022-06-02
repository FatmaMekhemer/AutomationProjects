package Steps;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisterationPage;
import Tests.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UserRegisteration extends TestBase {
    HomePage homeObject;
    UserRegisterationPage registerationObject;

    @Given("user is in the home page")
    public void user_is_in_the_home_page()  {
        homeObject=new HomePage(driver);
        homeObject.openRegistration();
    }

    @When("I click on the register Link")
    public void i_click_on_the_register_Link() {
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));

    }

    @When("fill in the required data")
    public void fill_in_the_required_data()  {
        registerationObject=new UserRegisterationPage(driver);
        registerationObject.filluserRegisterationForm("hii","hii","hi@gmail.com","12345678");
    }

    @Then("The registration page is displayed successfully")
    public void the_registration_page_is_displayed_successfully() {
        Assert.assertTrue(registerationObject.sucessMessage.getText().contains("Your registration completed"));

    }

}
