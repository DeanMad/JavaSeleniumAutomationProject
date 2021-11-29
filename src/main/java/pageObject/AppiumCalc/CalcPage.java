package pageObject.AppiumCalc;

import Utilities.UIActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
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

}
