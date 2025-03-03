package org.example.Ex09_Shadow_DOM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Notes {
    public static void main(String[] args) {
        /*
         * ===========================
         *  Shadow DOM in Selenium
         * ===========================
         *
         * What is Shadow DOM?
         * -------------------
         * - Shadow DOM (Shadow Document Object Model) is a web standard for encapsulating HTML and CSS.
         * - It prevents styles and scripts from affecting elements inside the shadow root.
         * - Standard Selenium locators (XPath, CSS Selectors) **do not work** inside Shadow DOM.
         *
         * How to Handle Shadow DOM?
         * -------------------------
         * - Use JavaScript Executor to **access shadowRoot**.
         * - Cannot directly use findElement() in Selenium.
         *
         * =======================================
         *  Handling Shadow DOM in Selenium (Java)
         * =======================================
         */

// 1️⃣ Access Shadow Root using JavaScript Executor
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement shadowHost = driver.findElement(By.cssSelector("shadow-host-selector"));  // Locate the shadow host
        WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);  // Get shadow root

// 2️⃣ Find element inside Shadow DOM
        WebElement shadowElement = shadowRoot.findElement(By.cssSelector("input.shadow-input"));
        shadowElement.sendKeys("Hello Shadow DOM!");

// =======================================
//  Handling Nested Shadow DOM (Shadow Inside Shadow)
// =======================================

// 1️⃣ Locate the first shadow host and get its shadow root
        WebElement shadowHost1 = driver.findElement(By.cssSelector("first-shadow-host"));
        WebElement shadowRoot1 = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost1);

// 2️⃣ Locate the second shadow host inside the first shadow root
        WebElement shadowHost2 = shadowRoot1.findElement(By.cssSelector("second-shadow-host"));
        WebElement shadowRoot2 = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost2);

// 3️⃣ Now find the element inside the nested Shadow DOM
        WebElement nestedElement = shadowRoot2.findElement(By.cssSelector("button.shadow-button"));
        nestedElement.click();

        /*
         * Limitations of Selenium with Shadow DOM
         * ---------------------------------------
         * ❌ Cannot use XPath inside Shadow DOM.
         * ❌ Standard Selenium findElement() does not work.
         * ❌ Closed Shadow DOM (mode="closed") cannot be accessed even with JavaScript.
         * ✅ Requires JavaScript Executor to interact with elements inside Shadow DOM.
         *
         * Alternative Tools for Shadow DOM
         * --------------------------------
         * - Playwright (Supports Shadow DOM natively)
         * - Cypress (Better support for Shadow DOM)
         * - Chrome DevTools Protocol (CDP) in Selenium 4
         */


    }
}
