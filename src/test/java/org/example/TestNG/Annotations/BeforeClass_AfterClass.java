package org.example.TestNG.Annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BeforeClass_AfterClass {

    /*
     * ✅ Test Scenario: Validate login functionality on Saucedemo
     *
     * 🔍 Test Steps:
     * 1. Launch browser and navigate to saucedemo.com [@BeforeClass]
     * 2. Check that login form elements are visible
     * 3. Enter valid credentials and submit login
     * 4. Validate successful login by checking URL or header
     * 5. Close browser after tests [@AfterClass]
     *
     * 🔁 Execution Flow:
     * - Setup runs once before all tests
     * - Two test methods run
     * - Teardown runs once after all tests
     */

    WebDriver driver; // Declared globally so it can be used in all test methods

    // ✅ Executed once before all @Test methods
    @BeforeClass
    void setup(){
        driver = new ChromeDriver(); // Launch browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait for elements
        driver.manage().window().maximize(); // Maximize browser window
        driver.get("https://www.saucedemo.com/"); // Open test URL
        System.out.println("This is Before class...");
    }

    // ✅ Test 1: Verify that login form UI elements are displayed correctly
    @Test(priority = 1)
    void verifyLoginFormElements(){
        // Check visibility of username input field
        boolean usernamePresent = driver.findElement(By.name("user-name")).isDisplayed();

        // Check visibility of password input field
        boolean passwordPresent = driver.findElement(By.name("password")).isDisplayed();

        // Check visibility of login button
        boolean loginBtnPresent  = driver.findElement(By.name("login-button")).isDisplayed();

        // Print results
        System.out.println("Username field displayed: " + usernamePresent);
        System.out.println("Password field displayed: " + passwordPresent);
        System.out.println("Login button displayed: " + loginBtnPresent);
    }

    // ✅ Test 2: Log in with valid credentials and verify user is redirected
    @Test(priority = 2)
    void performLogin(){
        // Enter valid username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Enter valid password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Click on the login button
        driver.findElement(By.id("login-button")).click();

        // Validate login by checking if URL contains 'inventory'
        boolean isLoggedIn = driver.getCurrentUrl().contains("inventory");
        System.out.println("Login successful: " + isLoggedIn);
    }

    // ✅ Executed once after all @Test methods
    @AfterClass
    void tearDown() {
        driver.quit();  // Close all browser windows and end WebDriver session
        System.out.println("This is After class...");
    }
}
