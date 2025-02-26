package org.example.Ex08_SVG_Elements.IndiaMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindState {
    public static void main(String[] args) throws InterruptedException {

        // Step 1: Set up ChromeOptions to customize browser behavior.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Open browser in maximized mode

        // Step 2: Initialize the WebDriver with ChromeDriver and the defined options
        WebDriver driver = new ChromeDriver(options);

        // Step 3: Navigate to the Maps page
        // Open the URL of the India map on the amcharts website
        driver.get("https://www.amcharts.com/svg-maps/?map=india");

        // Step 4: Handle popups
        // Click on the "I agree" button to accept cookies or any consent popup on the page
        driver.findElement(By.xpath("//button[text() = 'I understand and agree']")).click();

        // Step 5: Search for the Tripura state and click on it
        // Locate the state of Tripura using XPath with normalized spaces and click on it
        driver.findElement(By.xpath("//*[normalize-space(@aria-label)=\"Tripura\"]")).click();
        Thread.sleep(2000);

        // Step 6: Close the browser
        // Close the browser once the task is completed
        driver.close();

        System.out.println("Test case passed");
    }
}
