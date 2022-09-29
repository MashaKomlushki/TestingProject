package DataProviderClasses;

import org.testng.annotations.DataProvider;

public class ItemDataProvider {
    @DataProvider ( name= "getItemTestData")
    public Object [][] getItemData() {
        Object [][] itemData = {{}};
        return itemData;
    }
}
