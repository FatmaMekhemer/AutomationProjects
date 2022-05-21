package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailFriendTests extends TestBase{
    HomePage homeObj;
    UserRegisterationPage registerationObj;
    SearchPage searchObj;
   // SearchProductUsingAutoSuggest searchResultObj;
    ProductDetailsPage productDerailsObj;
    EmailFriendPage emailFriendObj;

    String mail = "ozoo@sad.com";
    String oldpass = "1234567";
    String productName = "Apple MacBook Pro 13-inch";
    String friendMail="saad@saad.com";
   String search="MacB";

    @Test(priority = 1, alwaysRun = true)
    public void UserRegisterSuccessfully() {
        homeObj = new HomePage(driver);
        homeObj.openRegistration();
        registerationObj = new UserRegisterationPage(driver);
        registerationObj.filluserRegisterationForm("Saad", "Hamdy", mail, oldpass);
        Assert.assertEquals(registerationObj.sucessMessage.getText(), "Your registration completed");
    }



    @Test (dependsOnMethods = "UserRegisterSuccessfully")
    public void UserCanSearchProduct() {
        searchObj = new SearchPage(driver);
        searchObj.productSearch(productName);

        searchObj.productSearchUsingAutoSuggest(search);
        productDerailsObj = new ProductDetailsPage(driver);

        Assert.assertEquals(productDerailsObj.productNameTxt.getText(), productName);
    }


    @Test (dependsOnMethods = "UserCanSearchProduct")
    public void UserCanSendMailToFriend()
    {
        emailFriendObj=new EmailFriendPage(driver);
      //  productDerailsObj.;
        emailFriendObj.sendAnEmail(friendMail,productName);
        Assert.assertEquals(emailFriendObj.getResultMessageText()
                ,"Your message has been sent.");

    }

    @Test(dependsOnMethods = {"UserCanSendMailToFriend"})
    public void UserCanLogout()
    {
     //   registerationObj;
    }


}
