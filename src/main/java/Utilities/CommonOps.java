package Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

import org.w3c.dom.Document;

public class CommonOps extends Base {
    @BeforeClass
    public void startSession() throws MalformedURLException {

        platform = getData("Platform", 0);
        browser = getData("Browser", 0);
        if (platform.equals("web")) {
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
            }
            driver.manage().window().maximize();
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 5);
            ManagePages.initWeb();
            screen = new Screen();
        } else if (platform.equals("api")) {
            RestAssured.baseURI = url;
            RestAssured.given();
            //request.header("Content-Type", "application/json");
        } else if (platform.equals("appium")) {
            capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.UDID, "ce051605b5d4d82c03");
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.shivgadhia.android.ukMortgageCalc");
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
            appiumDriver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
            ManagePages.initAppium();
        } else if (platform.equals("electron")) {

        } else if (platform.equals("desktop")) {

            capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", applicationSignature);
            driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            ManagePages.initDesktop();
        }
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        try {
            MonteScreenRecorder.startRecord(method.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void closeSession() {

        if (platform.equals("appium")) {
            appiumDriver.quit();
        } else if (!platform.equals("api")) {
            driver.quit();
        }
        //todo if platform not equal to REST
        //driver.quit();
    }

    private String getData(String nodeName, int index) {
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
        return doc.getElementsByTagName(nodeName).item(index).getTextContent();
    }


}
