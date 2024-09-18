import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryItemPageTest extends TestBase{
    @BeforeEach
    public void setUp() {
        driver.get("https://www.saucedemo.com/");
    }
    @Test
    public void testAddItemToInventoryFromItemPage() {
        loginPage.login("standard_user");

        inventoryPage.showProductDetails("Sauce Labs Backpack");
        inventoryItemPage.addToCart();
        inventoryItemPage.goToShoppingCartPage();
        assertTrue(cartPage.isItemInCart("Sauce Labs Backpack"));
        cartPage.deleteItem("Sauce Labs Backpack");
    }
    @Test
    public void testRemoveItemFromInventoryFromItemPage() {
        loginPage.login("standard_user");

        inventoryPage.showProductDetails("Sauce Labs Backpack");
        inventoryItemPage.addToCart();
        inventoryItemPage.removeFromCart();
        inventoryItemPage.goToShoppingCartPage();
        assertFalse(cartPage.isItemInCart("Sauce Labs Backpack"));
    }
    @Test
    public void testAddItemToCartFromInventoryPageAndRemoveFromItemPage() {
        loginPage.login("standard_user");

        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.showProductDetails("Sauce Labs Backpack");
        inventoryItemPage.removeFromCart();
        inventoryItemPage.goToShoppingCartPage();
        assertFalse(cartPage.isItemInCart("Sauce Labs Backpack"));
    }
    @Test
    public void testAddItemToCartFromItemPageAndRemoveFromInventoryPage() {
        loginPage.login("standard_user");

        inventoryPage.showProductDetails("Sauce Labs Backpack");
        inventoryItemPage.addToCart();
        inventoryItemPage.backToProductsPage();
        inventoryPage.removeProductFromCart("Sauce Labs Backpack");
        inventoryPage.goToShoppingCartPage();
        assertFalse(cartPage.isItemInCart("Sauce Labs Backpack"));
    }
    @ParameterizedTest
    @ValueSource(strings = {"standard_user", "performance_glitch_user", "error_user"})
    public void checkEveryItemsPage(String username) {
        loginPage.login(username);
        checkEveryItem();
    }
    @Test
    public void checkEveryItemsPageWithProblemUser(){
        loginPage.login("problem_user");
        checkEveryItem();
    }
    public void checkEveryItem(){
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
