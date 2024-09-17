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


    private Item buildItem(WebElement item) {
        return new Item(
            getProperty(item, "inventory-item-name"),
            getProperty(item, "inventory-item-desc"),
            MoneyUtil.asCents(getProperty(item, "inventory-item-price")),
            getProperty(item, "item-quantity")
        );
    }

    private String getProperty(WebElement item, String property) {
        String xpath = "//div[@data-test='%s']".formatted(property);
        return item.findElement(By.xpath(xpath)).getText();
    }
}
