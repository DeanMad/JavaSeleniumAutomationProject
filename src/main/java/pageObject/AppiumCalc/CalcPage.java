package pageObject.AppiumCalc;

import Utilities.UIActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CalcPage {

    private AppiumDriver driver;

    public CalcPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(3)), this);
    }

    @AndroidFindBy(xpath = "//*[@id='etAmount']")
    private WebElement amountField;

    @AndroidFindBy(xpath = "//*[@id='etTerm']")
    private WebElement termField;

    @AndroidFindBy(xpath = "//*[@id='etRate']")
    private WebElement rateField;

    @AndroidFindBy(xpath = "//*[@text='Calculate']")
    private WebElement calculateBtn;

    @AndroidFindBy(xpath = "//*[@id='btnSave']")
    private WebElement saveBtn;

    @AndroidFindBy(xpath = "//*[@id='tvRepayment']")
    private WebElement repayment;

    @AndroidFindBy(xpath = "//*[@id='tvInterestOnly']")
    private WebElement interestOnly;

    @Step("Setting the amount")
    public void setAmount(String amount) {
        UIActions.updateText(amountField, amount);
    }

    @Step("Setting the term")
    public void setTerm(String term) {
        UIActions.updateText(termField, term);
    }

    @Step("Setting the rate")
    public void setRate(String rate) {
        UIActions.updateText(rateField, rate);
    }

    @Step("Calculating...")
    public void calculate() {
        UIActions.clickNoWait(calculateBtn);
    }

    @Step("Saving")
    public void save() {
        UIActions.clickNoWait(saveBtn);
    }

    @Step("Get Repayment from result")
    public String getRepayment() {
        return UIActions.text(repayment);
    }

    @Step("Get Interest from  result")
    public String getInterest() {
        return UIActions.text(interestOnly);
    }

    @Step("Swipe Screen")
    public void swipe() {
        UIActions.swipeScreen(PointOption.point(1000,1000),PointOption.point(50,1000));
    }


}
