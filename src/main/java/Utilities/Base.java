package Utilities;

import Hackathon.PageObject.Web.GrafanaPage;
import Hackathon.PageObject.Web.LoginPage;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;

import javax.xml.ws.Response;
import java.util.List;

public class Base {
    protected static WebDriver driver;
    protected static LoginPage login;
    protected static GrafanaPage grafanaPage;
    protected static String url = "http://localhost:3000";
    protected static Screen screen;
    protected static String path = "C:\\Users\\PC\\Desktop\\automation\\Images\\";
    protected static RequestSpecification request;
    protected static Response response;
    protected static JsonPath jp;
    protected static JSONObject params;
}
