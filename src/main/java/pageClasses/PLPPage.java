package pageClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PLPPage extends BasePage{

    private final By menuButton = By.id("react-burger-menu-btn");
    private final By sortButton = By.className("product_sort_container");
    private final By sauceLabsBackpack = By.id("item_4_title_link");
    private final By sauceLabsBackpackAdd = By.id("add-to-cart-sauce-labs-backpack");

    private final By productPrice = By.className("inventory_item_price");
    private final By cartButton = By.id("shopping_cart_container");
    private final By logoutButton = By.id("logout_sidebar_link");

    String itemToBuy;


    public PLPPage(WebDriver driver, WebDriverWait wait)  {
        super(driver, wait);

    }


    public LoginPage logoutUser() throws IOException {
        driver.findElement(menuButton).click();
        driver.findElement(logoutButton).click();
        return new LoginPage(driver, wait);
    }

    public String getProductName (){
        //driver.findElement("").getText();
        return driver.findElement(sauceLabsBackpack).getText();
    }

    public YourCartPage addToCartBackpack(){
        driver.findElement(sauceLabsBackpackAdd).click();
        driver.findElement(cartButton).click();
        return  new YourCartPage(driver, wait);
    }

    /*public YourCartPage addToCart(Collection<String> itemsToBuy) {
        for (String itemToBuy : itemsToBuy) {
            driver.findElement(By.id(itemToBuy)).click();
        }

        return new YourCartPage(driver, wait); */



    public  List<Double> getProductPrices() {
        List<WebElement> productPriceElements = driver.findElements(productPrice);

        List<Double> productPriceValues = new ArrayList<>();

        for (WebElement p : productPriceElements) {
            productPriceValues.add(Double.valueOf(p.getText().replace("$", "")));
        }

        return productPriceValues;
    }

    public  List<Double> getProductPricesDescendingOrder() {
        Select dropdown = new Select(driver.findElement(sortButton));
        dropdown.selectByVisibleText("Price (high to low)");
        return getProductPrices();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }


    public YourCartPage addToCart(String itemToBuyID) {
        driver.findElement(By.id(itemToBuyID)).click();
        driver.findElement(cartButton).click();
     return new YourCartPage(driver, wait);
    }
}

