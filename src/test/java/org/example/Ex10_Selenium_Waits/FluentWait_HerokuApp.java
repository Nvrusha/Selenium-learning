package org.example.Ex10_Selenium_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWait_HerokuApp {
    public static void main(String[] args) {

        // ---------------------------------------------------------------------------------------------
        // ✅ Test Scenario: Interact with Dynamically Enabled Input Field using Fluent Wait
        // 📋 Test Case Name: Use Fluent Wait to Type into Input Field After It Becomes Enabled

        // 🔹 Test Steps:
        // 1️⃣ Launch the Chrome browser using Selenium WebDriver.
        // 2️⃣ Navigate to https://the-internet.herokuapp.com/dynamic_controls.
        // 3️⃣ Locate and click on the "Enable" button under the input field.
        // 4️⃣ Use Fluent Wait to:
        //     - Wait up to 10 seconds
        //     - Poll every 1 second
        //     - Ignore NoSuchElementException
        //     - Check if the input field becomes enabled
        // 5️⃣ Once the field is enabled, enter the text "Fluent wait success!" into the input field.
        // 6️⃣ Validate that no exception occurs and text is successfully typed.
        // 7️⃣ Print a message indicating the test result.
        // 8️⃣ Close the browser.
        // ---------------------------------------------------------------------------------------------

        // Step 1️⃣: Initialize WebDriver and maximize the window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2️⃣: Open the HerokuApp dynamic loading page
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Step 3️⃣: Click on the "Enable" button to start enabling the input field
        WebElement enableBtn = driver.findElement(By.xpath("//form[@id='input-example']/button"));
        enableBtn.click();

        // Step 4️⃣: Configure Fluent Wait
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))            // Total max wait time
                .pollingEvery(Duration.ofSeconds(2))            // Check every 1 second
                .ignoring(NoSuchElementException.class);        // Ignore if element is not yet present

        // Step 5️⃣: Use Fluent Wait to wait until the input field becomes enabled
        WebElement inputField = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                WebElement input = driver.findElement(By.xpath("//form[@id='input-example']/input"));
                return input.isEnabled() ? input : null;
            }
        });

        // Step 6️⃣: Type into the input field after it becomes enabled
        inputField.sendKeys("Fluent wait success!");

        // Step 7️⃣: Output confirmation
        System.out.println("✅ Test Passed: Input field was enabled and text was entered.");

        // Step 8️⃣: Close the browser
        driver.quit();

    }
}
