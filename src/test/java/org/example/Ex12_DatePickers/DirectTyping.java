package org.example.Ex12_DatePickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DirectTyping {
    public static void main(String[] args) throws InterruptedException {

        // -------------------------------------------------------------------------------------
        // ✅ Test Case: Select a Date in jQueryUI DatePicker by Typing
        //
        // 📋 Scenario:
        // The jQuery UI demo page contains a date picker input field within an iframe.
        // We'll directly type a date into the input field instead of using the calendar UI.
        //
        // ✅ Test Steps:
        // 1️⃣ Launch Chrome browser
        // 2️⃣ Navigate to https://jqueryui.com/datepicker/
        // 3️⃣ Switch into the iframe that contains the date picker
        // 4️⃣ Locate the date input field
        // 5️⃣ Type the desired date into the field (e.g., 20/09/2000)
        // 6️⃣ Verify the value entered in the field
        // 7️⃣ Print success message and close the browser
        //
        // 🧪 Expected Result:
        // The date field should contain "20/09/2000" without using the calendar popup.
        // -------------------------------------------------------------------------------------

        // Step 1️⃣: Launch the browser and maximize window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2️⃣: Navigate to the jQuery UI DatePicker demo page
        driver.get("https://jqueryui.com/datepicker/");

        // Step 3️⃣: Switch to the iframe that contains the date picker
        driver.switchTo().frame(0);

        // Step 4️⃣: Find the input field for the date
        WebElement dateField = driver.findElement(By.xpath("//input[@id='datepicker']"));

        // Step 5️⃣: Type the desired date directly into the input field
        String expectedDate = "20/09/2000";
        dateField.sendKeys(expectedDate);

        // Step 6️⃣: Verify the date value entered
        String actualDate = dateField.getAttribute("value");

        if (actualDate.equals(expectedDate)) {
            // Step 7️⃣: Print success message
            System.out.println("✅ Test Passed: Date successfully entered as " + actualDate);
        } else {
            System.out.println("❌ Test Failed: Expected '" + expectedDate + "' but found '" + actualDate + "'");
        }

        // Add wait, so that you can see the changes.
        Thread.sleep(2000);

        // Step 8️⃣: Close the browser
        driver.close();
    }
}
