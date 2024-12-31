package org.example.Ex05_Selenium_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.List;

public class Mini_Project3 {
    public static void main(String[] args) {
        /*
         Test Case: Verify Error Message for Invalid Email in Signup Form
         Steps:
         1. Open the browser and navigate to the signup page URL.
         2. Locate and click on the "Start a free trial" link to access the signup page.
         3. Enter an invalid email address (e.g., "invalid@email").
         4. Check the "I agree to the terms and conditions" checkbox.
         5. Click the "Sign Up" button.
         6. Verify that an appropriate error message is displayed: "The email address you entered is incorrect."
         7. Close the browser.
        */

        // Step 1: Set up ChromeOptions to maximize the browser window
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        // Initialize the WebDriver and navigate to the login page
        WebDriver driver = new ChromeDriver(chromeOptions);
        System.out.println("Navigating to the login page...");
        driver.get("https://app.vwo.com/#/login");

        // Step 2: Locate and click on the "Start a free trial" link
        System.out.println("Clicking on 'Start a free trial' link...");
        WebElement textLink = driver.findElement(By.linkText("Start a free trial"));
        textLink.click();

        // Step 3: Enter an invalid email address
        System.out.println("Entering an invalid email address...");
        WebElement emailInput = driver.findElement(By.id("page-v1-step1-email"));
        emailInput.sendKeys("invalid@email");

        // Step 4: Check the "I agree to the terms and conditions" checkbox
        System.out.println("Checking the 'I agree to the terms and conditions' checkbox...");
        WebElement agreeCheckbox = driver.findElement(By.name("gdpr_consent_checkbox"));
        agreeCheckbox.click();

        // Step 5: Locate and click the "Sign Up" button
        System.out.println("Clicking the 'Sign Up' button...");
        List<WebElement> buttonList = driver.findElements(By.tagName("button"));
        buttonList.get(0).click(); // Assuming the first button is the "Sign Up" button

        // Step 6: Verify the error message
        System.out.println("Verifying the error message...");
        WebElement errorMessage = driver.findElement(By.className("invalid-reason"));
        Assert.assertEquals(errorMessage.getText(), "The email address you entered is incorrect.", "Test Failed: Error message did not match");

        // Print a success message if the test passes
        System.out.println("Test Passed: Error message verified successfully.");

        // Step 7: Close the browser
        System.out.println("Closing the browser...");
        driver.close();
    }
}
