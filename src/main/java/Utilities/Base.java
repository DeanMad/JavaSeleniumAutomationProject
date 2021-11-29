package Utilities;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.AppiumCalc.CalcPage;
import pageObject.AppiumCalc.CalcSavedPage;
import pageObject.DesktopCalc.CalculatorPage;
import pageObject.WebGrafana.MainPage;
import pageObject.WebGrafana.LoginPage;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;

public class Base {
    protected static WebDriver driver;
    protected static AppiumDriver appiumDriver;
    protected static LoginPage login;
    protected static MainPage grafanaPage;
    protected static CalcPage ukCalc;
    protected static CalcSavedPage ukCalcSave;
    protected static String url = "http://localhost:3000";
    protected static Screen screen;
    protected static String path = "C:\\Users\\PC\\Desktop\\automation\\Images\\";
    protected static RequestSpecification request;
    protected static Response response;
    protected static JsonPath jp;
    protected static JSONObject params;
    protected static WebDriverWait wait;
    protected static DesiredCapabilities capabilities;
    protected static String applicationSignature = "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App";
    protected static CalculatorPage calculator;
    protected static String platform;
    protected static  String browser;
//    private WindowsDriver driver;
}
