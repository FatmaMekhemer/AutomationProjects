package Tests;

import Data.JsonDataReader;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisterationPage;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserRegistrationwithDDT_JSON extends TestBase{
    HomePage homeObject;
    UserRegisterationPage registerationObject;
    LoginPage loginObject;
    @Test(priority = 1, alwaysRun = true)
    public void userCanRegisterSuccessfully() throws IOException, ParseException {
        JsonDataReader jsonReader=new JsonDataReader();
        homeObject = new HomePage(driver);
        homeObject.openRegistration();
        registerationObject = new UserRegisterationPage(driver);
        registerationObject.filluserRegisterationForm(jsonReader.firstname,jsonReader.lastname,jsonReader.email, jsonReader.password);
        Assert.assertTrue(registerationObject.sucessMessage.getText().contains("Your registration completed"));
        registerationObject.userLogOut();
        homeObject.openLogIn();
        loginObject = new LoginPage(driver);
        loginObject.logIn(jsonReader.email, jsonReader.password);
        Assert.assertTrue(registerationObject.logoutbtn.isDisplayed());
        registerationObject.userLogOut();


    }
}
