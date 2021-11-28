package Hackathon.PageObject.Web;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class GrafanaPage {

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


    @Step("Navigate to users page")
    public void usersMenu() {
        btn_users.click();
    }
    @Step("Navigate to create user form")
    public void createUser(String name, String email, String username, String password) {
        btn_createUserMenu.click();
        name_input_field.sendKeys(name);
        email_input_field.sendKeys(email);
        username_input_field.sendKeys(username);
        password_input_field.sendKeys(password);
        btn_submit.click();
    }

    @Step("Get List of Users")
    public List<String> getUsersList() {
        List<String> users = new ArrayList<>();
        for (WebElement user : users_list) {
            users.add(user.getText());
        }
        return users;
    }


}
