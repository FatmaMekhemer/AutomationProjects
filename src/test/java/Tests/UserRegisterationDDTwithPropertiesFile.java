package Tests;

import Data.LoadProperties;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisterationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegisterationDDTwithPropertiesFile extends TestBase{
    HomePage homeObject;
    UserRegisterationPage registerationObject;
    LoginPage loginObject;
    String fn= LoadProperties.userData.getProperty("firstname");
    String ln= LoadProperties.userData.getProperty("lastname");
    String email= LoadProperties.userData.getProperty("email");
    String pass= LoadProperties.userData.getProperty("password");

    @Test(priority = 1,alwaysRun = true)
    public void userCanRegisterSuccessfully(){
        homeObject=new HomePage(driver);
        homeObject.openRegistration();
        registerationObject=new UserRegisterationPage(driver);
        registerationObject.filluserRegisterationForm(fn,ln,email,pass);
        Assert.assertTrue(registerationObject.sucessMessage.getText().contains("Your registration completed"));

    }
    @Test(dependsOnMethods = {"userCanRegisterSuccessfully"})
    public void UserCanLogOut(){
        registerationObject.userLogOut();
    }
    @Test(dependsOnMethods = {"UserCanLogOut"})
    public void UserCanLogIn(){
        homeObject.openLogIn();
        loginObject=new LoginPage(driver);
        loginObject.logIn(email,pass);
        Assert.assertTrue(registerationObject.logoutbtn.isDisplayed());

    }
}
