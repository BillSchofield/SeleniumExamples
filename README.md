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

Add Selenium to your project (`use org.seleniumhq.selenium:selenium-java:2.45.0`)

## Using WebDriver to find WebElements using Locators
Examine and run each of the unit tests in FindElementUsingLocators. This should give you some sense of how to locate
WebElements and use them. Note that these examples are not proper tests and are named for the Selenium features they
demonstrate. They also are not using the Page Object Pattern.

Implement each of the tests in AmazonShoppingTests. Use BDD-style tests and Page Object Pattern.



## Selenium Webdriver
Selenium is a portable software testing framework for web applications. Selenium WebDriver is the second major version
of Selenium. It accepts commands via a Client API and sends them to a browser. This is implemented through a
browser-specific browser driver, which sends commands to a browser, and retrieves results. Most browser drivers actually
launch and access a browser application (such as Firefox or Internet Explorer).

### Using Selenium for Tests
We tend to use Selenium in our UI Functional and User Workflow Tests. Typical usage looks like finding a web element on
the current webpage and either querying information about that element (what is your text?) or interacting with it like
a user would (click on the element).

#### Finding Elements
We use `find element` and `findElements` to provide access to web elements that live in the DOM.

> The Document Object Model (DOM) is a cross-platform and language-independent convention for representing and
> interacting with objects in HTML, XHTML, and XML documents. The nodes of every document are organized in a tree
> structure, called the DOM tree. Objects in the DOM tree may be addressed and manipulated by using methods on the
> objects.

The element finding methods us a locator to tell them which element(s) they should find for us. There are a number of
locator classes that work in different ways. You can find examples of these different locator classes in the
`FindElementUsingLocators` test class.

xpath – using xpath to find web elements sucks – don't do it if you can help it. Absolute xpath is a disaster, it's very
expensive, because if a customer wants to rearrange the web page, every path has to be rewritten in tests. IDs are the
best way – when devs are writing javascript they should be assigning ids to elements.

#### Querying Elements

#### Interacting with Elements

### Page Object Pattern
Your tests should be talking in the domain language of the customer (as much as possible). We want to hide the web page
specific details in a class that provides access to the behavior that lives on that page without revealing the 'how'.

Page Objects don't have to represent actual web pages, but can instead represent a group of related behaviors.

#### Rich client web apps

Javascript makes testing web apps a pain in the butt. Javascript races against Java so sometimes the test passes and
sometimes it fails depending on who won. If javascript didn't put 'checkout button' there first, then test will fail.
There is a thing called webdriverwait for this, can give conditions to it that it will have to wait on. Can use
predicates w/ webdriverwait, predicate can say 'wait till certain element shows up, or element is updated [not stale]'
or something like that.

It takes longer for javascript to find elements when dom is bigger = more things to look through, longer to find things.
Tests might start failing, b/c javascript is running slower than java. You can look at javascript console to figure out
what's going on.
Set of classes to allow easy extraction and manipulation of web pages within other programs
Makes all web elements on the page into objects. Stores all web page information in one place making tests much easier to maintain.
Helps abstract tests into more readable and understandable language that can be understood by the customer

### Common Problems with Selenium Testing

Testing web applications with java script can lead to page load/timing errors. Get() method waits until the has loaded
but, following the successful of html code, both java (selenium tests) and javascript run simultaneously. So, depending
on how fast the java and java script executes, it is possible to run tests in selenium before the java script.

To avoid java and javascript timing errors, use WebDriverWait
Reduce timing dependencies by limiting use of UI tests as much as possible
