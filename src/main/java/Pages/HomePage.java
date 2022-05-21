package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
        jse=(JavascriptExecutor) driver;
    }
    @FindBy(linkText = "Register")
    WebElement registerLink;
    @FindBy(linkText = "Log in")
    WebElement loginLink;
    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;
    @FindBy(id="customerCurrency")
    WebElement custCurrDrl;
    public void openRegistration(){
        clickButton(registerLink);
    }

    public void openLogIn(){
        clickButton(loginLink);
    }
    public void openContactUs(){
        scrollToBottom();
        clickButton(contactUsLink);}
    public void changeCurrency()
    {
      select=new Select(custCurrDrl);
      select.selectByVisibleText("Euro");

    }
}
