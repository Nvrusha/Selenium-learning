package org.example.Ex14_Page_Object_Model.Using_PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * ✅ Test Class: LoginTest
 * Demonstrates login test using Page Object Model (POM) with PageFactory in Selenium.
 */
public class LoginTest {

    WebDriver driver;

    /**
     * ✅ Setup method that runs once before any @Test method.
     * Initializes the browser and opens the login page.
     */
    @BeforeClass
    void setup() {
        // Launch the Chrome browser
        driver = new ChromeDriver();

        // Set implicit wait to handle element load delays
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to OrangeHRM login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Maximize browser window
        driver.manage().window().maximize();

        // Assertion to verify page title
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }

    /**
     * ✅ Test Method: Verifies login functionality using POM with PageFactory.
     */
    @Test
    void TestLogin() {
        // Create object of Page Object class (LoginPage1) and pass driver to it
        LoginPage1 lp = new LoginPage1(driver);

        // Use page methods to perform login steps
        lp.setUserName("Admin");       // Enter username
        lp.setPwd("Test@123");         // Enter password
        lp.clickBtn();                 // Click on Login button
    }
}
