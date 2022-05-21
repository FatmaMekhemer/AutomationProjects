package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegisterationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends TestBase{
    HomePage homeObject;
    UserRegisterationPage registerationObject;
    MyAccountPage myaccObject;
    LoginPage loginObject;
    @Test(priority = 1,alwaysRun = true)
    public void userCanRegisterSuccessfully(){
        homeObject=new HomePage(driver);
        homeObject.openRegistration();
        registerationObject=new UserRegisterationPage(driver);
        registerationObject.filluserRegisterationForm("Fatma","Mekhemer","afaftimamekhemeer11111@hotmail.com","01064481312");
        Assert.assertTrue(registerationObject.sucessMessage.getText().contains("Your registration completed"));

    }
    @Test (priority = 2)
    public void RegisteredUserCanChangePassword(){
        registerationObject.MyAccount();
        myaccObject=new MyAccountPage(driver);
        myaccObject.OpenChangePasswordPage();
        myaccObject.UserChangePassword("01064481312","010644813122");
        Assert.assertTrue(myaccObject.resultMsg.getText().contains("Password was changed"));
        //myaccObject.xBtn.click();



    }
    @Test(priority = 3)
    public void UserCanLogOut(){
        registerationObject.userLogOut();
    }
    @Test(priority = 4)
    public void UserCanLogIn(){
        homeObject.openLogIn();
        loginObject=new LoginPage(driver);
        loginObject.logIn("afaftimamekhemeer11111@hotmail.com","010644813122");
        Assert.assertTrue(registerationObject.logoutbtn.isDisplayed());

    }
}
