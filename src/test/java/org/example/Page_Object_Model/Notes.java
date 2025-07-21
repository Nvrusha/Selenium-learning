package org.example.Page_Object_Model;

public class Notes {
    /*
      ===========================================
     📘 PAGE OBJECT MODEL (POM) - DETAILED NOTES
     ===========================================

     🔹 What is Page Object Model (POM)?
     -----------------------------------
     POM is a design pattern used in Selenium automation
     that helps to enhance test maintenance and reduce code duplication.

     Each web page in the application is represented as a separate Java class.
     This class contains:
       ➤ Locators for the page elements (object repository)
       ➤ Methods to perform actions (like click, enter text)

     🔹 Why use POM?
     ---------------
     ✅ Improves test readability and maintainability
     ✅ Easy to reuse methods across multiple tests
     ✅ Clean separation of UI structure and test logic
     ✅ Reduces duplication of element locators and code

     🔹 Components of POM
     ---------------------
     1. Page Class (e.g., LoginPage.java)
        ➤ Contains WebElements and methods to interact with them

     2. Test Class (e.g., LoginTest.java)
        ➤ Contains @Test methods using the Page class

     🔹 Example Structure:
     ---------------------
     📁 tests/
        └── LoginTest.java

     📁 pages/
        └── LoginPage.java

     🔹 Two Ways to Implement POM:
     ------------------------------
     1️⃣ Without PageFactory:
        ➤ Use 'By' class to define locators
        ➤ Use driver.findElement(locator) inside methods

        Pros:
          ✔ Simple for small tests
        Cons:
          ❌ Repetitive code
          ❌ Less readable

     2️⃣ With PageFactory (Recommended):
        ➤ Use '@FindBy' annotations to declare WebElements
        ➤ Initialize elements using PageFactory.initElements(driver, this);

        Pros:
          ✔ Cleaner and more readable
          ✔ Avoids frequent element lookups
          ✔ Supports multiple locator strategies
          ✔ Better suited for scalable projects

     🔹 Tips for Using POM Effectively:
     -----------------------------------
     ✅ One page = one class
     ✅ Keep all locators private (encapsulation)
     ✅ Provide public methods for external interaction
     ✅ Avoid assertions inside page classes
     ✅ Keep test logic and element interaction separate

     🔹 Naming Conventions:
     -----------------------
     ✅ Class: PageName + 'Page' (e.g., LoginPage)
     ✅ Method: describe the action (e.g., clickLoginButton())

     🔹 Limitations of POM:
     -----------------------
     ❌ Cannot handle dynamic elements on its own
     ❌ Does not define test flow (use with frameworks like TestNG, JUnit)

     🔹 Common Enhancements:
     ------------------------
     ⚙️ Combine with:
        ✔ TestNG (for test management)
        ✔ ExtentReports (for reporting)
        ✔ Data-Driven Testing (for multiple inputs)
        ✔ Utilities (for waits, screenshots, etc.)

     ===========================================
     🟢 Summary:
     -----------
     POM is not a testing framework but a design pattern.
     It helps in building robust, maintainable, and reusable automation code.
     Highly recommended when working on medium to large test automation projects.
     ===========================================
    */

}
