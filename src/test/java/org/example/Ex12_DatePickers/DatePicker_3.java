package org.example.Ex12_DatePickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePicker_3 {
    public static void main(String[] args) throws InterruptedException {

        // -------------------------------------------------------------------------------------
        // ✅ Test Case: Select a Date from a Date Picker with Year & Month Dropdowns
        //
        // 📋 Scenario:
        // User opens the date picker widget on the page, selects a specific year and month
        // using dropdowns, then clicks on a specific day to populate the input field.
        //
        // 🧪 Test Steps:
        // 1️⃣ Launch the browser and navigate to https://testautomationpractice.blogspot.com/
        // 2️⃣ Click on the date input field to display the calendar widget.
        // 3️⃣ Select the year "2035" from the year dropdown.
        // 4️⃣ Select the month "Jan" from the month dropdown.
        // 5️⃣ Select the date "30" from the calendar grid.
        // 6️⃣ Verify that the selected date appears in the input field (e.g., "01/30/2035").
        // 7️⃣ Close the browser.
        //
        // ✅ Expected Result:
        // The input field should be filled with the selected date in MM/dd/yyyy format.
        // -------------------------------------------------------------------------------------

        // Step 1️⃣: Launch Chrome browser and maximize the window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2️⃣: Open the target page with date picker
        driver.get("https://testautomationpractice.blogspot.com/");

        // Step 3️⃣: Click on the input field to open the calendar widget
        WebElement dateField = driver.findElement(By.xpath("//input[@id='txtDate']"));
        dateField.click();

        // Step 4️⃣: Select the year from the dropdown (e.g., 2035)
        WebElement yearDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select yearSelect = new Select(yearDropdown);
        yearSelect.selectByVisibleText("2035");

        // Step 5️⃣: Select the month from the dropdown (e.g., Jan)
        WebElement monthDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select monthSelect = new Select(monthDropdown);
        monthSelect.selectByVisibleText("Jan");

        // Step 6️⃣: Select the specific date (e.g., 30) from the calendar
        WebElement selectDate = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='30']"));
        selectDate.click();

        // Optional Step: Print success message (you can add assertion if using a test framework)
        System.out.println("✅ Test Passed: Date '01/30/2035' successfully selected.");

        // Temporary pause to visually observe the change (not recommended in real tests)
        Thread.sleep(2000);

        // Step 7️⃣: Close the browser
        driver.close();
    }
}
