import Utilities.CommonOps;
import Utilities.DDT;
import Workflow.GrafanaWeb.WF_Web;
import io.qameta.allure.Description;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

//@Listeners(AutomationListeners.class)
public class GrafanaWeb extends CommonOps {
    @Test (description = "Login with DB")
    @Description ("Login with DB")
    public void test01() {
        WF_Web.login();
        WF_Web.verifyLogin();
    }

    @Test(dataProviderClass = DDT.class, dataProvider = "data-provider")
    public void test02(String name, String email, String username, String password) {
        WF_Web.createUser(name,email,username,password);
    }

    @Test (description = "delete user")
    public void test03() {
        WF_Web.deleteUser("KukuUser21");
    }

    @Test(description="")
    public void test04()
    {
        WF_Web.verifyUserExists("admin");
    }

    @Test(description = "Change to light mode and verify")
    public void test05() throws FindFailed {
        WF_Web.changeThemeToLightMode();
        WF_Web.verifyLightMode();
    }



}

