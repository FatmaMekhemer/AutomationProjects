package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductReviewPage extends PageBase{
    public AddProductReviewPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="input.review-title")
    WebElement reviewTitleTxtBox;
    @FindBy(id="AddProductReview_ReviewText")
    WebElement reviewTxtBox;
    @FindBy(id="addproductrating_4")
    WebElement ratingRadioBtn;
    @FindBy(css="button.button-1.write-product-review-button")
    WebElement submitBtn;
    @FindBy(css="div.result")
    public WebElement successMessage;

    public void AddReview(String rTitle,String txtReview){

        setTextElement(reviewTitleTxtBox,rTitle);
        setTextElement(reviewTxtBox,txtReview);
        clickButton(ratingRadioBtn);
       // scrollToBottom();

        clickButton(submitBtn);
    }

}
