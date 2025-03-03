package org.example.Ex08_SVG_Elements.IndiaMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PrintAll_States {
    public static void main(String[] args) throws InterruptedException {

        // Step 1: Initialize the WebDriver (ChromeDriver) and maximize the browser window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2: Navigate to the India map page on the amcharts website
        driver.get("https://www.amcharts.com/svg-maps/?map=india");

        // Step 3: Handle the "I understand and agree" popup (if present)
        driver.findElement(By.xpath("//button[text() = 'I understand and agree']")).click();

        // Step 4: Locate all state elements inside the SVG map using XPath
        List<WebElement> states = driver.findElements(By.xpath(
                "//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"
        ));

        // Step 5: Iterate through each state, print its name, and click on Maharashtra
        for (WebElement state : states) {
            String stateName = state.getAttribute("aria-label"); // Get the state name
            System.out.println("State Name: " + stateName); // Print the state name

            // If the state is Maharashtra, click it
            if (stateName != null && stateName.contains("Maharashtra")) {
                state.click();
                System.out.println("Clicked on Maharashtra!");
            }
        }

        Thread.sleep(2000);

        // Step 6: Close the browser
        driver.close();
    }
}
