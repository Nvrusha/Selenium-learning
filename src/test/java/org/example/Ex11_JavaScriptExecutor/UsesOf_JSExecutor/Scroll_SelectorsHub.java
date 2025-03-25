package org.example.Ex11_JavaScriptExecutor.UsesOf_JSExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scroll_SelectorsHub {
    public static void main(String[] args) throws InterruptedException {

        // ================================================
        // Test Case: Verify Scrolling Functionality on SelectorsHub Practice Page Using JavaScriptExecutor
        // ================================================
        // Test steps:
        // 1. Open SelectorsHub XPath Practice Page in a Chrome browser.
        // 2. Maximize the browser window.
        // 3. Scroll down by 500 pixels using JavaScriptExecutor.
        // 4. Scroll to the bottom of the page using JavaScriptExecutor.
        // 5. Scroll to a specific element (Button: "Click To Open Window Prompt Alert").
        // 6. Close the browser.
        //
        // Expected Result:
        // - The page should successfully scroll down by 500 pixels.
        // - The page should scroll to the bottom.
        // - The button should become visible after scrolling to it.
        // ================================================

        // Step 1: Set up ChromeOptions to customize browser behavior.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Open browser in maximized mode

        // Step 2: Initialize the WebDriver with ChromeDriver and the defined options
        WebDriver driver = new ChromeDriver(options);

        // Step 3: Navigate to the SelectorsHub practice page
        driver.get("https://selectorshub.com/xpath-practice-page/");

        // Step 4: Typecast WebDriver to JavascriptExecutor
        JavascriptExecutor JS = (JavascriptExecutor) driver;

        // ================================
        // 1️⃣ Scroll the Page using JavaScriptExecutor
        // ================================

        // (a) Scroll Down by a Specific Pixel Value (500 pixels)
        JS.executeScript("window.scrollBy(0,500)"); // Scroll down by 500 pixels
        Thread.sleep(4000); // Wait for 4 seconds to observe the scrolling effect

        // Retrieve and print the current vertical scroll position of the page
        System.out.println(JS.executeScript("return window.pageYOffset"));


        // (b) Scroll to the Bottom of the Page
        JS.executeScript("window.scrollBy(0, document.body.scrollHeight)"); // Scroll to the bottom
        Thread.sleep(1000); // Short wait time to ensure smooth scrolling

        // (c) Scroll to a Specific Element (Button: "Click To Open Window Prompt Alert")
        WebElement specific_Element = driver.findElement(By.xpath("//button[text()='Click To Open Window Prompt Alert']"));
        JS.executeScript("arguments[0].scrollIntoView(true)", specific_Element); // Scroll until the element is visible
        Thread.sleep(2000); // Pause to verify if the element is in view

        // Step 5: Close the browser
        driver.quit();
    }
}
