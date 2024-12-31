package org.example.Ex05_Selenium_Locators;

public class Locators_Importantclasses {
    public static void main(String[] args) {
        /*
        // ==========================
        // 1. By Class
        // ==========================
        // The By class provides static methods for locating elements using different types of locators.
        // Common methods include:
        // By.id() - Locates an element by its unique ID.
        // By.name() - Locates an element by its name attribute.
        // By.className() - Locates an element by its class name.
        // By.tagName() - Locates all elements with a specific HTML tag.
        // By.linkText() - Locates a hyperlink using its exact visible text.
        // By.partialLinkText() - Locates a hyperlink using partial visible text.
        // By.cssSelector() - Locates elements using CSS selectors.
        // By.xpath() - Locates elements using XPath expressions.

        // Example using the By class:
        WebElement elementById = driver.findElement(By.id("username")); // Locates element by ID
        WebElement elementByXPath = driver.findElement(By.xpath("//input[@type='text']")); // Locates using XPath


        // ==========================
        // 2. WebDriver Class
        // ==========================
        // The WebDriver class interacts with the browser and provides methods to locate elements.
        // Two important methods:
        // findElement(By locator): Locates a single element.
        // findElements(By locator): Locates multiple elements matching the locator.

        // Example:
        WebElement username = driver.findElement(By.name("username")); // Finds a single element
        List<WebElement> links = driver.findElements(By.tagName("a")); // Finds multiple elements


        // ==========================
        // 3. WebElement Class
        // ==========================
        // Represents an HTML element and provides methods for interacting with it.
        // Common methods include:
        // click() - Clicks the element.
        // sendKeys(String text) - Types the given text into an input field.
        // clear() - Clears the text in an input or text area.
        // getText() - Retrieves the visible text of the element.
        // getAttribute(String attribute) - Fetches the value of a specific attribute (e.g., href).
        // isDisplayed() - Checks if the element is visible on the page.

        // Example:
        WebElement loginButton = driver.findElement(By.className("btn-login"));
        loginButton.click(); // Clicks the login button


        // ==========================
        // 4. Select Class
        // ==========================
        // The Select class is designed for interacting with <select> dropdowns.
        // Common methods include:
        // selectByIndex(int index) - Selects an option by its index.
        // selectByValue(String value) - Selects an option by its value attribute.
        // selectByVisibleText(String text) - Selects an option by its visible text.
        // getOptions() - Retrieves all options in the dropdown.
        // getFirstSelectedOption() - Gets the currently selected option.

        // Example:
        WebElement dropdown = driver.findElement(By.id("country"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("India"); // Selects option "India"


        // ==========================
        // 5. Actions Class
        // ==========================
        // Provides advanced user interactions like hover, drag-and-drop, and right-click.
        // Common methods include:
        // moveToElement(WebElement element) - Moves the mouse to a specific element.
        // click() - Performs a click at the current mouse location.
        // doubleClick(WebElement element) - Double-clicks on an element.
        // contextClick(WebElement element) - Right-clicks on an element.
        // dragAndDrop(WebElement source, WebElement target) - Drags an element to a target location.

        // Example:
        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(By.id("menu-item"));
        actions.moveToElement(menu).perform(); // Hovers over the menu item


        // ==========================
        // 6. JavascriptExecutor Interface
        // ==========================
        // Allows executing JavaScript code for locating or interacting with elements.
        // Key method:
        // executeScript(String script, Object... args): Executes JavaScript in the browser.

        // Example:
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = (WebElement) js.executeScript("return document.getElementById('username');");
        element.sendKeys("test_user"); // Types "test_user" into the element


        // ==========================
        // Best Practices for Locators
        // ==========================
        // 1. Prefer using 'id' as it is unique and fast.
        // 2. Use 'cssSelector' for complex element identification.
        // 3. Use 'xpath' for deep or dynamic element structures.
        // 4. Avoid absolute XPath as it is fragile and prone to breaking.
        // 5. Validate locator stability and reliability across different environments.
        */
    }
}