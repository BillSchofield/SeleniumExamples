package com.thoughtworks.selenium.helpers;

import com.google.common.base.Predicate;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NonStaleElementFinder implements SearchContext {

    private final WebDriverWait wait;
    private WebDriver driver;

    public NonStaleElementFinder(WebDriver driver, long timeOutInSeconds) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    @Override
    public List<WebElement> findElements(By by) {
        wait.until(new ElementsAreNotStale(by));
        return driver.findElements(by);
    }

    @Override
    public WebElement findElement(final By by){
        wait.until(new ElementIsNotStale(by));
        return driver.findElement(by);

    }

    private static class ElementIsNotStale implements Predicate<WebDriver> {
        private final By by;

        public ElementIsNotStale(By by) {
            this.by = by;
        }

        public boolean apply(WebDriver driver) {
            boolean isStale = false;
            try {
                driver.findElement(by);
            } catch (StaleElementReferenceException ex){
                isStale = true;
            }

            return !isStale;
        }
    }

    private static class ElementsAreNotStale implements Predicate<WebDriver> {
        private By by;

        public ElementsAreNotStale(By by) {
            this.by = by;
        }

        public boolean apply(WebDriver driver) {
            boolean isStale = false;
            try {
                driver.findElements(by);
            } catch (StaleElementReferenceException ex){
                isStale = true;
            }

            return !isStale;
        }
    }
}
