package swag.labs.test;
import DataProviderClasses.ValidLoginDataProvider;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageClasses.LoginPage;
import pageClasses.PLPPage;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class PLPSortingTest extends BaseTest{

    LoginPage loginPage;

    @BeforeMethod
    public void setUp() throws IOException {
        loginPage = new LoginPage(driver, wait);
    }
    @Test (dataProvider = "getValidLoginTestData", dataProviderClass = ValidLoginDataProvider.class)
    public void testPLPSorting(String baseURL, String username, String password, String successLoginURL) {

        PLPPage plpPage = loginPage.loginUser(username,password);
        List<Double> unsortedProductPrices = plpPage.getProductPrices();
        List<Double> productPricesSortedDescendingOrder = plpPage.getProductPricesDescendingOrder();
        Collections.sort(unsortedProductPrices);
        Collections.reverse(unsortedProductPrices);
        assertEquals(unsortedProductPrices, productPricesSortedDescendingOrder);
    }
}

