package org.example.Ex05_Selenium_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Mini_Project4 {
    public static void main(String[] args) {
        /*
         Test Case: Verify Navigation to Appointment Page After Login
         Steps:
         1. Open the browser and navigate to the URL: https://katalon-demo-cura.herokuapp.com/
         2. Click on the "Make Appointment" button.
         3. Enter valid login credentials (username: John Doe, password: ThisIsNotAPassword).
         4. Click the "Login" button.
         5. Verify that the current URL matches the expected URL: https://katalon-demo-cura.herokuapp.com/#appointment
         6. Close the browser.
         */


        // Step 1: Set up ChromeOptions to maximize the browser window
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(chromeOptions);

        // Navigate to the URL
        System.out.println("Navigating to the website...");
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        // Step 2: Click on the "Make Appointment" button
        System.out.println("Clicking on 'Make Appointment' button...");
        WebElement makeAppointmentButton = driver.findElement(By.id("btn-make-appointment"));
        makeAppointmentButton.click();

        // Step 3: Enter login credentials
        System.out.println("Entering login credentials...");
        WebElement usernameInput = driver.findElement(By.id("txt-username"));
        usernameInput.sendKeys("John Doe");

        WebElement passwordInput = driver.findElement(By.id("txt-password"));
        passwordInput.sendKeys("ThisIsNotAPassword");

        // Step 4: Click the "Login" button
        System.out.println("Clicking on 'Login' button...");
        WebElement loginButton = driver.findElement(By.id("btn-login"));
        loginButton.click();

        // Step 5: Verify that the current URL matches the expected URL
        System.out.println("Verifying the current URL...");
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://katalon-demo-cura.herokuapp.com/#appointment";

        Assert.assertEquals(currentURL, expectedURL, "Test Failed: The current URL does not match the expected URL!");
        System.out.println("Test Passed: Successfully navigated to the appointment page.");

        // Step 6: Close the browser
        driver.quit();


    }
}
