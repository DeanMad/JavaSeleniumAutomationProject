package Workflow.GrafanaWeb;

import Utilities.CommonOps;
import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class WF_Login extends CommonOps {


    @Step("Login to Grafana")
    public static void login() {
        login.setUsername("admin");
        login.setPassword("12345");
        login.submit();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }


    @Step
    public static void verifyLogin() {
        Assert.assertEquals(driver.getTitle(), "Home - Grafana");
    }

    @Step
    public static void createUser(String name, String email, String username, String password) {
        grafanaPage.usersMenu();
        grafanaPage.createUser(name, email, username, password);
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));
        Assert.assertTrue(containsUser(username));
    }

    @Step("Check if a given user is contained in the list")
    public static boolean containsUser(String username) {
        return  grafanaPage.contains(username);
    }

    @Step
    public static void deleteUser(String username) {
        grafanaPage.usersMenu();
        grafanaPage.deleteUser(username);
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));
        Assert.assertFalse(containsUser(username));
    }

    @Step ("Changing theme with sikuli")
    public static void changeTheme() throws FindFailed {
        screen.click(path+"Settingbtn.png");
        screen.click(path+"Preferences.png");
        screen.click(path+"Light.png");
        screen.click(path+"Save.png");
    }
}

