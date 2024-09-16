package com.codecool.sauceTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public class InventoryPage extends PageBase{
    @FindBy(xpath = "//div[@data-test='inventory-item']")
    private List<WebElement> inventoryItems;
    @FindBy(xpath = "//select[@data-test='product-sort-container']")
    private WebElement productSort;
    @FindBy(xpath = "//a[@data-test='shopping-cart-link']")
    private WebElement shoppingCartLink;
    public InventoryPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    private WebElement getProduct(String productName){
        return inventoryItems.stream()
                .filter(e -> InventoryPage.hasName(e, productName))
                .findAny()
                .orElse(null);
    }

    private static boolean hasName(WebElement element, String productName){
        try {
            element.findElement(By.xpath("//div[@data-test='inventory-item-name']"));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
