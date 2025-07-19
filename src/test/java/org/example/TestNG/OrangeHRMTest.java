package org.example.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRMTest {

    WebDriver driver; // WebDriver instance declared at class level for reuse in all test methods

    /*
     * Test Scenario:
     * --------------
     * Verify that a user can log in successfully to the OrangeHRM application.
     *
     * Test Steps:
     * 1. Launch the browser and open the OrangeHRM login page.
     * 2. Verify that the login page logo is displayed.
     * 3. Enter valid login credentials (username and password).
     * 4. Click on the login button and ensure login is successful.
     * 5. Close the browser.
     */

    // Precondition: Launch application (runs once before all test methods)
    @BeforeClass
    void openApp() {
        // Step 1: Launch Chrome browser
        driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Implicit wait to handle delays in loading elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the OrangeHRM login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    // Test Case 1: Verify that the OrangeHRM logo is displayed on the login page
    @Test(priority = 2)
    void testLogo() {
        // Step 2: Check if logo is displayed to ensure correct page is loaded
        boolean status = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']")).isDisplayed();
        System.out.println("Logo displayed: " + status);
        // Assertion can be added here in real-world testing
    }

    // Test Case 2: Verify successful login with valid credentials
    @Test(priority = 3)
    void testLogin() {
        // Step 3: Enter username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

        // Step 4: Enter password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

        // Step 5: Click login
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Validation of login success (like checking for dashboard element) can be added here
    }

    // Postcondition: Close the application (runs once after all tests)
    @AfterClass
    void testLogout() {
        // Step 6: Close the browser to clean up the session
        driver.close();
    }
}
