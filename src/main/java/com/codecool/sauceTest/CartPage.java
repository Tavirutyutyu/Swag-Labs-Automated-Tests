package com.codecool.sauceTest;

import com.codecool.sauceTest.data.Item;
import com.codecool.sauceTest.util.MoneyUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends PageBase{
    @FindBy(xpath="//div[@data-test='inventory-item']")
    private List<WebElement> inventoryItems;


    public CartPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    private void deleteItem(String name) {
        String xpath = "//button[contains(@id, 'remove-']";
        inventoryItems.stream()
            .filter(item -> item.getText().contains(name))
            .findAny().orElseThrow(() -> new RuntimeException("item name not found"))
            .findElement(By.xpath(xpath))
            .click();
    }
}
