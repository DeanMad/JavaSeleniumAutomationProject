package Workflow.CalcAppium;

import Utilities.CommonOps;
import io.qameta.allure.Step;

public class WF_AppiumCalc extends CommonOps {

    @Step("Calculating Repayment and Interest")
    public static void calculateMonthlyPayments(String amount, String term, String rate) {
        ukCalc.setAmount(amount);
        ukCalc.setTerm(term);
        ukCalc.setRate(rate);
        ukCalc.calculate();
        ukCalc.save();
    }


}
