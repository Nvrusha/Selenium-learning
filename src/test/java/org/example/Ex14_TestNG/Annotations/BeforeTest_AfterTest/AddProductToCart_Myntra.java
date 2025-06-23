package org.example.Ex14_TestNG.Annotations.BeforeTest_AfterTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddProductToCart_Myntra {

    WebDriver driver;

    @BeforeTest
    void launchBrowser(){
        System.out.println("Launching browser and opening Myntra...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.myntra.com/");
    }

    @Test
    void VerifyAddingToCart (){
        driver.findElement(By.xpath("//input[@class = 'desktop-searchBar']")).sendKeys("Shoes for women");
        driver.findElement(By.xpath("//a[@class='desktop-submit']")).click();
        driver.findElement(By.xpath("//img[contains(@title,'Back To School Shoes')]]")).click();
        driver.findElement(By.xpath("//p[text() ='7']")).click();
        driver.findElement(By.xpath("//div[contains(@class,'flex pdp-center')]")).click();
    }
}
