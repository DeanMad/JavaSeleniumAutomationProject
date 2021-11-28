package Workflow.GrafanaWeb;

import Utilities.CommonOps;
import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import java.util.concurrent.TimeUnit;


public class WF_Login extends CommonOps {


        @Step("Login to Grafana")
        public static void login() {
            login.setUsername("admin");
            login.setPassword("12345");
            login.submit();
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        }




}

