package Utilities;

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

    @Step("Swipe Screen ")
    //A function to swipe mobile screen
    public static void swipeScreen(PointOption start, PointOption end) {
        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        // execute swipe using TouchAction
        try {
            new TouchAction(appiumDriver)
                    .press(start)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(end)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
        }
    }

    @Step("Get request")
    protected static Response getRequest(String requestPath) {
        response = request.get(requestPath);
        return response;
    }

    @Step("Get request with id")
    protected static Response getRequestID(String requestPath, String id) {
        response = request.get(requestPath + id);
        return response;
    }

    @Step("Post request")
    protected static Response postRequest(String requestPath, JSONObject jsonObject) {
        request.body(jsonObject.toJSONString());
        response = request.post(requestPath);
        return response;
    }

    @Step("Put request")
    protected static Response putRequest(String requestPath,String id, JSONObject jsonObject) {
        request.body(jsonObject.toJSONString());
        response = request.put(requestPath+ id);
        return response;
    }

}

