package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import pageObject.AppiumCalc.CalcPage;
import pageObject.AppiumCalc.CalcSavedPage;
import pageObject.DesktopCalc.CalculatorPage;
import pageObject.WebGrafana.LoginPage;
import pageObject.WebGrafana.MainPage;

public class ManagePages extends Base {

    @Step ("Initiate web pages")
    public static void initWeb() {
        login = PageFactory.initElements(driver, LoginPage.class);
        grafanaPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Step ("Initiate desktop")
    public static void initDesktop() {
        calculator = PageFactory.initElements(driver, CalculatorPage.class);
    }

    @Step ("Initiate appium")
    public static void initAppium() {
        ukCalc=new CalcPage(appiumDriver);
        ukCalcSave=new CalcSavedPage(appiumDriver);
    }

    @Step ("Initiate electron")
    public static void electron() {

    }
}
