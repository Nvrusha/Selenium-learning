package org.example.Ex09_Shadow_DOM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SelectorsHUb {
    public static void main(String[] args) throws InterruptedException {

        // Step 1: Set up ChromeOptions to customize browser behavior.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Open browser in maximized mode

        // Step 2: Initialize the WebDriver with ChromeDriver and defined options
        WebDriver driver = new ChromeDriver(options);

        // Step 3: Navigate to the SelectorsHub page
        driver.get("https://selectorshub.com/xpath-practice-page/");

        // Step 4: Typecast WebDriver to JavascriptExecutor for executing JS commands
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Step 5: Locate the element to scroll to and bring it into view
        WebElement toScroll = driver.findElement(By.xpath("//div[@id='userName']"));
        js.executeScript("arguments[0].scrollIntoView(true);", toScroll);

        // Adding delay after scrolling
        Thread.sleep(15000);

        // Step 6: Access the shadow DOM and find the input field inside it

        WebElement userName = (WebElement) js.executeScript(
                "return document.querySelector('#userName').shadowRoot.querySelector('#kils')"
        ); // UserName input field

        WebElement pizzaName = (WebElement) js.executeScript(
                "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")"
        ); // pizzaName input field


        // Step 7: Send input value to the located shadow DOM element
        userName.sendKeys("Vrusha1234");
        pizzaName.sendKeys("Margherita pizza");


        // Adding delay before quiting
        Thread.sleep(2000);

        // Step 8: Close the browser session properly
        System.out.println("Test passed!");
        driver.quit();

    }

}
