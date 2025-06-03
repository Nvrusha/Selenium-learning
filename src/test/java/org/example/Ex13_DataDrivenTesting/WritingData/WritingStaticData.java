package org.example.Ex13_DataDrivenTesting.WritingData;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

// ✅ Test Scenario: Write User Data into Excel File
//
// 🎯 Objective:
// To verify that the program can create an Excel (.xlsx) file, write headers and multiple rows of user data,
// and store the file in the project directory using Apache POI.
//
// 🧪 Test Steps:
// 1. Create a blank workbook and a sheet named "Data".
// 2. Add a header row with fields: ID, Name, Email.
// 3. Add two rows of mock user data.
// 4. Use FileOutputStream to save the Excel file to the /TestData folder.
// 5. Verify the file is created and data is saved.
//
// ✅ Expected Result:
// - File "myFile.xlsx" is created successfully inside the TestData folder.
// - File contains the correct headers and user data rows.
// - No IOExceptions occur during file creation or saving.

public class WritingStaticData {
    public static void main(String[] args) throws IOException {

        // Step 1: Create a new workbook (represents the .xlsx file in memory)
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Step 2: Create a sheet named "Data" in the workbook
        XSSFSheet sheet = workbook.createSheet("Data");

        // Step 3: Create header row at index 0 and add column names
        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Email");

        // Step 4: Create first row of actual data at index 1
        XSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("12");
        row1.createCell(1).setCellValue("Vrushali");
        row1.createCell(2).setCellValue("asfasdfasd@gmail.com");

        // Step 5: Create second row of data at index 2
        XSSFRow row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("100");
        row2.createCell(1).setCellValue("Shea");
        row2.createCell(2).setCellValue("ioiuiyuity@gmail.com");

        // Step 6: Define output location using user.dir to ensure project-relative path
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\TestData\\myFile.xlsx");

        // Step 7: Write workbook data into the file
        workbook.write(file);

        // Step 8: Close resources to prevent memory leaks
        workbook.close();
        file.close();

        // Step 9: Print success message
        System.out.println("✅ File is created successfully at /TestData/myFile.xlsx");
    }
}
