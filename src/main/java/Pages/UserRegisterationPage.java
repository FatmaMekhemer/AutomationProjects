package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends  PageBase{
    public UserRegisterationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gender-male")
    WebElement radioBtn;

    @FindBy(id = "FirstName")
    WebElement fnTxtBox;

    @FindBy(id = "LastName")
    WebElement lnTxtBox;

    @FindBy(id = "Email")
    WebElement emailTxtBox;

    @FindBy(id = "Password")
    WebElement passwordTxtBox;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordTxtBox;

    @FindBy(id = "register-button")
    WebElement registerButton;
    @FindBy (css="div.result")
    public WebElement sucessMessage;
    @FindBy(linkText = "Log out")
   public WebElement logoutbtn;
    @FindBy(linkText = "My account")
    WebElement myAccountbtn;
   public void filluserRegisterationForm(String firstName,String lastName,String email,String password){
       clickButton(radioBtn);
        setTextElement(fnTxtBox,firstName);
        setTextElement(lnTxtBox,lastName);
        setTextElement(emailTxtBox,email);
        setTextElement(passwordTxtBox,password);
        setTextElement(confirmPasswordTxtBox,password);
        clickButton(registerButton);
   }
   public void userLogOut(){
       clickButton(logoutbtn);
   }
   public void MyAccount(){
       clickButton(myAccountbtn);
   }



}
