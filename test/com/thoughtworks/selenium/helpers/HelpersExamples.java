package com.thoughtworks.selenium.helpers;

import com.thoughtworks.selenium.helpers.CompositeBy;
import com.thoughtworks.selenium.helpers.NonStaleElementFinder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelpersExamples {
    private WebDriver driver;

    @Test
    public void nonStaleElementFinder() {
        By locator = By.id("gbqfq");
        final WebElement element = new NonStaleElementFinder(driver, 2).findElement(locator);
        element.sendKeys("Hello World");
    }

//    @Test
//    public void compositeByExample() {
//        By compositeBy = new CompositeBy();
//    }

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/ThoughtWorker/Tools/chromedriver");
        this.driver = new ChromeDriver();

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
