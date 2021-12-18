package extensions;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class ApiActions extends CommonOps {
    @Step("Get request")
    protected static Response getRequest(String requestPath) {
        response = request.get(requestPath);
        return response;
    }

    @Step("Get request with id")
    protected static Response getRequestID(String requestPath, String id) {
        response = request.get(requestPath + id);
        return response;
    }

    @Step("Post request")
    protected static Response postRequest(String requestPath, JSONObject jsonObject) {
        request.body(jsonObject.toJSONString());
        response = request.post(requestPath);
        return response;
    }

    @Step("Put request")
    protected static Response putRequest(String requestPath,String id, JSONObject jsonObject) {
        request.body(jsonObject.toJSONString());
        response = request.put(requestPath+ id);
        return response;
    }



}
