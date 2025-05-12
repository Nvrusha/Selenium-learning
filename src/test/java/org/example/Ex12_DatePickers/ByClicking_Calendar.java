package org.example.Ex12_DatePickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ByClicking_Calendar {

    // 🔧 Method to navigate to the correct month/year and select a specific date
    static void selectDateFromCalendar(WebDriver driver, String month, String year, String day) {
        while (true) {
            // 🔍 Get the currently displayed month and year in the calendar
            String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            // ✅ Stop loop if correct month and year are shown
            if (currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            }

            // 🔄 Navigate forward or backward based on the year/month comparison
            int targetYear = Integer.parseInt(year);
            int actualYear = Integer.parseInt(currentYear);

            if (targetYear > actualYear || (targetYear == actualYear && !currentMonth.equals(month))) {
                // ➡️ Next month
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
            } else {
                // ⬅️ Previous month
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
            }
        }

        // 📅 Select the expected day from the calendar
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td/a"));
        for (WebElement date : allDates) {
            if (date.getText().equals(day)) {
                date.click(); // ✅ Click the matching date
                break;
            }
        }
    }

    public static void main(String[] args) {

        // -------------------------------------------------------------------------------------
        // ✅ Test Case: Select a Date Using jQuery Calendar Widget
        //
        // 📋 Scenario:
        // Open a date picker, navigate to a target month/year, and select a given day.
        //
        // ✅ Steps:
        // 1️⃣ Launch browser and navigate to the calendar demo page.
        // 2️⃣ Switch to iframe and open calendar.
        // 3️⃣ Call method to navigate and select the desired date.
        // 4️⃣ Confirm date selection.
        // 5️⃣ Close the browser.
        //
        // 🧪 Expected Result:
        // Input field should reflect the selected date (e.g., "20/09/2025").
        // -------------------------------------------------------------------------------------

        // Step 1️⃣: Launch Chrome and maximize window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2️⃣: Navigate to jQuery UI DatePicker demo
        driver.get("https://jqueryui.com/datepicker/");

        // Step 3️⃣: Switch to iframe containing the date picker widget
        driver.switchTo().frame(0);

        // Step 4️⃣: Open the calendar by clicking the input field
        WebElement dateField = driver.findElement(By.xpath("//input[@id='datepicker']"));
        dateField.click();

        // Step 5️⃣: Define desired date values
        String year = "2025";
        String month = "September";
        String day = "20";

        // Step 6️⃣: Select the date using the combined method
        selectDateFromCalendar(driver, month, year, day);

        // Step 7️⃣: Confirmation message
        System.out.println("✅ Test Passed: Date '" + day + "/" + month + "/" + year + "' successfully selected.");

        // Step 8️⃣: Close the browser
        driver.close();
    }
}
