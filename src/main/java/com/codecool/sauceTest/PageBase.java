package com.codecool.sauceTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final Actions actions;
    public PageBase(WebDriver driver, WebDriverWait wait, Actions actions) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
        this.actions = actions;
    }
}
