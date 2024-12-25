package org.example.Ex01.Selenium_Basics1;

// Test case
//1. Launch browser (chrome).
//2. Open URL - https://www.opencart.com/index.php?route=cms/demo
//3. Validate title should be 'OpenCart - Demo'
//4. Close browser

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstTestCase {
    public static void main(String[] args) {

        //1. Launch browser (chrome).

        // Launch Chrome browser using ChromeDriver
        ChromeDriver driver = new ChromeDriver();

        // Alternative: You can use WebDriver interface to launch Edge browser
        // WebDriver driver1 = new EdgeDriver();

        //2. Open URL - https://www.opencart.com/index.php?route=cms/demo

        driver.get("https://www.opencart.com/index.php?route=cms/demo");

        //3. Validate title should be 'OpenCart - Demo'

        String actualTitle = driver.getTitle(); // Get the title of the current page

        // Check if the title matches the expected value
        if (actualTitle.equals("OpenCart - Demo")){
            System.out.println("Test Passed"); // Print success message if the title matches
        }
        else {
            System.out.println("Test Failed");// Print failure message if the title does not match
        }

        //4. Close browser

        driver.quit(); // Use driver.quit() to close the entire browser and end the session

        // Alternative: Use driver.close() to close only the current browser tab
        //driver.close();


    }


}
