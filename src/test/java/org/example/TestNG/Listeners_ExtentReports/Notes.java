package org.example.TestNG.Listeners_ExtentReports;

public class Notes {
    /*
     ✅ TestNG Listeners – Notes
     1. What is a Listener?
     A listener is used to listen to events that occur during test execution (e.g., test start, pass, fail).

     2. Why use Listeners?
     - To customize test execution behavior
     - To log test results
     - To take screenshots on test failure
     - To generate custom reports

     3. Common Listener Interfaces in TestNG:
     - ITestListener       → handles test-level events
     - ISuiteListener      → handles before/after suite execution
     - IInvokedMethodListener → handles before/after each method call

     4. ITestListener Common Methods:
     - onTestStart()       → called before each test method starts
     - onTestSuccess()     → called when a test method passes
     - onTestFailure()     → called when a test method fails
     - onTestSkipped()     → called when a test is skipped
     - onStart()           → called before any tests start
     - onFinish()          → called after all tests finish

     5. How to Use a Listener:
     a) Create a class and implement ITestListener
     b) Override the required methods
     c) Register Listener:
     - Using @Listeners annotation:
       @Listeners(MyListenerClass.class)
       public class MyTestClass { ... }
     - OR using extentreports.xml:
       <listeners>
         <listener class-name="your.package.MyListenerClass"/>
       </listeners>

     6. Example Use Case:
     - Use onTestFailure() to capture a screenshot if the test fails
    */

}
