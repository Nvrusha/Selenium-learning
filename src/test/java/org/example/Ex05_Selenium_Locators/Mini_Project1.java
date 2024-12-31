package org.example.Ex05_Selenium_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Mini_Project1 {
    public static void main(String[] args) throws InterruptedException {

        /*
         Test Case: Locators - Find the web elements
         1. Open the URL: https://app.vwo.com/#/login
         2. Locate the email input box and enter the email: admin@admin.com
         3. Locate the password input box and enter the password: admin
         4. Locate and click on the submit button
         5. Verify that the error message is displayed: "Your email, password, IP address, or location did not match"
         Step 1: Set up ChromeOptions to maximize the browser window
        */

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        // Step 2: Initialize the ChromeDriver and open the login URL
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://app.vwo.com/#/login");

        // Step 3: Locate the email input field by its ID and enter a sample email
        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");

        // Step 4: Locate the password input field by its name attribute and enter a sample password
        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("admin");

        // Step 5: Locate the submit button by its ID and click on it
        WebElement submitButton = driver.findElement(By.id("js-login-btn"));
        submitButton.click();

        // Step 6: Wait briefly for the error message to load
        Thread.sleep(1000);

        // Step 7: Locate the error message by its class name and validate the text using assertion
        WebElement errorMessage = driver.findElement(By.className("notification-box-description"));

        // Assert that the error message text matches the expected message
        Assert.assertEquals(errorMessage.getText(), "Your email, password, IP address or location did not match",
                "Error message text did not match the expected value.");

        // Print "Test Passed" message if the assertion passed
        System.out.println("Test Passed: Error message displayed correctly.");

        // Step 8: Wait for a while before closing the browser (for visual inspection, if needed)
        Thread.sleep(2000);

        // Step 9: Close the browser session
        driver.quit();
    }
}
