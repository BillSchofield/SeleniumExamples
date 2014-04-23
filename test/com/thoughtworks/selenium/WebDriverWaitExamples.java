package com.thoughtworks.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class WebDriverWaitExamples {
    private WebDriverWait wait;
    private WebDriver driver;

    @Test
    public void alertIsPresent() {
        // AlertIsPresent has great code to show how to detect and handle alerts
        getW3Example("tryjs_alert", "js");
        driver.findElement(By.cssSelector("body > button")).click();
        final Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertThat(alert, is(notNullValue()));
    }

    @Test
    public void elementToBeClickable(){
        getW3Example("tryjsref_document_createelement", "jsref");
        driver.findElement(By.cssSelector("body > button")).click();
        WebElement secondButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > button:nth-child(4)")));
        sleep();
        assertThat(secondButton, is(notNullValue()));
    }

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/ThoughtWorker/Tools/chromedriver");
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, 10);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private void getW3Example(String w3exampleName, String js) {
        driver.get("http://www.w3schools.com/" + js + "/tryit.asp?filename=" + w3exampleName);
        driver.switchTo().frame("iframeResult");
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
