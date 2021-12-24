import Utilities.CommonOps;
import Workflow.CalcDesktop.WF_Calc;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcDesktop extends CommonOps {
    @Test(description = "Addition action")
    @Description("This Test is making an addition action and verifies the result")
    public void test01_verifyAdd() {
        WF_Calc.verifyAdd(calculator.one, calculator.two, "3");
    }

    @Test(description = "Subtraction action")
    @Description("This Test is making a subtraction action and verifies the result")
    public void test02_verifySubtract() {
        WF_Calc.verifySubtract(calculator.one, calculator.two, "-1");
    }

    @Test(description = "Division action")
    @Description("This Test is making a division action and verifies the result")
    public void test01_verifyDivide() {
        WF_Calc.verifyDivide(calculator.one, calculator.one, "1");
    }

    @Test(description = "Multiplication action")
    @Description("This Test is making a multiplication action and verifies the result")
    public void test01_verifyMultiply() {
        WF_Calc.verifyMultiply(calculator.one, calculator.two, "2");
    }
}
