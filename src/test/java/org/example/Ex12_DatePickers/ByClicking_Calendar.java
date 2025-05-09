package org.example.Ex12_DatePickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ByClicking_Calendar {

    // 🔧 Method to navigate to the desired month and year in the calendar
    static void selectMonthAndYear(WebDriver driver, String month, String year) {
        while (true) {
            // Get the currently displayed month and year
            String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            // Stop if the desired month and year are displayed
            if (currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            }

            // Convert year to integers for comparison
            int targetYear = Integer.parseInt(year);
            int actualYear = Integer.parseInt(currentYear);

            // Navigate to future or past month
            if (targetYear > actualYear || (targetYear == actualYear && !currentMonth.equals(month))) {
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // ➡️ Next
            } else {
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); // ⬅️ Previous
            }
        }
    }

    // 🔧 Method to select a specific date from the calendar
    static void selectDate(WebDriver driver, String expectedDate) {
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td/a"));
        for (WebElement date : allDates) {
            if (date.getText().equals(expectedDate)) {
                date.click(); // ✅ Click the matching date
                break;
            }
        }
    }

    public static void main(String[] args) {

        // -------------------------------------------------------------------------------------
        // ✅ Test Case: Select a Date Using Calendar Widget (Modular Approach)
        //
        // 📋 Scenario:
        // Open the date picker, navigate to the desired month/year, and click on a specific date.
        //
        // ✅ Steps:
        // 1️⃣ Launch browser and open the site.
        // 2️⃣ Open the date picker widget.
        // 3️⃣ Use method to select the correct month and year.
        // 4️⃣ Use method to click the expected date.
        // 5️⃣ Print success message.
        // 6️⃣ Close the browser.
        //
        // 🧪 Expected Result:
        // The date input should display the selected date (e.g., "20/09/2025").
        // -------------------------------------------------------------------------------------

        // Step 1️⃣: Setup browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2️⃣: Open jQuery UI DatePicker demo
        driver.get("https://jqueryui.com/datepicker/");

        // Step 3️⃣: Switch to iframe containing the date picker
        driver.switchTo().frame(0);

        // Step 4️⃣: Click date input field to open calendar
        WebElement dateField = driver.findElement(By.xpath("//input[@id='datepicker']"));
        dateField.click();

        // Step 5️⃣: Define target date
        String year = "2025";
        String month = "September";
        String expectedDate = "20";

        // Step 6️⃣: Navigate to correct month and year
        selectMonthAndYear(driver, month, year);

        // Step 7️⃣: Select the desired day
        selectDate(driver, expectedDate);

        // Step 8️⃣: Confirmation
        System.out.println("✅ Test Passed: Date '" + expectedDate + "/" + month + "/" + year + "' successfully selected.");

        // Step 9️⃣: Cleanup
        driver.close();
    }
}
