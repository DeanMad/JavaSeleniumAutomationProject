import org.testng.annotations.Test;

//@Listeners(AutomationListeners.class)
public class Kuku extends CommonOps {
    @Test
    public void test01() {
        login();
        verifyLogin();
    }

    @Test(dataProviderClass = ExternalProvider.class, dataProvider = "data-providerCSV")
    public void test02() {
        createUser("kuku3","kuku@e3mail.com","kukuser3","kukupass3");

    }


}

