package org.example.Ex07_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Print_AllData {
    public static void main(String[] args) {
        // Step 1: Initialize the WebDriver (ChromeDriver in this case)
        WebDriver driver = new ChromeDriver();

        // Step 2: Navigate to the web page containing the web table
        driver.get("https://awesomeqa.com/webtable.html");

        // Step 3: Define parts of the dynamic XPath for table cells
        String first_Part = "//table[@id='customers']/tbody/tr["; // Beginning of row XPath
        String second_Part = "]/td["; // Middle part for column XPath
        String third_Part = "]"; // Closing bracket of XPath

        // Step 4: Find the total number of rows in the table
        // Exclude the header row (if any) to get only the data rows
        int rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();

        // Step 5: Find the total number of columns in the second row
        // Assuming all rows have the same number of columns
        int cols = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();

        // Step 6: Loop through each row and column to extract and print table data
        for (int i = 2; i <= rows; i++) { // Start from row 2 to skip the header row
            for (int j = 1; j <= cols; j++) { // Loop through all columns in the current row

                // Step 7: Construct the dynamic XPath for each cell
                String dynamic_Path = first_Part + i + second_Part + j + third_Part;

                // Step 8: Fetch the text content of the cell using the dynamic XPath
                String data = driver.findElement(By.xpath(dynamic_Path)).getText();

                // Step 9: Print the cell data to the console
                System.out.println("Row " + (i - 1) + ", Column " + j + ": " + data);
            }
        }

        // Step 10: Close the browser after the operation is complete
        driver.quit();
    }
}
