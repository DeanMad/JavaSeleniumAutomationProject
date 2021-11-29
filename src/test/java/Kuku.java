import Utilities.CommonOps;
import Utilities.ExternalProvider;
import Workflow.GrafanaWeb.WF_Login;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

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

    @Test (description = "delete user")
    public void test03() {
        WF_Login.deleteUser("KukuUser21");
    }

    @Test(description="")
    public void test04()
    {
        WF_Login.verifyUserExists("admin");
    }

    @Test(description = "Change to light mode and verify")
    public void test05() throws FindFailed {
        WF_Login.changeThemeToLightMode();
        WF_Login.verifyLightMode();
    }



}

