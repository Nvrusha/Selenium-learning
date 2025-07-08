package org.example.Ex14_TestNG.Parameterization.Using_XMLFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class XML_ParallelTesting {

    WebDriver driver; // Declaring WebDriver instance

    // ✅ This method runs once before any @Test method in the class.
    // It is used to launch the browser and perform basic setup like timeouts and opening the application URL.
    @BeforeClass
    void setUp() {
        // Launching a new Chrome browser instance
        driver = new ChromeDriver();

        // Setting implicit wait to handle dynamic elements (max wait 10 seconds)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Opening the login page of the OrangeHRM demo website
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    // ✅ This test validates whether the OrangeHRM logo is displayed on the login page
    @Test(priority = 1)
    void testLogo() {
        // Locating the logo element and checking if it's visible
        boolean logo = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']")).isDisplayed();

        // Verifying the logo is displayed; if not, the test will fail
        Assert.assertEquals(logo, true, "❌ Logo is not displayed on the login page.");
    }

    // ✅ This test verifies the page title of the OrangeHRM login page
    @Test(priority = 2)
    void testTitle() {
        // Getting the current page title and comparing it to the expected value
        Assert.assertEquals(driver.getTitle(), "OrangeHRM", "❌ Page title does not match.");
    }

    // ✅ This test checks whether the current URL is correct
    @Test(priority = 3)
    void testURL() {
        // Comparing current URL with the expected login page URL
        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",
                "❌ URL mismatch for the login page."
        );
    }

    // ✅ This method runs after all @Test methods are completed
    // It is used to clean up the browser and close the WebDriver session
    @AfterClass
    void tearDown() {
        // Closing the browser
        driver.quit();
    }
}
