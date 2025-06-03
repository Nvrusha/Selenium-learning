package org.example.Ex13_DataDrivenTesting;

public class Notes {
    public static void main(String[] args) {
        /*
         * 🔍 DATA-DRIVEN TESTING (DDT) – NOTES
         * ------------------------------------
         * ✅ What is Data-Driven Testing?
         * Data-Driven Testing is a testing methodology in which test data is stored externally
         * (like in Excel, CSV, JSON, XML, or databases), and the same test logic is executed multiple times
         * with different sets of input values and expected results.
         *
         * ✅ Why use Data-Driven Testing?
         * - Reduces code duplication: one test logic, many data inputs.
         * - Enhances test coverage by testing multiple combinations and edge cases.
         * - Easy to maintain and scale as adding test cases means just updating the data file.
         *
         * ✅ Real-World Example:
         * - A login test that needs to verify multiple username/password combinations.
         * - A registration form that should accept and reject data based on different conditions.
         *
         * ✅ Common External Data Sources:
         * - Excel (.xlsx or .xls) ➝ most commonly used
         * - CSV files
         * - JSON or XML files
         * - SQL databases
         *
         * ✅ Tools & Libraries used with DDT:
         * - Apache POI: To read/write Excel files (.xlsx, .xls)
         * - OpenCSV: For reading CSV files
         * - Jackson/Gson: For JSON files
         * - JDBC: For database-driven tests
         * - TestNG / JUnit: To run data-driven tests (via @DataProvider in TestNG)

         * ✅ Key Components in Excel-based DDT:
         * - FileInputStream: To read the file from the system
         * - XSSFWorkbook / HSSFWorkbook: Workbook representation of .xlsx or .xls
         * - XSSFSheet: Specific sheet inside the workbook
         * - XSSFRow & XSSFCell: Representing rows and cells for accessing data

         * ✅ Best Practices:
         * - Always close file streams to avoid memory leaks.
         * - Use try-with-resources or finally blocks for resource handling.
         * - Handle null values and missing cells gracefully.
         * - Keep test data clean, well-formatted, and separate from logic.
         *
         * ✅ Sample Test Data Table (Excel Sheet: "data"):
         * -------------------------------------------------
         * | Username    | Password  | Expected Result     |
         * |-------------|-----------|---------------------|
         * | user1       | pass123   | Login Successful    |
         * | user2       | wrongpass | Invalid Credentials |
         * | empty       | pass      | Username required   |
         *
         * ✅ Execution Flow:
         * 1. Read Excel data using Apache POI.
         * 2. Extract values row by row.
         * 3. Pass each row's data as input to the test method.
         * 4. Validate the actual outcome against the expected result.
         */

    }
}
