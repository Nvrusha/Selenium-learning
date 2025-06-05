package org.example.Ex13_DataDrivenTesting;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {

    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static CellStyle style;

    public static int getRowCount(String filePath, String sheetName) throws IOException {

        fi = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        int rowCount = ws.getLastRowNum();
        wb.close();
        fi.close();
        return rowCount;

    }

}
