package org.example.Ex13_DataDrivenTesting;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Utility class to perform Data-Driven operations on Excel files using Apache POI.
 * Supports reading row/cell count, reading/writing data, and formatting cells with colors.
 */
public class ExcelUtils {

    // Global static references for reuse across methods
    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static CellStyle style;

    /**
     * Returns the number of non-empty rows in a given Excel sheet.
     */
    public static int getRowCount(String filePath, String sheetName) throws IOException {
        fi = new FileInputStream(filePath);                 // Open Excel file
        wb = new XSSFWorkbook(fi);                          // Load workbook
        ws = wb.getSheet(sheetName);                        // Access specified sheet
        int rowCount = ws.getLastRowNum();                  // Get index of last non-empty row
        wb.close(); fi.close();                             // Close resources
        return rowCount;                                    // Return total row count
    }

    /**
     * Returns the number of cells (columns) in a specified row of a sheet.
     */
    public static int getCellCount(String filePath, String sheetName, int rowNum) throws IOException {
        fi = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rowNum);                            // Get specific row
        int cellCount = row.getLastCellNum();               // Get number of cells in that row
        wb.close(); fi.close();
        return cellCount;
    }

    /**
     * Retrieves the data from a specific cell as a String.
     * Returns an empty string if the cell is null or unreadable.
     */
    public static String getCellData(String filePath, String sheetName, int rowNum, int colNum) throws IOException {
        fi = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rowNum);
        cell = row.getCell(colNum);

        String data;
        try {
            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);      // Convert cell value to string

        } catch (Exception e) {
            data = "";                                      // Return empty if cell is null
        }

        wb.close(); fi.close();
        return data;
    }

    /**
     * Sets the value of a specific cell in a sheet.
     */
    public static void setCellData(String filePath, String sheetName, int rowNum, int colNum, String data) throws IOException {
        fi = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rowNum);

        if (row == null) {                                  // Create row if it doesn't exist
            row = ws.createRow(rowNum);
        }

        cell = row.createCell(colNum);                      // Create or overwrite cell
        cell.setCellValue(data);                            // Set value

        fo = new FileOutputStream(filePath);                // Open file output stream
        wb.write(fo);                                       // Write changes to file

        fo.close(); wb.close(); fi.close();
    }

    /**
     * Fills the specified cell with green background color (typically for pass status).
     */
    public static void fillGreenColor(String filePath, String sheetName, int rowNum, int colNum, String data) throws IOException {
        fi = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rowNum);
        cell = row.getCell(colNum);

        if (cell == null) {                                 // Create cell if it doesn't exist
            cell = row.createCell(colNum);
        }

        style = wb.createCellStyle();                       // Create new cell style
        style.setFillForegroundColor(IndexedColors.GREEN.getIndex()); // Set foreground to green
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);       // Solid fill

        cell.setCellStyle(style);                           // Apply style to cell

        fo = new FileOutputStream(filePath);
        wb.write(fo);                                       // Save the workbook with changes

        fo.close(); wb.close(); fi.close();
    }

    /**
     * Fills the specified cell with red background color (typically for fail status).
     */
    public static void fillRedColor(String filePath, String sheetName, int rowNum, int colNum, String data) throws IOException {
        fi = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rowNum);
        cell = row.getCell(colNum);

        if (cell == null) {
            cell = row.createCell(colNum);
        }

        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);
        fo = new FileOutputStream(filePath);
        wb.write(fo);

        fo.close(); wb.close(); fi.close();
    }
}
