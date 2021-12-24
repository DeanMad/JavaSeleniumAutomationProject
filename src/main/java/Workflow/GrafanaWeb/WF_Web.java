package Workflow.GrafanaWeb;

import Utilities.CommonOps;
import extensions.DBActions;
import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.sikuli.script.FindFailed;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


public class WF_Web extends CommonOps {


    @Step("Login to Grafana")
    public static void login() {
        login.setUsername(DBActions.getUsername());
        login.setPassword(DBActions.getPassword());
        login.submit();
        driver.navigate().refresh();
    }


    @Step("Creating a user")
    public static void createUser(String name, String email, String username, String password) {
        grafanaPage.usersMenu();
        grafanaPage.createUser(name, email, username, password);
        Assert.assertTrue(containsUser(username));
    }

    @Step("Check if a given user is contained in the list")
    public static boolean containsUser(String username) {
        return  grafanaPage.contains(username);
    }

    @Step ("Deleting a user")
    public static void deleteUser(String username) {
        grafanaPage.usersMenu();
        grafanaPage.deleteUser(username);
        Assert.assertFalse(containsUser(username));
    }


    @Step("Verify user exists")
    public static void verifyUserExists(String username)
    {
        grafanaPage.usersMenu();
        grafanaPage.search(username);
        Assert.assertTrue(containsUser(username));
    }

    @Step ("Changing theme with sikuli")
    public static void changeThemeToLightMode() throws FindFailed {
        screen.click(path+"Settingbtn.png");
        screen.hover(path+"Configuration.png");
        screen.click(path+"Preferences.png");
        screen.click(path+"Light.png");
        screen.click(path+"Save.png");
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }

    @Step ("Verify light mode")
    public static void verifyLightMode() {
        Assert.assertTrue(grafanaPage.clickedButtonStatus());
    }
}

