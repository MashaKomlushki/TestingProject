package swag.labs.test;
import DataProviderClasses.ValidLoginDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageClasses.LoginPage;
import pageClasses.PLPPage;
import java.io.IOException;
import static org.testng.Assert.*;

public class LogoutTest extends BaseTest{
    LoginPage loginPage;



    @BeforeMethod
    public void setUp() throws IOException {
        loginPage = new LoginPage(driver, wait);
    }

    @Test (dataProvider = "getValidLoginTestData", dataProviderClass = ValidLoginDataProvider.class)
    public void testLogoutUser(String baseURL, String username, String password, String successLoginURL) throws IOException {

        PLPPage plpPage = loginPage.loginUser(username,password);

        plpPage.logoutUser();

        assertEquals(baseURL, plpPage.getCurrentUrl());

    }
}
