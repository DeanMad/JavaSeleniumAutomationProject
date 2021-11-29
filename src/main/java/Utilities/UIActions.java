package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UIActions extends CommonOps{

    @Step
    public static void click(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step
    public static void clickNoWait(WebElement elem){
        elem.click();
    }

    @Step
    public static void updateText(WebElement elem, String text){
        elem.sendKeys(text);
    }


}
