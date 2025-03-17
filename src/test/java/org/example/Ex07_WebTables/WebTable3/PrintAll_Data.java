package org.example.Ex07_WebTables.WebTable3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PrintAll_Data {
    public static void main(String[] args) throws InterruptedException {

        // Step 1: Initialize WebDriver and maximize the browser window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2: Navigate to the login page
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");

        // Pause to allow the page to load fully
        Thread.sleep(2000);

        // Step 3: Locate and interact with the username input field
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("admin"); // Enter username

        // Step 4: Locate and interact with the password input field
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Hacker@4321"); // Enter password

        // Step 5: Locate and click the login button to submit the form
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();

        // Pause to allow the page to navigate to the next section
        Thread.sleep(3000);

        // Step 6: Scroll down the page using JavaScript Executor
        JavascriptExecutor java = (JavascriptExecutor) driver;
        java.executeScript("window.scrollBy(0,500);"); // Scroll down by 500 pixels

        // Step 7: Locate all data elements in the 6th column of the web table
        List<WebElement> columnData =
                driver.findElements(By.xpath("//div[@class='oxd-table-card']/div/div[6]"));

        // Step 8: Iterate over each element in the 6th column
        for (WebElement data : columnData) {
            // Check if the text of the element equals "Terminated"
            if (data.getText().equals("Terminated")) {
                // Step 9: Locate the trash icon button and click it to delete the entry
                driver.findElement(By.xpath("//button/i[@class='oxd-icon bi-trash']")).click();
            }
        }

        // Step 10: Close the browser session
        driver.close();
    }
}
