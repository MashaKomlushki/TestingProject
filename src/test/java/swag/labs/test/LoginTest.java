package swag.labs.test;
import DataProviderClasses.ValidLoginDataProvider;
import DataProviderClasses.InvalidLoginDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageClasses.LoginPage;
import java.io.IOException;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginTest extends BaseTest{
    LoginPage loginPage;


    @BeforeMethod
    public void setUp() throws IOException {
        loginPage = new LoginPage(driver, wait);

    }

    @Test (dataProvider = "getValidLoginTestData", dataProviderClass = ValidLoginDataProvider.class)
    public void testValidLogin(String baseURL, String username, String password, String successLoginURL)  {

        loginPage.loginUser(username, password);

        assertEquals(successLoginURL, loginPage.getCurrentUrl());
    }

    @Test (dataProvider = "getInvalidLoginTestData", dataProviderClass = InvalidLoginDataProvider.class)
    public void testInvalidLogin(String emptyUsername, String password)  {

        loginPage.loginUser(emptyUsername, password);

        assertTrue(loginPage.isInvalidLoginErrorMessageDisplayed());
    }
}

