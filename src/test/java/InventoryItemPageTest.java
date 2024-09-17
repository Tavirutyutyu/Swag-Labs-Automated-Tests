import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryItemPageTest extends TestBase{
    @BeforeEach
    public void setUp() {
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
    }
    @Test
    public void testAddItemToInventoryFromItemPage() {
        inventoryPage.showProductDetails("Sauce Labs Backpack");
        inventoryItemPage.addToCart();
        assertTrue(inventoryItemPage.isProductInCart());
    }
}
