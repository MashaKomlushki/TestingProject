package DataProviderClasses;

import jsonFilesParser.JSONManagement;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class ValidLoginDataProvider {
    @DataProvider (name = "getValidLoginTestData")
    public Object [][] getValidLoginData() throws IOException {
     Object[][] validLoginData = {{
             JSONManagement.readProperty("baseURL"),JSONManagement.readProperty("username"),
             JSONManagement.readProperty("password"), JSONManagement.readProperty("successLoginURL")}};
        return validLoginData;

}
}
