package extensions;

import Utilities.APIMethods;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Verifications extends CommonOps {

    @Step
    public static void verifyLogin() {
        Assert.assertEquals(driver.getTitle(), "Home - Grafana");
    }

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

    @Step("Confirming ID is in the list")
    public static void verifyID(String id) {
        Assert.assertTrue(APIMethods.verifyIDExistsInList(id));
    }

    @Step("Confirming email was updated")
    public static void updateEmail(String id, String email) {
        Assert.assertTrue(APIMethods.changeEmail(id, email).contains("User updated"));
    }

    @Step("Confirming login succeeded")
    public static void login(String username, String password) {
        Assert.assertTrue(APIMethods.login(username, password).contains("Logged in"));
    }

    @Step("Verify deletion")
    public static void verifyDeletion(int newSize, int currentSize){
        Assert.assertTrue(newSize <= currentSize);
    }
}
