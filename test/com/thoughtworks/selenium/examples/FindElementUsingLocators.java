package com.thoughtworks.selenium.examples;

import com.thoughtworks.selenium.Sleeper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FindElementUsingLocators {
    public static final String prayingOtter = "http://25.media.tumblr.com/tumblr_lzv405ceft1qhtzioo1_500.jpg";
    private final String indexURL = "file://localhost/Users/ThoughtWorker/Projects/SeleniumUtils/resources/index.html";
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/ThoughtWorker/Tools/chromedriver");
        driver = new ChromeDriver();
        driver.get(indexURL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    // By.id
    // This is the most efficient and preferred way to locate an element. Common pitfalls that UI developers make is
    // having non-unique id’s on a page or auto-generating the id, both should be avoided. A class on an html element is
    // more appropriate than an auto-generated id.
    @Test
    public void shouldFindElementByIdAndGetText() {
        By nameLocator = By.id("name");
        WebElement nameElement = driver.findElement(nameLocator);
        assertThat(nameElement.getText(), is("Name:"));
    }

    // By.className
    // “Class” in this case refers to the attribute on the DOM element. Often in practical use there are many DOM
    // elements with the same class name, thus finding multiple elements becomes the more practical option over finding
    // the first element.
    @Test
    public void shouldFindElementByClassAndGetAttribute() {
        By nameLocator = By.className("text-box");
        WebElement nameElement = driver.findElement(nameLocator);

        assertThat(nameElement.getAttribute("value"), containsString("Name"));
    }

    // By.tagName
    // The DOM Tag Name of the element.
    @Test
    public void shouldFindElementByTagNameAndGetDimensions() {
        By image = By.tagName("img");
        WebElement imageElement = driver.findElement(image);

        Dimension imageSize = imageElement.getSize();

        assertThat(imageSize, is(new Dimension(225, 266)));
    }

    // By.name
    // Find the input element with matching name attribute.
    @Test
    public void shouldFindElementByNameAndGetLocation() {
        By image = By.name("otter");
        WebElement imageElement = driver.findElement(image);

        Point imageLocation = imageElement.getLocation();

        assertThat(imageLocation, is(new Point(8, 132)));
    }

    // By.linkText
    // Find the link element with matching visible text.
    @Test
    public void shouldFindElementByLinkTextAndGetLink() {
        By moreOttersLink = By.linkText("More Otters!");

        WebElement linkElement = driver.findElement(moreOttersLink);

        String href = linkElement.getAttribute("href");

        assertThat(href, is("http://lmgtfy.com/?q=cute+otters"));
    }

    // By.partialLinkText
    // Find the link element with partial matching visible text.
    @Test
    public void shouldFindElementByPartialLinkTextAndGetTagName() {
        By moreOttersLink = By.partialLinkText("Otter");

        WebElement linkElement = driver.findElement(moreOttersLink);

        String tagName = linkElement.getTagName();

        assertThat(tagName, is("a"));
    }

    // By.cssSelector
    // Like the name implies it is a locator strategy by css. Native browser support is used by default, so please refer
    // to w3c css selectors <http://www.w3.org/TR/CSS/#selectors> for a list of generally available css selectors.
    // Beware that not all browsers were created equal, some css that might work in one version may not work in another.
    @Test
    public void shouldFindElementByCssSelectorAndClickLink() {
        By moreOttersLink = By.cssSelector("a.otter-link");
        WebElement linkElement = driver.findElement(moreOttersLink);

        linkElement.click();

        assertThat(driver.getCurrentUrl(), is("http://lmgtfy.com/?q=cute+otters"));
    }

    //By.xpath
    // At a high level, WebDriver uses a browser’s native XPath capabilities wherever possible. On those browsers that
    // don’t have native XPath support, we have provided our own implementation. This can lead to some unexpected
    // behaviour unless you are aware of the differences in the various xpath engines.
    @Test
    public void shouldFindElementByXpathAnd() {
        By hardToLocatorElementLocator = By.xpath("/html/body/div/table/tbody/tr/td[3]/div[2]/textarea");
        WebElement hardToLocateElement = driver.findElement(hardToLocatorElementLocator);

        hardToLocateElement.sendKeys(prayingOtter);

        assertThat(hardToLocateElement.getAttribute("value"), containsString(prayingOtter));
    }
}
