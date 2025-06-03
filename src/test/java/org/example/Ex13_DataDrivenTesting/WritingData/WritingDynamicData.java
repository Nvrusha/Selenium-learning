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
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Step 2: Create a sheet named "DynamicData"
        XSSFSheet sheet = workbook.createSheet("DynamicData");

        Scanner sc = new Scanner(System.in);

        // Step 3: Ask user for number of rows and columns
        System.out.print("Enter number of rows of data (excluding headers): ");
        int rowNum = sc.nextInt();

        System.out.print("Enter number of cells (columns): ");
        int cellNum = sc.nextInt();

        sc.nextLine(); // Consume newline character after integer input

        // Step 4 (Optional): Add a header row
        XSSFRow header = sheet.createRow(0);
        for (int c = 0; c < cellNum; c++) {
            System.out.print("Enter header name for column " + (c + 1) + ": ");
            String headerName = sc.nextLine();
            header.createCell(c).setCellValue(headerName);
        }

        // Step 5: Accept row-wise data from user and store in Excel
        for (int r = 1; r <= rowNum; r++) { // Start from 1 because 0 is header
            XSSFRow row = sheet.createRow(r);

            for (int c = 0; c < cellNum; c++) {
                System.out.print("Enter data for row " + r + ", column " + (c + 1) + ": ");
                String value = sc.nextLine();
                row.createCell(c).setCellValue(value);
            }
        }

        // Step 6: Save the workbook to a file
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\TestData\\myFile1.xlsx");
        workbook.write(file);

        // Step 7: Close resources
        workbook.close();
        file.close();

        System.out.println("✅ File 'myFile1.xlsx' created successfully with dynamic data.");
    }
}
