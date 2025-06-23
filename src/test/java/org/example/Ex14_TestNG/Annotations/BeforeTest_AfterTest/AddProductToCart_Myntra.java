package org.example.Ex14_TestNG.Annotations.BeforeTest_AfterTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddProductToCart_Myntra {

    WebDriver driver;

    @BeforeTest
    void launchBrowser() {
        System.out.println("Launching browser and opening Myntra...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.myntra.com/");
    }

    @Test
    void VerifyAddingToCart() throws InterruptedException {
        System.out.println("Searching for shoes...");
        driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("Shoes for women");
        driver.findElement(By.xpath("//a[@class='desktop-submit']")).click();

        Thread.sleep(3000);  // Wait for products to load

        System.out.println("Selecting a product...");
        driver.findElement(By.xpath("//img[contains(@title,'Back To School Shoes')]")).click();

        Thread.sleep(3000);  // Wait for product page to load

        System.out.println("Selecting shoe size...");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement sizeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(@class,'size-buttons-size-button') and text()='7']")));
        sizeButton.click();

        System.out.println("Adding to cart...");
        driver.findElement(By.xpath("//div[contains(@class,'flex pdp-center')]")).click();
    }

    @AfterTest
    void tearDown() {
        System.out.println("Closing browser...");
        driver.quit();
    }
}
