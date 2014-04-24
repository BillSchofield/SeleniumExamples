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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HelpersExamples {
    private WebDriver driver;

    @Test
    public void nonStaleElementFinder() {
        By locator = By.id("gbqfq");
        final WebElement element = new NonStaleElementFinder(driver, 2).findElement(locator);
        element.sendKeys("Hello World");
    }

    @Test
    public void compositeByExample() {
        By compositeBy = new CompositeBy(By.id("chm"), By.cssSelector("div:nth-child(2)"));
//      Equivalent By.cssSelector("#chm > div:nth-child(2) > div:nth-child(2)")
        assertThat(driver.findElement(compositeBy).isDisplayed(), is(false));
    }

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/ThoughtWorker/Tools/chromedriver");
        this.driver = new ChromeDriver();
        driver.get("https://www.google.com/");

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
