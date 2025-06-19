package org.example.Ex14_TestNG.Annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BeforeMethod_AfterMethod {
    WebDriver driver;

    @BeforeMethod
    void Setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    // ✅ Test 1: Validate page title
    @Test
    void verifyTitle(){
        String expectedTitle = "OrangeHRM";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title is correct..");
        }
        else {
            System.out.println("Title is incorrect..");
        }
    }

    // ✅ Runs after every @Test method

    @AfterMethod
    void teardown(){
        driver.quit();  // Closes all browser windows
    }
}
