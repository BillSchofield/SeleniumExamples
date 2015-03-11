package com.thoughtworks.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class W3HomePage extends W3Page {

    private final By closeSearchLocator = By.id("closeSearchBTN");

    public W3HomePage(WebDriver driver) {
        super(driver, "", "default", "");
    }

    public WebElement searchEnd() {
        return driver.findElement(closeSearchLocator);
    }
}
