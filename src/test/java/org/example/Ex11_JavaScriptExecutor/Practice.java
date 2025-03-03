package org.example.Ex11_JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Practice {
    public static void main(String[] args) throws InterruptedException {

        // Step 1: Set up ChromeOptions to customize browser behavior.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Open browser in maximized mode

        // Step 2: Initialize the WebDriver with ChromeDriver and the defined options
        WebDriver driver = new ChromeDriver(options);

        // Step 3: Navigate to the SelectorsHub page
        driver.get("https://selectorshub.com/xpath-practice-page/");

        // Step 4: Typecasting WebDriver to JavascriptExecutor
        JavascriptExecutor JS = (JavascriptExecutor)driver;

        // 1️⃣ Scroll the Page

        // (a) Scroll Down by a Specific Pixel Value
        JS.executeScript("window.scrollBy(0,2000)"); // Scroll down by 500 pixels

        // (b) Scroll to the Bottom of the Page
        JS.executeScript("window.scrollBy(0, document.body.scrollHeight)");

        Thread.sleep(1000);
        // (c) Scroll to a Specific Element
        WebElement specific_Element = driver.findElement(By.xpath("//button[text()='Click To Open Window Prompt Alert']"));
        JS.executeScript("arguments[0].scrollIntoView(true)", specific_Element);

        Thread.sleep(1000);
        driver.quit();

    }
}
