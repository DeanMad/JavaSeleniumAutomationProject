package Workflow.CalcAppium;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class WF_AppiumCalc extends CommonOps {

    @Step("Calculating Repayment and Interest")
    public static void calculateMonthlyPayments(String amount, String term, String rate) {
        ukCalc.setAmount(amount);
        ukCalc.setTerm(term);
        ukCalc.setRate(rate);
        ukCalc.calculate();
        ukCalc.save();
    }

    @Step("Verify Result Not Empty")
    public static void verifyRepaymentAndInterest() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(ukCalc.getRepayment().length() > 0);
        soft.assertTrue(ukCalc.getInterest().length() > 0);
        soft.assertAll();
    }

    @Step("Verify Saved Result")
    public static void verifySaved() {
        ukCalc.swipe();
        Assert.assertTrue(ukCalcSave.getListSize() > 0);
    }

    @Step("Verify Saved Result")
    public static void verifyDelete(int index) {
        int currentSize = ukCalcSave.getListSize();
        ukCalc.swipe();
        ukCalcSave.deleteItem(index);
        int newSize = ukCalcSave.getListSize();
        Assert.assertTrue(newSize <= currentSize);
    }


}
