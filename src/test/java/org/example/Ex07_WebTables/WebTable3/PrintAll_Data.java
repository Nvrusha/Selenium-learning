package org.example.Ex07_WebTables.WebTable3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintAll_Data {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");

        Thread.sleep(2000);

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("admin");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Hacker@4321");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();

        Thread.sleep(3000);

//        WebElement data = driver.findElement(By.xpath("//div[@role='row']/div/div/div/div[1]"));
////        data.getText();
//
////        driver.close();
    }
}
