Introduction to Selenium Webdriver
==================================
## Setup
Download [Chrome Driver](https://sites.google.com/a/chromium.org/chromedriver/downloads)
Unzip Chrome Driver and move it to a tools directory
Change the line `System.setProperty("webdriver.chrome.driver", "/Users/ThoughtWorker/Tools/chromedriver");` in
`FindElementsUsingLocators` to reference the location where you installed Chrome Driver

Change the line `private final String indexURL =
"file://localhost/Users/ThoughtWorker/Projects/SeleniumUtils/resources/index.html";` in `FindElementsUsingLocators` to
reference your local version of this project

## Using WebDriver to find WebElements using Locators
Examine and run each of the unit tests in FindElementUsingLocators. This should give you some sense of how to locate
WebElements and use them. Note that these examples are not proper tests and are named for the Selenium features they
demonstrate. They also are not using the Page Object Pattern.

Implement each of the tests in AmazonShoppingTests. Use BDD-style tests and Page Object Pattern.