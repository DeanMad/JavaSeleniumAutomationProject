import Hackathon.PageObject.Web.GrafanaPage;
import Hackathon.PageObject.Web.LoginPage;
import Utilities.MonteScreenRecorder;
import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {
    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        login = PageFactory.initElements(driver, LoginPage.class);
        grafanaPage = PageFactory.initElements(driver, GrafanaPage.class);
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
        //driver.quit();
    }


    @Step("Login to Grafana")
    public void login() {
        login.setUsername("admin");
        login.setPassword("12345");
        login.submit();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

    @Step
    public void verifyLogin() {
        Assert.assertEquals(driver.getTitle(), "Home - Grafana");
    }

    @Step
    public void createUser(String name, String email, String username, String password) {
        grafanaPage.usersMenu();
        grafanaPage.createUser(name, email, username, password);
        Assert.assertTrue(containsUser(username));
    }

    @Step("Check if a given user is contained in the list")
    public boolean containsUser(String username) {
        users = grafanaPage.getUsersList();
        return users.contains(username);
    }


}
