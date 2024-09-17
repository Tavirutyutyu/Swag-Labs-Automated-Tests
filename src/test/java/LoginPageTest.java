import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTest extends TestBase{
    @BeforeEach
    public void setUp() {
        driver.get("https://www.saucedemo.com/");
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
