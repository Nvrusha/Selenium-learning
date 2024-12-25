package org.example.Ex02_Selenium_Basics;

// Test case 2
//1. Launch browser (chrome).
//2. Open URL - https://app.vwo.com/#/login
//3. Validate the page contains "Sign in to VWO platform"
//4. Close browser

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondTestCase {
    public static void main(String[] args) {

        // Step 1: Launch the Chrome browser
        WebDriver driver = new ChromeDriver();

        // Step 2: Open the VWO login page URL
        driver.get("https://app.vwo.com/#/login");
        // Optional: Maximize the browser window for better visibility
        driver.manage().window().maximize();


        // Step 3: Validate that the page contains the text "Sign in to VWO platform"
        if (driver.getPageSource().contains("Sign in to VWO platform")){
            System.out.println("Sign in to VWO platform - is visible");
        }
        else {
            System.out.println("Sign in to VWO platform - Not visible");
        }

        // Step 4: Close the browser
        driver.close();
    }
}
