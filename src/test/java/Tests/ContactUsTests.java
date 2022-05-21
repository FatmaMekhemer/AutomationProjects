package Tests;


import Pages.ContactUsPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTests extends TestBase{
    String fullname="Maha Radwa";
    String email="test@test.com";
    String enquiry="7asbya allah wi ne3m el wakel";
    HomePage homeObject;
    ContactUsPage contacUsObject;
    @Test
    public void userCanTestContactUs(){
        homeObject=new HomePage(driver);
        contacUsObject=new ContactUsPage(driver);
        homeObject.openContactUs();
        contacUsObject.UserWriteInContactUs(fullname,email,enquiry);
        Assert.assertTrue(contacUsObject.successMsg.getText().contains("Your enquiry has been successfully sent to the store owner."));
    }

}

