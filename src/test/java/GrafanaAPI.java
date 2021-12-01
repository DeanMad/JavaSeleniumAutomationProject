import Utilities.CommonOps;
import Workflow.GrafanaAPI.WF_API;
import org.testng.annotations.Test;

public class GrafanaAPI extends CommonOps {

    @Test
    public void test01_verifyList(){
        WF_API.getListByKey("name");
    }

    @Test
    public void test02_verifyUserExist(){
    WF_API.verifyID("68");
    }

    @Test
    public void test03_LoginAndVerify(){
        WF_API.login("admin","admin");
    }

    @Test
    public void test04_verifyEmailUpdate(){
    WF_API.updateEmail("68","skwuf@gmai.com");
    }

}
