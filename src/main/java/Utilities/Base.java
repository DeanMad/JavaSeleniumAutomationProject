package Utilities;

import Hackathon.PageObject.Web.GrafanaPage;
        import Hackathon.PageObject.Web.LoginPage;
        import org.openqa.selenium.WebDriver;

        import java.util.List;

public class Base {
    protected static WebDriver driver;
    protected static LoginPage login;
    protected static GrafanaPage grafanaPage;
    protected static String url = "http://localhost:3000";
    protected static List<String> users;
}
