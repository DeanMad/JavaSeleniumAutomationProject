package Utilities;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.tools.ant.types.selectors.SelectSelector;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;

import java.util.List;

public class APIMethods extends CommonOps {

@Step ("Get list by key")
    public static List<String> getlistByKey(String key){
    response = UIActions.getRequest("api/users");
    if(response.getStatusCode() == 200) {
        jp = response.jsonPath();
        return jp.getList("." + key);
    }
    return null;
}

    @Step ("Check if a given id exists")
    public static boolean verifyIDExistsInList(String id){
        response = UIActions.getRequest("api/users/"+id);
        if(response.body().equals("{\"message\":\"user not found\"}"))
            return false;
        return true;
    }

    @Step
    public static void createUser(){
//        UIActions.postRequest("api/users/", )

    }

    @Step ("Change username")
    public static void changeUsername(){
//    UIActions.putRequest("api/users/", )
    }

}
