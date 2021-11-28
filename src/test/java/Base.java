import Hackathon.PageObject.Web.GrafanaPage;
        import Hackathon.PageObject.Web.LoginPage;
        import org.openqa.selenium.WebDriver;

        import java.util.List;

public class Base {
    protected WebDriver driver;
    protected LoginPage login;
    protected GrafanaPage grafanaPage;
    protected String url = "http://localhost:3000";
    protected List<String> users;
}
