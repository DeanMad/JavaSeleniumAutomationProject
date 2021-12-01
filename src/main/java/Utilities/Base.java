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
    protected static String url;
    protected static Screen screen;
    protected static String path ;

    //API
    protected static RequestSpecification request;
    protected static Response response;
    protected static JsonPath jp;
    protected static JSONObject params;
    protected static WebDriverWait wait;
    protected static String pathGet;
    protected static String pathPost;

    //Electron
    protected static Actions action;
    protected static ChromeOptions opt;
    protected static String electPropertyKey;
    protected static String electPropertyValue;
    protected static String applicationPath;
    protected static ToDoPage todo;

    //Appium
    protected static DesiredCapabilities capabilities;
    protected static String applicationSignature ;
    protected static String deviceSignature ;
    protected static String appPackage;
    protected static String appActivity;
    protected static String applicationServer;

    //Desktop
    protected static CalculatorPage calculator;
    protected static String desktopServer;

    //DB
    protected static String dbUrl;
    protected static String username;
    protected static String password;
    protected static ResultSet rs;
    protected static Connection con;
    protected static Statement stmt;

}
