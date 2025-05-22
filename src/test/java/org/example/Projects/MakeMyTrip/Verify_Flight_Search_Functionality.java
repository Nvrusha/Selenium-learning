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

    /**
     * Reusable method to select the date with the lowest available price from given calendar date cells.
     * @param dateCells List of WebElement representing date cells with price tags
     */
    public static void lowestPricesSelection(List<WebElement> dateCells) {
        int minPrice = Integer.MAX_VALUE;
        WebElement minPriceDateElement = null;

        for (WebElement cell : dateCells) {
            try {
                WebElement priceElement = cell.findElement(By.xpath(".//p[2]"));
                String priceText = priceElement.getText().replaceAll("[^0-9]", "");
                if (!priceText.isEmpty()) {
                    int price = Integer.parseInt(priceText);
                    if (price < minPrice) {
                        minPrice = price;
                        minPriceDateElement = cell;
                    }
                }
            } catch (Exception e) {
                // Skip this cell if no price is found
                continue;
            }
        }

        if (minPriceDateElement != null) {
            minPriceDateElement.click();
            System.out.println("✅ Selected lowest-priced date: ₹" + minPrice);
        } else {
            System.out.println("❌ No date with price found.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Step 1️⃣: Initialize WebDriver and wait
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 2️⃣: Open MakeMyTrip website
        driver.get("https://www.makemytrip.com/");

        // Step 3️⃣: Handle optional login popup overlay
        try {
            WebElement popupClose = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".commonModal__close")));
            popupClose.click();
        } catch (Exception e) {
            System.out.println("No popup appeared.");
        }

        // Click blank area to remove focus from login or auto-input fields
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='fswTabs latoRegular darkGreyText ']//li[2]"))).click();

        // Step 4️⃣: Enter "From" city as New Delhi
        WebElement fromCity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='fromCity']")));
        fromCity.click();

        WebElement fromInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='From']")));
        fromInput.sendKeys("New Delhi");

        WebElement fromSuggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='makeFlex appendTop12  forHideundefined']")));
        fromSuggestion.click();

        // Step 5️⃣: Enter "To" city as Mumbai
        WebElement toCity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='toCity']")));
        toCity.click();

        WebElement toInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='To']")));
        toInput.sendKeys("Mumbai");

        WebElement toSuggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@role='listbox']//li[contains(@id,'section-0-item-0')]")));
        toSuggestion.click();

        // Step 6️⃣: Select departure date (lowest-priced)
        WebElement departureField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='departure']")));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(departureField)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", departureField);
        }

        // Fetch all dates in visible second month and select the cheapest one
        List<WebElement> dateCells = driver.findElements(By.xpath("//div[@class='DayPicker-Month'][2]//div[@class='dateInnerCell']"));
        lowestPricesSelection(dateCells);

        // Step 7️⃣: Select return date (from next month with lowest price)
        WebElement returnField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='return']")));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(returnField)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", returnField);
        }

        // Store current visible month before clicking next
        String currentMonth = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();

        // Click the next month arrow
        WebElement nextArrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")));
        nextArrow.click();

        // Wait for the month to change (ensure calendar updated)
        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBePresentInElementLocated(
                        By.xpath("//div[@class='DayPicker-Caption']"), currentMonth
                )
        ));

        // Select lowest price date in the newly visible month
        List<WebElement> returnDateCells = driver.findElements(By.xpath("//div[@class='DayPicker-Month'][2]//div[@class='dateInnerCell']"));
        lowestPricesSelection(returnDateCells);

        // Step 9️⃣: Close browser
        driver.quit();
    }
}
