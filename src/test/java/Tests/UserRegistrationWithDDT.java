package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisterationPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import static Tests.TestBase.driver;

public class UserRegistrationWithDDT extends TestBase {
    HomePage homeObject;
    UserRegisterationPage registerationObject;
    LoginPage loginObject;

     @DataProvider(name = "testData")
     public static Object[][]userData(){
         return new Object[][]{
                 {"Fatma", "Mekhemer", "fatmamekhemer9999999@hotmail.com", "01064481312"},
                 {"Rawan","Ehab","rawan@ttest.com","01111243498"}
         };
     }

    @Test(priority = 1, alwaysRun = true,dataProvider = "testData")
    public void userCanRegisterSuccessfully(String fname,String lname,String email,String password) {
        homeObject = new HomePage(driver);
        homeObject.openRegistration();
        registerationObject = new UserRegisterationPage(driver);
        registerationObject.filluserRegisterationForm(fname, lname, email, password);
        Assert.assertTrue(registerationObject.sucessMessage.getText().contains("Your registration completed"));
        registerationObject.userLogOut();
        homeObject.openLogIn();
        loginObject = new LoginPage(driver);
        loginObject.logIn(email, password);
        Assert.assertTrue(registerationObject.logoutbtn.isDisplayed());
        registerationObject.userLogOut();


    }


}
