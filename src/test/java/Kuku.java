import Utilities.CommonOps;
import Utilities.ExternalProvider;
import Workflow.GrafanaWeb.WF_Login;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;

//@Listeners(AutomationListeners.class)
public class Kuku extends CommonOps {
    @Test
    public void test01() {
        WF_Login.login();
        WF_Login.verifyLogin();
    }

    @Test(dataProviderClass = ExternalProvider.class, dataProvider = "data-provider")
    public void test02(String name, String email, String username, String password) {

        WF_Login.createUser(name,email,username,password);
    }

    @Test
    public void test03() {
    }
}

