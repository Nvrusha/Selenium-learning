package org.example.Ex14_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRMTest {

    WebDriver driver; // declared at class level


    // This method runs once before all test methods
    @BeforeClass
    void openApp() {
        // Launch Chrome browser
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set implicit wait to handle dynamic elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the OrangeHRM login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    // This is the second test case (executed after openApp)
    @Test(priority = 2)
    void testLogo() {
        // Verify if the OrangeHRM logo is displayed
        boolean status = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']")).isDisplayed();
        System.out.println("Logo displayed: " + status);
    }

    // This is the third test case (executed after testLogo)
    @Test(priority = 3)
    void testLogin() {
        // Enter username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

        // Enter password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

        // Click on the login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    // This method runs once after all test methods
    @AfterClass
    void testLogout() {
        // Close the browser
        driver.close();
    }
}
