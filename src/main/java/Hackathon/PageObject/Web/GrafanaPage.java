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

    @FindBy(css = "div>button.css-1r3qgdo-button")
    WebElement btn_delete;

    @FindBy(css = "div.css-1pvl9up-layoutChildrenWrapper>button.css-1r3qgdo-button")
    WebElement btn_deleteConfirmation;


    @Step("Navigate to users page")
    public void navigateToUsersMenu() {
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

    @Step("check if a given username is inside the list")
    public boolean contains (String username) {
        navigateToUsersMenu();
        for (WebElement user : users_list) {
            if(user.getText().equals(username))
            {
                return true;
            }

        }
        return false;
    }

    @Step("Delete a user")
    public void deleteUser(String userName) {
       boolean flag = false;
       for(int i=0;i<users_list.size();i++)
           if (users_list.get(i).getText().equals(userName)) {
               users_list.get(i).click();
               btn_delete.click();
               btn_deleteConfirmation.click();
               flag = true;
               break;
           }
       if (flag == false)
        System.out.println("User name "+userName+" does not exist");
    }


}
