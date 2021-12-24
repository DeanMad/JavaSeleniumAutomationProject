import Utilities.CommonOps;
import Utilities.DDT;
import Workflow.GrafanaWeb.WF_Web;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

public class GrafanaWeb extends CommonOps {
    @Test (description = "Login with DB")
    @Description ("Login with DB")
    public void test01() {
        WF_Web.login();
        Verifications.verifyLogin();
    }

    @Test(dataProviderClass = DDT.class, dataProvider = "data-provider")
    @Description ("Creaing users from a csv file")
    public void test02(String name, String email, String username, String password) {
        WF_Web.createUser(name,email,username,password);
    }

    @Test (description = "delete user")
    @Description ("This test deletes a user")
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

