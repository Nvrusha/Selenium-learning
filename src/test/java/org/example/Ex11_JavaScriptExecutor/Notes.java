package org.example.Ex11_JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Notes {
    public static void main(String[] args) {
        /*
         * ===========================================
         *  JavaScriptExecutor in Selenium WebDriver
         * ===========================================
         *
         * What is JavaScriptExecutor?
         * ---------------------------
         * - JavaScriptExecutor is an interface in Selenium that allows executing JavaScript code in the browser.
         * - It is useful when standard Selenium methods (findElement, click, sendKeys) do not work.
         * - Can interact with elements inside Shadow DOM, perform scrolling, and handle dynamic elements.
         *
         * How to Use JavaScriptExecutor?
         * ------------------------------
         * - JavaScriptExecutor is used via `JavascriptExecutor js = (JavascriptExecutor) driver;`
         * - The `executeScript()` method runs JavaScript code in the browser.
         *
         * ========================================
         *  Common JavaScriptExecutor Methods
         * ========================================
         */

        // 1️⃣ Initializing JavaScriptExecutor
        WebDriver driver = new ChromeDriver;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        /*
         * 2️⃣ Clicking an Element using JavaScript
         * - Useful when Selenium's click() method fails due to overlays or JavaScript-based buttons.
         */
        WebElement button = driver.findElement(By.id("submitButton"));
        js.executeScript("arguments[0].click();", button);

        /*
         * 3️⃣ Entering Text into a Field using JavaScript
         * - Useful when sendKeys() does not work.
         */
        WebElement inputField = driver.findElement(By.id("username"));
        js.executeScript("arguments[0].value='TestUser';", inputField);

        /*
         * 4️⃣ Scrolling the Page using JavaScript
         * - Scroll down by a specific number of pixels.
         */
        js.executeScript("window.scrollBy(0,500);");  // Scroll down by 500 pixels

        // Scroll to the bottom of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        // Scroll to a specific element
        WebElement footer = driver.findElement(By.id("footer"));
        js.executeScript("arguments[0].scrollIntoView(true);", footer);

        /*
         * 5️⃣ Getting the Page Title using JavaScriptExecutor
         */
        String title = (String) js.executeScript("return document.title;");
        System.out.println("Page Title: " + title);

        /*
         * 6️⃣ Fetching Inner Text of an Element
         */
        String innerText = (String) js.executeScript("return arguments[0].innerText;", button);
        System.out.println("Button Text: " + innerText);

        /*
         * 7️⃣ Handling Alerts using JavaScript
         */
        // Generate an alert popup
        js.executeScript("alert('This is an alert from JavaScriptExecutor!');");

        // Accept alert
        driver.switchTo().alert().accept();

        /*
         * 8️⃣ Accessing Shadow DOM using JavaScriptExecutor
         */
        WebElement shadowHost = driver.findElement(By.cssSelector("shadow-host-selector"));
        WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);
        WebElement shadowElement = shadowRoot.findElement(By.cssSelector("input.shadow-input"));
        shadowElement.sendKeys("Inside Shadow DOM");

        /*
         * ================================
         *  JavaScriptExecutor Best Practices
         * ================================
         * ✅ Use when standard Selenium methods fail (e.g., clicking hidden elements).
         * ✅ Use for scrolling, handling Shadow DOM, and interacting with JavaScript-heavy elements.
         * ❌ Avoid excessive JavaScriptExecutor usage—prefer standard Selenium methods where possible.
         * ❌ Do not execute untrusted JavaScript code (security risk).
         */


    }
}
