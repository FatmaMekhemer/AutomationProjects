package Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class PageBase {

     static protected WebDriver driver;
     public JavascriptExecutor jse;
     public Select select;
    //constructor
    public PageBase(WebDriver driver){
        PageFactory.initElements(driver,this);
        PageBase.driver= driver;
    }
    protected void  clickButton(WebElement button){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(PageBase.driver)
                .withTimeout(Duration.ofSeconds(40L))
                .pollingEvery(Duration.ofSeconds(4L))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(ElementClickInterceptedException.class);
        wait.until(ExpectedConditions.elementToBeClickable(button));


        button.click();
    }
    protected static void setTextElement(WebElement textElement,String value){
        textElement.sendKeys(value);
    }
    public void scrollToBottom(){

        jse.executeScript("scrollBy(0,2500)");
    }

}
