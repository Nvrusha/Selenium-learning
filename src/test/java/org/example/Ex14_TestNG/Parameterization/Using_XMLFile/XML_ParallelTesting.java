package org.example.Ex14_TestNG.Parameterization.Using_XMLFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class XML_ParallelTesting {

    WebDriver driver;

    @BeforeClass
    void setUp(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    @Test(priority = 1)
    void testLogo(){

        boolean logo = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']")).isDisplayed();
        Assert.assertEquals(logo, true);
    }

    @Test(priority = 2)
    void testTitle(){
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }

    @Test(priority = 3)
    void testURL(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
