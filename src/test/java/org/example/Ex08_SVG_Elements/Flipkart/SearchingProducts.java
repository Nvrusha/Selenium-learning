package org.example.Ex08_SVG_Elements.Flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class SearchingProducts {
    public static void main(String[] args) {
        // Step 1: Set up ChromeOptions to customize browser behavior
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Start the browser in maximized mode

        // Step 2: Initialize the WebDriver with ChromeDriver and the defined options
        WebDriver driver = new ChromeDriver(options);

        // Step 3: Navigate to the Flipkart website
        driver.get("https://www.flipkart.com/");

        // Step 4: Locate the search input field using its 'name' attribute and enter the product name
        driver.findElement(By.name("q")).sendKeys("Dove"); // Input "Dove" into the search bar

        // Step 5: Locate the search icon, which is an SVG element, using its XPath
        // SVG elements in the DOM need special handling, hence the use of `[name()='svg']`
        List<WebElement> svgElements = driver.findElements(By.xpath("//*[name()='svg']"));

        // Step 6: Click on the first SVG element found, which is assumed to be the search icon
        svgElements.get(0).click();

        // Step 7: To print the list of all searched items
        List<WebElement> titleResults = driver.findElements(By.xpath("//div[contains(@class,'slAVV4')]/a[2]"));

        for (WebElement title : titleResults){
            System.out.println(title.getText());
            System.out.println();
        }

        // Step 8: Close the browser after the operation is complete
        driver.close();

    }
}
