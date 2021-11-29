package pageObject.WebGrafana;

import Utilities.UIActions;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    @FindBy(xpath = "//input[@name='user']")
    private WebElement username_input_field;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password_input_field;

    @FindBy(xpath = "//button[@aria-label='Login button']")
    private WebElement login_btn;

    public void setUsername(String username) {
        UIActions.updateText(username_input_field, username);
    }


    public void setPassword(String password) {
        UIActions.updateText(password_input_field, password);
    }

    public void submit() {
        UIActions.click(login_btn);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }
}
