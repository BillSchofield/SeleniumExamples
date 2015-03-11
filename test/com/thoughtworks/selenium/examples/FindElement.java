package com.thoughtworks.selenium.examples;

import com.thoughtworks.selenium.pages.W3HomePage;
import com.thoughtworks.selenium.pages.W3Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.thoughtworks.selenium.Sleeper.sleep;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FindElement {
    private WebDriver driver;
    private W3HomePage homePage;
    private W3Page htmlDefaultPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/ThoughtWorker/Tools/chromedriver");
        driver = new ChromeDriver();
        htmlDefaultPage = new W3Page(driver, "html", "default", "");
        homePage = new W3HomePage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void shouldBeHomeAfterGoingHomeWhenStartingAtHtmlDefaultTutorial() {
        htmlDefaultPage.get();
        sleep(1);
        htmlDefaultPage.goHome();
        sleep(1);
        assertThat(driver.getCurrentUrl(), is(homePage.url()));
    }
    
//    @Test
//    public void shouldHaveXForEndingSearchWhenHome() {
//        homePage.get();
//        assertThat(homePage.searchEnd().getText(), is("X"));
//    }
}
