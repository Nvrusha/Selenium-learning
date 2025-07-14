package org.example.Ex14_TestNG.Grouping;

public class Notes {

    /*
      ===============================
     ✅ TestNG - Grouping Concept
     ===============================

     ✅ Why use Groups?

     👉 Allows us to group related test cases (like Smoke, Regression, Sanity etc).
     👉 Helps when we want to run a specific set of tests, instead of all tests.

     ------------------------------------------------
     ✅ How to create Groups?

     👉 Use `groups` attribute inside `@Test` annotation.

     Example:

     @Test(groups = "Smoke")
     void testLogin() { }

     @Test(groups = {"Regression", "Sanity"})
     void testAddToCart() { }

     ------------------------------------------------
     ✅ Running Groups using extentreports.xml

     👉 Create XML suite and specify which group(s) to include or exclude.

     Example XML:

     <suite name="GroupSuite">
       <test name="Smoke Tests">
         <groups>
           <run>
             <include name="Smoke"/>
           </run>
         </groups>
         <classes>
           <class name="org.example.TestClassName"/>
         </classes>
       </test>
     </suite>

     ------------------------------------------------
     ✅ Advantages of Grouping:

     ✔ Run only selected group of tests (e.g., only Smoke tests).
     ✔ Skip unwanted groups (by exclude tag in XML).
     ✔ Helps in organizing large test suites.

     ------------------------------------------------
     ✅ Multiple Groups for a single Test:

     @Test(groups = {"Regression", "Sanity"})
     void testCheckout() { }

     ✔ This test belongs to both Regression & Sanity groups.

     ------------------------------------------------
     ✅ Example Test Class:

     public class GroupingExample {

         @Test(groups = "Smoke")
         void loginTest() {
             System.out.println("Executing Smoke - Login Test");
         }

         @Test(groups = "Regression")
         void addToCartTest() {
             System.out.println("Executing Regression - Add to Cart Test");
         }

         @Test(groups = {"Sanity", "Regression"})
         void paymentTest() {
             System.out.println("Executing Sanity & Regression - Payment Test");
         }
     }

     ------------------------------------------------
     ✅ Summary:

     ✔ Grouping helps manage and control large test suites.
     ✔ Groups can be run using TestNG XML (via include/exclude).
     ✔ Test method can belong to **multiple groups**.
     ✔ Useful for Smoke, Sanity, Regression categorization.

     ===============================
    */

}
