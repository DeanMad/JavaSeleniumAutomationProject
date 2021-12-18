package extensions;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Verifications extends CommonOps {

    @Step("Verify String")
    public static void verifyString(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    @Step("Verify Integer")
    public static void verifyInt(int actual, int expected) {
        Assert.assertEquals(actual, expected);
    }

    @Step("Verify Condition is true")
    public static void verifyConditionIsTrue(boolean condition) {
        Assert.assertTrue(condition);
    }

    @Step("Verify Condition is false")
    public static void verifyConditionIsFalse(boolean condition) {
        Assert.assertFalse(condition);
    }

    @Step("Verify Result Not Empty")
    public static void verifyRepaymentAndInterest() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(ukCalc.getRepayment().length() > 0);
        soft.assertTrue(ukCalc.getInterest().length() > 0);
        soft.assertAll();
    }


}
