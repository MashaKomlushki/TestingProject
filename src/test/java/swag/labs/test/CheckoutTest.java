package swag.labs.test;
import DataProviderClasses.CheckoutDataProvider;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageClasses.*;
import java.io.IOException;


public class CheckoutTest extends BaseTest{

    LoginPage loginPage;


    @BeforeMethod
    public void setUp() throws IOException {
        loginPage = new LoginPage(driver, wait);
    }

    @Test (dataProvider = "getCheckoutTestData", dataProviderClass = CheckoutDataProvider.class)
    public void testCheckout(String username,String password, String firstName,
                             String lastName, String postalCode, String successCheckoutURL)  {

        String checkoutCompleteUrl = loginPage
                .loginUser(username,password)
                .addToCartBackpack()
                .goToCheckout()
                .fillInformationAndContinueToCheckout(firstName,lastName,postalCode)
                .finishCheckout()
                .getCurrentUrl();

        assertEquals(checkoutCompleteUrl,successCheckoutURL);
    }
}


