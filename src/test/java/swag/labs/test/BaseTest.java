package swag.labs.test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;

    @BeforeMethod
    public void setUpDriver() throws IOException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("headless");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterMethod
    public void endTest() {

        driver.quit();
    }
}
