import Utilities.Base;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GrafanaAPI extends Base {

    protected static Response getListOfUsersByPage() {
        response = request.get("/api/users");
        return response;
    }




}
