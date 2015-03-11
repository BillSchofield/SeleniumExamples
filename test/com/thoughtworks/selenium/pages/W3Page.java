package com.thoughtworks.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class W3Page {
    private final By homeLinkLocator = By.linkText("« W3Schools Home");
    WebDriver driver;
    String category;
    String tutorial;
    private String filename;

    public W3Page(WebDriver driver, String category, String tutorial, String filename) {
        this.driver = driver;
        this.category = category;
        this.tutorial = tutorial;
        this.filename = filename;
    }

    public void get() {
        driver.get(url());
    }

    public String url() {
        String resourceId = "";
        if (!category.isEmpty()){
            resourceId += "/" + category;
        }
        if (!tutorial.isEmpty()){
            resourceId += "/" + tutorial + ".asp";
        }
        if(!filename.isEmpty()){
            resourceId += "?filename=" + filename;
        }

        return "http://www.w3schools.com" + resourceId;
    }

    public void goHome() {
        WebElement homeLink = driver.findElement(homeLinkLocator);
        homeLink.click();
    }
}
