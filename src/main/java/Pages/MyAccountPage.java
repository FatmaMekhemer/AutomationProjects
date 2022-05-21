package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Change password")
    WebElement changePasswordLink;

    @FindBy(id = "OldPassword")
    WebElement oldpasswordTxt;

    @FindBy (id="NewPassword")
    WebElement newpasswordTxt;

    @FindBy(id="ConfirmNewPassword")
    WebElement confirmPasswordTxt;
    @FindBy(css="button.button-1.change-password-button")
    WebElement changePasswordBtn;
    @FindBy(css="span.close")
    public WebElement xBtn;

    @FindBy(css="p.content")
    public WebElement resultMsg;
    public void OpenChangePasswordPage(){
        clickButton(changePasswordLink);
    }

    public void UserChangePassword(String password,String newpassword){
        setTextElement(oldpasswordTxt,password);
        setTextElement(newpasswordTxt,newpassword);
        setTextElement(confirmPasswordTxt,newpassword);
        clickButton(changePasswordBtn);
    }
    public void clickOnXbtn(){
        clickButton(xBtn);
    }
}
