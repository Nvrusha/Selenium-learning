package org.example.Ex09_Shadow_DOM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SelectorsHUb {
    public static void main(String[] args) {

        // Step 1: Set up ChromeOptions to customize browser behavior.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Open browser in maximized mode

        // Step 2: Initialize the WebDriver with ChromeDriver and the defined options
        WebDriver driver = new ChromeDriver(options);

        // Step 3: Navigate to the SelectorsHub page
        driver.get("https://selectorshub.com/xpath-practice-page/");

        // Step 4: Typecasting WebDriver to JavascriptExecutor
        JavascriptExecutor JS = (JavascriptExecutor)driver;

        JS.executeScript("alert(1)");

    }
}
