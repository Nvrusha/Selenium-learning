package org.example.Ex13_DataDrivenTesting.ReadingData;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Practice {
    public static void main(String[] args) throws IOException {

        // Step 1: Define test data path
        // Description: Load the Excel file using FileInputStream
        FileInputStream file = new FileInputStream("C:\\Users\\visha\\IdeaProjects\\Selenium\\TestData\\MOCK_DATA.xlsx");

        // Step 2: Create an instance of XSSFWorkbook to read .xlsx format
        // Description: This reads the Excel workbook from the input stream
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        // Step 3: Access the specific sheet by name
        // Description: We're targeting the sheet named "data"
        XSSFSheet sheet = workbook.getSheet("data");

        // Step 4: Fetch total number of rows
        // Note: getLastRowNum() returns the **zero-based** index of the last row with data
        int totalRows = sheet.getLastRowNum();

        // Step 5: Fetch total number of columns (cells) in second row (index 1)
        // Note: getLastCellNum() returns the number of cells, which is **1-based**
        int totalCells = sheet.getRow(1).getLastCellNum();

        // Step 6: Print the output to validate the data size
        System.out.println("✅ Number of rows: " + totalRows);
        System.out.println("✅ Number of cells: " + totalCells);

        // Step 7: Close the workbook (Good practice to release resources)
        workbook.close();
        file.close();
    }
}
