package org.example.Ex14_TestNG.Annotations.BeforeTest_AfterTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class VerifySearch_Myntra {

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
    void VerifySearch() throws InterruptedException {
        System.out.println("Searching for shoes...");
        driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("Shoes for women");
        driver.findElement(By.xpath("//a[@class='desktop-submit']")).click();

        Thread.sleep(3000);  // Wait for products to load

        List<WebElement> listOfShoes = driver.findElements(By.xpath("//div[@class ='product-productMetaInfo']/h4[1]"));

        for (WebElement shoes: listOfShoes){
            System.out.println(shoes.getText());
        }

    }




}
