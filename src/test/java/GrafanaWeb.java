import Utilities.CommonOps;
import Utilities.DDT;
import Workflow.GrafanaWeb.WF_Web;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

public class GrafanaWeb extends CommonOps {
    @Test (description = "Login with DB")
    @Description ("Login with credentials from DB")
    public void test01() {
        WF_Web.login();
        Verifications.verifyLogin();
    }

    @Test(dataProviderClass = DDT.class, dataProvider = "data-provider")
<<<<<<< Updated upstream
    @Description ("Creaing users from a csv file")
=======
    @Description ("Create users with CSV file")
>>>>>>> Stashed changes
    public void test02(String name, String email, String username, String password) {
        WF_Web.createUser(name,email,username,password);
    }

    @Test (description = "delete user")
<<<<<<< Updated upstream
    @Description ("This test deletes a user")
=======
    @Description ("Create a specific user by username")
>>>>>>> Stashed changes
    public void test03() {
        WF_Web.deleteUser("KukuUser21");
    }

    @Test(description="Check that a user exists according to username")
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

