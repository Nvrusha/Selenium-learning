package org.example.Projects.MakeMyTrip;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Verify_Flight_Search_Functionality {

    // 🔁 Reusable method to select the date cell with the lowest price
    public static void lowestPricesSelection(WebDriver driver, List<WebElement> dateCells, String tripType) {
        int minPrice = Integer.MAX_VALUE; // Start with the maximum possible value
        WebElement minPriceDateElement = null; // Store element with lowest price

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        for (WebElement cell : dateCells) {
            try {
                // Find price inside cell (2nd <p> tag)
                WebElement priceElement = wait.until(driver1 -> cell.findElement(By.xpath(".//p[2]")));
                String priceText = priceElement.getText().replaceAll("[^0-9]", "");

                if (!priceText.isEmpty()) {
                    int price = Integer.parseInt(priceText);
                    if (price < minPrice) {
                        minPrice = price;
                        minPriceDateElement = cell;
                    }
                }
            } catch (Exception e) {
                // Skip if no price is found
                continue;
            }
        }

        // Click the cell with the lowest price, if found
        if (minPriceDateElement != null) {

            // Extract the date number (from first <p>)
            String date = minPriceDateElement.findElement(By.xpath(".//p[1]")).getText();

            // Extract month and year from parent calendar container (traverse up to DayPicker-Month)
            WebElement month = minPriceDateElement.findElement(By.xpath("./ancestor::div[contains(@class, 'DayPicker-Month')]//div[@class='DayPicker-Caption']"));
            String monthYear = month.getText();

            // Click the lowest price date
            minPriceDateElement.click();

            System.out.println("✅ Selected lowest-priced " + tripType + " date: " + date + " " + monthYear + " (₹" + minPrice + ")");

        } else {
            System.out.println("❌ No "+ tripType +" date with price found.");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // ✅ Step 1: Launch browser and set wait
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ✅ Step 2: Open MakeMyTrip website
        driver.get("https://www.makemytrip.com/");

        // ✅ Step 3: Handle potential pop-up (login or ads)
        try {
            WebElement popupClose = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".commonModal__close")));
            popupClose.click();
        } catch (Exception e) {
            System.out.println("No popup appeared.");
        }

        // Click somewhere blank to dismiss any auto-focus issues
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='fswTabs latoRegular darkGreyText ']//li[2]"))).click();

        // ✅ Step 4: Enter 'From' city - New Delhi
        WebElement fromCity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='fromCity']")));
        fromCity.click();

        WebElement fromInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='From']")));
        fromInput.sendKeys("New Delhi");

        WebElement fromSuggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='makeFlex appendTop12  forHideundefined']")));
        fromSuggestion.click();

        // ✅ Step 5: Enter 'To' city - Mumbai
        WebElement toCity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='toCity']")));
        toCity.click();

        WebElement toInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='To']")));
        toInput.sendKeys("Mumbai");

        WebElement toSuggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@role='listbox']//li[contains(@id,'section-0-item-0')]")));
        toSuggestion.click();

        // ✅ Step 6: Select lowest-priced departure date

//        WebElement departureField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='departure']")));
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(departureField)).click();
//        } catch (Exception e) {
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", departureField);
//        }

//        // Wait for calendar section to be visible
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//div[@class='DayPicker-Month'][2]")
//        ));

        // Get all date cells in the second month view
        List<WebElement> dateCells = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[@class='DayPicker-Month'][2]//div[@class='dateInnerCell']")
        ));
        lowestPricesSelection(driver, dateCells, "Departure"); // Call method to pick lowest price

        // ✅ Step 7: Select return date (next month lowest price)

        // Save current month to compare after clicking next
        String currentMonth = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();

        // Click next arrow to go to next month
        WebElement nextArrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")));
        nextArrow.click();

        // ✅ Wait until the month view updates (ensure DOM is refreshed)
        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBePresentInElementLocated(
                        By.xpath("//div[@class='DayPicker-Caption']"), currentMonth
                )
        ));

        // Get all date cells in the newly opened second month
        List<WebElement> returnDateCells = driver.findElements(By.xpath("//div[@class='DayPicker-Month'][2]//div[@class='dateInnerCell']"));
        lowestPricesSelection(driver, returnDateCells, "Return"); // Call method to pick lowest return price

        // ✅ Step 8: Click on the search button
        WebElement searchBtn = driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']"));
        searchBtn.click();

        // Temporary pause to visually observe the change (not recommended in real tests)
        Thread.sleep(2000);

        // ✅ Step 8: Close the browser
        driver.quit();
    }
}
