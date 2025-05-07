package org.example.Ex12_DatePickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByClicking_Calendar {
    public static void main(String[] args) {

        //    -------------------------------------------------------------------------------------
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
        // 4️⃣ Click on the specific day (e.g., "10") in the calendar.
        // 5️⃣ Validate that the correct date is selected/displayed in the input field.
        // 6️⃣ Close the browser.
        //
        // 🧪 Expected Result:
        // The calendar widget should update the date input field with the selected date (e.g., "10/05/2025").
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
        dateField.click();

        //Expected data
        String year = "2000";
        String month = "September";
        String date = "20";

        while (true){
            // Actual data
           String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
           String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

           if (currentMonth.equals(month) && currentYear.equals(year)){
               break;
           }

            // Convert years to int for proper comparison
            int targetYear = Integer.parseInt(year);
            int actualYear = Integer.parseInt(currentYear);

           if (targetYear > actualYear || (targetYear == actualYear && !currentMonth.equals(month))){
               driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
           }
           else {
               driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
           }

        }
    }
}
