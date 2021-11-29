package Workflow.CalcDesktop;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObject.DesktopCalc.CalculatorPage;

public class WF_Calc extends CommonOps {

    @Step
    public static void verifyAdd(WebElement elem1, WebElement elem2, String expected) {
        calculator.add(elem1, elem2);
        Assert.assertEquals(calculator.getResult(), expected);
    }

    @Step
    public static void verifySubtract(WebElement elem1, WebElement elem2, String expected) {
        calculator.subtract(elem1, elem2);
        Assert.assertEquals(calculator.getResult(), expected);
    }

    @Step
    public static void verifyDivide(WebElement elem1, WebElement elem2, String expected) {
        calculator.divide(elem1, elem2);
        Assert.assertEquals(calculator.getResult(), expected);
    }

    @Step
    public static void verifyMultiply(WebElement elem1, WebElement elem2, String expected) {
        calculator.multiply(elem1, elem2);
        Assert.assertEquals(calculator.getResult(), expected);
    }
}
