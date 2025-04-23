package org.example.Ex10_Selenium_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Notes {
    public static void main(String[] args) throws InterruptedException {

        // ---------------------------------------------
        // 🔄 Selenium Waits: Overview
        // ---------------------------------------------


        // 1️⃣ Thread.sleep() - Java's Static Wait
        // ---------------------------------------------
        // ➤ Not part of Selenium (comes from Java)
        // ➤ Always waits for the exact duration, no matter if the element is ready or not
        // ➤ Syntax: Thread.sleep(milliseconds);
        // ➤ Use only for quick debugging, not recommended in production
        // ➤ Example:

        Thread.sleep(3000);  // Waits exactly 3 seconds


        // 2️⃣ Implicit Wait - Global Selenium Wait
        // ---------------------------------------------
        // ➤ Tells WebDriver to wait for a certain time before throwing NoSuchElementException
        // ➤ Applies to all elements in the driver instance
        // ➤ Set once and it will be used throughout the session
        // ➤ Syntax:

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // waits up to 10s
        // ➤ Best for general use where elements usually load within a fixed time


        // 3️⃣ Explicit Wait - Condition-Based Wait
        // ---------------------------------------------
        // ➤ Waits for a specific condition to occur (like visibility, clickability, etc.)
        // ➤ More flexible and powerful than implicit wait
        // ➤ Uses WebDriverWait and ExpectedConditions
        // ➤ Syntax:

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));
        // ➤ Best used when elements take varying time to appear or change


        // 4️⃣ Fluent Wait - Advanced Explicit Wait
        // ---------------------------------------------
        // ➤ Like Explicit Wait but lets you customize polling frequency and exceptions to ignore
        // ➤ Used in complex or flaky scenarios
        // ➤ Syntax:

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        // ➤ Use when you want fine-grained control


        // ---------------------------------------------
        // 🔁 Summary:
        // ---------------------------------------------
        // 🔹 Thread.sleep() → Static, not recommended
        // 🔹 Implicit Wait → Global, simple
        // 🔹 Explicit Wait → Smart, condition-based
        // 🔹 Fluent Wait → Customizable, advanced version of explicit

    }
}
