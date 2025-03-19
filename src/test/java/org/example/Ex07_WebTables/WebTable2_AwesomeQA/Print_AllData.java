package org.example.Ex07_WebTables.WebTable2_AwesomeQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Print_AllData {
    public static void main(String[] args) {
        // Print all data for uneven rows and table

        // Step 1: Initialize the WebDriver (ChromeDriver in this case)
        WebDriver driver = new ChromeDriver();

        // Step 2: Navigate to the web page containing the web table
        driver.get("https://awesomeqa.com/webtable1.html");

        // Step 3: Locate the table element using its 'summary' attribute
        WebElement table = driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));

        // Step 4: Fetch all rows in the table
        // Use the <tr> tag to locate all rows in the table
        List<WebElement> rows_Table = table.findElements(By.tagName("tr"));

        // Step 5: Iterate through each row in the table
        for (int i = 0; i < rows_Table.size(); i++) {
            // Step 6: Fetch all columns (cells) in the current row
            List<WebElement> cols_Table = rows_Table.get(i).findElements(By.tagName("td"));

            // Step 7: Iterate through each cell and print the text content
            for (WebElement c : cols_Table) {
                // Print the text content of each cell
                System.out.println(c.getText());
            }
        }

        // Step 8: Close the browser window after the operation is complete
        driver.close();
    }
}
