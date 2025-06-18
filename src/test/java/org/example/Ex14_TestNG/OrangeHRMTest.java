package org.example.Ex14_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRMTest {

    WebDriver driver;
    @Test(priority = 1)
    void openApp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 2)
    void testLogo(){

       boolean status = driver.findElement(
               By.xpath("//div[@class='orangehrm-login-branding']")).isDisplayed();

       if (status){
           System.out.println("Logo displayed...");
       }
       else {
           System.out.println("Logo is not displayed...");
       }
    }

    @Test(priority = 3)
    void testLogin(){

    }

    @Test(priority = 4)
    void testLogout(){

    }
}
