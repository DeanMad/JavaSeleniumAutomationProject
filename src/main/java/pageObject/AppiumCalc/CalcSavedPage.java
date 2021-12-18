package pageObject.AppiumCalc;

import extensions.UIActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class CalcSavedPage {

    private AppiumDriver driver;

    public CalcSavedPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(3)), this);
    }


    @AndroidFindBy(xpath = "//*[@id='tvRef']")
    private List<WebElement> items;

    @AndroidFindBy(xpath = "//*[@id='btnDel']")
    private List<WebElement> deleteButtons;

    @AndroidFindBy(xpath = "//*[@id='button1']")
    private WebElement confirmDelete;


    @Step("Return the size of the list")
    public int getListSize() {
        return UIActions.getListSize(items);
    }

    @Step("Delete all the list content")
    public void deleteItem(int index) {
        UIActions.clickNoWait(deleteButtons.get(index));
        UIActions.clickNoWait(confirmDelete);
    }


}
