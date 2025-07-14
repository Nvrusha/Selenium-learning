package org.example.Ex14_TestNG;

import org.apache.hc.core5.reactor.Command;
import org.testng.annotations.Test;

public class Notes {
    /*
─────────────────────────────────────────────
🧪 TestNG – Test Next Generation (Java-based Unit Testing Framework)
─────────────────────────────────────────────
🔹 What is TestNG?
TestNG is a testing framework inspired by JUnit and NUnit, designed to simplify a broad range of testing needs, from unit testing to integration and functional testing.

─────────────────────────────────────────────
📌 Advantages of TestNG:
─────────────────────────────────────────────
1. Supports creation of **Test Suites**
2. Allows **prioritization of test cases**
3. Supports **grouping** of tests
4. Enables **parameterization**
5. Supports **parallel test execution**
6. Generates **detailed HTML & XML reports**
7. Offers **annotations** to manage test execution flow

─────────────────────────────────────────────
🔧 TestNG Setup:
─────────────────────────────────────────────
✔ Add TestNG to project:
   - If using Maven → add dependency in `pom.xml`
   - If using manually → add TestNG library to classpath

─────────────────────────────────────────────
🧷 Important Annotations:
─────────────────────────────────────────────
@BeforeSuite     → runs before all test cases in suite
@AfterSuite      → runs after all test cases in suite
@BeforeTest      → runs before <test> tag in extentreports.xml
@AfterTest       → runs after <test> tag in extentreports.xml
@BeforeClass     → runs before the first method in the current class
@AfterClass      → runs after all test methods in the class
@BeforeMethod    → runs before each test method
@AfterMethod     → runs after each test method
@Test            → marks a method as a test case

─────────────────────────────────────────────
📋 Test Execution Order (Default Behavior):
─────────────────────────────────────────────
1. If **no priority** is specified → methods run in **alphabetical order**
2. You can use `@Test(priority = x)` to control the execution order
3. Priority can be **negative, positive or random numbers**
4. If multiple tests have the **same priority**, then **alphabetical order** is used again
5. If priority is not specified → default is `0`

─────────────────────────────────────────────
📌 Grouping Test Cases:
─────────────────────────────────────────────
- You can group test methods using `groups` attribute in @Test
```java
@Test(groups={"smoke"})
     */

}
