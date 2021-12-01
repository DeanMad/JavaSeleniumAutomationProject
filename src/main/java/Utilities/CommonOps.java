package Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Parameters;
import org.w3c.dom.Document;

public class CommonOps extends Base {
    @BeforeClass
    @Parameters({"Platform","Browser"})
    public void startSession(String platform,String browser) throws Exception {
        switch (platform) {
            case "web":
                casesSwitch(browser);
                web_init();
                break;
            case "api":
                api_init();
                break;
            case "appium":
                appium_init();
                break;
            case "electron":
                electron_init();
                break;
            case "desktop":
                desktop_init();
                break;
            default: throw new Exception("Invalid platform");
        }
    }

    @BeforeMethod
    @Parameters({"Platform"})
    public void beforeMethod(String platform, Method method) {
        if(!(platform.equals("api")))
        try {
            MonteScreenRecorder.startRecord(method.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterClass
    @Parameters({"Platform"})
    public void closeSession(String platform) {
        switch (platform) {
            case "appium":
                appiumDriver.quit();
                break;
            case "web":
                driver.quit();
                RemoteDB.closeDBCon();
            case "api":
                RemoteDB.closeDBCon();
                break;
            default:
                driver.quit();
                break;
        }
    }


    @Step("Switch Cases according to platform")
    private void casesSwitch(String browser) throws Exception {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            default: throw new Exception("Invalid browser");
        }
    }


    @Step("A function to initialize the web session ")
    private void web_init() {
        initURL();
        path = getData("path");
        initDBVariables();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        ManagePages.initWeb();
        screen = new Screen();
        RemoteDB.initSQLConnection();
    }

    @Step("A function to initialize the Api session ")
    private void api_init() {
        initURL();
        pathGet = getData("pathGet");
        pathPost = getData("pathPost");
        initDBVariables();
        RemoteDB.initSQLConnection();
        RestAssured.baseURI = url;
        request = RestAssured.given().auth().preemptive().basic(RemoteDB.getUsername(), RemoteDB.getPassword());
        request.header("Content-Type", "application/json");
    }

    @Step("A function to initialize the Appium session ")
    private void appium_init() throws MalformedURLException {
        deviceSignature = getData("deviceSignature");
        appPackage = getData("appPackage");
        appActivity = getData("appActivity");
        applicationServer = getData("applicationServer");
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.UDID, deviceSignature);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
        appiumDriver = new AppiumDriver<>(new URL(applicationServer), capabilities);
        ManagePages.initAppium();
    }

    @Step("A function to initialize the Desktop session ")
    private void desktop_init() throws MalformedURLException {
        applicationSignature = getData("applicationSignature");
        desktopServer = getData("desktopServer");
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", applicationSignature);
        driver = new WindowsDriver(new URL(desktopServer), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ManagePages.initDesktop();
    }

    @Step("A function to initialize the Electron session ")
    private void electron_init() {
        electPropertyKey = getData("electPropertyKey");
        electPropertyValue = getData("electPropertyValue");
        applicationPath = getData("applicationPath");
        System.setProperty(electPropertyKey,electPropertyValue);
        opt=new ChromeOptions();
        opt.setBinary(applicationPath);
        capabilities=new DesiredCapabilities();
        capabilities.setCapability("chromeOptions",opt);
        capabilities.setBrowserName("chrome");
        driver=new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        action=new Actions(driver);
        ManagePages.initElectron();
    }

    protected static String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("Config/ConfigFile.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    @Step
    public static void initDBVariables(){
        dbUrl = getData("dbUrl");
        username = getData("username");
        password = getData("password");
    }

    @Step
    public static void initURL(){
        url = getData("url");
    }


}
