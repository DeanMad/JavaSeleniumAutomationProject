package Workflow.GrafanaWeb;

import Utilities.CommonOps;
import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

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
        Assert.assertTrue(containsUser(username));
    }

    @Step("Check if a given user is contained in the list")
    public static boolean containsUser(String username) {
        users = grafanaPage.getUsersList();
        return users.contains(username);
    }



}

