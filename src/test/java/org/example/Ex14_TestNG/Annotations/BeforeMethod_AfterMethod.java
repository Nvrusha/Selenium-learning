package org.example.Ex14_TestNG.Annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BeforeMethod_AfterMethod {

    WebDriver driver; // WebDriver instance declared at class level for reuse in all test methods

    /*
     * ✅ Test Scenario: Validate key UI elements on OrangeHRM login page using TestNG's @BeforeMethod and @AfterMethod
     *
     * 📌 Objective:
     * 1. Verify that the OrangeHRM login page title is correct.
     * 2. Verify that the username field is displayed.
     *
     * 🔁 Test Flow for each test:
     *  - @BeforeMethod: Launch the browser and open OrangeHRM login page.
     *  - @Test: Perform a specific validation (title or field presence).
     *  - @AfterMethod: Close the browser after each test method to ensure clean session.
     */

    // ✅ Setup method that runs before each @Test
    @BeforeMethod
    void Setup() {
        // Initialize Chrome browser
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set implicit wait for 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to OrangeHRM login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("This is Before method...");
    }

    // ✅ Test 1: Validate the page title
    @Test
    void verifyTitle() {
        // Expected page title
        String expectedTitle = "OrangeHRM";

        // Get actual page title
        String actualTitle = driver.getTitle();

        // Compare and print result
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("✅ Title is correct.");
        } else {
            System.out.println("❌ Title is incorrect. Found: " + actualTitle);
        }
    }

    // ✅ Test 2: Verify username input field is visible
    @Test
    void testUsernameFieldPresent() {
        // Check if username field is displayed
        boolean isPresent = driver.findElement(By.name("username")).isDisplayed();

        // Print result
        System.out.println("✅ Username field is present: " + isPresent);
    }

    // ✅ Teardown method that runs after each @Test
    @AfterMethod
    void teardown() {
        // Quit the browser to clean up session
        driver.quit();
        System.out.println("This is After method...");
    }
}
