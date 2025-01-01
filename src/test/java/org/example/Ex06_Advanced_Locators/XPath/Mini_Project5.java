package org.example.Ex06_Advanced_Locators.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Mini_Project5 {
    public static void main(String[] args) throws InterruptedException {

        // Test Case: Verify Free Trial Message After Login
        // 1.Open browser and navigate to https://www.idrive360.com/enterprise/login.
        // 2.Enter email: augtest_040823@idrive.com.
        // 3.Enter password: 123456.
        // 4.Click "Login" button.
        // 5.Verify that the free trial message is visible on the page.
        // 6. Close the browser.

        // Step 1: Set up ChromeOptions to maximize the browser window
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(chromeOptions);

        // Step 2: Navigate to the URL
        System.out.println("Step 1: Navigating to the website...");
        driver.get("https://www.idrive360.com/enterprise/login");
        Thread.sleep(5000); // Wait for the page to load

        // Step 3: Enter email
        System.out.println("Step 2: Entering email...");
        WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
        emailInput.sendKeys("augtest_040823@idrive.com");

        // Step 4: Enter password
        System.out.println("Step 3: Entering password...");
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys("123456");

        // Step 5: Click "Login" button
        System.out.println("Step 4: Clicking the 'Login' button...");
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='frm-btn']"));
        loginButton.click();

        // Step 6: Verify the free trial message is visible on the page
        System.out.println("Step 5: Verifying if the free trial message is displayed...");
        Thread.sleep(20000); // Wait for the free trial message to appear
        WebElement trialMessage = driver.findElement(By.xpath("//h5[text()='Your free trial has expired']"));
        String actualMessage = trialMessage.getText();

        // Expected message
        String expectedMessage = "Your free trial has expired";

        // Assert that the actual message matches the expected message
        Assert.assertEquals(actualMessage, expectedMessage, "Test Failed");

        // Step 7: Print confirmation for test success
        System.out.println("Test Passed: Free trial message is displayed correctly.");

        // Step 8: Close the browser
        driver.quit();
        System.out.println("Step 6: Browser closed successfully.");
    }
}
