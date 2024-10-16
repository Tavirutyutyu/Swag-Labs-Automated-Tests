import com.codecool.sauceTest.valueSources.LoadCredentials;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutTest extends TestBase {
    @BeforeEach
    public void setUp() {
        driver.get("https://www.saucedemo.com/");
    }
    @ParameterizedTest
    @MethodSource("provideValidBuyerCredentials")
    @DisplayName("Test buying a product")
    public void testCheckoutWithValidCredentials(String username, String firstName, String lastName, String zipCode, String checkoutText) {
        loginPage.login(username);
        inventoryPage.goToShoppingCartPage();
        cartPage.checkout();
        checkoutOnePage.fillData(firstName, lastName, zipCode);
        checkoutTwoPage.finish();
        assertTrue(checkoutCompletePage.completeTextEquals(checkoutText));
    }
    @ParameterizedTest
    @MethodSource("provideInvalidBuyerCredentials")
    @DisplayName("Test trying to buy a product with invalid credentials")
    public void testCheckoutWithInvalidCredentials(String username, String firstName, String lastName, String zipCode, String expectedMessage) {
        loginPage.login(username);
        inventoryPage.goToShoppingCartPage();
        cartPage.checkout();
        checkoutOnePage.fillData(firstName, lastName, zipCode);
        assertTrue(checkoutOnePage.errorMessageEquals(expectedMessage));
    }

    public Stream<Arguments> provideValidBuyerCredentials() {
        return LoadCredentials.loadValidBuyerCredentials();
    }

    public Stream<Arguments> provideInvalidBuyerCredentials() {
        return LoadCredentials.loadInvalidBuyerCredentials();
    }

}
