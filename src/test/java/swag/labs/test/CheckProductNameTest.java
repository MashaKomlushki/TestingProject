package swag.labs.test;

import jsonFilesParser.JSONManagement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageClasses.LoginPage;
import pageClasses.PLPPage;
import pageClasses.YourCartPage;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class CheckProductNameTest extends BaseTest{
    LoginPage loginPage;
    String username;
    String password;

    @BeforeMethod
    public void setUp() throws IOException {
        loginPage = new LoginPage(driver, wait);

        username = JSONManagement.readProperty("username");

        password = JSONManagement.readProperty("password");
    }
    @Test
    public void testCheckProductName() {

        PLPPage plpPage = loginPage.loginUser(username, password);
        String productNamePLP = plpPage.getProductName();
        YourCartPage yourCartPage = new YourCartPage(driver, wait);
        String productNameCart = yourCartPage.getProductName();
        assertEquals(productNamePLP, productNameCart);

    }
}





