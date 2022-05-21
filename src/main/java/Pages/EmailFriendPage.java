package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase{
    public EmailFriendPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="FriendEmail")
    WebElement friendEmailBox;

    @FindBy(id="PersonalMessage")
    WebElement personalMessageBox;

    @FindBy(name = "send-email")
    WebElement sendEmailBtn;

    @FindBy(css = "div.result")
    WebElement resultMessage;
    public void sendAnEmail(String friendEmail, String message){
        setTextElement(friendEmailBox,friendEmail);
        setTextElement(personalMessageBox,message);
        clickButton(sendEmailBtn);
    }
    public String getResultMessageText()
    {
        return resultMessage.getText();
    }
}
