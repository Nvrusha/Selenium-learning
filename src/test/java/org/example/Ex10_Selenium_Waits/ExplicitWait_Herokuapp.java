package org.example.Ex10_Selenium_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait_Herokuapp {
    public static void main(String[] args) {
        // -------------------------------------------------------------------------------------
        // ✅ Test Case: Validate Visibility of Dynamic Text Using Explicit Wait on HerokuApp
        //
        // 🔍 Scenario:
        // - Navigate to the "Dynamic Loading" page on HerokuApp.
        // - Click the "Start" button to trigger delayed content loading.
        // - Use explicit wait to wait until the "Hello World!" message is visible.
        // - Verify that the correct message is displayed on the screen.
        //
        // 🧪 Test Steps:
        // 1️⃣ Launch the Chrome browser and open the target URL.
        // 2️⃣ Click the "Start" button to initiate loading.
        // 3️⃣ Use explicit wait to wait until the result element becomes visible.
        // 4️⃣ Assert that the text "Hello World!" is displayed.
        // 5️⃣ Close the browser.
        // -------------------------------------------------------------------------------------

        // Step 1️⃣: Initialize WebDriver and maximize the window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2️⃣: Open the HerokuApp dynamic loading page
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // Step 3️⃣: Click the "Start" button to begin loading
        WebElement startBtn = driver.findElement(By.xpath("//div[@id='start']/button"));
        startBtn.click();

        // Step 4️⃣: Use explicit wait to wait until the "Hello World!" text is visible
        // Explicit wait declaration
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Usage of explicit wait
        WebElement resultText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4"))
        );

        // Step 5️⃣: Validate the displayed message
        if (resultText.getText().equals("Hello World!")) {
            System.out.println("✅ Test Passed: Message is displayed correctly");
        } else {
            System.out.println("❌ Test Failed: Unexpected or empty message -> '" + resultText.getText() + "'");
        }

        // Step 6️⃣: Close the browser
        driver.quit();
    }
}
