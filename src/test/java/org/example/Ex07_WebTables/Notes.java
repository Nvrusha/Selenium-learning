package org.example.Ex07_WebTables;

public class Notes {
    public static void main(String[] args) {
        /*
        // Web Tables in Selenium
        // Web tables are used on web pages to display data in a tabular format. Selenium provides
        tools to locate and interact with table elements.

        // 1. Static Web Table
        // A static web table has a fixed structure and content that does not change dynamically.
        // These are easier to handle as locators remain constant.

        // 2. Dynamic Web Table
        // A dynamic web table updates its content dynamically based on user interactions or backend updates.
        // These require dynamic locators or loops to handle.

        // HTML Structure of a Web Table
        // Example:
        // <table id="example">
        //     <thead>
        //         <tr>
        //             <th>Header 1</th>
        //             <th>Header 2</th>
        //         </tr>
        //     </thead>
        //     <tbody>
        //         <tr>
        //             <td>Row 1 Col 1</td>
        //             <td>Row 1 Col 2</td>
        //         </tr>
        //     </tbody>
        // </table>

        // Step 1: Locate the Table
        // Use a unique attribute like 'id', 'class', or 'XPath' to locate the table.
        // Example:
        WebElement table = driver.findElement(By.id("example"));

        // Step 2: Fetch Rows
        // Use 'findElements(By.tagName("tr"))' to retrieve all rows in the table.
        // Example:
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        System.out.println("Total Rows: " + rows.size());

        // Step 3: Fetch Columns
        // For a specific row, fetch all column elements using 'findElements(By.tagName("td"))'.
        // Example:
        List<WebElement> columns = rows.get(1).findElements(By.tagName("td")); // Fetch columns of the second row
        System.out.println("Total Columns in Row 2: " + columns.size());

        // Step 4: Fetch Specific Cell Data
        // Combine row and column indices to retrieve specific cell data.
        // Example:
        String cellData = rows.get(1).findElements(By.tagName("td")).get(0).getText();
        System.out.println("Data in Row 2, Column 1: " + cellData);

        // Step 5: Loop Through the Table
        // Use nested loops to print all table data.
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.print(col.getText() + " ");
            }
            System.out.println();
        }

        // Handling Table Headers
        // Use the 'th' tag to locate and interact with table headers.
        // Example:
        List<WebElement> headers = table.findElements(By.tagName("th"));
        for (WebElement header : headers) {
            System.out.println(header.getText());
        }

        // Searching for Specific Data in the Table
        // Example:
        String searchValue = "Row 2 Col 2";
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                if (col.getText().equals(searchValue)) {
                    System.out.println("Found: " + searchValue);
                    break;
                }
            }
        }

        // Dynamic XPath for Table Elements
        // Use XPath to locate specific cells or rows dynamically.
        // Example:
        // Locate a specific cell by row and column index
        WebElement cell = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[2]/td[1]"));
        System.out.println("Cell Data: " + cell.getText());

        // Best Practices
        // 1. Use loops for large tables to avoid unnecessary operations.
        // 2. Use dynamic locators for handling dynamic web tables.
        // 3. Wait for dynamic content to load using explicit waits.
        // 4. Handle empty rows or columns gracefully to avoid errors.
        */
    }
}
