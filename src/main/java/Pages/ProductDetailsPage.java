package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (linkText = "Apple MacBook Pro 13-inch")
    public WebElement productNameTxt;
    @FindBy (css="span.price.actual-price")
    public  WebElement productPrice;
   /* public void productText(String productName){
      setTextElement(productNameTxt,productName);
    }*/
   @FindBy (linkText = "Add your review")
   WebElement addBtn;
    public void clickOnReviewBtn(){
        clickButton(addBtn);
    }
}
