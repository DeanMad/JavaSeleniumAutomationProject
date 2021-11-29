package Workflow.GrafanaAPI;

public class WF_API extends GrafanaApi {


    protected static void printListOfUsers() {
        response=getListOfUsers();
        jp = response.jsonPath();
        usersByPage = jp.getList("data.email");
        for (String email : usersByPage) {
            System.out.println(email);
        }
        return response.statusCode();
    }


}
