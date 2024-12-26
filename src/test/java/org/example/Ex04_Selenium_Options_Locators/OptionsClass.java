package org.example.Ex04_Selenium_Options_Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OptionsClass {
    public static void main(String[] args) throws InterruptedException {

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

        // Pauses the execution of the current thread for 3 seconds (3000 milliseconds)
        // This is useful for adding delays between actions in automation tests or simulations.
        Thread.sleep(3000);

        // Quit the browser
        driver.quit();
    }
}
