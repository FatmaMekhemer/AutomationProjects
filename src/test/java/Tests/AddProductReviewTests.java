package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductReviewTests extends TestBase{
    HomePage homeObject;
    LoginPage loginObject;
    UserRegisterationPage registerationObject;
    String productName="Apple MacBook Pro 13-inch";

    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    AddProductReviewPage reviewObject;
    @Test(priority = 1)
    public void UserCanLogIn() {
        homeObject=new HomePage(driver);
        homeObject.openLogIn();
        loginObject = new LoginPage(driver);
        loginObject.logIn("fatmamekhemer999@hotmail.com", "01064481312");
        //Assert.assertTrue(registerationObject.logoutbtn.isDisplayed());
    }

    @Test(priority = 2)
    public void UserCanSearchForProduct(){
        searchObject=new SearchPage(driver);
        searchObject.productSearchUsingAutoSuggest("MacB");
        detailsObject=new ProductDetailsPage(driver);
        //Assert.assertTrue(detailsObject.productNameTxt.getText().equalsIgnoreCase(productName));
    }
    @Test(priority = 3)
    public void userCanAddReview(){
        reviewObject=new AddProductReviewPage(driver);
        detailsObject=new ProductDetailsPage(driver);
        detailsObject.clickOnReviewBtn();
        reviewObject.AddReview("Fatma","nice item");
        Assert.assertTrue(reviewObject.successMessage.getText().equalsIgnoreCase("Product review is successfully added."));

    }
    @Test(priority = 4)
    public void UserCanLogOut(){
        registerationObject=new UserRegisterationPage(driver);
        registerationObject.userLogOut();
    }
}
