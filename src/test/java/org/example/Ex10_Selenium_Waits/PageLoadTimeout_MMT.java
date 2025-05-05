package org.example.Ex10_Selenium_Waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PageLoadTimeout_MMT {

    public static void main(String[] args) {

        // -------------------------------------------------------------------------------------
        // ✅ Test Case: Verify Page Load Timeout Handling on MakeMyTrip Homepage
        //
        // 📋 Scenario:
        // - Launch the browser and set a strict pageLoadTimeout (e.g., 5 seconds)
        // - Attempt to open the MakeMyTrip homepage
        // - If the page doesn't fully load within 5 seconds, a timeout exception should be caught
        //
        // ✅ Test Steps:
        // 1️⃣ Launch the Chrome browser
        // 2️⃣ Set a low page load timeout (e.g., 5 seconds)
        // 3️⃣ Navigate to https://www.makemytrip.com
        // 4️⃣ Catch and log any timeout exceptions
        // 5️⃣ Close the browser
        // -------------------------------------------------------------------------------------

        // Step 1️⃣: Initialize WebDriver and maximize the browser window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2️⃣: Set a strict page load timeout (for test purposes)
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        // Step 3️⃣: Try navigating to MakeMyTrip
        try {
            driver.get("https://www.makemytrip.com/");
            System.out.println("✅ Page loaded successfully within timeout.");
        } catch (Exception e) {
            System.out.println("⏰ Timeout Exception: MakeMyTrip did not load within 5 seconds.");
            System.out.println("🔍 Exception Message: " + e.getMessage());
        }

        // Step 4️⃣: Close the browser
        driver.quit();
    }
}
