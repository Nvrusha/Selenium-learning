package org.example.Ex12_DatePickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePicker_3 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement dateField = driver.findElement(By.xpath("//input[@id='txtDate']"));
        dateField.click();

        WebElement yearDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select yearSelect = new Select(yearDropdown);
        yearSelect.selectByVisibleText("2035");

        WebElement monthDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select monthSelect = new Select(monthDropdown);
        monthSelect.selectByVisibleText("Jan");
    }
}
