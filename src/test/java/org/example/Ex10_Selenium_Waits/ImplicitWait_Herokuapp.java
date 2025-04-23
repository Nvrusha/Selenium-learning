package org.example.Ex10_Selenium_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ImplicitWait_Herokuapp {
    public static void main(String[] args) throws InterruptedException {

        // -------------------------------------------------------------------------------------
        // 📌 Test Case: Verify Implicit Wait Functionality on The Internet HerokuApp
        // 📌 Scenario: Navigate to a dynamic loading page where content appears with a delay,
        // and use implicit wait to ensure Selenium waits until the element is available.
        //
        // ⚠️ Note: This example also demonstrates a limitation of implicit wait.
        // Implicit wait only waits for the presence of elements in the DOM.
        // It does NOT wait for content (like text) to be visible inside an element.
        //
        // ✅ Test Steps:
        // 1️⃣ Launch the browser and open the dynamic loading page.
        // 2️⃣ Set an implicit wait for the WebDriver.
        // 3️⃣ Click on the "Start" button to begin loading.
        // 4️⃣ Attempt to locate the "Hello World!" text using implicit wait.
        // 5️⃣ Validate that the correct message is displayed (may fail if content not visible yet).
        // 6️⃣ Close the browser.
        // -------------------------------------------------------------------------------------

        // Step 1️⃣: Initialize WebDriver and maximize the browser window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2️⃣: Set implicit wait (applies globally for all element lookups)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Step 3️⃣: Navigate to the Heroku dynamic loading page
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // Step 4️⃣: Click the "Start" button to begin loading
        WebElement startBtn = driver.findElement(By.xpath("//div[@id='start']/button"));
        startBtn.click();

        // Step 5️⃣: Locate the element that appears after loading
        // ⚠️ The element may be found, but its inner text ("Hello World!") might not be visible yet.
        // ❌ This is exactly why implicit wait is not reliable for dynamic content—
        // it only waits for the presence of the element in the DOM, not for visibility or content updates.
        // In such cases, it's better to use explicit wait with conditions like visibilityOfElementLocated.
        WebElement resultText = driver.findElement(By.xpath("//div[@id='finish']/h4"));

        // Step 6️⃣: Validate the result (may fail due to timing of dynamic content)
        if (resultText.getText().equals("Hello World!")) {
            System.out.println("✅ Test Passed: Message is displayed correctly");
        } else {
            System.out.println("❌ Test Failed: Unexpected or empty message -> '" + resultText.getText() + "'");
        }

        // Step 7️⃣: Close the browser
        driver.quit();
    }
}
