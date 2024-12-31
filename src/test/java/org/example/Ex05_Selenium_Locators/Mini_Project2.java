package org.example.Ex05_Selenium_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Mini_Project2 {
    public static void main(String[] args) {
        /*
         Test Case: Verify Navigation Using Link Text Locator
         Steps:
         1. Open the browser and navigate to the URL: https://app.vwo.com/#/login
         2. Locate and click on the link with the text "Start a free trial."
         3. Verify that the URL changes to the expected target page URL:
            (https://vwo.com/free-trial/?utm_medium=website&utm_source=login-page&utm_campaign=mof_eg_loginpage)
         4. Close the browser.
        */

        // Step 1: Set up ChromeOptions to maximize the browser window
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        // Step 2: Open the browser and navigate to the URL: https://app.vwo.com/#/login
        WebDriver driver = new ChromeDriver(chromeOptions);
        System.out.println("Navigating to the login page...");
        driver.get("https://app.vwo.com/#/login");

        // Step 3: Locate and click on the link with the text "Start a free trial."
        System.out.println("Locating the 'Start a free trial' link...");
        WebElement textLink = driver.findElement(By.linkText("Start a free trial"));
        textLink.click();

        // Step 4: Verify that the URL changes to the expected target page URL:
        //(https://vwo.com/free-trial/?utm_medium=website&utm_source=login-page&utm_campaign=mof_eg_loginpage)
        System.out.println("Verifying the URL...");
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://vwo.com/free-trial/?utm_medium=website&utm_source=login-page&utm_campaign=mof_eg_loginpage";

        Assert.assertEquals(currentURL, expectedURL,"Test Failed: URL does not match the expected URL!");

        // Print "Test Passed" message if the assertion passed
        System.out.println("Test Passed: URL navigation is verified successfully.");

        // Step 5: Close the browser.
        System.out.println("Closing the browser...");
        driver.close();


    }
}
