package Workflow.GrafanaAPI;

import Utilities.APIMethods;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.testng.Assert;

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



}