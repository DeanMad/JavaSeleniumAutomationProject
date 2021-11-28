package Hackathon.PageObject.Web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {


    @FindBy(xpath = "//input[@name='user']")
    private WebElement username_input_field;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password_input_field;

    @FindBy(xpath = "//button[@aria-label='Login button']")
    private WebElement login_btn;

    public void setUsername(String username) {
        username_input_field.sendKeys(username);
    }

    public void setPassword(String password) {
        password_input_field.sendKeys(password);
    }

    public void submit() {
        login_btn.click();
    }
}
