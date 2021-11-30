import Utilities.Base;
import Workflow.GrafanaAPI.WF_API;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GrafanaAPI extends Base {

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
        WF_API.login("admin","12345");

    }

    @Test
    public void test04_verifyEmailUpdate(){
    WF_API.updateEmail("68","skwuf@gmai.com");


    }


}
