package Utilities;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.AppiumCalc.CalcPage;
import pageObject.AppiumCalc.CalcSavedPage;
import pageObject.DesktopCalc.CalculatorPage;
import pageObject.ElectronToDo.ToDoPage;
import pageObject.WebGrafana.MainPage;
import pageObject.WebGrafana.LoginPage;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {
    //WEB
    protected static WebDriver driver;
    protected static AppiumDriver appiumDriver;
    protected static LoginPage login;
    protected static MainPage grafanaPage;
    protected static CalcPage ukCalc;
    protected static CalcSavedPage ukCalcSave;
    protected static String url = "http://localhost:3000";
    protected static Screen screen;
    protected static String path = "C:\\Users\\PC\\Desktop\\automation\\Images\\";

    //API
    protected static RequestSpecification request;
    protected static Response response;
    protected static JsonPath jp;
    protected static JSONObject params;
    protected static WebDriverWait wait;
    protected final static String pathGet = "/api/users/";
    protected final static String pathPost = "/login/";

    //Electron
    protected static Actions action;
    protected static ChromeOptions opt;
    protected static String electPropertyKey = "webdriver.chrome.driver";
    protected static String electPropertyValue = "C:\\Automation\\ElectronDriver\\electrondriver.exe";
    protected static String applicationPath = "C:\\Users\\PC\\AppData\\Local\\Programs\\todolist\\Todolist.exe";
    protected static ToDoPage todo;

    //Appium
    protected static DesiredCapabilities capabilities;
    protected static String applicationSignature = "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App";
    protected static String deviceSignature = "ce051605b5d4d82c03";
    protected static String appPackage = "com.shivgadhia.android.ukMortgageCalc";
    protected static String appActivity = ".MainActivity";
    protected static String applicationServer = "http://localhost:4723/wd/hub";

    //Desktop
    protected static CalculatorPage calculator;

    //DB
    protected static String dbUrl = "jdbc:mysql://remotemysql.com:3306/o51EvpDF5Z";
    protected static String username = "o51EvpDF5Z";
    protected static String password = "ZvjcsQ9714";
    protected static ResultSet rs;
    protected static Connection con;
    protected static Statement stmt;

}
