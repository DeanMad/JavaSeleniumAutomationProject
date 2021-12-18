package extensions;

import Utilities.CommonOps;
import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOps {

    @Step("Click")
    public static void click(WebElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Click without waiting")
    public static void clickNoWait(WebElement elem) {
        elem.click();
    }

    @Step("Updating text")
    public static void updateText(WebElement elem, String text) {
        elem.sendKeys(text);
    }

    @Step("Keyboard Keys on input field")
    public static void keyboardKey(WebElement elem, Keys key) {
        elem.sendKeys(key);
    }


    @Step("Check if a given text exists in a list")
    public static boolean contains(String key, List<WebElement> list) {
        for (WebElement elem : list) {
            if (elem.getText().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Step("return the index of a given item,if it doesn't exit return -1")
    public static int getIndex(String item, List<WebElement> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().equals(item)) {
                return i;
            }
        }
        return -1;
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

    @Step("highlight a text inside a given element ")
    public static void moveToElement(WebElement elem)
    {
        action.moveToElement(elem).build().perform();
        action.build().perform();
    }

    @Step("highlight a text inside a given element ")
    public static void highlightTextInsideElement(WebElement elem,int index)
    {
        action.click(elem).doubleClick().doubleClick();
        action.build().perform();
    }

    @Step("highlight a text inside a given element ")
    public static void updateTextUsingActions(String text)
    {
        action.sendKeys(text).sendKeys(Keys.ENTER).build().perform();
        action.build().perform();
    }

    @Step("Get size of a list")
    public static int getListSize(List<WebElement> list) {
        return list.size();
    }

    @Step("Get Text from element")
    public static String text(WebElement elem) {
        return elem.getText();
    }

    @Step("Confirm attribute of an element")
    public static boolean clickedButtonStatus(WebElement element, String attribute, String value) {
        if (element.getAttribute(attribute).equals(value))
            return true;
        else
            return false;
    }


}

