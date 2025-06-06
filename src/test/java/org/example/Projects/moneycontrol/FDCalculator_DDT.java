package org.example.Projects.moneycontrol;

import org.example.Ex13_DataDrivenTesting.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class FDCalculator_DDT {
    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

        // Closing the overlays
        driver.findElement(By.xpath("//button[@id='wzrk-cancel']")).click();

        String filePath = System.getProperty("user.dir") + "\\TestData\\calcdata1.xlsx";

        int rows = ExcelUtils.getRowCount(filePath,"Sheet1");

        for (int i = 1; i <= rows; i++) {

            // Read data from excel
            String principleAmount = ExcelUtils.getCellData(filePath,"Sheet1", i, 0);
            String rateOfInterest = ExcelUtils.getCellData(filePath,"Sheet1", i, 1);
            String period = ExcelUtils.getCellData(filePath,"Sheet1", i, 2);
            String periodType = ExcelUtils.getCellData(filePath,"Sheet1", i, 3);
            String frequency = ExcelUtils.getCellData(filePath,"Sheet1", i, 4);
            String expectedMaturity = ExcelUtils.getCellData(filePath,"Sheet1", i, 5);


            // Pass excel data into application

            driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principleAmount);
            driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateOfInterest);
            driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period);

            Select periodDropDown = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
            periodDropDown.selectByVisibleText(periodType);

            Select frequencyDropDown = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
            frequencyDropDown.selectByVisibleText(frequency);

            driver.findElement(By.xpath("//div[@class='CTR PT15']//a")).click();

            // Validate the results

            String actualMaturity = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();

            if (Double.parseDouble(expectedMaturity) == Double.parseDouble(actualMaturity)){
                System.out.println("Test passed");
                //ExcelUtils.setCellData(filePath,"Sheet1", i, 6, "Passed");
                ExcelUtils.fillGreenColor(filePath,"Sheet1", i, 6,"Passed");
            }
            else {
                System.out.println("Test failed");
                ExcelUtils.fillRedColor(filePath,"Sheet1", i, 6,"Failed");
            }

            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@class='CTR PT15']//a[2]")).click();

        }

        driver.close();
    }
}
