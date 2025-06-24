package org.example.Ex14_TestNG.Annotations.BeforeTest_AfterTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class VerifyFilters_Myntra {

    WebDriver driver;

    @Test
    void VerifyFilter(){

    }

    @AfterTest
    void tearDown() {
        System.out.println("Closing browser...");
        driver.quit();
    }
}
