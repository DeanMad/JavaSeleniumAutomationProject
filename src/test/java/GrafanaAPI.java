import Utilities.CommonOps;
import Workflow.GrafanaAPI.WF_API;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class GrafanaAPI extends CommonOps {

    @Test(description = "Printing requested list and verifying the list is not empty")
    @Description("This test prints the requested list by key and verifies the list is not empty")
    public void test01_verifyList(){
        WF_API.getListByKey("name");
    }

    @Test(description = "Verifying existence of ID")
    @Description("This test verifies the existence of ID in the list")
    public void test02_verifyUserExist(){
        Verifications.verifyID("68");
    }

    @Test(description = "Login")
    @Description("This test login to the server with the given credentials")
    public void test03_LoginAndVerify(){
        Verifications.login("admin","admin");
    }

    @Test(description = "Updating email")
    @Description("This test updates the email address and verifies the response")
    public void test04_verifyEmailUpdate(){
        Verifications.updateEmail("68","skwuf@gmai.com");
    }

}
