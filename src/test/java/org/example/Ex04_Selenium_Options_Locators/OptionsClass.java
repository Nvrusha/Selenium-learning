package org.example.Ex04_Selenium_Options_Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OptionsClass {
    public static void main(String[] args) {

        // Set up ChromeOptions
        ChromeOptions options = new ChromeOptions();

        // Add some common options
        options.addArguments("--start-maximized"); // Open browser in maximized mode
        options.addArguments("--incognito");      // Open browser in incognito mode
        options.addArguments("--disable-notifications"); // Disable browser notifications

        // Create WebDriver instance with ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        // Navigate to a webpage
        driver.get("https://github.com/Nvrusha");

        // Perform some actions
        System.out.println("Page title is: " + driver.getTitle());

        // Quit the browser
        driver.quit();
    }
}
