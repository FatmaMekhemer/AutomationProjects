package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends PageBase{
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (id="small-searchterms")
    WebElement searchTxtBox;
    @FindBy(css = "button.button-1.search-box-button")
    WebElement searchBtn;
    @FindBy(id="ui-id-1")
    List<WebElement> searchResults;
    public void productSearch(String productName){
        setTextElement(searchTxtBox,productName);
        clickButton(searchBtn);
    }
    public void productSearchUsingAutoSuggest(String searchTxt){
        setTextElement(searchTxtBox,searchTxt);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        searchResults.get(0).click();
    }
}
