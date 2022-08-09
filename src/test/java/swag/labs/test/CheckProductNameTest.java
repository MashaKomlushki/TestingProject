package swag.labs.test;

import DataProviderClasses.ValidLoginDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageClasses.LoginPage;
import pageClasses.PLPPage;
import pageClasses.YourCartPage;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class CheckProductNameTest extends BaseTest{
    LoginPage loginPage;


    @BeforeMethod
    public void setUp() throws IOException {
        loginPage = new LoginPage(driver, wait);
    }

    @Test (dataProvider = "getValidLoginTestData", dataProviderClass = ValidLoginDataProvider.class)
    public void testCheckProductName(String baseURL, String username, String password, String successLoginURL) {

        PLPPage plpPage = loginPage.loginUser(username, password);
        String productNamePLP = plpPage.getProductName();
        YourCartPage yourCartPage = new YourCartPage(driver, wait);
        String productNameCart = yourCartPage.getProductName();
        assertEquals(productNamePLP, productNameCart);

    }
}





