import Utilities.CommonOps;
import Workflow.CalcAppium.WF_AppiumCalc;
import Workflow.CalcDesktop.WF_Calc;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class CalcAppium extends CommonOps {

    @Test(description = "Test 01:Verify Operation")
    @Description("This Test verifies that Payment and Interest exist after calculation")
    public void test01_verifyCalculator() {
        WF_AppiumCalc.calculateMonthlyPayments("10", "10", "2");
        Verifications.verifyRepaymentAndInterest();
    }


    @Test(description = "Test 02:Verify Save Button")
    @Description("This Test verifies that calculation is saved")
    public void test02_verifyCalculatorSaveResults() {
        Verifications.verifyConditionIsTrue(WF_AppiumCalc.getSavedSectionSize() > 0);
    }

    @Test(description = "Test 03:Verify Delete Button")
    @Description("This Test verifies that calculation is saved")
    public void test03_verifyDelete() {
        WF_AppiumCalc.verifyDelete(1);
    }

}
