package Workflow.GrafanaAPI;

import Utilities.APIMethods;
import Utilities.CommonOps;
import Utilities.UIActions;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class WF_API extends CommonOps {

    @Step("Get a list by key")
    public static void getListByKey(String key) {
        List<String> list = APIMethods.getlistByKey("name");
        for (String item : list) {
            System.out.println(item);
        }
        Assert.assertTrue(list.size() > 0);
    }

    @Step()
    public static void verifyID(String id) {
        Assert.assertTrue(APIMethods.verifyIDExistsInList(id));
    }

    @Step()
    public static void updateEmail(String id, String email) {
        Assert.assertTrue(APIMethods.changeEmail(id, email).contains("User updated"));
    }

    @Step()
    public static void login(String username, String password) {

        Assert.assertTrue(APIMethods.login(username, password).contains("Logged in"));

    }

}