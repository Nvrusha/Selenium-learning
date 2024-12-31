package org.example.Ex05_Selenium_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class LocatorsNotes {
    public static void main(String[] args) {

        //Selenium Locators:
        //Locators in Selenium are used to identify elements in a web page. Choosing the right
        //locator is critical for test reliability and speed. Selenium provides several types of locators.

        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Navigate to a sample website
        driver.get("https://example.com/login");

        // Types of Selenium Locators

        // **1. Locator by ID**
        // - ID is the fastest and most reliable locator.
        // - Use when the element has a unique and stable ID.
        WebElement username = driver.findElement(By.id("user-id"));
        username.sendKeys("test_user");

        // **2. Locator by Name**
        // - Useful when ID is not present, but the `name` attribute is unique.
        // - Avoid if multiple elements share the same `name`.
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("password123");

        // **3. Locator by Class Name**
        // - Best for elements with unique class attributes.
        // - Avoid for generic classes that apply to multiple elements.
        WebElement loginButton = driver.findElement(By.className("btn-primary"));
        loginButton.click();

        // **4. Locator by Tag Name**
        // - Locates elements by their tag, e.g., `input`, `button`, `a`.
        // - Often used for handling collections of elements.
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            System.out.println(link.getText()); // Prints the text of all anchor tags on the page.
        }

        // **5. Locator by Link Text**
        // - Locates a link (anchor tag `<a>`) by its exact text.
        // - Avoid if the link text is dynamic or changes frequently.
        WebElement forgotPassword = driver.findElement(By.linkText("Forgot Password?"));
        forgotPassword.click();

        // **6. Locator by Partial Link Text**
        // - Locates a link using partial matching of the link text.
        // - Ideal for dynamic or lengthy link texts.
        WebElement partialLink = driver.findElement(By.partialLinkText("Forgot"));
        partialLink.click();

        // **7. Locator by CSS Selector**
        // - A powerful and efficient locator using CSS rules.
        // - Syntax:
        //   - By ID: `#id`
        //   - By class: `.class`
        //   - By attribute: `[attribute='value']`
        //   - Hierarchical: `parent child` or `parent > child`
        WebElement searchBox = driver.findElement(By.cssSelector("input[name='q']"));
        searchBox.sendKeys("Selenium CSS Selector");

        // **8. Locator by XPath**
        // - The most versatile locator, especially for dynamic elements.
        // - Syntax:
        //   - Absolute XPath: `/html/body/div[1]/div/input` (Avoid as it is brittle)
        //   - Relative XPath: `//tag[@attribute='value']`
        WebElement searchBoxXPath = driver.findElement(By.xpath("//input[@name='q']"));
        searchBoxXPath.sendKeys("Selenium XPath Example");

        // **Additional Notes on Locators**

        // **Best Practices**
        // - Prefer ID > Name > CSS Selector for speed and reliability.
        // - Use XPath sparingly, mainly for complex structures.
        // - Avoid absolute XPath as it is prone to breaking with DOM changes.

        // **Dynamic Elements**
        // - Use contains(), starts-with(), or ends-with() in XPath to handle dynamic attributes.
        // Example: `//input[contains(@id, 'user-')]`

        // **Index-Based Selection**
        // - Use CSS or XPath to select an element based on index.
        // CSS Example: `ul li:nth-child(3)`
        // XPath Example: `(//ul/li)[3]`

        // **Compound Locators**
        // - Combine attributes for better specificity.
        // Example CSS: `input[type='text'][name='username']`
        // Example XPath: `//input[@type='text' and @name='username']`

        // **Error Handling**
        // - Use try-catch blocks to handle cases where locators fail.
        try {
            WebElement optionalElement = driver.findElement(By.id("optional-element"));
            optionalElement.click();
        } catch (Exception e) {
            System.out.println("Element not found: " + e.getMessage());
        }

        // **Validation**
        // - Validate elements exist before interacting.
        List<WebElement> elements = driver.findElements(By.tagName("input"));
        if (!elements.isEmpty()) {
            System.out.println("Found " + elements.size() + " input elements.");
        }

        // Close the browser
        driver.quit();


    }
}
