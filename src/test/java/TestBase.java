import com.codecool.sauceTest.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestBase {
    private static final Duration TIMEOUT = Duration.ofSeconds(3);

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;
    protected InventoryItemPage inventoryItemPage;
    protected CartPage cartPage;
    protected CheckoutOnePage checkoutOnePage;
    protected CheckoutTwoPage checkoutTwoPage;
    protected CheckoutCompletePage checkoutCompletePage;

    @BeforeAll
    public void beforeAll() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT);
        wait = new WebDriverWait(driver, TIMEOUT);
        actions = new Actions(driver);

        loginPage = new LoginPage(driver, wait, actions);
        inventoryPage = new InventoryPage(driver, wait, actions);
        inventoryItemPage = new InventoryItemPage(driver, wait, actions);
        cartPage = new CartPage(driver, wait, actions);
        checkoutOnePage = new CheckoutOnePage(driver, wait, actions);
        checkoutTwoPage = new CheckoutTwoPage(driver, wait, actions);
        checkoutCompletePage = new CheckoutCompletePage(driver, wait, actions);
    }
    @AfterAll
    public void afterAll() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
