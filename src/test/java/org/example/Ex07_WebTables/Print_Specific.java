package org.example.Ex07_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Print_Specific {
    public static void main(String[] args) {

        // Step 1: Initialize the WebDriver (ChromeDriver in this case)
        WebDriver driver = new ChromeDriver();

        // Step 2: Navigate to the web page containing the web table
        driver.get("https://awesomeqa.com/webtable.html");

        // Step 3: Define parts of the dynamic XPath to locate individual table cells
        String first_Part = "//table[@id='customers']/tbody/tr["; // Beginning of the row XPath
        String second_Part = "]/td["; // Middle part for the column XPath
        String third_Part = "]"; // Closing bracket of the XPath

        // Step 4: Determine the total number of rows in the table, including the header row
        int rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();

        // Step 5: Determine the total number of columns in the table by checking the second row
        int cols = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();

        // Step 6: Loop through each row and column to search for the specific data
        for (int i = 2; i <= rows; i++) { // Start from row 2 to exclude the header row
            for (int j = 1; j <= cols; j++) { // Loop through all columns in the current row

                // Step 7: Construct the dynamic XPath for the current cell
                String dynamic_Path = first_Part + i + second_Part + j + third_Part;

                // Step 8: Extract the text content of the current cell
                String data = driver.findElement(By.xpath(dynamic_Path)).getText();

                // Step 9: Check if the current cell contains the specific data ("Helen Bennett")
                if (data.contains("Helen Bennett")) { // If the data matches "Helen Bennett"

                    // Step 10: Create an XPath to find the data in the adjacent cell (same row)
                    String specific_Path = dynamic_Path + "/following-sibling::td";

                    // Step 11: Extract the text content of the related cell
                    String specific_Text = driver.findElement(By.xpath(specific_Path)).getText();

                    // Step 12: Print the specific data along with its related information
                    System.out.println("Helen Bennett lives in the " + specific_Text);
                }
            }
        }

        // Step 13: Close the browser after processing is complete
        driver.quit();
    }
}
