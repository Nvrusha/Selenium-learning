package org.example.Ex14_TestNG.Annotations.BeforeTest_AfterTest;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class B_VerifyFilters_Myntra {

    // ✅ Test Case: Apply a product filter on Myntra
    @Test()
    void applyFilters() throws InterruptedException {
        System.out.println("Running Filter Test...");

        // Click on the 'Heels' filter under product categories
        DriverManager.driver.findElement(By.xpath("//label[text()='Heels']")).click();

        // Wait for the filter to apply and results to update (static wait for demo purposes)
        Thread.sleep(2000);
    }

    // ✅ @AfterTest runs once after all @Test methods in the suite
    @AfterTest
    void tearDown() {
        System.out.println("Closing browser...");

        // Close the browser and end WebDriver session
        DriverManager.driver.quit();
    }
}
