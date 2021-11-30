//package Utilities;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//public class RemoteDBTest extends RemoteDB {
//    WebDriver driver;
//
//    @BeforeClass
//    public void openBrowser() {
//        initSQLConnection();
//    }
//
//    @Test
//    public void Test01() throws InterruptedException {
//        System.out.println(getCredentials().get(0));
//        System.out.println(getCredentials().get(1));
//    }
//
//    @AfterClass
//    public void afterClass() throws InterruptedException {
//        Thread.sleep(2000);
//        closeDBCon();
//    }
//}
