package org.example.Page_Object_Model.Without_PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;

    // ✅ Setup method runs once before all test methods
    @BeforeClass
    void setup() {
        // Launching Chrome browser
        driver = new ChromeDriver();

        // Setting implicit wait for element loading
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigating to the login page of OrangeHRM
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Maximizing browser window
        driver.manage().window().maximize();

        // Verifying the page title
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }

    // ✅ Test method to verify login functionality using Page Object Model
    @Test
    void TestLogin() {
        // Creating object of Page Object class and passing driver to it
        LoginPage lp = new LoginPage(driver);

        // Performing actions using methods from the LoginPage class
        lp.setUserName("Admin");       // Enter username
        lp.setPwd("Test@123");         // Enter password
        lp.clickBtn();                 // Click login button
    }
}
