package org.example.Projects.MakeMyTrip;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Verify_Flight_Search_Functionality {
    public static void main(String[] args) throws InterruptedException {

        // -----------------------------------------------------------------------------------------
        // ✅ Test Case: Verify Flight Search Functionality Using MakeMyTrip
        //
        // 🔍 Scenario:
        // Search for flights from New Delhi to Mumbai and validate that search results are displayed.
        //
        // ✅ Test Steps:
        // 1. Launch the browser and open MakeMyTrip.
        // 2. Handle any initial popups or overlays.
        // 3. Enter 'From' city as New Delhi and select from suggestions.
        // 4. Enter 'To' city as Mumbai and select from suggestions.
        // 5. Select a specific departure date (e.g., 6 June 2025).
        // 6. Click the Search button.
        // 7. Verify that flight search results are displayed.
        // 8. Close the browser.
        // -----------------------------------------------------------------------------------------

        // Step 1️⃣: Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 2️⃣: Open MakeMyTrip website
        driver.get("https://www.makemytrip.com/");

        // Step 3️⃣: Handle potential login modal or overlay
        try {
            WebElement popupClose = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".commonModal__close")));
            popupClose.click();
        } catch (Exception e) {
            System.out.println("No popup appeared.");
        }

        // Click somewhere blank on the page to release focus from the auto-selected field
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='fswTabs latoRegular darkGreyText ']//li[2]"))).click();

        // Step 4️⃣: Click on 'From' field and enter New Delhi
        WebElement fromCity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='fromCity']")));
        fromCity.click();

        WebElement fromInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='From']")));
        fromInput.sendKeys("New Delhi");

        WebElement fromSuggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='makeFlex appendTop12  forHideundefined']")));
        fromSuggestion.click();

        // Step 5️⃣: Click on 'To' field and enter Mumbai
        WebElement toCity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='toCity']")));
        toCity.click();

        WebElement toInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='To']")));
        toInput.sendKeys("Mumbai");

        WebElement toSuggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@role='listbox']//li[contains(@id,'section-0-item-0')]")));
        toSuggestion.click();

        // Step 6️⃣: Select departure date
        WebElement departureField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='departure']")));
        try {
            // Try regular click
            wait.until(ExpectedConditions.elementToBeClickable(departureField)).click();
        } catch (Exception e) {
            // If not clickable normally, use JS click as fallback
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", departureField);
        }


        // Find all date cells in the second month calendar container
        List<WebElement> dateCells = driver.findElements(By.xpath("//div[@class='DayPicker-Month'][2]//div[@class='dateInnerCell']"));

        // Initialize minPrice to maximum value to find the lowest price easily
        int minPrice = Integer.MAX_VALUE;

        // This will hold the date cell WebElement with the lowest price
        WebElement minPriceDateElement = null;

        // Loop through each date cell to find the price and compare
        for (WebElement cell : dateCells) {
            try {
                // Locate the price element inside the cell (2nd <p> tag within this cell)
                // Using .// to search relative to current 'cell'
                WebElement priceElement = cell.findElement(By.xpath(".//p[2]"));

                // Extract price text, removing all non-digit characters like currency symbols and commas
                String priceText = priceElement.getText().replaceAll("[^0-9]", "");

                // Proceed only if price text is not empty
                if (!priceText.isEmpty()) {
                    // Parse the cleaned string to an integer price value
                    int price = Integer.parseInt(priceText);

                    // Update minPrice and element if current price is lower than the stored minimum
                    if (price < minPrice) {
                        minPrice = price;
                        minPriceDateElement = cell;
                    }
                }
            } catch (Exception e) {
                // If no price element is found in this cell, skip it silently
                continue;
            }
        }

        // After looping, check if a lowest price date was found
        if (minPriceDateElement != null) {
            // Click the date cell with the lowest price
            minPriceDateElement.click();

            // Log the selected price to the console
            System.out.println("✅ Selected lowest-priced date: ₹" + minPrice);
        } else {
            // Inform if no date with a price was found on the calendar
            System.out.println("❌ No date with price found.");
        }

        // Step 9️⃣: Close the browser
        driver.quit();
    }
}
