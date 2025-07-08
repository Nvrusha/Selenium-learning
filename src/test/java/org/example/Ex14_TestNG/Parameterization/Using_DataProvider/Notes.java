package org.example.Ex14_TestNG.Parameterization.Using_DataProvider;

public class Notes {

    /*
      ✅ TestNG @DataProvider — Notes

     ✅ Purpose:
     -----------------------------
     - Used to supply multiple sets of data to a single test method.
     - Supports **Data-Driven Testing** in TestNG.
     - Helps in testing the same logic with multiple input values.

     ✅ Syntax:
     -----------------------------
     @DataProvider(name = "providerName")
     public Object[][] yourDataMethod() {
         return new Object[][] {
             {"input1", "input2"},
             {"input3", "input4"}
         };
     }

     @Test(dataProvider = "providerName")
     public void testMethod(String val1, String val2) {
         // test logic here
     }

     ✅ Key Points:
     -----------------------------
     1️⃣ Must return a **2D Object array** (`Object[][]`) where:
         - Rows = number of test iterations
         - Columns = number of parameters in test method

     2️⃣ DataProvider can be in:
         - The same class
         - A different class (must use `dataProviderClass` attribute in @Test)

     3️⃣ You can **filter test data** using:
         - `indices = {0, 2}` → runs test only for selected rows
         - `parallel = true` → runs tests in parallel mode for faster execution

     4️⃣ The order of data rows defines execution order of test method.

     5️⃣ Can return different types of data:
         - Strings, Integers, custom objects, etc.

     ✅ Example:
     -----------------------------
     @DataProvider(name = "loginData")
     public Object[][] data() {
         return new Object[][] {
             {"user1@gmail.com", "pass1"},
             {"user2@gmail.com", "pass2"}
         };
     }

     @Test(dataProvider = "loginData")
     public void loginTest(String email, String password) {
         // Your test code here
     }

     ✅ Advanced Usage:
     -----------------------------
     - Use external sources (Excel, CSV, DB) with custom logic inside DataProvider.
     - Can return `Iterator<Object[]>` for large datasets.

     ✅ Interview Tip:
     -----------------------------
     - Great for reducing duplicate test code.
     - Often used with Login, Form Submission, Negative/Positive tests.
     - Not suitable when input/output is dependent on previous test runs.
    */

}
