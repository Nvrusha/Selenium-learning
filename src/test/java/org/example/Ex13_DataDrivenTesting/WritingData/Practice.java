package org.example.Ex13_DataDrivenTesting.WritingData;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// Excel file ---> Workbook ---> Sheets ---> Cells
public class Practice {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Data");

        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Email");

        XSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("12");
        row1.createCell(1).setCellValue("Vrushali");
        row1.createCell(2).setCellValue("asfasdfasd@gmail.com");

        XSSFRow row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("100");
        row2.createCell(1).setCellValue("Shea");
        row2.createCell(2).setCellValue("ioiuiyuity@gmail.com");

        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\TestData\\myFile.xlsx");
        workbook.write(file);

        workbook.close();
        file.close();

        System.out.println("File is created...");
    }
}
