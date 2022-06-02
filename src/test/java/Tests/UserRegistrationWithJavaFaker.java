package Tests;

import Data.JsonDataReader;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisterationPage;
import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserRegistrationWithJavaFaker extends TestBase{
    HomePage homeObject;
    UserRegisterationPage registerationObject;
    LoginPage loginObject;
    Faker fakeData=new Faker();
    String firstname=fakeData.name().firstName();
    String lastname=fakeData.name().lastName();
    String email=fakeData.internet().emailAddress();
    String password=fakeData.number().digits(8);

    @Test(priority = 1, alwaysRun = true)
    public void userCanRegisterSuccessfully() throws IOException, ParseException {
        homeObject = new HomePage(driver);
        homeObject.openRegistration();
        registerationObject = new UserRegisterationPage(driver);
        registerationObject.filluserRegisterationForm(firstname,lastname,email, password);
        Assert.assertTrue(registerationObject.sucessMessage.getText().contains("Your registration completed"));
        registerationObject.userLogOut();
        homeObject.openLogIn();
        loginObject = new LoginPage(driver);
        loginObject.logIn(email, password);
        Assert.assertTrue(registerationObject.logoutbtn.isDisplayed());
        registerationObject.userLogOut();


    }
}
