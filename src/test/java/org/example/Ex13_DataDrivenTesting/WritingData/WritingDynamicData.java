package org.example.Ex13_DataDrivenTesting.WritingData;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WritingDynamicData {
    public static void main(String[] args) throws IOException {

        /**
         * ✅ Test Scenario: Write Dynamic User Input to Excel File
         *
         * Objective:
         * - To accept dynamic user input (rows and columns) via console,
         * - and write the data to an Excel (.xlsx) file using Apache POI.
         *
         * Test Steps:
         * 1. Ask user for number of rows and columns.
         * 2. Create an Excel workbook and sheet.
         * 3. Loop over each row and column, take input and store in Excel.
         * 4. Save the file to the given directory.
         * 5. Close all resources.
         *
         * Expected Result:
         * - A file `myFile1.xlsx` is created under `TestData` folder.
         * - It contains the entered data in a table format.
         */

        // Step 1: Create a new workbook (represents Excel file in memory)
        XSSFWorkbook workbook = new XSSFWorkbook(); // This creates an in-memory Excel workbook

        // Step 2: Create a sheet named "DynamicData"
        XSSFSheet sheet = workbook.createSheet("DynamicData"); // Creates a worksheet inside the workbook

        Scanner sc = new Scanner(System.in);

        // Step 3: Ask user for number of rows and columns
        System.out.print("Enter number of rows:  ");
        int rowNum = sc.nextInt(); // Number of data rows user wants to input

        System.out.print("Enter number of cells (columns): ");
        int cellNum = sc.nextInt(); // Number of columns per row

        sc.nextLine(); // Consume newline character after integer input to avoid skipping nextLine()

        // Step 4 (Optional): Add a header row
        XSSFRow header = sheet.createRow(0); // Create first row for headers
        for (int c = 0; c < cellNum; c++) {
            System.out.print("Enter header name for column " + (c + 1) + ": ");
            String headerName = sc.nextLine(); // Read column header from user
            header.createCell(c).setCellValue(headerName); // Write header to Excel cell
        }

        // Step 5: Accept row-wise data from user and store in Excel
        for (int r = 1; r <= rowNum; r++) { // Start from 1 because 0 is header
            XSSFRow row = sheet.createRow(r); // Create new row at index r

            for (int c = 0; c < cellNum; c++) {
                System.out.print("Enter data for row " + r + ", column " + (c + 1) + ": ");
                String value = sc.nextLine(); // Read cell data from user
                row.createCell(c).setCellValue(value); // Write cell data to Excel
            }
        }

        // Step 6: Save the workbook to a file
        // Saves the created workbook as an Excel file under "TestData" folder inside the project directory
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\TestData\\myFile1.xlsx");
        workbook.write(file); // Write workbook content to file system

        // Step 7: Close resources
        workbook.close(); // Release workbook memory
        file.close();     // Close file stream

        System.out.println("✅ File 'myFile1.xlsx' created successfully with dynamic data.");
    }
}
