package Utilities;

import pageObject.WebGrafana.MainPage;
import pageObject.WebGrafana.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;
import org.w3c.dom.Document;

public class CommonOps extends Base {
    @BeforeClass
    public void startSession() {


        // platform = getData("Platform");
        // if ( platform == "web" {
        // Do web stuff
        // else if (platform == "api")

        String platform = getData("Platform", 0);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        login = PageFactory.initElements(driver, LoginPage.class);
        grafanaPage = PageFactory.initElements(driver, MainPage.class);
        screen = new Screen();
        RestAssured.baseURI = url;
        RestAssured.given();
        request.header("Content-Type", "application/json");
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
        driver.quit();
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
