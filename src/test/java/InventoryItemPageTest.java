import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
    @Test
    public void testRemoveItemFromInventoryFromItemPage() {
        inventoryPage.showProductDetails("Sauce Labs Backpack");
        inventoryItemPage.addToCart();
        inventoryItemPage.removeFromCart();
        assertFalse(inventoryItemPage.isProductInCart());
    }
    @Test
    public void testAddItemToCartFromInventoryPageAndRemoveFromItemPage() {
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.showProductDetails("Sauce Labs Backpack");
        inventoryItemPage.removeFromCart();
        assertFalse(inventoryItemPage.isProductInCart());
    }
    @Test
    public void testAddItemToCartFromItemPageAndRemoveFromInventoryPage() {
        inventoryPage.showProductDetails("Sauce Labs Backpack");
        inventoryItemPage.addToCart();
        inventoryItemPage.backToProductsPage();
        inventoryPage.removeProductFromCart("Sauce Labs Backpack");
        assertFalse(inventoryItemPage.isProductInCart());
    }
}
