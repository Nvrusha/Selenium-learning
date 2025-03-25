package org.example.Ex11_JavaScriptExecutor.UsesOf_JSExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomIn_ZoomOut_SelectorHub {
    public static void main(String[] args) throws InterruptedException {

        // Test Case: Verify Zoom In & Zoom Out Functionality on SelectorsHub
        // Test Scenario: Validate that the zoom-in and zoom-out functionality works correctly using
        // JavaScript Executor on the SelectorsHub practice page.

        // Test Steps:
        // 1️⃣ Launch the browser and navigate to SelectorsHub XPath Practice Page (https://selectorshub.com/xpath-practice-page/).
        // 2️⃣ Zoom in to 150% using JavaScript Executor.
        // 3️⃣ Verify zoom-in effect by checking the document.body.style.zoom value.
        // 4️⃣ Zoom out to 50% using JavaScript Executor.
        // 5️⃣ Verify zoom-out effect by checking the document.body.style.zoom value.
        // 6️⃣ Reset zoom to 100% (default).

        // Step 1: Initialize WebDriver
        WebDriver driver = new ChromeDriver(); // Launch Chrome browser

        Thread.sleep(2000); // Adding wait for visibility

        // Step 2: Minimize the browser window
        driver.manage().window().minimize();
        Thread.sleep(2000); // Pause to observe the minimized window

        // Step 3: Maximize the browser window to full screen
        driver.manage().window().maximize();
        Thread.sleep(2000); // Pause to observe the maximized window

        // Step 4: Navigate to the SelectorsHub practice page
        driver.get("https://selectorshub.com/xpath-practice-page/");

        // Step 5: Initialize JavaScript Executor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Step 6: Zoom out the page to 50%
        js.executeScript("document.body.style.zoom='50%'");
        Thread.sleep(2000); // Pause to observe zoom effect

        // Step 7: Zoom in the page to 150%
        js.executeScript("document.body.style.zoom='150%'");
        Thread.sleep(2000); // Pause to observe zoom effect

        // Step 8: Reset zoom to 100% (Default)
        js.executeScript("document.body.style.zoom='100%'");
        Thread.sleep(2000); // Pause to observe zoom reset

        // Step 9: Close the browser
        driver.close();
    }
}
