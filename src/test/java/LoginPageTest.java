import com.codecool.sauceTest.LoginPage;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginPageTest extends TestBase{
    private LoginPage loginPage;
    @BeforeEach
    public void setUp() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver, wait, actions);
    }
    @Test
    public void testLogin() {
        loginPage.login("standard_user", "secret_sauce");
        String url = driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/inventory.html", url);
    }
    @Test
    public void testErrorMessage(){
        loginPage.login("", "");
        String errorMessage = loginPage.getErrorMessage();
        assertEquals("Epic sadface: Username is required", errorMessage);
    }
}
