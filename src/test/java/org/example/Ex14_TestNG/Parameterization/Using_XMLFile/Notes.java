package org.example.Ex14_TestNG.Parameterization.Using_XMLFile;

public class Notes {
    /*
       ✅ TestNG XML for Parallel Testing — Study Notes

      🔹 Purpose:
         → To run multiple test cases, classes, or methods in parallel using XML configuration.
         → Saves time by executing tests concurrently.

      ---------------------------------------------------------------------------------------
      🔹 Basic Structure:
         <suite name="Test Suite" parallel="tests" thread-count="2">
             <test name="Test1">
                 <classes>
                     <class name="your.package.ClassOne"/>
                 </classes>
             </test>

             <test name="Test2">
                 <classes>
                     <class name="your.package.ClassTwo"/>
                 </classes>
             </test>
         </suite>

      ---------------------------------------------------------------------------------------
      ✅ Important Attributes:

      1) parallel = "tests"       → Executes each <test> block in parallel (best for class-level parallelism)
      2) parallel = "classes"     → Executes test classes in parallel (within the same <test>)
      3) parallel = "methods"     → Executes test methods in parallel (within the same class)
      4) thread-count = "n"       → Max number of threads to run in parallel

      ---------------------------------------------------------------------------------------
      ✅ When to use what:

      • parallel="tests"    → Use when each <test> in XML contains independent test classes.
      • parallel="classes"  → Use when you want to run multiple classes inside same <test> tag.
      • parallel="methods"  → Use for executing multiple @Test methods of same class in parallel.

      ---------------------------------------------------------------------------------------
      ✅ Example for parallel = "classes":

     <suite name="Parallel Suite" parallel="classes" thread-count="3">
         <test name="ParallelTestExecution">
             <classes>
                 <class name="com.example.TestClassOne"/>
                 <class name="com.example.TestClassTwo"/>
                 <class name="com.example.TestClassThree"/>
             </classes>
         </test>
     </suite>

      ---------------------------------------------------------------------------------------
      ✅ Best Practices:

      • Make your WebDriver thread-safe using ThreadLocal when using parallel testing.
      • Avoid sharing static/global resources across parallel threads.
      • Use @BeforeMethod and @AfterMethod (instead of @BeforeClass) for isolated setup/teardown.
    */

}
