package Tests;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductTests extends TestBase{
    String productName="Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    @Test
    public void UserCanSearchForProduct(){
        searchObject=new SearchPage(driver);
        detailsObject=new ProductDetailsPage(driver);
        searchObject.productSearch(productName);
        Assert.assertTrue(detailsObject.productNameTxt.getText().equalsIgnoreCase("Apple MacBook Pro 13-inch"));
    }
}
