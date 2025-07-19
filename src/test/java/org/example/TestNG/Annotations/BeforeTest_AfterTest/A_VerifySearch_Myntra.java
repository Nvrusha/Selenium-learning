package org.example.TestNG.Annotations.BeforeTest_AfterTest;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class A_VerifySearch_Myntra {

    // ✅ @BeforeTest runs once before any @Test method in this suite
    @BeforeTest
    void launchBrowser() {
        System.out.println("This is before test...");

        // Initialize Chrome browser
        DriverManager.driver = new ChromeDriver();

        // Maximize the browser window
        DriverManager.driver.manage().window().maximize();

        // Set implicit wait to handle dynamic web elements
        DriverManager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the Myntra homepage
        DriverManager.driver.get("https://www.myntra.com/");
    }

    // ✅ Test Case: Search for women's shoes on Myntra
    @Test()
    void searchShoes() throws InterruptedException {
        System.out.println("Running Search Test...");

        // Locate the search bar and enter the keyword
        DriverManager.driver.findElement(By.className("desktop-searchBar")).sendKeys("Shoes for women");

        // Click the search submit button
        DriverManager.driver.findElement(By.className("desktop-submit")).click();

        // Wait for 3 seconds to allow search results to load (for demo purpose)
        Thread.sleep(3000);
    }
}
