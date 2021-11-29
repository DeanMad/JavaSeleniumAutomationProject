package pageObject.WebGrafana;

import Utilities.UIActions;
import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage {

    @FindBy(xpath = "//*[@id='reactRoot']/div/nav/div[2]/div[7]/a")
    private WebElement btn_users;

    @FindBy(xpath = "//a[@class='css-aja5tg-button']")
    private WebElement btn_createUserMenu;


    @FindBy(xpath = "//input[@name='name']")
    private WebElement name_input_field;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement email_input_field;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement username_input_field;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password_input_field;

    @FindBy(xpath = "//button[@class='css-aja5tg-button']")
    private WebElement btn_submit;

    @FindBy(xpath = "//table/tbody/tr/td[2]/a")
    private List<WebElement> users_list;

    @FindBy(css = "div>button.css-1r3qgdo-button")
    private WebElement btn_delete;

    @FindBy(css = "div.css-1pvl9up-layoutChildrenWrapper>button.css-1r3qgdo-button")
    private WebElement btn_deleteConfirmation;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement usersSearchField;

    @FindBy(xpath = "//label[text()='Light']")
    private WebElement btn_lightMood;


    @Step("Navigate to users page")
    public void usersMenu() {
        UIActions.click(btn_users);
    }

    @Step("Navigate to create user form")
    public void createUser(String name, String email, String username, String password) {
        UIActions.click(btn_createUserMenu);
        UIActions.updateText(name_input_field, name);
        UIActions.updateText(email_input_field, email);
        UIActions.updateText(username_input_field, username);
        UIActions.updateText(password_input_field, password);
        UIActions.click(btn_submit);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);

    }

    @Step("Search for a user")
    public void search(String username) {
        UIActions.updateText(usersSearchField, username);
    }


    @Step("check if a given username is inside the list")
    public boolean contains(String username) {
        return UIActions.contains(username, users_list);
    }

    @Step("Delete a user")
    public void deleteUser(String userName) {
        UIActions.deleteUser(userName, users_list, btn_delete, btn_deleteConfirmation);
    }

    @Step ("Get the size of user's list")
    public int getListSize() {
        return users_list.size();
    }

    @Step ("Check the status of light mode button")
    public boolean clickedButtonStatus() {
        return UIActions.clickedButtonStatus(btn_lightMood, "for", "option-light-radiogroup-2");
    }
}
