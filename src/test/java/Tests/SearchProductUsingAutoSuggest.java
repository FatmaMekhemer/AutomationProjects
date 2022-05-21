package Tests;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductUsingAutoSuggest extends TestBase{
    String productName="Apple MacBook Pro 13-inch";

    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    @Test
    public void UserCanSearchForProduct(){
        searchObject=new SearchPage(driver);
        searchObject.productSearchUsingAutoSuggest("MacB");
        detailsObject=new ProductDetailsPage(driver);
      //  Assert.assertTrue(detailsObject.productNameTxt.getText().equalsIgnoreCase(productName));
    }
}
