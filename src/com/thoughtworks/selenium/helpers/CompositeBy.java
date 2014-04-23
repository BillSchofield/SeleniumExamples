package com.thoughtworks.selenium.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.*;

public class CompositeBy extends By {
    private final By firstLocator;
    private List<By> remainingLocators;

    public CompositeBy(By...locators) {
        this.firstLocator = locators[0];
        this.remainingLocators = Arrays.asList(locators).subList(1, locators.length-1);
    }

    @Override
    public WebElement findElement(SearchContext searchContext) {
        WebElement element = searchContext.findElement(firstLocator);
        for (By locator : remainingLocators) {
            element = element.findElement(locator);
        }
        return element;
    }

    @Override
    public List<WebElement> findElements(SearchContext searchContext) {
        List<WebElement> elements = searchContext.findElements(firstLocator);
        final Iterator<By> nextLocator = remainingLocators.iterator();
        return expandSearch(nextLocator, elements);
    }

    private List<WebElement> expandSearch(Iterator<By> nextLocator, List<WebElement> elements) {
        List<WebElement> newElements = new ArrayList<WebElement>();
        if (nextLocator.hasNext()) {
            for (WebElement element : elements) {
                final By next = nextLocator.next();
                final List<WebElement> elementsExpandedFromCurrentElement = element.findElements(next);
                newElements.addAll(elementsExpandedFromCurrentElement);
                expandSearch(nextLocator, elementsExpandedFromCurrentElement);
            }
        }
        return newElements;
    }

}
