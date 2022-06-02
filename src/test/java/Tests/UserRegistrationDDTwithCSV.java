package Tests;

import Data.ExcelReader;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisterationPage;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserRegistrationDDTwithCSV extends TestBase {
    HomePage homeObject;
    UserRegisterationPage registerationObject;
    LoginPage loginObject;
    CSVReader reader;


    @Test(priority = 1, alwaysRun = true)
    public void userCanRegisterSuccessfully() throws IOException, CsvValidationException {
        String csv_path= System.getProperty("user.dir")+"/src/test/java/Data/user_Data_CSV.csv";
        reader=new CSVReader(new FileReader(csv_path));
        String [] csvCell;
        while((csvCell=reader.readNext())!=null) {
            String fn = csvCell[0];
            String ln = csvCell[1];
            String email = csvCell[2];
            String pass = csvCell[3];
            homeObject = new HomePage(driver);
            homeObject.openRegistration();
            registerationObject = new UserRegisterationPage(driver);
            registerationObject.filluserRegisterationForm(fn, ln, email, pass);
            Assert.assertTrue(registerationObject.sucessMessage.getText().contains("Your registration completed"));
            registerationObject.userLogOut();
            homeObject.openLogIn();
            loginObject = new LoginPage(driver);
            loginObject.logIn(email, pass);
            Assert.assertTrue(registerationObject.logoutbtn.isDisplayed());
            registerationObject.userLogOut();
        }
    }
}