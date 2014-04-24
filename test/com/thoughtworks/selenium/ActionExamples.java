package com.thoughtworks.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionExamples {

    private WebDriver driver;

    @Test
    public void mouseOver() {
        driver.get("http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_onmouseover");
        Actions action = new Actions(driver);
        driver.switchTo().frame("iframeResult");
        WebElement elem = driver.findElement(By.cssSelector("body > img"));
        action.moveToElement(elem);
        action.perform();
    }

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
