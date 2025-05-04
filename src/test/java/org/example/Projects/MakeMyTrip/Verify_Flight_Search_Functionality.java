package org.example.Projects.MakeMyTrip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Verify_Flight_Search_Functionality {
    public static void main(String[] args) throws InterruptedException {

        //Test Case: Verify Flight Search Functionality Using JavaScript Executor
        //Scenario: Search for a flight from Delhi to Mumbai and validate the search results.
        //
        //Test Steps:

        // 1.Open MakeMyTrip website.
        // 2.Close any pop-ups or overlays (if applicable).
        // 3.Click on the From city field using JavaScript Executor.
        // 4.Enter Delhi and select it from the suggestions.
        // 5.Click on the To city field using JavaScript Executor.
        // 6.Enter Mumbai and select it from the suggestions.
        // 7.Select the departure date.
        // 8.Click the Search button using JavaScript Executor.
        // 9.Validate that flight search results are displayed.

        // Step 1: Initialize WebDriver and maximize the browser window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2: Navigate to MakeMyTrip website
        driver.get("https://www.makemytrip.com/");

        // Step 3: Close any pop-ups or overlays (if applicable).
        Thread.sleep(2000);
        WebElement popupClose = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
        popupClose.click();

        // Step 4: Click on the From city field using JavaScript Executor.
        WebElement fromCity = driver.findElement(By.xpath("//label[@for='fromCity']"));
        fromCity.click();

        // Step 5: Enter Delhi and select it from the suggestions.
        Thread.sleep(2000);
        WebElement fromCityInputBox = driver.findElement(By.xpath("//input[@placeholder='From']"));
        fromCityInputBox.sendKeys("New Delhi");

        //Click on the To city field using JavaScript Executor.
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']")).click();

        //Click on the To city field using JavaScript Executor.
        WebElement toCity = driver.findElement(By.xpath("//label[@for='toCity']"));
        toCity.click();

        //Enter Mumbai and select it from the suggestions.
        Thread.sleep(2000);
        WebElement toCityInputBox = driver.findElement(By.xpath("//input[@placeholder='To']"));
        toCityInputBox.sendKeys("Mumbai");

        //Click on the To city field using JavaScript Executor.
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']")).click();

        //Select the departure date.
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
        // Step 3️⃣: Select a specific date (Example: 6 June 2025)

        




        Thread.sleep(4000);
        //driver.close();



    }
}
