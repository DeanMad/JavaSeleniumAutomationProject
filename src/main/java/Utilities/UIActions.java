package Utilities;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOps{

    @Step ("Click")
    public static void click(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step ("Click without waiting")
    public static void clickNoWait(WebElement elem){
        elem.click();
    }

    @Step ("Updating text")
    public static void updateText(WebElement elem, String text){
        elem.sendKeys(text);
    }

    @Step ("Check if a given text exists in a list")
    public static boolean contains(String key, List<WebElement> list) {
        for (WebElement elem : list) {
            if (elem.getText().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Step("Delete a user")
    public static void deleteUser(String userName, List<WebElement> list, WebElement deleteButton, WebElement deleteConfirmationButton) {
        boolean flag = false;
        for (int i = 0; i < list.size(); i++)
            if (list.get(i).getText().equals(userName)) {
                list.get(i).click();
                deleteButton.click();
                deleteConfirmationButton.click();
                flag = true;
                Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
                break;
            }
        if (flag == false)
            System.out.println("User name " + userName + " does not exist");
    }

    @Step ("Get size of a list")
    public int getListSize(List<WebElement> list) {
        return list.size();
    }

    @Step ("Confirm attribute of an element")
    public static boolean clickedButtonStatus(WebElement element, String attribute, String value){
        if(element.getAttribute(attribute).equals(value))
            return true;
        else
            return false;
    }

}
