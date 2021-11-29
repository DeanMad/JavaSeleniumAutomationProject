package Workflow.CalcAppium;

import Utilities.CommonOps;
import io.qameta.allure.Step;
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

    @Step("Verift Result Not Empty")
    public static void verifyRepaymentAndInterest() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(ukCalc.getRepayment().length() > 0);
        soft.assertTrue(ukCalc.getInterest().length() > 0);
        soft.assertAll();
    }


}
