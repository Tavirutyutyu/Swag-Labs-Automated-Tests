package com.codecool.sauceTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends PageBase{
    public CartPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }
}
