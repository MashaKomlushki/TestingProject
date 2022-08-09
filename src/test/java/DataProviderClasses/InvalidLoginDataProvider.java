package DataProviderClasses;

import jsonFilesParser.JSONManagement;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class InvalidLoginDataProvider {

        @DataProvider(name = "getInvalidLoginTestData")
        public Object [][] getInvalidLoginData() throws IOException {
            Object[][] invalidLoginData = {
                    {JSONManagement.readProperty("emptyUsername"), JSONManagement.readProperty("password")}};
            return invalidLoginData;

        }
    }

