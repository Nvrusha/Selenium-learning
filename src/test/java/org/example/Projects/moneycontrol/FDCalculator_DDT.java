package org.example.Projects.moneycontrol;

import org.example.Ex13_DataDrivenTesting.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;

public class FDCalculator_DDT {
    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

        String filePath = System.getProperty("user.dir") + "\\TestData\\caldata2.xlsx";

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

            // Validate the results
        }
    }
}
