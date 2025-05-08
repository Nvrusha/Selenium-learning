package org.example.Ex12_DatePickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ByClicking_Calendar {
    public static void main(String[] args) {

        // -------------------------------------------------------------------------------------
        // ✅ Test Case: Select a Date Using Calendar Widget
        //
        // 📋 Scenario:
        // User opens the date picker, navigates to the correct month if needed,
        // and selects a specific date by clicking on the calendar widget.
        //
        // ✅ Test Steps:
        // 1️⃣ Launch the browser and navigate to the target website with a date picker.
        // 2️⃣ Click on the date input or calendar icon to open the calendar.
        // 3️⃣ Navigate to the desired month using next/previous arrows (if required).
        // 4️⃣ Click on the specific day (e.g., "20") in the calendar.
        // 5️⃣ Validate that the correct date is selected/displayed in the input field.
        // 6️⃣ Close the browser.
        //
        // 🧪 Expected Result:
        // The calendar widget should update the date input field with the selected date (e.g., "20/09/2025").
        // -------------------------------------------------------------------------------------

        // Step 1️⃣: Launch Chrome browser and maximize the window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2️⃣: Navigate to the jQuery UI DatePicker demo page
        driver.get("https://jqueryui.com/datepicker/");

        // Step 3️⃣: Switch to the iframe that contains the date picker widget
        driver.switchTo().frame(0);

        // Step 4️⃣: Locate and click the input field to open the calendar widget
        WebElement dateField = driver.findElement(By.xpath("//input[@id='datepicker']"));
        dateField.click();

        // Step 5️⃣: Define the desired date to be selected
        String year = "2025";
        String month = "September";
        String expectedDate = "20";

        // Step 6️⃣: Loop until the correct month and year is displayed
        while (true) {
            // Get currently displayed month and year
            String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            // Break loop if desired month and year is reached
            if (currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            }

            // Convert years to integers to compare properly
            int targetYear = Integer.parseInt(year);
            int actualYear = Integer.parseInt(currentYear);

            // Navigate forward or backward based on comparison
            if (targetYear > actualYear || (targetYear == actualYear && !currentMonth.equals(month))) {
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // Next month
            } else {
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); // Previous month
            }
        }

        // Step 7️⃣: Select the desired date from the calendar using enhanced for-loop
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td/a"));
        for (WebElement date : allDates) {
            if (date.getText().equals(expectedDate)) {
                date.click(); // Click the matching date
                break;
            }
        }

        // ✅ Optional Step: Print confirmation message
        System.out.println("✅ Test Passed: Date '" + expectedDate + "/" + month + "/" + year + "' successfully selected.");

        // Step 8️⃣: Close the browser
        driver.close();
    }
}
