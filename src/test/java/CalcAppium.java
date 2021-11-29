import Utilities.CommonOps;
import Workflow.CalcAppium.WF_AppiumCalc;
import Workflow.CalcDesktop.WF_Calc;
import org.testng.annotations.Test;

public class CalcAppium extends CommonOps {

    @Test
    public void test01_verifyCalculator() {
        WF_AppiumCalc.calculateMonthlyPayments("10", "10", "2");
        WF_AppiumCalc.verifyRepaymentAndInterest();
    }

    @Test
    public void test02_verifyCalculatorSaveResults() {
        WF_AppiumCalc.verifySaved();
    }

    @Test
    public void test03_verifyDelete() {
        WF_AppiumCalc.verifyDelete(1);
    }

}
