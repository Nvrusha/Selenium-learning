package org.example.Ex14_TestNG.Annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.PriorityQueue;

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
     * - Two test cases run
     * - Teardown runs once after all tests
     */

    WebDriver driver;

    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    // ✅ Test 1: Verify login form elements are displayed
    @Test(priority = 1)
    void verifyLoginFormElements(){
        boolean usernamePresent = driver.findElement(By.name("user-name")).isDisplayed();
        boolean passwordPresent = driver.findElement(By.name("password")).isDisplayed();
        boolean loginBtnPresent  = driver.findElement(By.name("login-button")).isDisplayed();

        System.out.println("Username field displayed: " + usernamePresent);
        System.out.println("Password field displayed: " + passwordPresent);
        System.out.println("Login button displayed: " + loginBtnPresent);
    }

    // ✅ Test 2: Perform login and validate successful login
    @Test(priority = 2)
    void performLogin(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");  // valid username
        driver.findElement(By.id("password")).sendKeys("secret_sauce");    // valid password
        driver.findElement(By.id("login-button")).click();

        // Verify user is redirected to inventory page
        boolean isLoggedIn = driver.getCurrentUrl().contains("inventory");
        System.out.println("Login successful: " + isLoggedIn);
    }

    @AfterClass
    void tearDown() {
        driver.quit();  // Close browser
    }

}
