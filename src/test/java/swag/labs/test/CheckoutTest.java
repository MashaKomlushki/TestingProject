package swag.labs.test;

import DataProviderClasses.CheckoutDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageClasses.LoginPage;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest{

    LoginPage loginPage;


    @BeforeMethod
    public void setUp() throws IOException {
        loginPage = new LoginPage(driver, wait);
    }

    @Test(dataProvider = "getCheckoutTestData", dataProviderClass = CheckoutDataProvider.class)
    public void testCheckout(String username,String password, String itemToBuyID, String firstName,
                             String lastName, String postalCode, String successCheckoutURL)  {

        String checkoutCompleteUrl = loginPage
                .loginUser(username,password)
                .addToCart(itemToBuyID)
                .goToCheckout()
                .fillInformationAndContinueToCheckout(firstName,lastName,postalCode)
                .finishCheckout()
                .getCurrentUrl();

        assertEquals(checkoutCompleteUrl,successCheckoutURL);
    }
}


