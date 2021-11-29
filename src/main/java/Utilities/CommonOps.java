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


import java.lang.reflect.Method;
import java.time.Duration;

public class CommonOps extends Base {
    @BeforeClass
    public void startSession() {

        // paltform = getData("Platform");
        // if ( platform == "web" {
        // Do web stuff
    // else if (platform == "aipi")



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





}
