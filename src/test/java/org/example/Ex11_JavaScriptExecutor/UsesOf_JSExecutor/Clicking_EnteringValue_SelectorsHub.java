package org.example.Ex11_JavaScriptExecutor.UsesOf_JSExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Clicking_EnteringValue_SelectorsHub {
    public static void main(String[] args) throws InterruptedException {

        // ================================================
        // Test Case: Verify Form Filling Using JavaScript Executor
        // Scenario: Fill out a sample form on SelectorsHub's XPath Practice Page and submit it.
        // ================================================

        // Test Steps:
        // 1. Open the SelectorsHub XPath Practice Page.
        // 2. Locate the "Email" field and enter an email using JavaScript Executor.
        // 3. Locate the "Password" field and enter a password using JavaScript Executor.
        // 4. Locate the first "Company" input field (if multiple exist) and enter a value using JavaScript Executor.
        // 5. Locate the first "Mobile Number" input field (if multiple exist) and enter a value using JavaScript Executor.
        // 6. Click the submit button using JavaScript Executor.
        // 7. Close the browser.

        // Step 1: Initialize WebDriver and maximize the browser window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2: Navigate to the SelectorsHub practice page**
        driver.get("https://selectorshub.com/xpath-practice-page/");

        // Initialize JavaScript Executor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Step 3: Locate Email Input Field and Enter Email Using JS Executor
        WebElement mailInput = driver.findElement(By.xpath("//input[@class='selectors-input jsSelector' and @title='Email']"));
        js.executeScript("arguments[0].value='vrushali@gmail.com'", mailInput);
        Thread.sleep(1000);

        // Step 4: Locate Password Input Field and Enter Password Using JS Executor
        WebElement passwordInput = driver.findElement(By.xpath("//input[@class='selectors-input jsSelector' and @title='Password']"));
        js.executeScript("arguments[0].value='Vrusha123$'", passwordInput);
        Thread.sleep(1000);

        // Step 5: Locate the First "Company" Input Field and Enter Value Using JS Executor
        List<WebElement> companyInput = driver.findElements(By.xpath("//input[@name='company']"));
        if (!companyInput.isEmpty()) {
            js.executeScript("arguments[0].value='Cognizant'", companyInput.get(0));
            Thread.sleep(1000);
        }

        // Step 6: Locate the First "Mobile Number" Input Field and Enter Value Using JS Executor
        List<WebElement> numberInput = driver.findElements(By.xpath("//input[@name='mobile number']"));
        if (!numberInput.isEmpty()) {
            js.executeScript("arguments[0].value='92635261767'", numberInput.get(0));
            Thread.sleep(1000);
        }

        // Step 7: Locate and Click the Submit Button Using JS Executor
        WebElement submitBtn = driver.findElement(By.xpath("//button[@value='Submit']")); // Ensure this XPath matches the actual submit button
        js.executeScript("arguments[0].click()", submitBtn);
        Thread.sleep(2000);


        // Step 8: Close the Browser
        driver.close();
    }
}
