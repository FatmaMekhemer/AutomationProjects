package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisterationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegistrationTest extends TestBase{
    HomePage homeObject;
    UserRegisterationPage registerationObject;
    LoginPage loginObject;
    @Test(priority = 1,alwaysRun = true)
    public void userCanRegisterSuccessfully(){
        homeObject=new HomePage(driver);
        homeObject.openRegistration();
        registerationObject=new UserRegisterationPage(driver);
      registerationObject.filluserRegisterationForm("Fatma","Mekhemer","fatimamekhemeer99911111@hotmail.com","01064481312");
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
        loginObject.logIn("fatimamekhemeer09999911111@hotmail.com","01064481312");
        Assert.assertTrue(registerationObject.logoutbtn.isDisplayed());

    }



}
