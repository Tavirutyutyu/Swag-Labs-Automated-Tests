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
    @Test
    public void checkEveryItemsPage() {
        inventoryPage.showProductDetails("Sauce Labs Backpack");
        assertTrue(inventoryItemPage.isProductNameEqual("Sauce Labs Backpack"));
        inventoryItemPage.backToProductsPage();

        inventoryPage.showProductDetails("Sauce Labs Bike Light");
        assertTrue(inventoryItemPage.isProductNameEqual("Sauce Labs Bike Light"));
        inventoryItemPage.backToProductsPage();

        inventoryPage.showProductDetails("Sauce Labs Bolt T-Shirt");
        assertTrue(inventoryItemPage.isProductNameEqual("Sauce Labs Bolt T-Shirt"));
        inventoryItemPage.backToProductsPage();

        inventoryPage.showProductDetails("Sauce Labs Fleece Jacket");
        assertTrue(inventoryItemPage.isProductNameEqual("Sauce Labs Fleece Jacket"));
        inventoryItemPage.backToProductsPage();

        inventoryPage.showProductDetails("Sauce Labs Onesie");
        assertTrue(inventoryItemPage.isProductNameEqual("Sauce Labs Onesie"));
        inventoryItemPage.backToProductsPage();

        inventoryPage.showProductDetails("Test.allTheThings() T-Shirt (Red)");
        assertTrue(inventoryItemPage.isProductNameEqual("Test.allTheThings() T-Shirt (Red)"));
    }
}
