package Tests;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeCurrenyTests extends TestBase{
    HomePage homeObj;
    ProductDetailsPage productObj;
    SearchPage searchObj;
    @Test(priority = 2)
    public void UserCanSearchForProduct(){
        searchObj=new SearchPage(driver);
        searchObj.productSearchUsingAutoSuggest("MacB");
        productObj=new ProductDetailsPage(driver);
        //  Assert.assertTrue(detailsObject.productNameTxt.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(productObj.productPrice.getText().contains("€"));
    }
    @Test(priority = 1)
    public void UserCanCHangeCurrency(){
        homeObj=new HomePage(driver);
        homeObj.changeCurrency();
    }
}
