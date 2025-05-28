package org.example.Ex13_DataDrivenTesting.ReadingData;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;



public class Practice {
    public static void main(String[] args) throws IOException {



//         * ✅ Test Scenario: Read and Print Excel Data (Data-Driven Testing)
//         *
//         * Objective:
//         * To verify the ability to read an Excel (.xlsx) file, fetch the number of rows and columns,
//         * and print each cell's data using Apache POI.
//         *
//         * Test Steps:
//         * 1. Load the Excel file using FileInputStream.
//         * 2. Access the workbook and select the sheet named "data".
//         * 3. Get the total number of rows and columns.
//         * 4. Loop through each row and column and print the cell data.
//         * 5. Close resources properly to avoid memory leaks.
//         *
//         * Expected Result:
//         * - Data from each cell is printed correctly to the console.
//         * - No exceptions or errors while reading the file.


        // Step 1: Load the Excel file
        // Use FileInputStream to read the .xlsx file located at the given path
        FileInputStream file = new FileInputStream("C:\\Users\\visha\\IdeaProjects\\Selenium\\TestData\\MOCK_DATA.xlsx");

        // Step 2: Create a workbook instance that refers to the Excel file
        // XSSFWorkbook is used for .xlsx files
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        // Step 3: Access the specific worksheet
        // Here, we're accessing the sheet named "data"
        XSSFSheet sheet = workbook.getSheet("data");

        // Step 4: Get the total number of rows with data
        // getLastRowNum() returns the index of the last row (zero-based)
        int totalRows = sheet.getLastRowNum();

        // Step 5: Get the total number of cells (columns) in the second row
        // getLastCellNum() returns number of cells in a row (1-based)
        int totalCells = sheet.getRow(1).getLastCellNum();

        // Step 6: Print row and column info for verification
        System.out.println("✅ Number of rows: " + totalRows);
        System.out.println("✅ Number of cells: " + totalCells);

        // Step 7: Loop through each row and column to read and print data
        for (int i = 0; i <= totalRows; i++) {
            XSSFRow currentRow = sheet.getRow(i); // Get the current row

            for (int j = 0; j < totalCells; j++) {
                XSSFCell cell = currentRow.getCell(j); // Get each cell in the row

                // Print the cell value as a string (will automatically convert numeric, string, etc.)
                System.out.println(cell.toString());
            }
        }

        // Step 8: Close the workbook and file to release memory/resources
        workbook.close();
        file.close();
    }
}
