package Tests;

import Data.ExcelReader;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisterationPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserRegistrationDDTwithExcel extends TestBase {
    HomePage homeObject;
    UserRegisterationPage registerationObject;
    LoginPage loginObject;

    @DataProvider(name = "ExcelData")
    public Object [][]userRegisterData(){
        ExcelReader ex=new ExcelReader();
        return ex.getExcelData();
    }
    @Test(priority = 1, alwaysRun = true,dataProvider = "ExcelData")
    public void userCanRegisterSuccessfully(String fn,String ln,String email ,String pass ) {
        homeObject = new HomePage(driver);
        homeObject.openRegistration();
        registerationObject = new UserRegisterationPage(driver);
        registerationObject.filluserRegisterationForm(fn, ln, email,pass );
        Assert.assertTrue(registerationObject.sucessMessage.getText().contains("Your registration completed"));
        registerationObject.userLogOut();
        homeObject.openLogIn();
        loginObject = new LoginPage(driver);
        loginObject.logIn(email, pass);
        Assert.assertTrue(registerationObject.logoutbtn.isDisplayed());
        registerationObject.userLogOut();



}




}
