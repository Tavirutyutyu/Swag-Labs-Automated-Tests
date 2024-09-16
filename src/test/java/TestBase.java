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
    private static final Duration TIMEOUT = Duration.ofSeconds(5);

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    @BeforeAll
    public void beforeAll() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT);
        wait = new WebDriverWait(driver, TIMEOUT);
        actions = new Actions(driver);
    }
    @AfterAll
    public void afterAll() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
