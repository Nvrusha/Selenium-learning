package org.example.Ex13_DataDrivenTesting.UpdatingData;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToSpecificCell {

    public static void main(String[] args) throws IOException {

        /*
         * ✅ Test Scenario: Write Data to a Specific Row and Column in an Excel Sheet
         *
         * Objective:
         * - To verify that data can be successfully written to a specific cell in an existing Excel sheet (.xlsx).
         *
         * Preconditions:
         * - Excel file 'myFile1.xlsx' should exist inside TestData folder.
         * - Sheet named "DynamicData" must be present inside the workbook.
         *
         * Test Steps:
         * 1. Load the Excel file using FileInputStream.
         * 2. Access the "DynamicData" sheet.
         * 3. Navigate to the desired row and column.
         * 4. Write "TestPassed" into Row 3, Column 2 (i.e., cell B3 in Excel).
         * 5. Save and close the file.
         *
         * Expected Result:
         * - The Excel file should be updated and contain the value "TestPassed" in cell B3.
         */

        // Step 1: Load the existing Excel file
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\myFile1.xlsx");

        // Step 2: Create workbook instance and access the desired sheet
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("DynamicData");

        // Step 3: Define target row and column (e.g., row 2 = 3rd row, column 1 = 2nd column in Excel)
        int rowIndex = 2;  // Row 3 (0-based indexing)
        int colIndex = 1;  // Column B (0-based indexing)

        // Step 4: Get or create the specific row
        XSSFRow row = sheet.getRow(rowIndex);
        if (row == null) {
            row = sheet.createRow(rowIndex);  // If row doesn't exist, create it
        }

        // Step 5: Get or create the specific cell
        XSSFCell cell = row.getCell(colIndex);
        if (cell == null) {
            cell = row.createCell(colIndex);  // If cell doesn't exist, create it
        }

        // Step 6: Write data into the specific cell
        cell.setCellValue("TestPassed");

        // Step 7: Close input stream before writing
        file.close();

        // Step 8: Write updated workbook back to the file
        FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "\\TestData\\myFile1.xlsx");
        workbook.write(fos);

        // Step 9: Close resources
        workbook.close();
        fos.close();

        System.out.println("✅ Data written to Row 3, Column 2 successfully!");
    }
}
