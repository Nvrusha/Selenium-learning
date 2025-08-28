package org.example.Ex15_TestNG.Listeners_ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

/**
 * ✅ Listener class that integrates ExtentReports with TestNG.
 * Implements ITestListener to generate detailed HTML reports.
 */

@Listeners()
public class ExtentReportsManager implements ITestListener {

    public ExtentSparkReporter sparkReporter; // Responsible for generating the HTML report
    public ExtentReports extent;              // Main ExtentReports object to manage the report
    public ExtentTest test;                   // Logs each test's status and steps

    /**
     * ✅ Called once before any test methods run in the suite.
     * Sets up the Extent report configuration like theme, name, and system info.
     */
    public void onStart(ITestContext context) {
        // Initialize Spark Reporter with target report path
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/myReport.html");

        // Report customizations
        sparkReporter.config().setDocumentTitle("Automation Report");     // Sets the browser tab title
        sparkReporter.config().setReportName("Functional Testing");       // Sets the report name on top
        sparkReporter.config().setTheme(Theme.DARK);                      // Sets dark theme

        // Create ExtentReports instance and attach Spark Reporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Set environment and tester information shown in report
        extent.setSystemInfo("Project Name", "OrangeHRM Automation");
        extent.setSystemInfo("Tester", "Vrushali N");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Browser", "Chrome 123.0");
        extent.setSystemInfo("OS", "Windows 11");
    }

    /**
     * ✅ Called when a test method passes.
     * Logs test as PASSED in the report.
     */
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName()); // Creates test entry with method name
        test.log(Status.PASS, "Test case PASSED is: " + result.getName());
    }

    /**
     * ❌ Called when a test method fails.
     * Logs test as FAILED and attaches the failure cause (exception).
     */
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test case FAILED cause is: " + result.getThrowable());
    }

    /**
     * ⚠️ Called when a test method is skipped.
     * Logs test as SKIPPED in the report.
     */
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case SKIPPED is: " + result.getName());
    }

    /**
     * 🔚 Called after all test cases in the suite have been executed.
     * Flushes the report to ensure all logs and info are written to disk.
     */
    public void onFinish(ITestContext context) {
        extent.flush(); // Mandatory to generate the final report
    }
}
