package DataProviderClasses;

import jsonFilesParser.JSONManagement;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class CheckoutDataProvider {
    @DataProvider(name = "getCheckoutTestData")
    public Object [][] getCheckoutData() throws IOException {
        Object[][] checkoutData = {{
                JSONManagement.readProperty("username"), JSONManagement.readProperty("password"),
                JSONManagement.readProperty("firstName"), JSONManagement.readProperty("lastName"),
                JSONManagement.readProperty("postalCode"),JSONManagement.readProperty("successCheckoutURL")}};
        return checkoutData;

    }
}
