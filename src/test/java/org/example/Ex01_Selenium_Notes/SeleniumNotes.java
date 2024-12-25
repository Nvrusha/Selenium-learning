package org.example.Ex01_Selenium_Notes;

public class SeleniumNotes {
    public static void main(String[] args) {
        // 🌟 Selenium Basics Notes 🌟

/*
 🔹 1. What is Selenium?
      - Selenium is a tool for automating web browsers.
      - Used for testing web applications and performing browser automation tasks.

 🔹 2. Key Components of Selenium:
      - Selenium WebDriver: Core API for browser automation.
      - Selenium IDE: Record and playback tool (not for coding).
      - Selenium Grid: Execute tests on multiple machines and browsers.

 🔹 3. Key Features:
      - Supports multiple browsers (Chrome, Firefox, Edge, etc.).
      - Supports multiple programming languages (Java, Python, C#, etc.).
      - Cross-platform (Windows, macOS, Linux).

 🔹 4. Commonly Used Selenium Classes:
      - WebDriver: Controls the browser.
      - WebElement: Interacts with elements on the page.
      - By: Locates elements using various strategies.

 🔹 5. Locators in Selenium:
      - ID: `By.id("elementId")`
      - Name: `By.name("elementName")`
      - Class Name: `By.className("className")`
      - Tag Name: `By.tagName("tagName")`
      - Link Text: `By.linkText("linkText")`
      - Partial Link Text: `By.partialLinkText("partialText")`
      - CSS Selector: `By.cssSelector("cssExpression")`
      - XPath: `By.xpath("xpathExpression")`

 🔹 6. Common Methods in WebDriver:
      - `get(String url)`: Opens a webpage.
      - `getTitle()`: Retrieves the page title.
      - `findElement(By locator)`: Finds a single element.
      - `findElements(By locator)`: Finds multiple elements.
      - `click()`: Simulates a click action.
      - `sendKeys(String input)`: Types input into a field.
      - `getText()`: Retrieves text from an element.

 🔹 7. Types of Waits:
      - Implicit Wait: Waits for a default amount of time.
        `driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));`
      - Explicit Wait: Waits for a specific condition.
        `new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("btn")));`
      - Fluent Wait: Polls the DOM at intervals.

 🔹 8. Test Best Practices:
      - Use explicit waits for dynamic elements.
      - Organize code using the Page Object Model (POM).
      - Write reusable methods for actions like clicking or entering text.

 🔹 9. Debugging Tips:
      - Use browser developer tools (Inspect, Console).
      - Print element attributes to verify locators.
      - Take screenshots on test failures.
*/

    }
}
