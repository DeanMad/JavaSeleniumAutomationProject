package Utilities;

import io.qameta.allure.Step;
import org.json.simple.JSONObject;

import java.util.List;

public class APIMethods extends CommonOps {

@Step ("Get list by key")
    public static List<String> getlistByKey(String key){
    response = UIActions.getRequest(pathGet);
    if(response.getStatusCode() == 200) {
        jp = response.jsonPath();
        return jp.getList("." + key);
    }
    return null;
}

    @Step ("Check if a given id exists")
    public static boolean verifyIDExistsInList(String id){
        response = UIActions.getRequest(pathGet+id);
        if(response.body().equals("{\"message\":\"user not found\"}"))
            return false;
        return true;
    }

    @Step
    public static String login(String user,String password){
         params = new JSONObject();
         params.put("user",user);
         params.put("password",password);
       return UIActions.postRequest(pathPost,params).body().asString();
    }

    @Step ("Change username")
    public static String changeEmail(String id,String email){
        params = new JSONObject();
        params.put("email",email);
        return UIActions.putRequest(pathGet, id, params).body().asString();
    }



}
