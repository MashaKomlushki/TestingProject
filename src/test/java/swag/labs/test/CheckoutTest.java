package swag.labs.test;

import jsonFilesParser.JSONManagement;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageClasses.*;
import java.io.IOException;


public class CheckoutTest extends BaseTest{

    LoginPage loginPage;
    String username;
    String password;
    String firstName;
    String lastName;
    String postalCode;
    String successCheckoutURL;


    @BeforeMethod
    public void setUp() throws IOException {
        loginPage = new LoginPage(driver, wait);

        username = JSONManagement.readProperty("username");

        password = JSONManagement.readProperty("password");

        firstName = JSONManagement.readProperty("firstName");

        lastName = JSONManagement.readProperty("lastName");

        postalCode = JSONManagement.readProperty("postalCode");

        successCheckoutURL = JSONManagement.readProperty("successCheckoutURL");

    }

    @Test
    public void testCheckout()  {

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


