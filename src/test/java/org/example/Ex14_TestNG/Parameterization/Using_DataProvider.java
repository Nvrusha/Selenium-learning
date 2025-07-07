package org.example.Ex14_TestNG.Parameterization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Using_DataProvider {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.out.println();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    void login() throws InterruptedException {
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("nivangunevrushali.vn@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Vrusha123$");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Thread.sleep(2000);

        boolean myAccountPage = driver.findElement(By.xpath("//h2[normalize-space(text())='My Account']")).isDisplayed();

        if (myAccountPage){
            driver.findElement(By.xpath("//div[@class='list-group']//a[contains(text(), 'Logout')]")).click();
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }



    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
