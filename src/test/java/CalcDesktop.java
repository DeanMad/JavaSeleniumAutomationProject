import Utilities.CommonOps;
import Workflow.CalcDesktop.WF_Calc;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcDesktop extends CommonOps {
    @Test
    public void test01_verifyAdd() {
        WF_Calc.verifyAdd(calculator.one, calculator.two, "3");
    }

    @Test
    public void test02_verifySubtract() {
        WF_Calc.verifySubtract(calculator.one, calculator.two, "-1");
    }

    @Test
    public void test01_verifyDivide() {
        WF_Calc.verifyDivide(calculator.one, calculator.one, "1");

    }

    @Test
    public void test01_verifyMultiply() {
        WF_Calc.verifyMultiply(calculator.one, calculator.two, "2");
    }
}
